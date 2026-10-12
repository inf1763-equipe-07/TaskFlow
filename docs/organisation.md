# TaskFlow — Organisation de l'équipe · MP1

> Notre façon de travailler pour le mini-projet 1. Ce document fixe **comment** on travaille ; le **contenu** (récits, priorités, itérations) se construit ensemble dans GitHub.
>
> **Statut : proposition.** Elle est ouverte en PR. Chacun commente et propose ses modifications directement dans la PR ; la version finale est fusionnée au lancement de l'itération 1.
>

## 1. Objectif du produit et de l'équipe

**Le produit.** TaskFlow est un outil interne pour une équipe de soutien informatique : conserver une liste de tâches, leur donner une priorité et une échéance, les marquer comme terminées, et retrouver ses données à la prochaine utilisation. C'est une application Java en console.

**Ce qu'on livre et remet.** L'application, le dépôt GitHub avec tout son historique, et la documentation. À la remise (semaine 7, date sur Moodle) : le lien du dépôt, l'identifiant du commit final et l'archive `TaskFlow_MP1_EquipeXX.zip`.

**Ce qui compte le plus.** La démarche. Les Issues, les PR, les revues et le tableau pèsent plus lourd que le code.

**Chacun doit pouvoir montrer :**
- au moins 2 récits dont il est l'auteur principal ;
- au moins 1 PR de code ;
- au moins 1 revue de la PR d'un autre membre ;
- sa participation au backlog et aux vérifications ;
- qu'il sait expliquer ce qu'il a fait.

---

## 2. Organisation de l'équipe

### Rôles

Rôles proposés à la première rencontre d'équipe, attribués en séance de lancement. Ahmed a déjà pris l'Intégrateur (ce rôle remplace celui de « développeur » : comme tout le monde développe, il s'occupe de l'intégration). Chacun a un rôle, un domaine de code et un document. Le rôle s'ajoute au code, il ne le remplace pas.

| Rôle | Membre | Ce qu'il fait | Son document |
|---|---|---|---|
| Product Owner | Emilien | Valide les récits, ordonne le backlog, propose l'objectif et le contenu de chaque itération. Administre le tableau. | `docs/organisation.md` |
| Scrum Master | Sofiane | Seul point de coordination : anime les rendez-vous, suit le tableau, relance, note les relances et les mesures prises. | `docs/iterations.md` |
| Intégrateur | Ahmed | Prépare le démarrage (ce document, le dépôt, le socle). Administre le dépôt (accès, protection de `main`), gère les fusions et les conflits. | `CONTRIBUTING.md` |
| Responsable Qualité/Test | Marc-Rafael | Exécute les vérifications sur un clone propre et veille à la définition de terminé. | `docs/verification.md` |
| Responsable de la documentation | Mathieu | Tient le README, vérifie la cohérence des documents, fait la remise sur Moodle. | `README.md` |

- Chacun ajoute aux documents ce qui concerne ses propres récits, et écrit lui-même sa ligne de contribution.
- Toute modification d'un document passe par une PR.
- Le dépôt appartient à l'organisation GitHub de l'équipe, et les droits de chacun suivent son rôle (détail dans `CONTRIBUTING.md`).

### Domaines

Chacun possède un domaine de bout en bout (affichage, logique, fichier) pendant tout le MP1, et en écrit les récits.

| Domaine | Ce qu'il couvre | Propriétaire |
|---|---|---|
| A — Ajout | ajouter une tâche (titre, priorité, échéance) et refuser les saisies invalides | Sofiane |
| B — Consultation et modification | afficher la liste, marquer une tâche terminée, modifier sa priorité | Ahmed |
| C — Échéance | attribuer, modifier et retirer une échéance | Marc-Raphaël |
| D — Sauvegarde | sauvegarder dans le fichier, signaler un échec de sauvegarde | Mathieu |
| E — Chargement | retrouver ses tâches au démarrage, démarrer sans fichier, gérer un fichier abîmé | Émilien |

Les domaines sont attribués en séance de lancement, avec les rôles. Chaque domaine a un point d'entrée et des zones dans le socle (voir `CONTRIBUTING.md`).

### Qui fait quoi : ensemble ou seul

**On décide ensemble, on réalise seul.** Les décisions se prennent au rendez-vous ou dans une PR. Le travail se fait sans attendre personne et se voit sur le tableau.

