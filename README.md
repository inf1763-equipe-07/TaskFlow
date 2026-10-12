# TaskFlow

Application Java en console pour gérer une liste de tâches. Projet de l'équipe 07, cours INF1763 (UQO), automne 2026, mini-projet 1.

À tenir par le Responsable de la documentation.

## Équipe

| Nom | Rôle | Domaine |
|---|---|---|

## Fonctionnalités

- ajouter une tâche (titre obligatoire, priorité, échéance facultative) ;
- afficher la liste des tâches ;
- marquer une tâche comme terminée ;
- modifier la priorité d'une tâche ;
- attribuer, modifier ou retirer une échéance ;
- sauvegarder les données dans un fichier et les recharger au démarrage.

## Prérequis

JDK 21 (proposition à valider). Chacun vérifie sa version avec `java -version`.

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

- Le menu s'affiche : on choisit une entrée par son numéro, et `0` quitte.
- Le programme lit et écrit en UTF-8. Le terminal doit être en UTF-8 pour que les accents s'affichent bien ; sous Windows, on l'y met avec `chcp 65001` avant de lancer.
- Le dossier `out/` contient les fichiers compilés. Git l'ignore, on peut le supprimer à tout moment.

## Exemple d'utilisation

_À compléter._

## Fichier de données

Proposition à valider : `data/taches.txt`, une ligne par tâche, `id;priorite;echeance;statut;titre`.

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

- La sauvegarde se fait sur commande.
- Au démarrage, les données sont rechargées automatiquement si le fichier existe ; sinon, la liste est vide.
- Les identifiants sont conservés ; une nouvelle tâche reçoit un identifiant distinct de tous les autres.
- Si le fichier est illisible, un message s'affiche et le démarrage s'interrompt, sans modifier le fichier.
- Si la sauvegarde échoue, un message d'échec s'affiche, jamais un message de réussite.

## Architecture

Voir les règles d'architecture dans `CONTRIBUTING.md`.

## Limites connues

_À compléter._
