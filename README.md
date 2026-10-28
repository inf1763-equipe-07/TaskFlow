# TaskFlow

Application Java en console pour gérer une liste de tâches. Projet de l'équipe 07, cours INF1763 (UQO), automne 2026, mini-projet 1.

## Équipe

| Nom | Rôle | Domaine |
|---|---|---|
| Émilien Thibert | Product Owner | E — Chargement |
| Sofiane Khider | Scrum Master | A — Ajout |
| Ahmed Boussayri | Intégrateur | B — Consultation et modification |
| Marc-Raphaël Chehab | Responsable qualité et tests | C — Échéances |
| Mathieu Pagé | Responsable de la documentation | D — Sauvegarde |

## Fonctionnalités

- ajouter une tâche avec un titre obligatoire ;
- choisir sa priorité : Basse, Normale ou Élevée (Normale par défaut) ;
- lui donner une échéance facultative dès sa création ;
- afficher la liste des tâches ;
- marquer une tâche comme terminée ;
- modifier la priorité d'une tâche existante ;
- attribuer, modifier ou retirer l'échéance d'une tâche existante ;
- sauvegarder les tâches dans un fichier ;
- signaler un échec de sauvegarde, sans jamais annoncer une fausse réussite ;
- recharger les tâches au démarrage.

## Prérequis

JDK 21. Le JDK fournit `javac`, qui compile le code, et `java`, qui lance le programme. On vérifie leur version dans un terminal avec `java -version` et `javac -version` : les deux doivent indiquer 21.

## Compiler et lancer

Les commandes se lancent depuis la racine du dépôt, avec le JDK 21 installé (voir Prérequis).

Linux, macOS ou Git Bash :

```
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out taskflow.Main
```

PowerShell :

```
javac -encoding UTF-8 -d out (Get-ChildItem -Path src -Recurse -Filter *.java).FullName
java -cp out taskflow.Main
```

Deux options peuvent s'ajouter au lancement, seules ou ensemble :

- `--demo` démarre avec deux tâches de test, les mêmes que dans `donnees-test/exemple.txt`, sans lire le fichier de données ;
- un chemin, par exemple `java -cp out taskflow.Main essai.txt`, lit et sauvegarde ce fichier au lieu de `Sauvegarde.txt`.

Remarques :

- Le menu s'affiche : on choisit une entrée par son numéro, et `0` quitte. Pendant un ajout, `0` annule la saisie.
- Le programme lit et écrit en UTF-8. Le terminal doit être en UTF-8 pour que les accents s'affichent bien ; sous Windows, on l'y met avec `chcp 65001` avant de lancer.
- Le dossier `out/` contient les fichiers compilés. Git l'ignore, on peut le supprimer à tout moment.

## Exemple d'utilisation

On lance le programme sans fichier `Sauvegarde.txt`, on ajoute une tâche, on la sauvegarde, puis on quitte. Le menu réapparaît après chaque action ; il n'est montré qu'une fois ici.

```
TASKFLOW — Gestion des tâches
Aucun fichier de sauvegarde trouve, un nouveau a ete cree

1. Ajouter une tâche
2. Marquer une tâche comme terminée
3. Afficher les tâches
4. Modifier la priorité d'une tâche
5. Gérer une échéance
6. Sauvegarder les tâches
0. Quitter

Votre choix : 1

AJOUTER UNE TÂCHE

Titre (0 = Annuler) : Préparer la présentation
Priorité (Basse/Normale/Élevée, Entrée = Normale, 0 = Annuler) : Élevée
Échéance (AAAA-MM-JJ, Entrée = aucune, 0 = Annuler) : 2026-11-20
Tâche ajoutée avec succès.
Identifiant : 1
Titre : Préparer la présentation
Priorité : Élevée
Échéance : 2026-11-20
Statut : À faire

Votre choix : 6
Tâches sauvegardées avec succès.

Votre choix : 0

Fermeture de TaskFlow.
Au revoir !
```

Le fichier `Sauvegarde.txt` contient alors :

```
1;ELEVEE;2026-11-20;A_FAIRE;Préparer la présentation
```

Pendant l'ajout, une saisie invalide affiche un message, puis la question est reposée. Par exemple, une date impossible comme `2026-02-30` donne « Erreur : La date indiquée n'existe pas dans le calendrier. ».