| Document ou livrable | Quoi | Fait par | Validé par | Quand |
|---|---|---|---|---|
| **Ce document** (`docs/organisation.md`) | première version, ouverte en PR avec `CONTRIBUTING.md` et le README (T1) | Intégrateur | toute l'équipe (commentaires de la PR) | avant le lancement de l'itération 1 |
| | format du fichier, version du JDK (voir `README.md`) | Intégrateur propose | toute l'équipe (PR) | avant la séance de lancement |
| | mise à jour : backlog, itérations, ajustements | Product Owner | toute l'équipe | pendant les itérations |
| | ligne de contribution | chacun pour soi | Responsable de la documentation | en fin de projet |
| | attribution des rôles et des domaines | toute l'équipe, en séance | — | séance de lancement |
| **Dépôt GitHub** | création, accès, protection de `main` (T0) | Intégrateur | — | avant la séance de lancement |
| | socle (T2) | Intégrateur | toute l'équipe (commentaires de la PR) | avant la séance de lancement |
| **Tableau** | colonnes, règles de passage | Intégrateur propose | toute l'équipe (PR T1) | avant le lancement de l'itération 1 |
| | champs Domaine, Itération, Estimation | Product Owner, avec l'équipe | toute l'équipe | entre la séance et le lancement de l'itération 1 |
| **Issues** (backlog) | propositions de récits sur tout le produit | chacun, dans l'Issue « Propositions de récits » | — | avant la séance de lancement |
| | regroupement en un backlog commun | toute l'équipe, en séance | — | séance de lancement |
| | récits de son domaine | propriétaire | Product Owner | entre la séance et le lancement de l'itération 1 |
| | estimation de ses récits | chacun | toute l'équipe | entre la séance et le lancement de l'itération 1 |
| | ordre du backlog, contenu de chaque itération | Product Owner propose | toute l'équipe | avant l'itération 1, puis à chaque itération |
| **Pull requests** | code d'un récit | propriétaire | relecteur désigné | pendant les itérations |
| | revue | relecteur désigné | — | sous 48 h |
| | conflit entre deux domaines | auteurs concernés | Intégrateur | à la fusion |
| **`docs/verification.md`** et `donnees-test/` | vérifications et données de ses récits | propriétaire | Responsable Qualité/Test | pendant les itérations |
| | vérification complète sur un clone propre | Responsable Qualité/Test | — | à la fin de chaque itération |
| **`docs/iterations.md`** | comptes rendus : planification, revue, rétrospective | Scrum Master | toute l'équipe | à chaque rendez-vous |
| | blocages, relances, mesures | Scrum Master | toute l'équipe (pour les mesures) | pendant les itérations |
| **`CONTRIBUTING.md`** | règles de contribution, architecture, IA | Intégrateur | toute l'équipe (PR) | avant le lancement de l'itération 1 |
| **`README.md`** | sa ligne « Équipe » (nom, rôle, domaine) | chacun, par sa première PR | un autre membre | après la séance de lancement |
| | description, commandes, fichier de données | Responsable de la documentation, avec chacun pour ses fonctionnalités | — | pendant les itérations |
| **Remise Moodle** | lien, commit final, archive | Responsable de la documentation | toute l'équipe (Issue « Livraison MP1 ») | en fin de projet |

### Communication

**Tout se passe sur GitHub.** Ce qui n'y est pas écrit n'existe pas.

| Type d'échange | Entre qui | Où |
|---|---|---|
| Technique (question, revue, conflit) | directement entre les membres concernés | dans l'Issue ou la PR |
| Coordination (avancement, blocage, retard, relance) | toujours par le Scrum Master | dans l'Issue, avec `@membre` |
| Décision | toute l'équipe | au rendez-vous, notée dans `docs/iterations.md` |

- Chacun suit le dépôt (*Watch*) pour recevoir les mentions par courriel.
- **Bloqué ?** Commentaire dans l'Issue, label *bloqué*, mention du Scrum Master. La carte reste dans sa colonne : le blocage se signale par le label, il n'y a pas de colonne « Bloqué ».

**Relances :**

