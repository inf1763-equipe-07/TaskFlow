# Résultat des vérifications du prototype

- Compilateur : `javac 21.0.12.1`, compilation en mode `--release 17 -Xlint:all`, **sans erreur ni avertissement**.
- Système d'exécution : environnement Linux de développement ; **Windows/PowerShell non testé**.
- Commande : `python propositions/sofiane/tests/verifier_console.py` après compilation du Java.
- **16 vérifications automatisées réussies** : démarrage sans données, liste vide, titre vide, priorité incorrecte, date impossible, mauvais format, sauvegarde, chargement, identifiants après redémarrage, valeurs par défaut, tâche déjà terminée, modification de priorité, échéance définie/retirée, annulation, identifiant invalide ou inconnu, fichier corrompu intact, échec d'écriture, avertissement avant de quitter.

**Limite :** ces 16 vérifications sont des essais ciblés du prototype, pas une validation formelle des scénarios officiels du professeur ni une revue collective des PR.
