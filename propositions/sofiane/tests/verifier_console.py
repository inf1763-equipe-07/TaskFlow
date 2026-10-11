"""Vérifications sans dépendances externes (Python 3 standard). Exécuter après javac."""
from pathlib import Path
from tempfile import TemporaryDirectory
import subprocess
import sys

root = Path(__file__).resolve().parents[1]
cp = root / 'out'
if not cp.exists():
    raise SystemExit('Compiler le code Java avant de lancer les tests (voir README.md).')

def run(inputs, data):
    return subprocess.run(['java', '-cp', str(cp), 'taskflow.Main', str(data)],
                          input=inputs, text=True, encoding='utf-8',
                          capture_output=True, timeout=12)

def verify(label, ok):
    if not ok: raise AssertionError(label)
    print('OK', label)

with TemporaryDirectory(prefix='taskflow-sofiane-test-') as tmp:
    f = Path(tmp) / 'taches.txt'
    p = run('2\n0\n', f)
    verify('01 premier lancement et liste vide', p.returncode == 0 and 'Aucune tâche à afficher' in p.stdout)
    p = run('1\n   \nTache test\nUrgente\nÉlevée\n2026-02-30\n10/08/2026\n2026-10-05\n6\n0\n', f)
    verify('02 titre vide refusé', 'le titre est obligatoire' in p.stdout)
    verify('03 priorité invalide refusée', 'la priorité doit' in p.stdout)
    verify('04 date impossible refusée', "n'est pas une date valide" in p.stdout)
    verify('05 format incorrect refusé', "n'est pas un format de date valide" in p.stdout)
    verify('06 sauvegarde réussie', 'Sauvegarde réussie : 1 tâches' in p.stdout and f.exists())
    p = run('2\n1\nNouvelle\n\n\n3\n1\n3\n1\n4\n1\nBasse\n5\n1\n1\n2026-10-06\n5\n1\n2\n6\n0\n', f)
    verify('07 rechargement / identifiant incrémenté', '1 tâches chargées' in p.stdout and 'Identifiant : 2' in p.stdout)
    verify('08 priorité par défaut / échéance facultative', 'Priorité    : Normale' in p.stdout and 'Échéance    : Aucune' in p.stdout)
    verify('09 déjà terminée', 'est déjà terminée' in p.stdout)
    verify('10 priorité modifiée', 'a été modifiée' in p.stdout)
    verify('11 échéance définie puis retirée', 'a été retirée' in p.stdout)
    p = run('1\nannuler\n2\n0\n', f)
    verify('12 annulation sans ajout', 'Ajout annulé' in p.stdout)
    p = run('3\nabc\n3\n99\n0\n', f)
    verify('13 identifiant invalide et inconnu', 'identifiant invalide' in p.stdout and 'aucune tâche ne correspond' in p.stdout)
    saved = f.read_bytes()
    f.write_text('# TaskFlow v1\n1|Corrompu|INCONNUE||A_FAIRE\n', encoding='utf-8')
    p = run('2\n', f)
    verify('14 fichier corrompu refusé et préservé', p.returncode != 0 and 'Démarrage interrompu' in p.stdout and 'INCONNUE' in f.read_text())
    f.write_bytes(saved)
    invalid_parent = Path(tmp) / 'occupied'
    invalid_parent.write_text('not a directory', encoding='utf-8')
    p = run('1\nNouvelle\n\n\n6\n0\no\n', invalid_parent / 'data.txt')
    verify('15 sauvegarde impossible clairement signalée', 'Les modifications n\'ont pas été sauvegardées.' in p.stdout)
    p = run('1\nAjouter sans enregistrer\n\n\n0\nn\n0\no\n', Path(tmp) / 'other.txt')
    verify('16 avertissement sortie avec modifications non sauvegardées', 'Retour au menu.' in p.stdout)

print('16 vérifications automatiques réussies')
