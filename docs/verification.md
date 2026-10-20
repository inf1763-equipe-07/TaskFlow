# Vérification

À tenir par le Responsable Qualité/Test (Marc-Raphaël).

> Gabarit minimal proposé en attendant la reprise du document par le Responsable Qualité/Test, basé sur la couverture minimale des vérifications de l'énoncé (§8.2). Chaque auteur consigne son résultat pour ses propres récits ; Marc-Raphaël rejoue la vérification sur un clone propre et confirme (ou non) dans la dernière colonne, conformément à son rôle de Responsable Qualité/Test.
>
> Les scénarios 1, 4, 5 et 6 (partiel) sont pré-remplis à partir des PR #51 et #52 (Ahmed, déjà fusionnées) et des vérifications déjà confirmées par Sofiane en revue. Le contrôle indépendant de Marc-Raphaël reste à faire sur un clone propre.

| Scénario | Récit(s) concerné(s) | Comportement attendu | Données utilisées | Résultat attendu | Résultat observé (auteur) | Conclusion (auteur) | Commit testé | Contrôle indépendant (Marc-Raphaël) |
|---|---|---|---|---|---|---|---|---|
| 1. Liste vide | US-04 | L'application indique clairement qu'aucune tâche n'est présente. | Démarrage sans aucune tâche ajoutée. | Message explicite « Aucune tâche enregistrée ». | Message affiché correctement, conforme (CA3), confirmé par Sofiane en revue. | Conforme | `a48ed26` (PR #51, fusionnée) | Partiellement conforme — la liste vide est détectée et un message s’affiche, mais les accents sont mal affichés dans le terminal.|
| 2. Ajout valide | US-01 | La tâche reçoit un identifiant et les valeurs par défaut attendues lorsque les informations facultatives sont omises. | | | | | | |
| 3. Titre invalide | US-01 | Un titre vide ou composé uniquement d'espaces est refusé sans ajout de tâche. | | | | | | |
| 4. Liste de plusieurs tâches | US-04 | Toutes les tâches sont affichées avec l'ensemble de leurs informations. | Deux tâches de démonstration (titre, priorité, échéance, statut variés). | Les cinq champs de chaque tâche affichés clairement. | Affichage correct des cinq champs, lisible, conforme (CA1/CA2), confirmé par Sofiane en revue. | Conforme | `a48ed26` (PR #51, fusionnée) | Partiellement conforme — les tâches et leurs champs s’affichent, mais les accents sont mal rendus dans le terminal.|
| 5. Tâche terminée | US-05 | Seul le statut de la tâche sélectionnée change ; une tâche déjà terminée est correctement signalée. | Tâche d'ID 2 existante ; appel de `terminer(2)` une première fois, puis une seconde fois. | Statut → Terminée avec confirmation ; second appel signale « déjà terminée » sans modification. | Statut changé correctement (CA1/CA2), seul le statut modifié (CA3), doublon détecté sans nouvelle modification (CA5), confirmé par Sofiane en revue. | Conforme | `1331c7a` (PR #52, fusionnée) | Conforme pour le comportement — le premier appel termine la tâche; le second signale qu’elle est déjà terminée, sans nouvelle modification. Accents mal rendus dans le terminal.|
| 6. Identifiant inconnu | US-05, US-06, US-07, US-08, US-09 | L'application affiche un message et conserve les données existantes. | ID `999` (inexistant) et `abc` (non numérique) passés à `terminer()`. | Message d'erreur, aucune donnée modifiée. | Rejet correct des deux cas pour US-05 (CA4), confirmé par Sofiane en revue. US-06 à US-09 non codées : scénario non testable pour ces récits. | Partiellement conforme (US-05 seulement) | `1331c7a` (PR #52, fusionnée) | Fonctionnellement conforme pour US-05 — les identifiants 999 et abc sont rejetés; les tâches existantes restent inchangées. Accents mal rendus dans le terminal.|
| 7. Priorité | US-02, US-06 | Les valeurs autorisées sont acceptées ; une valeur invalide est refusée sans modifier la priorité actuelle. | Tâche d'ID 2 (priorité `Normale`) ; saisie `Élevée`, puis `Urgente`. | Priorité changée pour une valeur valide ; valeur invalide refusée avec message, priorité inchangée. | Pour US-06 : priorité changée avec confirmation (CA1/CA2) ; `Urgente` refusée avec message, priorité restée `Normale` (CA3/CA5) ; identifiants `99` et `abc` refusés (CA4). Résultats pour US-02 (Sofiane) non couverts ici. | Conforme (US-06 seulement) | `5c12546` (PR #40, non fusionnée) | |
| 8. Échéance | US-03, US-07, US-08, US-09 | L'ajout, la modification et le retrait fonctionnent ; dates valides acceptées, formats incorrects et dates impossibles refusés. | | | | | | |
| 9. Sauvegarde et redémarrage | US-10, US-12 | Toutes les informations sont retrouvées, y compris identifiants, statuts et échéances absentes. | | | | | | |
| 10. Ajout après rechargement | US-01, US-12 | La nouvelle tâche reçoit un identifiant distinct de ceux déjà chargés. | | | | | | |
| 11. Fichier absent ou mal formé | US-13, US-14 | Fichier absent → démarrage avec liste vide ; fichier mal formé/illisible → message et interruption sans modifier le fichier. | | | | | | |
| 12. Échec d'écriture | US-11 | Une sauvegarde impossible est signalée comme un échec, sans message de réussite. | `--demo`, choix 5 vers 4 emplacements temporaires non accessibles en écriture : parent qui est un fichier, chemin qui est un dossier, dossier en lecture seule, fichier en lecture seule (détail plus bas). | Message d'erreur clair, aucun message de réussite, retour au menu, tâches conservées en mémoire, fichier existant inchangé. | Dans les 4 cas, « Erreur : impossible de sauvegarder les tâches (…) » avec la raison en français ; aucun message de réussite ; « Afficher » montre encore les 2 tâches ; le fichier protégé garde son contenu ; pas de plantage. | Conforme (CA1, CA2, CA3) | `e00add1` | |
## Vérifications de Marc-Raphaël — US-07

| Vérification | Saisie | Résultat |
|---|---|---|
| Date valide | Tâche 1, `2026-10-20` | Acceptée |
| Date impossible | Tâche 1, `2026-02-30` | Refusée |
| Date passée | Tâche 2, `2026-10-05` | Acceptée |
| Identifiant inexistant | `99` | Erreur affichée |
| Identifiant non numérique | `abc` | Refusé |

## Vérifications de Mathieu — US-11

Reproduire l'échec sans changer de droits (vérifié sous macOS) : lancer `java -cp out taskflow.Main --demo data/bloque`, choisir 5 puis 0, ce qui crée le fichier `data/bloque` ; relancer avec `--demo data/bloque/Sauvegarde.txt` et choisir 5.

| Vérification | Saisie | Résultat |
|---|---|---|
| Sauvegarde normale | `--demo`, choix 5 | « Tâches sauvegardées avec succès. » ; fichier identique à `donnees-test/exemple.txt` |
| Parent qui est un fichier | `--demo data/bloque/Sauvegarde.txt`, choix 5 | « Erreur : impossible de sauvegarder les tâches (« …/data/bloque » est un fichier et non un dossier). » ; aucune réussite |
| Chemin qui est un dossier | `--demo un-dossier`, choix 5 | « Erreur : impossible de sauvegarder les tâches (le fichier « un-dossier » n'a pas pu être écrit). » ; aucune réussite |
| Dossier en lecture seule | Dossier temporaire en `chmod 555`, choix 5 | « Erreur : impossible de sauvegarder les tâches (accès refusé à « lecture-seule/Sauvegarde.txt »). » ; aucune réussite |
| Fichier en lecture seule | Fichier temporaire en `chmod 444`, choix 5 | « Erreur : impossible de sauvegarder les tâches (accès refusé à « protege.txt »). » ; aucune réussite, contenu inchangé |