| Quand | Le Scrum Master… |
|---|---|
| Carte immobile depuis 3 jours, ou PR sans revue depuis 48 h | relance dans l'Issue, avec une échéance de 48 h |
| Toujours rien | relance une deuxième fois (24 h) et inscrit le point au rendez-vous |
| Toujours rien | propose une mesure, décidée ensemble : aide, découpage ou réaffectation du récit |

Une réponse, c'est un commentaire qui donne l'état, la prochaine étape et une date. Le Scrum Master garde un tableau des relances, réponses et mesures dans `docs/iterations.md`.

**Rendez-vous :**
- Chaque vendredi, en ligne : revue, rétrospective, planification.
- Le cours du mercredi et le TD du lundi servent au besoin.
- Le compte rendu est publié dans les 24 h.

**Décisions :** par consensus. Sinon, le PO tranche sur le produit, la majorité sur le reste.

### Mise en place : dépôt (T0), documents (T1) et socle (T2)

- **T0 — Dépôt.** L'Intégrateur crée l'organisation de l'équipe et le dépôt, invite tout le monde, prépare le tableau et protège `main`. C'est la seule fois où l'on travaille directement sur `main` ; ensuite, tout passe par une PR. Les droits et les réglages sont dans `CONTRIBUTING.md`. Ces choix (organisation rattachée au compte de l'Intégrateur, dépôt public) sont des propositions : on peut les changer.
- **T1 — Documents d'équipe.** Ce document, `CONTRIBUTING.md` et le README sont ouverts en PR, avant le socle, pour que chacun puisse les lire avant la séance de lancement. Chacun commente les lignes concernées, ou propose une modification avec la fonction *suggestion* de GitHub. La PR reste ouverte jusqu'au lancement de l'itération 1, et sa fusion vaut validation par l'équipe.
- **T2 — Socle.** Le code de départ commun : un menu qui tourne, le modèle de base, un point d'entrée vide pour chaque domaine et les zones partagées (voir `CONTRIBUTING.md`). Il ne contient que ce que plusieurs domaines partagent. L'Intégrateur ouvre la PR avant la séance de lancement, avec une description de chaque classe ; chacun la commente pour vérifier que le socle couvre son domaine ; elle est fusionnée après au moins une approbation. Le détail technique (commandes, format du fichier, données de test) est dans le README.
- **Première PR de chacun.** Après la séance de lancement, chacun ajoute sa ligne (nom, rôle, domaine) dans la section « Équipe » du README. On pratique ainsi tout le circuit sur un vrai cas. Cinq personnes modifient la même section : il y aura des conflits à résoudre, et c'est voulu. Un autre membre relit chaque PR ; l'Intégrateur fixe l'ordre des fusions.

---

## 3. Backlog

Le backlog est dans les Issues du dépôt, suivies dans le tableau :
- Issues : https://github.com/inf1763-equipe-07/TaskFlow/issues
- Tableau : https://github.com/orgs/inf1763-equipe-07/projects/1

**Règles pour les récits :**
- Avant la séance de lancement, chacun propose des récits sur tout le produit, en commentaire de l'Issue « Propositions de récits ». En séance, on les regroupe en un backlog commun ; ensuite, chaque propriétaire écrit les Issues des récits de son domaine.
- Au moins 12 récits au total, au moins 2 par membre.
- Un récit = une action de l'utilisateur. Un cas d'erreur (titre vide, date impossible…) est un critère, pas un récit.
- Chaque Issue contient : `US-xx` dans le titre, « En tant que… je veux… afin de… », au moins 2 critères vérifiables, une estimation avec ses hypothèses, la priorité avec sa justification, et quelques notes techniques.
- Le PO relit chaque Issue sous 24 h. Il demande les corrections en commentaire, puis ajoute la priorité et déplace la carte de « Brouillon » à « À faire ». À partir de là, le récit peut être codé.
- Les tâches techniques (comme T0, T1 et T2) et les anomalies sont des Issues distinctes des récits, signalées par leur label.
- Une idée en dehors du projet devient une Issue *amélioration*, à prendre seulement s'il reste du temps.

**Le tableau :**
- Les cartes sont des récits, des tâches techniques et des anomalies. Le label dit de quelle sorte il s'agit.
- Colonnes :
  - **Brouillon :** le récit est en cours de rédaction, pas encore validé par le PO. On ne le code pas.
  - **À faire :** validé par le PO, prêt à être codé.
  - **En cours :** une branche existe, quelqu'un y travaille.
  - **À vérifier :** la PR est ouverte, en attente de revue.
  - **Terminé :** la définition de terminé est satisfaite et la PR est fusionnée.
