
# TaskFlow — Backlog produit

**Cours :** INF1763 — Techniques et outils professionnels de développement logiciel  
**Projet :** Mini-projet 1 — Organisation agile et développement collaboratif

## 1. Objectif

Ce backlog présente les 12 récits utilisateurs de TaskFlow, une application Java en ligne de commande permettant à un utilisateur de gérer ses tâches.

Chaque récit comprend sa description, ses critères d'acceptation, sa priorité, son estimation, ses dépendances et les vérifications permettant de confirmer son bon fonctionnement.

## 2. Échelle de priorité

- **P1 — Très élevée :** fonctionnalité fondamentale.
- **P2 — Élevée :** fonctionnalité complémentaire ou gestion d'un cas particulier obligatoire.
- **P3 - Normale :** fonctionnalité obligatoire mais non cruciale

**Estimation :** points d'effort proposés à valider par l'équipe.

---

## US-01 — Ajouter une tâche

**Priorité :** P1 — Très élevée  
**Estimation :** 5 points, crucial pour le projet, plus de temps doit lui être accordé

### Récit utilisateur

En tant qu'utilisateur de soutien, je veux ajouter une tâche afin de conserver une trace du travail à effectuer.

### Critères d'acceptation

- [ ] CA1 : Lorsqu'un titre valide est fourni, l'application crée une tâche avec un identifiant positif unique et le statut `À faire`.
- [ ] CA2 : Si aucune priorité n'est précisée ou la valeur entrée est invalide, la priorité par défaut est `Normale`, sinon elle prend la valeur entrée, soit `Basse`, `Normale` ou `Élevée`.
- [ ] CA3 : Si aucune échéance n'est fournie ou la valeur entrée ne suit pas le format `AAAA-MM-JJ` la tâche est créée sans échéance, sinon elle prend la valeur entrée.
- [ ] CA4 : Un titre vide ou composé uniquement d'espaces est refusé sans créer de tâche, et un message explique l'erreur, sinon il prend la velur entrée.
- [ ] CA5 : Après un ajout réussi, l'application confirme la création et affiche l'identifiant attribué.
- [ ] CA6 : Il est possible à tout moment d'annuler la création d'une tâche.

### Dépendances

- Aucune dépendance fonctionnelle préalable.
- Nécessite la structure de données `Task` et un mécanisme de génération d'identifiants.

### Vérification

- Ajouter une tâche avec un titre valide et vérifier que son identifiant est positif et son statut est `À faire`.
- Ajouter une tâche sans priorité ni échéance et vérifier les valeurs par défaut.
- Tenter d'ajouter une tâche avec un titre vide ou composé d'espaces et vérifier qu'aucune tâche n'est créée.

---

## US-02 — Afficher la liste des tâches

**Priorité :** P1 — Très élevée  
**Estimation :** 2 points, quelques lignes de codes

### Récit utilisateur

En tant qu'utilisateur, je veux consulter la liste des tâches afin de connaître le travail à effectuer et son état d'avancement.

### Critères d'acceptation

- [ ] CA1 : Chaque tâche affiche son identifiant, son titre, sa priorité, son échéance ou l'absence d'échéance, et son statut.
- [ ] CA2 : Toutes les tâches existantes sont affichées dans un format clair et lisible.
- [ ] CA3 : Si aucune tâche n'existe, l'application affiche un message explicite indiquant que la liste est vide.

### Dépendances

- Dépend d'un jeu de test, pour disposer de tâches à afficher.
- Nécessite l'accès à la collection de tâches.

### Vérification

- Ajouter plusieurs tâches et vérifier que toutes leurs informations sont affichées.
- Vérifier l'affichage d'une tâche sans échéance.
- Afficher la liste lorsque celle-ci est vide et vérifier le message présenté.

---

## US-03 — Marquer une tâche comme terminée

**Priorité :** P1 — Très élevée  
**Estimation :** 2 points, quelques lignes de codes

### Récit utilisateur

En tant qu'utilisateur, je veux marquer une tâche comme terminée afin de suivre l'avancement du travail.

### Critères d'acceptation

- [ ] CA1 : Lorsqu'un identifiant existant est fourni, le statut de la tâche sélectionnée passe à `Terminée`.
- [ ] CA2 : L'application confirme le changement de statut.
- [ ] CA3 : Les autres informations de la tâche et les autres tâches restent inchangées.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application affiche un message d'erreur.
- [ ] CA5 : Si la tâche est déjà terminée, l'application le signale sans effectuer de modification inutile.

### Dépendances

- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche existante.
- Dépend de **US-02 — Afficher la liste des tâches**, pour faciliter la consultation des identifiants.

### Vérification

- Marquer une tâche existante comme terminée et vérifier son nouveau statut.
- Vérifier que les autres champs de la tâche restent inchangés.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.
- Tenter de terminer une tâche déjà terminée et vérifier le comportement.

---

## US-04 — Modifier la priorité d'une tâche

**Priorité :** P2 — Élevée  
**Estimation :** 2 points, quelques lignes de codes

### Récit utilisateur

En tant qu'utilisateur, je veux modifier la priorité d'une tâche afin d'adapter son importance aux besoins du service.

### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut sélectionner une tâche existante à l'aide de son identifiant.
- [ ] CA2 : Les valeurs `Basse`, `Normale` et `Élevée` sont acceptées.
- [ ] CA3 : Une priorité invalide est refusée et la priorité actuelle reste inchangée.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.
- [ ] CA5 : La modification de la priorité ne change pas les autres informations de la tâche.

### Dépendances

- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche à modifier.

### Vérification

- Modifier la priorité d'une tâche vers chacune des valeurs autorisées.
- Saisir une priorité invalide et vérifier que l'ancienne valeur est conservée.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.
- Vérifier que les autres informations restent inchangées.

---

## US-05 — Attribuer une échéance à une tâche

**Priorité :** P3 — Normale 
**Estimation :** 2 points, quelques lignes de codes

### Récit utilisateur

En tant qu'utilisateur, je veux attribuer une échéance à une tâche afin de connaître la date prévue pour son exécution.

### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut attribuer une date valide à une tâche existante.
- [ ] CA2 : La date respecte le format `AAAA-MM-JJ` et correspond à une date réelle du calendrier.
- [ ] CA3 : Une date impossible ou un format incorrect est refusé sans modifier l'échéance existante.
- [ ] CA4 : Les dates passées sont acceptées.
- [ ] CA5 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

### Dépendances

- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche existante.

### Vérification

- Attribuer une date valide et vérifier qu'elle est enregistrée.
- Essayer une date impossible, par exemple `2026-02-30`, et vérifier son refus.
- Essayer un format incorrect et vérifier que l'échéance reste inchangée.
- Vérifier qu'une date passée est acceptée.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

## US-06 — Modifier une échéance existante

**Priorité :** P3 — Normale  
**Estimation :** 2 points,  quelques lignes de codes

### Récit utilisateur

En tant qu'utilisateur, je veux modifier l'échéance d'une tâche afin de tenir compte d'un changement de calendrier.

### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut remplacer l'échéance d'une tâche existante par une nouvelle date valide.
- [ ] CA2 : La nouvelle date remplace l'ancienne sans modifier le titre, la priorité ou le statut.
- [ ] CA3 : Une date invalide est refusée et l'ancienne échéance est conservée.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

### Dépendances

- Dépend de **US-05 — Attribuer une échéance à une tâche**, pour disposer du mécanisme de gestion des échéances.
- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche existante.

### Vérification

- Remplacer une échéance par une autre date valide et vérifier le résultat.
- Saisir une date invalide et vérifier que l'ancienne échéance est conservée.
- Vérifier que les autres informations ne changent pas.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

## US-07 — Retirer l'échéance d'une tâche

**Priorité :** P3 — Normale  
**Estimation :** 2 points, quelques lignes de codes

### Récit utilisateur

En tant qu'utilisateur, je veux retirer l'échéance d'une tâche afin de ne plus lui associer de date limite.

### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut retirer l'échéance d'une tâche existante à l'aide de son identifiant.
- [ ] CA2 : Après le retrait, la tâche est conservée et son échéance est indiquée comme absente.
- [ ] CA3 : Le titre, la priorité, l'identifiant et le statut restent inchangés.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

### Dépendances

- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche existante.
- Dépend de **US-05 — Attribuer une échéance à une tâche**, pour utiliser le mécanisme de gestion des échéances.

### Vérification

- Retirer l'échéance d'une tâche et vérifier qu'elle est désormais absente.
- Vérifier que la tâche et ses autres informations sont conservées.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

## US-08 — Sauvegarder les tâches dans un fichier

**Priorité :** P1 — Très élevée  
**Estimation :** 5 points, crucial, besoin de plus de temps que les autres

### Récit utilisateur

En tant qu'utilisateur, je veux sauvegarder explicitement les tâches dans un fichier local afin de conserver mes données après la fermeture du programme.

### Critères d'acceptation

- [ ] CA1 : Une commande explicite permet de sauvegarder les données dans un fichier local.
- [ ] CA2 : La sauvegarde conserve toutes les informations des tâches, y compris les identifiants, les priorités, les statuts et les échéances absentes.
- [ ] CA3 : Un message de réussite est affiché uniquement si la sauvegarde réussit.
- [ ] CA4 : Si l'écriture échoue, l'application signale clairement l'échec et n'annonce pas une sauvegarde réussie.

### Dépendances

- Dépend d'un jeu de test pour disposer de données à sauvegarder.
- Nécessite un mécanisme d'écriture dans un fichier local.

### Vérification

- Ajouter plusieurs tâches et lancer la sauvegarde.
- Vérifier que le fichier contient toutes les informations nécessaires.
- Vérifier qu'un message de réussite apparaît après une sauvegarde réussie.
- Provoquer un échec d'écriture et vérifier que l'application signale l'échec.

---

## US-09 — Recharger les tâches sauvegardées au démarrage

**Priorité :** P2 — Élevée  
**Estimation :** 2 points, quelques lignes de codes

### Récit utilisateur

