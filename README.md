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

_À compléter avec le socle._

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