- Passages entre colonnes :
  - on prend son Issue → **En cours** ;
  - la PR est ouverte → **À vérifier** ;
  - la revue demande des changements → retour en **En cours** ;
  - la PR est fusionnée → **Terminé**.
- Ne déplacez une carte vers « Terminé » qu'après la fusion : le tableau ferme alors l'Issue automatiquement.
- Champs propres au tableau : Domaine, Itération, Estimation. Les champs *Priority* et *Effort* de GitHub ne sont pas utilisés, pour ne pas avoir deux endroits qui disent la même chose.
- Labels : *récit*, *tâche technique*, *anomalie*, *amélioration*, *bloqué*.
- Un défaut trouvé à la vérification devient une Issue *anomalie*, liée au récit concerné.
- Les réglages du tableau et du dépôt (visibilité, protection de `main`, fusion) sont dans `CONTRIBUTING.md`.

---

## 4. Priorités et estimations

**Priorités.** Le Product Owner ordonne le backlog et écrit, dans chaque Issue, la priorité avec sa justification. Il propose l'ordre et le contenu de chaque itération, et l'équipe les valide avant le lancement de l'itération.

**Estimations.**
- Chacun estime ses récits, en indiquant ses hypothèses dans l'Issue.
- L'échelle est commune : 1, 2, 3, 5, 8.
- Un récit de référence est choisi ensemble au lancement de l'itération 1, et l'équipe revoit les estimations ensemble.
- Le nombre est reporté dans le champ *Estimation* du tableau.

---

## 5. Définition de terminé

*Proposition, à discuter en équipe.*

- [ ] Les critères sont satisfaits, cas d'erreur compris.
- [ ] Ça compile et démarre depuis un clone propre.
- [ ] Les règles d'architecture (voir `CONTRIBUTING.md`) sont respectées.
- [ ] Un autre membre a relu et approuvé, avec un vrai commentaire.
- [ ] L'auteur sait expliquer son code.
- [ ] C'est fusionné et l'Issue est fermée.
- [ ] Les vérifications sont ajoutées à `docs/verification.md`.
- [ ] Le README est à jour si le comportement visible change.
- [ ] Données fictives uniquement.

---

## 6. Itérations

*Proposition, à vérifier en équipe. Les dates et la durée de chaque itération sont fixées en séance de lancement, à partir de la date de remise sur Moodle.*

| Étape | Ensemble | Chacun de son côté |
|---|---|---|
| **Avant la séance de lancement** | Commentaires sur la PR des documents et sur celle du socle | Chacun : ses propositions de récits. Intégrateur : T0, PR des documents (T1), PR du socle (T2) et sa fusion |
| **Séance de lancement** (en présentiel) | Regroupement des récits en backlog commun ; attribution des rôles et des domaines ; présentation du socle ; date de fin | — |
| **Entre la séance et le lancement de l'itération 1** | — | Chacun : sa première PR (README), puis les Issues des récits de son domaine ; le PO valide au fil de l'eau |
| **Lancement de l'itération 1** | Fusion de la PR des documents ; choix du récit de référence, revue des estimations, ordre du backlog | — |
| **Itération 1** | En fin d'itération : revue, rétrospective, planification de l'itération 2 | Ses récits : PR ouverte au plus tard 2 jours avant la fin, revue sous 48 h, fusion avant la revue d'itération |
| **Itération 2** | En fin d'itération : revue et rétrospective (en présentiel) | Même rythme que l'itération 1 |
| **Livraison** | Issue « Livraison MP1 » : chacun coche après avoir vérifié ses récits | Responsable Qualité/Test : vérification complète. Responsable de la documentation : remise sur Moodle |

- Chaque domaine a au moins un récit dans chaque itération.
- À la fin de chaque itération, le Responsable Qualité/Test vérifie sur un clone propre et note le commit ; la rétrospective retient au moins une amélioration.
- Après l'itération 2, on ne fait plus que des corrections. Les anomalies restantes sont déclarées.
- **Revue croisée :** à l'itération 1, on relit le membre suivant (1 → 2 … 5 → 1) ; à l'itération 2, celui d'après (1 → 3 … 5 → 2). La façon de relire est dans `CONTRIBUTING.md`.

