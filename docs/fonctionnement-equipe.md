# TaskFlow — Organisation de l'équipe · MP1

> Notre façon de travailler pour le mini-projet 1. Ce document fixe **comment** on travaille ; le **contenu** (récits, priorités, itérations) se construit ensemble dans GitHub.
>
> **Statut : proposition.** Elle est ouverte en PR. Chacun commente et propose ses modifications directement dans la PR ; la version finale est fusionnée au lancement de l'itération 1.
>
> **Fichier provisoire.** Le backlog occupe `docs/organisation.md` (PR #10). Ce contenu y sera fusionné par le Product Owner, puis ce fichier sera supprimé. Les autres documents renvoient déjà vers `docs/organisation.md`, le document final.

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
| Product Owner | [nom] | Valide les récits, ordonne le backlog, propose l'objectif et le contenu de chaque itération. Administre le tableau. | `docs/organisation.md` |
| Scrum Master | [nom] | Seul point de coordination : anime les rendez-vous, suit le tableau, relance, note les relances et les mesures prises. | `docs/iterations.md` |
| Intégrateur | Ahmed | Prépare le démarrage (ce document, le dépôt, le socle). Administre le dépôt (accès, protection de `main`), gère les fusions et les conflits. | `CONTRIBUTING.md` |
| Responsable Qualité/Test | [nom] | Exécute les vérifications sur un clone propre et veille à la définition de terminé. | `docs/verification.md` |
| Responsable de la documentation | [nom] | Tient le README, vérifie la cohérence des documents, fait la remise sur Moodle. | `README.md` |

- Chacun ajoute aux documents ce qui concerne ses propres récits, et écrit lui-même sa ligne de contribution.
- Toute modification d'un document passe par une PR.
- Le dépôt appartient à l'organisation GitHub de l'équipe, et les droits de chacun suivent son rôle (détail dans `CONTRIBUTING.md`).

### Domaines

Chacun possède un domaine de bout en bout (affichage, logique, fichier) pendant tout le MP1, et en écrit les récits.

| Domaine | Ce qu'il couvre | Propriétaire |
|---|---|---|
| A — Ajout | ajouter une tâche (titre, priorité, échéance) et refuser les saisies invalides | [nom] |
| B — Consultation et modification | afficher la liste, marquer une tâche terminée, modifier sa priorité | [nom] |
| C — Échéance | attribuer, modifier et retirer une échéance | [nom] |
| D — Sauvegarde | sauvegarder dans le fichier, signaler un échec de sauvegarde | [nom] |
| E — Chargement | retrouver ses tâches au démarrage, démarrer sans fichier, gérer un fichier abîmé | [nom] |

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
