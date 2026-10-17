# TaskFlow — Vérifications

**Projet :** INF1763 — Mini-projet 1, équipe 07  
**Responsable du document :** Marc-Raphaël Chehab — Responsable qualité et tests  
**Suivi :** [Issue #41 — US-07 : Attribuer une échéance à une tâche existante](https://github.com/inf1763-equipe-07/TaskFlow/issues/41)

---


## US-07 — Attribuer une échéance

Commande de compilation : `javac -d out (Get-ChildItem src -Recurse -Filter *.java).FullName`  
Commande de lancement : `java -cp out taskflow.Main --demo`

| Vérification | Saisie | Résultat obtenu |
|---|---|---|
| Attribuer une date valide | Tâche 1, `2026-10-20` | Échéance attribuée avec succès |
| Refuser une date impossible | Tâche 1, `2026-02-30` | Date refusée avec un message d’erreur |
| Accepter une date passée | Tâche 2, `2026-10-05` | Échéance attribuée avec succès |
| Signaler un identifiant inexistant | `99` | Message indiquant qu’aucune tâche ne possède cet identifiant |
| Refuser un identifiant non numérique | `abc` | Message indiquant que l’identifiant doit contenir uniquement des chiffres |