**Objectifs et résultats.** Le détail de chaque itération (planification, suivi, revue, rétrospective) est dans `docs/iterations.md`. Le résumé :

| Itération | Objectif | Récits | Version (commit) | Vérifications | Observations |
|---|---|---|---|---|---|
| 1 | | | | | |
| 2 | | | | | |

---

## 7. Ajustements

Les changements qu'on apporte à notre démarche, avec la raison. À compléter à chaque rétrospective.

| Ajustement | Raison |
|---|---|
| Le workflow « Auto-close issue » du tableau fermait les Issues placées en « En cours » ; il ne ferme plus qu'en « Terminé » | éviter des Issues fermées avant leur fusion |
| Les modèles d'Issue de récit et de PR sont livrés avec le socle (T2) plutôt qu'avec les documents (T1) | GitHub ne lit les modèles qu'une fois fusionnés dans `main` : ils doivent exister avant l'écriture des premiers récits |

---

## 8. Contribution de chaque membre

Chacun écrit sa ligne, avec des liens vers ses Issues, ses PR et ses revues. Le Responsable de la documentation la vérifie.

| Membre | Rôle | Domaine | Récits (Issues) | Pull requests | Revues |
|---|---|---|---|---|---|

## 9. Backlog détaillé (récits utilisateurs)

La section 3 renvoie aux Issues et au tableau. Le détail de chaque récit, synthétisé par Marc-Raphaël à partir des propositions de l'Issue #4 et mis en forme par Émilien, suit ci-dessous.

### 9.1 Objectif

Ce backlog présente les 12 récits utilisateurs de TaskFlow, une application Java en ligne de commande permettant à un utilisateur de gérer ses tâches.

Chaque récit comprend sa description, ses critères d'acceptation, sa priorité, son estimation, ses dépendances et les vérifications permettant de confirmer son bon fonctionnement.

### 9.2 Échelle de priorité

- **P1 — Très élevée :** fonctionnalité fondamentale.
- **P2 — Élevée :** fonctionnalité complémentaire ou gestion d'un cas particulier obligatoire.
- **P3 - Normale :** fonctionnalité obligatoire mais non cruciale

**Estimation :** points d'effort proposés à valider par l'équipe.

---

### US-01 — Ajouter une tâche

**Priorité :** P1 — Très élevée  
**Estimation :** 5 points, crucial pour le projet, plus de temps doit lui être accordé

#### Récit utilisateur

En tant qu'utilisateur de soutien, je veux ajouter une tâche afin de conserver une trace du travail à effectuer.

#### Critères d'acceptation

- [ ] CA1 : Lorsqu'un titre valide est fourni, l'application crée une tâche avec un identifiant positif unique et le statut `À faire`.
- [ ] CA2 : Si aucune priorité n'est précisée ou la valeur entrée est invalide, la priorité par défaut est `Normale`, sinon elle prend la valeur entrée, soit `Basse`, `Normale` ou `Élevée`.
- [ ] CA3 : Si aucune échéance n'est fournie ou la valeur entrée ne suit pas le format `AAAA-MM-JJ` la tâche est créée sans échéance, sinon elle prend la valeur entrée.
- [ ] CA4 : Un titre vide ou composé uniquement d'espaces est refusé sans créer de tâche, et un message explique l'erreur, sinon il prend la velur entrée.
- [ ] CA5 : Après un ajout réussi, l'application confirme la création et affiche l'identifiant attribué.
- [ ] CA6 : Il est possible à tout moment d'annuler la création d'une tâche.

#### Dépendances

- Aucune dépendance fonctionnelle préalable.
- Nécessite la structure de données `Task` et un mécanisme de génération d'identifiants.

#### Vérification

- Ajouter une tâche avec un titre valide et vérifier que son identifiant est positif et son statut est `À faire`.
- Ajouter une tâche sans priorité ni échéance et vérifier les valeurs par défaut.
- Tenter d'ajouter une tâche avec un titre vide ou composé d'espaces et vérifier qu'aucune tâche n'est créée.

---

### US-02 — Afficher la liste des tâches

**Priorité :** P1 — Très élevée  
**Estimation :** 2 points, quelques lignes de codes