En tant qu'utilisateur, je veux retrouver automatiquement mes tâches sauvegardées au démarrage afin de reprendre le travail sans ressaisir les données.

### Critères d'acceptation

- [ ] CA1 : Au démarrage, si un fichier de données valide existe, l'application recharge automatiquement les tâches.
- [ ] CA2 : Les informations et les identifiants restent identiques après le rechargement.
- [ ] CA3 : Une nouvelle tâche créée après le rechargement reçoit un identifiant distinct de ceux déjà présents.
- [ ] CA4 : Les tâches sans échéance sont également rechargées correctement.

### Dépendances

- Dépend de **US-08 — Sauvegarder les tâches dans un fichier**, pour disposer d'un fichier de données à recharger.
- Nécessite un mécanisme de lecture du fichier local.

### Vérification

- Créer plusieurs tâches, les sauvegarder, fermer l'application et la redémarrer.
- Vérifier que toutes les tâches et leurs informations sont restaurées.
- Comparer les identifiants avant et après le redémarrage.
- Ajouter une nouvelle tâche après le rechargement et vérifier l'unicité de son identifiant.

---

## US-10 — Démarrer sans fichier de données existant

**Priorité :** P3 — Normale 
**Estimation :** 2 points,  quelques lignes de codes, lié à US-09

### Récit utilisateur

En tant qu'utilisateur, je veux pouvoir démarrer l'application sans fichier de données existant afin de commencer à gérer mes tâches.

### Critères d'acceptation

- [ ] CA1 : Si le fichier de données n'existe pas au démarrage, l'application démarre avec une liste vide.
- [ ] CA2 : L'absence du fichier ne provoque pas d'erreur empêchant l'utilisation de l'application.
- [ ] CA3 : L'affichage de la liste vide présente un message explicite.

### Dépendances

- Dépend de **US-09 — Recharger les tâches sauvegardées au démarrage**, car cette fonctionnalité doit distinguer un fichier absent d'un fichier valide existant.

### Vérification

- Lancer l'application dans un environnement où le fichier de données n'existe pas.
- Vérifier que l'application démarre normalement.
- Afficher la liste et vérifier qu'elle est vide.

---

## US-11 — Gérer un fichier de données illisible ou mal formé

**Priorité :** P3 — Normale 
**Estimation :** 3 points,  quelques lignes de codes, besoin de recherche

### Récit utilisateur

En tant qu'utilisateur, je veux être averti si le fichier de données est illisible ou mal formé afin d'éviter d'utiliser des données incorrectes.

### Critères d'acceptation

- [ ] CA1 : Si le fichier existant est illisible ou mal formé, l'application affiche un message d'erreur clair.
- [ ] CA2 : Le démarrage est interrompu plutôt que de poursuivre avec des données potentiellement incorrectes.
- [ ] CA3 : Le fichier d'origine n'est pas modifié par cette tentative de chargement.

### Dépendances

- Dépend de **US-09 — Recharger les tâches sauvegardées au démarrage**, car ce récit couvre les erreurs rencontrées lors du chargement.

### Vérification

- Créer un fichier de données mal formé et démarrer l'application.
- Vérifier qu'un message d'erreur clair est affiché.
- Vérifier que l'application interrompt son démarrage.
- Comparer le fichier avant et après la tentative pour vérifier qu'il n'a pas été modifié.

---

## US-12 — Signaler un échec de sauvegarde

**Priorité :** P2 — Élevée  
**Estimation :** 3 points, quelques lignes de codes, besoin de recherche

### Récit utilisateur

En tant qu'utilisateur, je veux être averti lorsqu'une sauvegarde échoue afin de savoir que mes données n'ont pas été enregistrées correctement.

### Critères d'acceptation

- [ ] CA1 : Si le fichier ne peut pas être écrit, l'application affiche un message clair indiquant l'échec.
- [ ] CA2 : L'application n'affiche jamais un message de réussite lorsque l'écriture a échoué.
- [ ] CA3 : L'échec peut être reproduit manuellement, par exemple en utilisant un emplacement de sauvegarde non accessible en écriture.

### Dépendances

- Dépend de **US-08 — Sauvegarder les tâches dans un fichier**, car ce récit vérifie spécifiquement le comportement en cas d'échec de sauvegarde.

### Vérification

- Tenter une sauvegarde vers un emplacement non accessible en écriture.
- Vérifier que l'application affiche un message d'échec.
- Vérifier qu'aucun message de réussite n'est affiché à tort.

---

## 4. Règles de gestion du backlog

- Chaque récit possède un identifiant stable.
- Chaque récit comporte au moins deux critères d'acceptation vérifiables.
- Les priorités et les estimations sont validées collectivement par l'équipe.
- Les dépendances indiquent les récits nécessaires à la réalisation ou à la vérification d'un autre récit.
- Les vérifications doivent préciser les scénarios exécutés et les résultats attendus.
- Les récits sont reliés aux Issues GitHub, aux pull requests et aux vérifications correspondantes.
- Un récit est considéré comme terminé uniquement lorsque ses critères sont satisfaits, les vérifications pertinentes réalisées, le changement intégré, la revue de code effectuée et la documentation utile mise à jour.

---