## Fichier de données

Par défaut, le fichier s'appelle `Sauvegarde.txt` et se trouve dans le dossier depuis lequel on lance le programme (la racine du dépôt avec les commandes ci-dessus). Un autre chemin peut être donné au lancement (voir Compiler et lancer). Le fichier est en UTF-8, avec une ligne par tâche : `id;priorite;echeance;statut;titre`.

- Le titre est en dernier : on lit chaque ligne avec `split(";", 5)`, ce qui permet à un titre de contenir un point-virgule.
- Une échéance vide signifie « aucune échéance ».
- Les valeurs de priorité et de statut sont les noms internes (`BASSE`, `NORMALE`, `ELEVEE` ; `A_FAIRE`, `TERMINEE`).
- Les identifiants sont écrits tels quels et retrouvés au rechargement.

Exemple :

```
1;ELEVEE;2026-10-05;TERMINEE;Vérifier la sauvegarde du serveur
2;NORMALE;;A_FAIRE;Mettre à jour le guide utilisateur
```

Un fichier d'exemple, avec des données fictives, est fourni dans [`donnees-test/exemple.txt`](donnees-test/exemple.txt).

## Sauvegarde et rechargement

- La sauvegarde se fait sur commande, avec l'entrée 6 « Sauvegarder les tâches ». Rien n'est sauvegardé automatiquement, ni à la fermeture.
- Elle écrit toutes les tâches en mémoire, avec leurs identifiants : elle crée le fichier ou remplace tout son contenu. Les dossiers manquants du chemin sont créés si possible.
- Si l'écriture réussit, le programme affiche « Tâches sauvegardées avec succès. ».
- Si elle échoue, il affiche « Erreur : impossible de sauvegarder les tâches (…) », jamais un message de réussite. Les tâches restent en mémoire et le menu continue.

La raison de l'échec est donnée entre parenthèses :

| Raison affichée | Cause |
|---|---|
| `accès refusé à « … »` | pas le droit d'écrire dans ce fichier ou ce dossier |
| `« … » est un fichier et non un dossier` | le dossier qui doit contenir le fichier est en réalité un fichier |
| `le fichier « … » n'a pas pu être écrit` | autre erreur d'écriture, par exemple un chemin qui désigne un dossier |

Au démarrage normal, sans `--demo`, le programme lit le fichier de données :

- s'il existe, les tâches sont rechargées avec leurs identifiants, et une nouvelle tâche reçoit un identifiant plus grand que tous les autres ;
- s'il n'existe pas, le programme tente de le créer, avec ses dossiers, et démarre avec une liste vide ;
- s'il existe mais ne peut pas être lu (droit de lecture refusé), le programme affiche une erreur et s'arrête, sans modifier le fichier ;
- si certaines lignes sont mal formées (champ manquant, valeur inconnue, date ou identifiant invalide), elles sont ignorées avec le message « Ligne N ignorée », et le démarrage continue avec les tâches valides.

En mode `--demo`, le fichier n'est pas lu : une sauvegarde remplace alors son contenu par les tâches en mémoire.

## Architecture

Le code est dans `src/taskflow`, réparti en quatre paquets :

- `modele` : les tâches et leurs règles (titre, priorité, échéance, identifiants) ;
- `vue` : l'affichage et la saisie dans la console ;
- `controleur` : le menu et l'enchaînement des actions ;
- `persistance` : l'écriture du fichier de données.

`Main` crée et relie les objets, puis lance le menu. Les règles détaillées sont dans [`CONTRIBUTING.md`](CONTRIBUTING.md).

## Limites connues

- Aucun avertissement n'apparaît en quittant : les changements non sauvegardés sont perdus.
- On ne peut pas supprimer une tâche.
- Un titre ne peut pas être `0`, puisque `0` annule l'ajout.
- Le chemin du fichier est fixé au lancement et ne change pas pendant la session.
- Si l'écriture est interrompue (disque plein, arrêt brutal), le fichier peut rester incomplet.
- Au chargement, les lignes mal formées sont ignorées et le démarrage continue ; la sauvegarde suivante réécrit le fichier sans elles.
- Si la lecture échoue pour une autre raison, par exemple un fichier qui n'est pas en UTF-8, un message s'affiche, mais le programme démarre avec une liste vide ; une sauvegarde remplace alors le fichier.