#### Récit utilisateur

En tant qu'utilisateur, je veux consulter la liste des tâches afin de connaître le travail à effectuer et son état d'avancement.

#### Critères d'acceptation

- [ ] CA1 : Chaque tâche affiche son identifiant, son titre, sa priorité, son échéance ou l'absence d'échéance, et son statut.
- [ ] CA2 : Toutes les tâches existantes sont affichées dans un format clair et lisible.
- [ ] CA3 : Si aucune tâche n'existe, l'application affiche un message explicite indiquant que la liste est vide.

#### Dépendances

- Dépend d'un jeu de test, pour disposer de tâches à afficher.
- Nécessite l'accès à la collection de tâches.

#### Vérification

- Ajouter plusieurs tâches et vérifier que toutes leurs informations sont affichées.
- Vérifier l'affichage d'une tâche sans échéance.
- Afficher la liste lorsque celle-ci est vide et vérifier le message présenté.

---

### US-03 — Marquer une tâche comme terminée

**Priorité :** P1 — Très élevée  
**Estimation :** 2 points, quelques lignes de codes

#### Récit utilisateur

En tant qu'utilisateur, je veux marquer une tâche comme terminée afin de suivre l'avancement du travail.

#### Critères d'acceptation

- [ ] CA1 : Lorsqu'un identifiant existant est fourni, le statut de la tâche sélectionnée passe à `Terminée`.
- [ ] CA2 : L'application confirme le changement de statut.
- [ ] CA3 : Les autres informations de la tâche et les autres tâches restent inchangées.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application affiche un message d'erreur.
- [ ] CA5 : Si la tâche est déjà terminée, l'application le signale sans effectuer de modification inutile.

#### Dépendances

- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche existante.
- Dépend de **US-02 — Afficher la liste des tâches**, pour faciliter la consultation des identifiants.

#### Vérification

- Marquer une tâche existante comme terminée et vérifier son nouveau statut.
- Vérifier que les autres champs de la tâche restent inchangés.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.
- Tenter de terminer une tâche déjà terminée et vérifier le comportement.

---

### US-04 — Modifier la priorité d'une tâche

**Priorité :** P2 — Très élevée  
**Estimation :** 2 points, quelques lignes de codes

#### Récit utilisateur

En tant qu'utilisateur, je veux modifier la priorité d'une tâche afin d'adapter son importance aux besoins du service.

#### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut sélectionner une tâche existante à l'aide de son identifiant.
- [ ] CA2 : Les valeurs `Basse`, `Normale` et `Élevée` sont acceptées.
- [ ] CA3 : Une priorité invalide est refusée et la priorité actuelle reste inchangée.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.
- [ ] CA5 : La modification de la priorité ne change pas les autres informations de la tâche.

#### Dépendances

- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche à modifier.

#### Vérification

- Modifier la priorité d'une tâche vers chacune des valeurs autorisées.
- Saisir une priorité invalide et vérifier que l'ancienne valeur est conservée.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.
- Vérifier que les autres informations restent inchangées.

---

### US-05 — Attribuer une échéance à une tâche

**Priorité :** P3 — Très élevée  
**Estimation :** 2 points, quelques lignes de codes

#### Récit utilisateur

En tant qu'utilisateur, je veux attribuer une échéance à une tâche afin de connaître la date prévue pour son exécution.

#### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut attribuer une date valide à une tâche existante.
- [ ] CA2 : La date respecte le format `AAAA-MM-JJ` et correspond à une date réelle du calendrier.
- [ ] CA3 : Une date impossible ou un format incorrect est refusé sans modifier l'échéance existante.
- [ ] CA4 : Les dates passées sont acceptées.
- [ ] CA5 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

#### Dépendances

- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche existante.

#### Vérification

- Attribuer une date valide et vérifier qu'elle est enregistrée.
- Essayer une date impossible, par exemple `2026-02-30`, et vérifier son refus.
- Essayer un format incorrect et vérifier que l'échéance reste inchangée.
- Vérifier qu'une date passée est acceptée.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

### US-06 — Modifier une échéance existante

**Priorité :** P3 — Élevée  
**Estimation :** 2 points,  quelques lignes de codes

#### Récit utilisateur

