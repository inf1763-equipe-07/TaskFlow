# Vérification

À tenir par le Responsable Qualité/Test (Marc-Raphaël).

> Gabarit minimal proposé en attendant la reprise du document par le Responsable Qualité/Test, basé sur la couverture minimale des vérifications de l'énoncé (§8.2). À compléter avec le commit testé, les données réelles et les résultats observés pour chaque récit livré.

| Scénario | Récit(s) concerné(s) | Comportement attendu | Données utilisées | Résultat attendu | Résultat observé | Conclusion | Commit testé |
|---|---|---|---|---|---|---|---|
| 1. Liste vide | US-04 | L'application indique clairement qu'aucune tâche n'est présente. | | | | | |
| 2. Ajout valide | US-01 | La tâche reçoit un identifiant et les valeurs par défaut attendues lorsque les informations facultatives sont omises. | | | | | |
| 3. Titre invalide | US-01 | Un titre vide ou composé uniquement d'espaces est refusé sans ajout de tâche. | | | | | |
| 4. Liste de plusieurs tâches | US-04 | Toutes les tâches sont affichées avec l'ensemble de leurs informations. | | | | | |
| 5. Tâche terminée | US-05 | Seul le statut de la tâche sélectionnée change ; une tâche déjà terminée est correctement signalée. | | | | | |
| 6. Identifiant inconnu | US-05, US-06, US-07, US-08, US-09 | L'application affiche un message et conserve les données existantes. | | | | | |
| 7. Priorité | US-02, US-06 | Les valeurs autorisées sont acceptées ; une valeur invalide est refusée sans modifier la priorité actuelle. | | | | | |
| 8. Échéance | US-03, US-07, US-08, US-09 | L'ajout, la modification et le retrait fonctionnent ; dates valides acceptées, formats incorrects et dates impossibles refusés. | | | | | |
| 9. Sauvegarde et redémarrage | US-10, US-12 | Toutes les informations sont retrouvées, y compris identifiants, statuts et échéances absentes. | | | | | |
| 10. Ajout après rechargement | US-01, US-12 | La nouvelle tâche reçoit un identifiant distinct de ceux déjà chargés. | | | | | |
| 11. Fichier absent ou mal formé | US-13, US-14 | Fichier absent → démarrage avec liste vide ; fichier mal formé/illisible → message et interruption sans modifier le fichier. | | | | | |
| 12. Échec d'écriture | US-11 | Une sauvegarde impossible est signalée comme un échec, sans message de réussite. | | | | | |
