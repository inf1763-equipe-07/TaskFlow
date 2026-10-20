# TaskFlow

Application Java en console pour gérer une liste de tâches. Projet de l'équipe 07, cours INF1763 (UQO), automne 2026, mini-projet 1.

À tenir par le Responsable de la documentation.

## Équipe

| Nom | Rôle | Domaine |
|---|---|---|
| Émilien Thibert | Product Owner | E — Chargement |
| Sofiane Khider | Scrum Master | A — Ajout |
| Ahmed Boussayri | Intégrateur | B — Consultation et modification |
| Marc-Raphaël Chehab | Responsable qualité et tests | C — Échéances |
| Mathieu Pagé | Responsable de la documentation | D — Sauvegarde |

## Fonctionnalités

Disponibles :

- ajouter une tâche : titre obligatoire, priorité (Normale par défaut) et échéance facultative ;
- afficher la liste des tâches ;
- marquer une tâche comme terminée ;
- attribuer une échéance à une tâche existante (une nouvelle date remplace l'ancienne) ;
- sauvegarder les tâches dans un fichier, avec un message clair en cas d'échec.

En cours de développement :

- modifier la priorité d'une tâche existante (US-06) ;
- modifier ou retirer une échéance (US-08, US-09) ;
- recharger les tâches au démarrage, démarrer sans fichier et refuser un fichier illisible (US-12 à US-14).

## Prérequis

JDK 21. On vérifie sa version avec `java -version` et `javac -version` : les deux doivent indiquer 21.

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

- `--demo` démarre avec deux tâches de test, les mêmes que dans `donnees-test/exemple.txt` ;
- un chemin, par exemple `java -cp out taskflow.Main essai.txt`, sauvegarde dans ce fichier au lieu de `Sauvegarde.txt`.

Remarques :

- Le menu s'affiche : on choisit une entrée par son numéro, et `0` quitte. Pendant un ajout, `0` annule la saisie.
- Le programme lit et écrit en UTF-8. Le terminal doit être en UTF-8 pour que les accents s'affichent bien ; sous Windows, on l'y met avec `chcp 65001` avant de lancer.
- Le dossier `out/` contient les fichiers compilés. Git l'ignore, on peut le supprimer à tout moment.

## Exemple d'utilisation

On ajoute une tâche, on la sauvegarde, puis on quitte. Le menu réapparaît après chaque action ; il n'est montré qu'une fois ici.

```
TASKFLOW — Gestion des tâches

1. Ajouter une tâche
2. Marquer une tâche comme terminée
3. Afficher les tâches
4. Gérer une échéance
5. Sauvegarder les tâches
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

Votre choix : 5
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

Par défaut, `Sauvegarde.txt` à la racine du projet (le dossier depuis lequel on lance le programme), une ligne par tâche, `id;priorite;echeance;statut;titre`.

- Le titre est en dernier : on lit chaque ligne avec `split(";", 5)`, ce qui permet à un titre de contenir un point-virgule.
- Une échéance vide signifie « aucune échéance ».
- Les valeurs de priorité et de statut sont les noms internes (`BASSE`, `NORMALE`, `ELEVEE` ; `A_FAIRE`, `TERMINEE`).

Exemple :

```
1;ELEVEE;2026-10-05;TERMINEE;Vérifier la sauvegarde du serveur
2;NORMALE;;A_FAIRE;Mettre à jour le guide utilisateur
```

Un fichier d'exemple, avec des données fictives, est fourni dans `donnees-test/exemple.txt`.

## Sauvegarde et rechargement

- La sauvegarde se fait sur commande, avec l'entrée « Sauvegarder les tâches ». Rien n'est sauvegardé automatiquement, ni à la fermeture.
- Elle écrit toutes les tâches en mémoire, avec leurs identifiants, et remplace le contenu précédent du fichier. Les dossiers du chemin sont créés s'ils n'existent pas.
- Si l'écriture réussit, le programme affiche « Tâches sauvegardées avec succès. ».
- Si elle échoue, il affiche « Erreur : impossible de sauvegarder les tâches (…) », jamais un message de réussite. Les tâches restent en mémoire et le menu continue.

La raison de l'échec est donnée entre parenthèses :

| Raison affichée | Cause |
|---|---|
| `accès refusé à « … »` | pas le droit d'écrire dans ce fichier ou ce dossier |
| `« … » est un fichier et non un dossier` | une partie du chemin qui devrait être un dossier est un fichier |
| `le fichier « … » n'a pas pu être écrit` | autre erreur d'écriture, par exemple un chemin qui désigne un dossier |

Le rechargement est en cours de développement (US-12 à US-14). Une fois intégré, les tâches seront rechargées au démarrage si le fichier existe ; sinon, la liste sera vide. Un fichier illisible arrêtera le démarrage, sans être modifié. Pour l'instant, le programme démarre toujours avec une liste vide.

## Architecture

Le code est dans `src/taskflow`, réparti en quatre paquets : `modele`, `vue`, `controleur` et `persistance`. Voir les règles d'architecture dans `CONTRIBUTING.md`.

## Limites connues

- Comme le rechargement n'est pas encore disponible, une sauvegarde faite lors d'un nouveau lancement remplace le fichier : les tâches des lancements précédents sont perdues. Pour les garder, on donne un autre fichier au lancement.
- Aucun avertissement n'apparaît en quittant : les changements non sauvegardés sont perdus.
- On ne peut pas supprimer une tâche.
- Un titre ne peut pas être `0`, puisque `0` annule l'ajout.
- Le chemin du fichier est fixé au lancement et ne change pas pendant la session.
- Si l'écriture est interrompue (disque plein, arrêt brutal), le fichier peut rester incomplet.