En tant qu'utilisateur, je veux modifier l'échéance d'une tâche afin de tenir compte d'un changement de calendrier.

#### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut remplacer l'échéance d'une tâche existante par une nouvelle date valide.
- [ ] CA2 : La nouvelle date remplace l'ancienne sans modifier le titre, la priorité ou le statut.
- [ ] CA3 : Une date invalide est refusée et l'ancienne échéance est conservée.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

#### Dépendances

- Dépend de **US-05 — Attribuer une échéance à une tâche**, pour disposer du mécanisme de gestion des échéances.
- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche existante.

#### Vérification

- Remplacer une échéance par une autre date valide et vérifier le résultat.
- Saisir une date invalide et vérifier que l'ancienne échéance est conservée.
- Vérifier que les autres informations ne changent pas.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

### US-07 — Retirer l'échéance d'une tâche

**Priorité :** P3 — Élevée  
**Estimation :** 2 points, quelques lignes de codes

#### Récit utilisateur

En tant qu'utilisateur, je veux retirer l'échéance d'une tâche afin de ne plus lui associer de date limite.

#### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut retirer l'échéance d'une tâche existante à l'aide de son identifiant.
- [ ] CA2 : Après le retrait, la tâche est conservée et son échéance est indiquée comme absente.
- [ ] CA3 : Le titre, la priorité, l'identifiant et le statut restent inchangés.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

#### Dépendances

- Dépend de **US-01 — Ajouter une tâche**, pour disposer d'une tâche existante.
- Dépend de **US-05 — Attribuer une échéance à une tâche**, pour utiliser le mécanisme de gestion des échéances.

#### Vérification

- Retirer l'échéance d'une tâche et vérifier qu'elle est désormais absente.
- Vérifier que la tâche et ses autres informations sont conservées.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

### US-08 — Sauvegarder les tâches dans un fichier

**Priorité :** P1 — Très élevée  
**Estimation :** 5 points, crucial, besoin de plus de temps que les autres

#### Récit utilisateur

En tant qu'utilisateur, je veux sauvegarder explicitement les tâches dans un fichier local afin de conserver mes données après la fermeture du programme.

#### Critères d'acceptation

- [ ] CA1 : Une commande explicite permet de sauvegarder les données dans un fichier local.
- [ ] CA2 : La sauvegarde conserve toutes les informations des tâches, y compris les identifiants, les priorités, les statuts et les échéances absentes.
- [ ] CA3 : Un message de réussite est affiché uniquement si la sauvegarde réussit.
- [ ] CA4 : Si l'écriture échoue, l'application signale clairement l'échec et n'annonce pas une sauvegarde réussie.

#### Dépendances

- Dépend d'un jeu de test pour disposer de données à sauvegarder.
- Nécessite un mécanisme d'écriture dans un fichier local.

#### Vérification

- Ajouter plusieurs tâches et lancer la sauvegarde.
- Vérifier que le fichier contient toutes les informations nécessaires.
- Vérifier qu'un message de réussite apparaît après une sauvegarde réussie.
- Provoquer un échec d'écriture et vérifier que l'application signale l'échec.

---

### US-09 — Recharger les tâches sauvegardées au démarrage

**Priorité :** P2 — Très élevée  
**Estimation :** 2 points, quelques lignes de codes

#### Récit utilisateur

En tant qu'utilisateur, je veux retrouver automatiquement mes tâches sauvegardées au démarrage afin de reprendre le travail sans ressaisir les données.

#### Critères d'acceptation

- [ ] CA1 : Au démarrage, si un fichier de données valide existe, l'application recharge automatiquement les tâches.
- [ ] CA2 : Les informations et les identifiants restent identiques après le rechargement.
- [ ] CA3 : Une nouvelle tâche créée après le rechargement reçoit un identifiant distinct de ceux déjà présents.
- [ ] CA4 : Les tâches sans échéance sont également rechargées correctement.

#### Dépendances

- Dépend de **US-08 — Sauvegarder les tâches dans un fichier**, pour disposer d'un fichier de données à recharger.
- Nécessite un mécanisme de lecture du fichier local.

#### Vérification

- Créer plusieurs tâches, les sauvegarder, fermer l'application et la redémarrer.
- Vérifier que toutes les tâches et leurs informations sont restaurées.
- Comparer les identifiants avant et après le redémarrage.
- Ajouter une nouvelle tâche après le rechargement et vérifier l'unicité de son identifiant.

