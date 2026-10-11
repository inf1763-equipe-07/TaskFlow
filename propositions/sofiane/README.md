# TaskFlow — Proposition d'architecture alternative (Sofiane)

> **Statut : prototype autonome de comparaison, non destiné à une fusion directe.**
> Les fonctionnalités sont intégrées ici pour démontrer la faisabilité d'une architecture compacte. Le code de production et les récits restent à distribuer et à développer par les responsables de l'équipe, dans leurs propres branches et PR.

## Objectif

Évaluer une architecture Java compacte, **9 classes de production**, qui sépare les données, les règles métier, la persistance et la console. Comparer ce prototype aux propositions des PR #6 et #12 sans modifier les fichiers du programme principal.

## Architecture

```text
src/taskflow/
├── Main.java                         démarrage/chargement et assemblage
├── modele/
│   ├── Priorite.java                 trois valeurs admises + analyse du texte
│   ├── Statut.java                   À faire / Terminée
│   └── Tache.java                    données et invariants
├── service/
│   ├── ValidateurDate.java           calendrier strict AAAA-MM-JJ
│   └── TacheService.java             ajout, recherche, état et modifications
├── persistance/
│   ├── DonneesIllisiblesException.java
│   └── FichierTacheRepository.java   sauvegarde UTF-8 et chargement
└── vue/
    └── ConsoleUI.java               menu, validation des saisies, affichages
```

## Compilation et lancement

**JDK 17 ou plus.** Depuis la racine du dépôt, sous Git Bash :

```bash
mkdir -p propositions/sofiane/out
javac --release 17 -encoding UTF-8 -d propositions/sofiane/out $(find propositions/sofiane/src -name '*.java')
java -cp propositions/sofiane/out taskflow.Main propositions/sofiane/data/essai.txt
```

**PowerShell Windows :**

```powershell
New-Item -ItemType Directory -Force propositions/sofiane/out | Out-Null
javac --release 17 -encoding UTF-8 -d propositions/sofiane/out (Get-ChildItem propositions/sofiane/src -Recurse -Filter '*.java').FullName
java -cp propositions/sofiane/out taskflow.Main propositions/sofiane/data/essai.txt
```

L'argument `propositions/sofiane/data/essai.txt` **isole les données de démonstration**. Ne pas utiliser un vrai fichier de données de l'équipe pour les essais.

## Points de conformité illustrés

- Entrée seule : priorité `Normale`, échéance `Aucune`. Une saisie incorrecte provoque une erreur et une nouvelle question, sans valeur substituée silencieusement.
- Titre absent ou contenant `|` : refus ; annulation à toutes les questions d'ajout.
- Date au format strict AAAA-MM-JJ ; 30 février et format 10/08/2026 refusés.
- Identifiants uniques après chargement (maximum enregistré + 1) ; identifiant non numérique signalé.
- Une tâche déjà terminée ne change pas ; les priorités et dates existantes sont conservées si la nouvelle valeur est invalide.
- Écriture temporaire et déplacement atomique ; en cas d'échec, aucun succès n'est annoncé.
- Fichier corrompu : démarrage interrompu, sans réécriture.

## Limites et coûts de l'architecture

1. `ConsoleUI.java` centralise beaucoup de méthodes. Plusieurs domaines y travailleraient en parallèle : **risque de conflits Git**. C'est l'inconvénient principal par rapport aux contrôleurs/vues par domaine prévus par la PR #12.
2. Il n'y a pas de mode `--demo` ; les tests indépendants passent par un chemin de fichier explicite. On peut ajouter un générateur de données de test si nécessaire.
3. Les tests de bout en bout fournis utilisent Python standard en option ; aucun framework externe n'est requis pour compiler ou exécuter l'application.
4. L'écriture atomique peut être indisponible sur certains systèmes de fichiers : dans ce cas, la sauvegarde échoue explicitement plutôt que de risquer le fichier existant.
5. Le prototype n'est **pas** une preuve que toutes les intégrations des deux itérations ont été validées par l'équipe ou relues par ses membres.

## Proposition pour la réunion du 11 octobre

Évaluer l'architecture à travers quatre critères : **règles métier**, **autonomie des membres**, **lisibilité**, **coût des futures itérations**. On pourrait retenir la compacité de ce modèle tout en conservant **des contrôleurs de domaine séparés** comme dans la proposition d'Ahmed.

Voir `COMPARAISON.md` pour une comparaison explicite et la procédure de publication dans `README_POUR_SOFIANE.md` à la racine de l'archive.