---

### US-10 — Démarrer sans fichier de données existant

**Priorité :** P3 — Élevée  
**Estimation :** 2 points,  quelques lignes de codes, lié à US-09

#### Récit utilisateur

En tant qu'utilisateur, je veux pouvoir démarrer l'application sans fichier de données existant afin de commencer à gérer mes tâches.

#### Critères d'acceptation

- [ ] CA1 : Si le fichier de données n'existe pas au démarrage, l'application démarre avec une liste vide.
- [ ] CA2 : L'absence du fichier ne provoque pas d'erreur empêchant l'utilisation de l'application.
- [ ] CA3 : L'affichage de la liste vide présente un message explicite.

#### Dépendances

- Dépend de **US-09 — Recharger les tâches sauvegardées au démarrage**, car cette fonctionnalité doit distinguer un fichier absent d'un fichier valide existant.

#### Vérification

- Lancer l'application dans un environnement où le fichier de données n'existe pas.
- Vérifier que l'application démarre normalement.
- Afficher la liste et vérifier qu'elle est vide.

---

### US-11 — Gérer un fichier de données illisible ou mal formé

**Priorité :** P3 — Élevée  
**Estimation :** 3 points,  quelques lignes de codes, besoin de recherche

#### Récit utilisateur

En tant qu'utilisateur, je veux être averti si le fichier de données est illisible ou mal formé afin d'éviter d'utiliser des données incorrectes.

#### Critères d'acceptation

- [ ] CA1 : Si le fichier existant est illisible ou mal formé, l'application affiche un message d'erreur clair.
- [ ] CA2 : Le démarrage est interrompu plutôt que de poursuivre avec des données potentiellement incorrectes.
- [ ] CA3 : Le fichier d'origine n'est pas modifié par cette tentative de chargement.

#### Dépendances

- Dépend de **US-09 — Recharger les tâches sauvegardées au démarrage**, car ce récit couvre les erreurs rencontrées lors du chargement.

#### Vérification

- Créer un fichier de données mal formé et démarrer l'application.
- Vérifier qu'un message d'erreur clair est affiché.
- Vérifier que l'application interrompt son démarrage.
- Comparer le fichier avant et après la tentative pour vérifier qu'il n'a pas été modifié.

---

### US-12 — Signaler un échec de sauvegarde

**Priorité :** P2 — Élevée  
**Estimation :** 3 points, quelques lignes de codes, besoin de recherche

#### Récit utilisateur

En tant qu'utilisateur, je veux être averti lorsqu'une sauvegarde échoue afin de savoir que mes données n'ont pas été enregistrées correctement.

#### Critères d'acceptation

- [ ] CA1 : Si le fichier ne peut pas être écrit, l'application affiche un message clair indiquant l'échec.
- [ ] CA2 : L'application n'affiche jamais un message de réussite lorsque l'écriture a échoué.
- [ ] CA3 : L'échec peut être reproduit manuellement, par exemple en utilisant un emplacement de sauvegarde non accessible en écriture.

#### Dépendances

- Dépend de **US-08 — Sauvegarder les tâches dans un fichier**, car ce récit vérifie spécifiquement le comportement en cas d'échec de sauvegarde.

#### Vérification

- Tenter une sauvegarde vers un emplacement non accessible en écriture.
- Vérifier que l'application affiche un message d'échec.
- Vérifier qu'aucun message de réussite n'est affiché à tort.

---

### 9.3 Règles de gestion du backlog

- Chaque récit possède un identifiant stable.
- Chaque récit comporte au moins deux critères d'acceptation vérifiables.
- Les priorités et les estimations sont validées collectivement par l'équipe.
- Les dépendances indiquent les récits nécessaires à la réalisation ou à la vérification d'un autre récit.
- Les vérifications doivent préciser les scénarios exécutés et les résultats attendus.
- Les récits sont reliés aux Issues GitHub, aux pull requests et aux vérifications correspondantes.
- Un récit est considéré comme terminé uniquement lorsque ses critères sont satisfaits, les vérifications pertinentes réalisées, le changement intégré, la revue de code effectuée et la documentation utile mise à jour.

---

**Fin du backlog produit — TaskFlow, mini-projet 1.**
