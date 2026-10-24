# TaskFlow - Comptes rendus et suivi des itérations

**Projet :** INF1763 - Mini-projet 1, équipe 07  
**Document responsable :** Sofiane Khider — Scrum Master  
**Suivi :** Issue [#8 - Documenter les réunions et les itérations](https://github.com/inf1763-equipe-07/TaskFlow/issues/8)

---

## 1. Réunion de lancement - mercredi 7 octobre 2026

### Participants et rôles retenus

| Membre | Rôle | Document de référence |
|---|---|---|
| Émilien Thibert | Product Owner | `docs/organisation.md` |
| Sofiane Khider | Scrum Master | `docs/iterations.md` |
| Ahmed Boussayri | Intégrateur | `CONTRIBUTING.md` |
| Marc-Raphaël Chehab | Responsable qualité et tests | `docs/verification.md` |
| Mathieu Pagé | Responsable de la documentation | `README.md` |

### Points abordés et décisions

1. **Répartition des rôles.** Les responsabilités ci-dessus ont été attribuées aux membres de l'équipe.
2. **Propositions de récits utilisateurs.** Chaque membre doit déposer ses propositions en commentaire de l'[Issue #4](https://github.com/inf1763-equipe-07/TaskFlow/issues/4) afin de permettre leur comparaison et leur synthèse en équipe.
3. **Backlog commun.** Les récits proposés seront discutés collectivement avant de retenir un backlog couvrant les exigences du projet, avec **au moins 12 récits utilisateurs**.
4. **Revue documentaire.** Chaque membre est invité à lire et commenter les documents d'équipe proposés dans la [PR #5](https://github.com/inf1763-equipe-07/TaskFlow/pull/5), avant leur validation.
5. **Traçabilité.** Le Scrum Master consignera les réunions, les décisions, les actions et le suivi des itérations dans ce document.

### Actions de suivi

- [ ] **Tous les membres :** soumettre les propositions de récits dans l'Issue #4 et participer à leur synthèse.
- [ ] **Tous les membres :** examiner la PR #5 et formuler, au besoin, des commentaires constructifs.
- [ ] **Émilien (Product Owner), avec l'équipe :** proposer l'ordre de priorité du backlog et préparer l'attribution des récits.
- [ ] **Équipe :** confirmer les domaines de développement et les choix techniques encore ouverts.
- [ ] **Sofiane (Scrum Master) :** consigner les décisions et assurer le suivi des actions dans l'Issue #8 et `docs/iterations.md`.

> **Remarque :** les cases sont des éléments de suivi à actualiser ; elles ne constituent pas une affirmation que les actions sont encore inachevées à la date de lecture.

---

## 2. Réunion de suivi prévue - vendredi 9 octobre 2026

**Horaire prévu :** 9 h à 10 h  
**Format :** réunion d'équipe sur Teams

### Ordre du jour prévu

1. Comparer les propositions déposées dans l'Issue #4 et convenir d'un backlog commun d'au moins 12 récits.
2. Examiner les commentaires relatifs aux documents de la PR #5.
3. Discuter du socle Java de la [PR #6](https://github.com/inf1763-equipe-07/TaskFlow/pull/6), notamment du découpage des classes et des responsabilités partagées.
4. Confirmer la répartition des domaines, les contributions individuelles et les accès nécessaires au dépôt.
5. Préciser les objectifs et l'organisation des deux itérations.

**Compte rendu et décisions effectives :** voir le bilan détaillé de la réunion ci-dessous

###  Compte rendu effectif de la réunion du 9 octobre 2026

**Horaire prévu :** 9 h à 10 h  
**Format :** réunion d'équipe sur Teams  
**Rédacteur :** Sofiane Khider — Scrum Master

#### 1. Consolidation du backlog produit

L'équipe a examiné les différentes propositions de récits utilisateurs déposées dans l'[Issue #4](https://github.com/inf1763-equipe-07/TaskFlow/issues/4).

Après discussion et regroupement des propositions, une **synthèse commune de 12 récits utilisateurs** a été retenue comme base de travail. Cette synthèse, préparée par **Marc-Raphaël Chehab**, a été publiée en commentaire dans l'Issue #4.

**Décisions :**
- Confier à **Émilien Thibert, Product Owner**, la préparation d'une Pull Request présentant le backlog consolidé.
- Soumettre cette Pull Request à la relecture et à l'approbation d'un autre membre avant sa fusion.
- Ne considérer le backlog comme officiellement validé qu'après cette étape de revue.

**Suivi :** la synthèse est disponible dans l'Issue #4 ; la validation formelle par Pull Request reste à effectuer.

#### 2. Revue des Pull Requests en attente

Deux Pull Requests ont été examinées :

- [PR #5 — Documents d'équipe](https://github.com/inf1763-equipe-07/TaskFlow/pull/5)
- [PR #6 — Socle Java](https://github.com/inf1763-equipe-07/TaskFlow/pull/6)

L'équipe a constaté que la participation aux revues était encore insuffisante. **Sofiane avait déjà publié des commentaires sur les deux PR**, notamment sur l'organisation documentaire et sur le découpage architectural du socle. Émilien avait également signalé un ajustement concernant les rôles dans la PR #5.

**Décision :** chaque membre devra examiner personnellement les deux Pull Requests et y publier des observations constructives et argumentées avant la prochaine réunion.

Pour la PR #5, l'objectif est de finaliser la documentation commune et de permettre sa validation.

Pour la PR #6, une attention particulière devra être accordée à la structure technique et à la pertinence du découpage des classes.

#### 3. Débat sur l'architecture du socle Java

Une discussion approfondie a été consacrée à la proposition de socle développée par Ahmed, comprenant **23 classes Java**.

À partir des observations formulées dans la PR #6, l'équipe a débattu de la possibilité de simplifier cette architecture afin d'éviter une complexité excessive, tout en préparant les prochaines phases du projet.

Les principaux critères abordés sont :

- La simplicité, la lisibilité et la maintenabilité du code.
- Le respect de la séparation des responsabilités.
- La possibilité de répartir efficacement le travail entre les membres.
- L'autonomie des membres : chaque développeur doit pouvoir avancer dans son domaine sans attendre les autres ni perturber leur travail.
- La limitation des conflits Git lors du développement collaboratif.
- L'évolutivité de l'architecture pour la suite du projet.
- **Le respect intégral des règles métier et des exigences de l'énoncé.**

**Décision :** aucune modification définitive du socle n'a été arrêtée pendant cette rencontre. Chaque membre présentera, lors de la prochaine réunion, **sa propre proposition d'architecture alternative plus légère**.

Chaque proposition devra identifier les classes conservées, regroupées ou supprimées et **justifier les choix effectués**. L'objectif n'est pas de réduire le nombre de classes à tout prix, mais de retenir une architecture cohérente et adaptée aux besoins fonctionnels.

Une attention prioritaire sera accordée à la préservation des règles métier et de l'ensemble des comportements attendus.

#### 4. Plan d'action

| Action | Responsable | Échéance |
|---|---|---|
| Préparer une PR pour la synthèse des 12 récits utilisateurs | Émilien — Product Owner | Dès que possible |
| Relire et approuver la PR du backlog | Un autre membre de l'équipe | Après ouverture de la PR |
| Examiner et commenter la PR #5 — Documentation | Tous les membres | Avant la prochaine réunion |
| Examiner et commenter la PR #6 — Socle Java | Tous les membres | Avant la prochaine réunion |
| Préparer une architecture alternative plus légère, avec justification des choix | Chaque membre | Réunion du 11 octobre |
| Vérifier la conformité de chaque proposition aux règles métier et à l'énoncé | Chaque membre | Réunion du 11 octobre |
| Documenter les décisions et suivre les actions | Sofiane — Scrum Master | Suivi continu |

#### 5. Prochaine réunion - dimanche 11 octobre 2026

**Heure prévue :** vers **19 h**.

**Ordre du jour :**

1. Vérifier l'avancement de la validation du backlog par le Product Owner.
2. Faire le point sur les commentaires et les revues des PR #5 et #6.
3. Présenter les différentes propositions de socle simplifié.
4. Permettre à chaque membre de défendre son architecture et de justifier ses choix techniques.
5. Comparer les propositions selon la cohérence du code, les possibilités de collaboration et, surtout, **le respect des règles métier et des exigences du projet**.
6. Dégager une orientation commune et définir les prochaines actions.

**Point de vigilance :** toute simplification de l'architecture doit préserver les fonctionnalités et les validations prévues dans l'énoncé. Le nombre de classes ne constitue pas, à lui seul, un critère de qualité.


---

## 3. Suivi des itérations

### Itération 1

| Élément | Suivi |
|---|---|
| Dates | À confirmer collectivement |
| Objectif | À définir lors de la planification |
| Récits retenus | À inscrire après validation du backlog |
| Responsables | À préciser par récit / Issue |
| Principales tâches de réalisation | À préciser lors de la planification et à actualiser pendant l'itération |
| Version ou commit de référence | À renseigner lors de la revue |
| Vérifications effectuées | À compléter avec `docs/verification.md` |
| Résultats et difficultés | À consigner en revue d'itération |
| Ajustements décidés | À consigner au fil de l'itération, avec les raisons des changements |
| Amélioration retenue en rétrospective | À compléter |

### Itération 2

| Élément | Suivi |
|---|---|
| Dates | À confirmer collectivement |
| Objectif | À définir lors de la planification |
| Récits retenus | À inscrire après validation du backlog |
| Responsables | À préciser par récit / Issue |
| Principales tâches de réalisation | À préciser lors de la planification et à actualiser pendant l'itération |
| Version ou commit de référence | À renseigner lors de la revue |
| Vérifications effectuées | À compléter avec `docs/verification.md` |
| Résultats et difficultés | À consigner en revue d'itération |
| Ajustements décidés | À consigner au fil de l'itération, avec les raisons des changements |
| Amélioration retenue en rétrospective | À compléter |

---

## 4. Registre des décisions et des blocages

À mettre à jour après chaque réunion et lorsqu'un blocage nécessite une décision d'équipe.

| Date | Sujet | Décision ou mesure | Responsable | Suivi |
|---|---|---|---|---|
| 2026-10-07 | Attribution des rôles | Répartition des cinq responsabilités de l'équipe | Tous | Réalisé en réunion |
| 2026-10-07 | Propositions de récits | Centraliser les propositions dans l'Issue #4 | Tous | À actualiser |
| 2026-10-07 | Revue documentaire | Examiner et commenter la PR #5 | Tous | À actualiser |
| 2026-10-09 | Consolidation du backlog | Retenir la synthèse de 12 récits préparée par Marc comme base de travail, sous réserve de validation par PR | Émilien (Product Owner) | Synthèse publiée dans l'Issue #4 ; PR #10 ouverte, validation en attente |
| 2026-10-09 | Revue des PR #5 et #6 | Chaque membre doit examiner et commenter la documentation et le socle Java avant la prochaine réunion | Tous les membres | Échéance : 11 octobre ; suivi des commentaires et des approbations sur GitHub |
| 2026-10-09 | Architecture du socle Java | Chaque membre prépare une proposition de socle allégé et justifie ses choix, en veillant au respect des règles métier et des exigences du projet | Tous les membres | Présentation et comparaison prévues le 11 octobre ; aucune architecture définitivement retenue |
| 2026-10-09 | Prochaine réunion | Organiser une rencontre pour examiner les revues des PR, comparer les architectures proposées et déterminer les prochaines actions | Tous les membres | Réunion prévue le dimanche 11 octobre 2026, vers 19 h |

### Modèle pour les prochains comptes rendus

Pour chaque réunion, noter : **date et participants**, **objectif**, **décisions**, **actions et responsables**, **échéances**, **blocages**, puis **prochaine étape**. Les décisions définitives sont distinguées des propositions restant à valider.


---

## 5. Compte rendu de la réunion du 11 octobre 2026

**Participants :** Émilien Thibert, Sofiane Khider, Ahmed Boussayri, Marc-Raphaël Chehab et Mathieu Pagé.

**Objectif :** Finaliser les choix organisationnels et techniques du projet et lancer la première itération.

### Décisions prises

**1. Validation du backlog produit**

L'équipe a retenu le backlog commun de 12 récits utilisateurs présenté par Émilien, à la suite des discussions et des propositions des membres. Les éventuelles précisions aux critères d'acceptation feront l'objet d'un suivi dans la PR #10.

**2. Adoption du socle Java**

Après comparaison des propositions d'architecture, l'équipe a retenu le socle allégé proposé par Ahmed (PR #12), en privilégiant la simplicité, la séparation des responsabilités et l'autonomie des membres.

**3. Organisation du développement collaboratif**

Chaque membre développera les fonctionnalités de son domaine attribué, en utilisant le socle commun. Les contributions devront être identifiables à travers les branches, les commits et les Pull Requests. Les changements seront soumis à une revue avant leur intégration dans `main`.

**4. Lancement de l'itération 1**

L'équipe a convenu de réaliser les premières contributions de code de chaque domaine pour le 14 octobre 2026. Une réunion permettra d'examiner les réalisations et d'évaluer la possibilité de valider une première version collective de TaskFlow.

### Actions de suivi

- **Tous les membres :** développer, compiler et vérifier leurs premières fonctionnalités, puis présenter leur travail dans une Pull Request.
- **Émilien — Product Owner :** assurer le suivi du backlog et des critères d'acceptation.
- **Ahmed — Intégrateur :** accompagner l'intégration des contributions et la résolution des éventuels conflits.
- **Marc-Raphaël — Qualité/Test :** préparer le suivi des vérifications fonctionnelles.
- **Sofiane — Scrum Master :** organiser la revue de l'itération 1, suivre les blocages et documenter les décisions collectives.

---

## 6. Réunion du 14 octobre 2026 — Revue de l'itération 1

**Horaire prévu :** 20 h 30 à 21 h 30  
**Participants prévus :** les cinq membres de l'équipe.  
**Animateur :** Sofiane Khider, Scrum Master.

### Objectif principal

Examiner les contributions de code réalisées par chaque membre pendant la première itération, vérifier leur fonctionnement et déterminer collectivement si une première version de TaskFlow peut être validée.

### Ordre du jour

| Horaire | Activité |
|---|---|
| 20 h 30 – 20 h 35 | Ouverture et rappel des objectifs de l'itération 1 |
| 20 h 35 – 21 h 00 | Présentation des contributions individuelles (5 minutes par membre) |
| 21 h 00 – 21 h 10 | Vérification collective du code et de son intégration |
| 21 h 10 – 21 h 20 | Dépannage ciblé, si nécessaire (maximum 10 minutes au total) |
| 21 h 20 – 21 h 30 | Bilan, décision de validation et prochaines actions |

### Règles de déroulement

- Chaque membre présente sa contribution, sa Pull Request, les fonctionnalités réalisées et les résultats de ses vérifications.
- La réunion est consacrée principalement à la **revue et à la validation du code de l'itération 1**.
- Le temps total consacré au dépannage (*troubleshooting*) ne devra pas dépasser **10 minutes**.
- Les problèmes non résolus dans ce délai seront documentés et traités en dehors de la réunion.
- Une contribution ne sera considérée comme terminée que si les critères d'acceptation et la définition de terminé de l'équipe sont respectés.
- Si des éléments bloquants subsistent, l'équipe consignera les corrections nécessaires et leurs responsables.

### Compte rendu effectif de la réunion du 14 octobre 2026

**Projet :** INF1763 — Mini-projet 1 (TaskFlow)  
**Date :** mercredi 14 octobre 2026, en soirée  
**Participants présents :** Sofiane (Scrum Master), Ahmed (Intégrateur) et Marc-Raphaël (Responsable qualité/test)  
**Objet :** bilan du travail en cours, cohérence du backlog, répartition des récits, préparation du suivi des itérations  
**Rédaction :** 15 octobre 2026  
**Statut :** compte rendu des constats rapportés par les participants, accompagné de propositions documentaires **soumises à validation de l’équipe**.

> Ce texte distingue **les constats et orientations exprimés lors de la réunion** de **la mise en forme proposée ensuite dans `docs/organisation.md`**. Il ne présente ni les tâches proposées, ni les estimations, ni les récits non fusionnés comme des réalisations déjà validées.

#### 1. Constat partagé : répartition des récits et progression du projet

Le backlog existant comprend **12 récits utilisateurs**, mais leur répartition ne rend pas compte d’au moins deux récits principaux par membre : le domaine d’**ajout de tâches ne comportait qu’une seule US-01**, malgré plusieurs capacités distinctes attendues par l’énoncé.

Les participants ont retenu **le principe de découper cette ancienne US-01 en trois récits** pour mieux faire apparaître le travail déjà réalisé et répartir les fonctionnalités restantes sur les deux itérations, **sans redistribuer les fonctions des autres membres ni bouleverser leurs travaux en cours**.

Les trois capacités sont les suivantes :

| Récit | Capacité utilisateur | Positionnement proposé |
|---|---|---|
| **US-01** | Créer une tâche simple avec titre, ID automatique, statut `À faire`, priorité `Normale` et sans échéance. Refuser un titre vide. | **Itération 1**, correspondant au travail d’ajout simple déjà présenté ; la validation et la fusion restent à vérifier. |
| **US-02** | Choisir une priorité autorisée lors de la création ; valeur par défaut si aucun choix, erreur et correction si choix invalide. | **Itération 2**. |
| **US-03** | Définir ou omettre une échéance valide pendant la création ; corriger une date invalide ou annuler l’ajout. | **Itération 2**. |

**Nuance importante :** le titre vide, la date invalide, la priorité invalide et l’annulation sont des **critères d’acceptation**, pas des récits ajoutés artificiellement pour augmenter le total. À la fin de l’itération 2, les trois récits doivent ensemble couvrir l’intégralité de l’ajout demandé par l’énoncé.

#### 2. Maintenir les responsabilités sans perturber les travaux engagés

Le choix exprimé en réunion est de **préserver les domaines de travail des quatre autres membres** : consultation/modification, échéances sur tâches existantes, sauvegarde, chargement. La scission porte sur le domaine d’ajout, ce qui conduit à **14 récits** au total.

**Renumérotation documentaire établie après la réunion pour améliorer la lecture :** afin que tous les récits soient **consécutifs de US-01 à US-14 et regroupés par membre**, les anciens identifiants ont été redistribués **sans changer les contenus fonctionnels ni les propriétaires** :

| Domaine / membre | Récits de la version proposée |
|---|---|
| **Ajout — Sofiane** | **US-01, US-02, US-03** |
| **Consultation et modification — Ahmed** | **US-04, US-05, US-06** |
| **Échéances sur tâches existantes — Marc-Raphaël** | **US-07, US-08, US-09** |
| **Sauvegarde — Mathieu** | **US-10, US-11** |
| **Chargement — Émilien** | **US-12, US-13, US-14** |

L’ancien **US-12** (« échec de sauvegarde ») devient **US-11** afin de rester avec l’autre récit de sauvegarde (**US-10**). Les anciens récits de chargement **US-09, US-10 et US-11** deviennent **US-12, US-13 et US-14**. La table exhaustive de correspondance **ancien → nouveau** figure à la **section 2 d’`organisation.md`**.

**Cette renumérotation est une proposition de mise en cohérence éditoriale du backlog, et non un changement de travail décidé en l’absence de tous les membres.** Il faut actualiser les références textuelles dans les Issues, PR et documents ; **les numéros GitHub des Issues et PR ne changent pas**.

#### 3. Clarifier qui fait quoi et à quel moment

Le tableau « Domaines » de `docs/organisation.md` attribuait des lettres **A, B, C, D et E**, mais ne présentait pas directement les **US affectées à chaque membre**. Le document doit être complété par une colonne **« Récits attribués »**, avec des intitulés compréhensibles.

Les participants ont également demandé que le tableau récapitulatif des itérations indique les six renseignements suivants : **itération, objectif, récits, version/commit, vérifications et observations**. La version actualisée ajoute un plan de travail par membre, pour rendre les tâches concrètes.

**Consigne commune à communiquer à toute l’équipe :**

- **Consulter en priorité `docs/organisation.md`, section 6 « Itérations »**, pour connaître **les US de chacun, le résultat attendu pour chaque itération, les vérifications et les échéances**.
- Consulter la **section 2 « Domaines »** pour le responsable de chaque récit et la correspondance ancien/nouveau numéro.
- Consulter la **section 9 « Backlog détaillé »** pour lire les critères d’acceptation et les scénarios de test.
- Inscrire l’avancement réel dans **les Issues/PR de GitHub et le tableau Projects** ; publier les comptes rendus de réunion et de rétrospective dans `docs/iterations.md` et les tests dans `docs/verification.md`.

**Itération 1 — ciblage proposé** : US-01 (Sofiane), US-04 et US-05 (Ahmed), US-07 (Marc-Raphaël), US-10 (Mathieu), US-12 (Émilien).  
**Itération 2 — ciblage proposé** : US-02 et US-03 (Sofiane), US-06 (Ahmed), US-08 et US-09 (Marc-Raphaël), US-11 (Mathieu), US-13 et US-14 (Émilien), plus les éventuelles corrections de l’itération 1.

**Ces affectations par itération sont des propositions de planification** : elles devront être confirmées par les intéressés et le Product Owner, qui n’a pas participé à cette réunion. Elles ne constituent pas une déclaration de travaux terminés.

#### 4. Jalon fixé : vendredi 16 octobre 2026

La date du **vendredi 16 octobre 2026** a été retenue pour **présenter les résultats de l’itération 1**. Chaque membre devra pouvoir montrer ce qui fonctionne réellement, ce qui a été testé et ce qui reste à corriger ou à intégrer.

Le bilan doit inclure les **Issues, les PR, les résultats de vérification, les éventuels blocages et les décisions d’intégration**. L’objectif n’est **pas** de déclarer le projet complet ce vendredi : les fonctions complémentaires et les scénarios d’erreur restent prévus pour l’itération 2.

**La date de fin de l’itération 2 n’a pas été précisée** dans les informations communiquées ; elle doit être décidée collectivement. Le commit de référence d’une itération correspond au **commit intégré de `main`**, à consigner lors du bilan, et non à un commit resté sur une branche de travail.

#### 5. Exigences GitHub : une Issue par récit et suivi vérifiable

Les participants ont souligné la nécessité de se conformer à l’énoncé et de **vérifier l’existence d’une Issue dédiée à chaque User Story**, puis de créer les Issues manquantes et de relier les contributions au bon récit.

Un contrôle effectué le **15 octobre** avait identifié les Issues documentaires, techniques et collectives (dont **#4**), mais **pas encore d’Issues individuelles US-01 à US-14**. Cet état historique a changé le 16 octobre ; voir le suivi daté ci-dessous.

Le fonctionnement prévu est : **une US = une Issue identifiable**, avec propriétaire, formulation, critères d’acceptation, priorité justifiée, estimation, itération et tests ; le code est relié par PR et la progression est suivie dans GitHub Projects. **Les PR #18 et #19** sont deux variantes de la **même US-01** ; **une seule doit être choisie et fusionnée**.

#### 6. Points de vigilance techniques et coordination

- **Socle commun :** réutiliser autant que possible les classes et zones déjà prévues afin de garder une architecture légère. L’équipe accepte les interactions sur les fichiers communs, sous contrôle de l’Intégrateur.
- **Frontière entre domaines :** la priorité et l’échéance **lors de la création** relèvent de l’ajout ; leur modification sur une tâche **déjà existante** relève des domaines de consultation/modification et d’échéance.
- **Format de données :** Mathieu et Émilien doivent partager un même chemin et format de fichier pour garantir la compatibilité sauvegarde/chargement ; les erreurs de lecture et d’écriture doivent être vérifiées.
- **Intégration :** aucune US ne doit être déclarée « Terminée » tant que les critères ne sont pas vérifiés, la PR relue, et le changement fusionné dans `main`.

Ces points sont **des précisions opérationnelles pour prévenir les ambiguïtés de réalisation**. Ils ne prétendent pas constituer des décisions techniques nouvelles adoptées formellement pendant la réunion.

#### 7. Actions à effectuer et validations en attente

| Action | Responsable | Quand / preuve attendue |
|---|---|---|
| Partager le présent compte rendu et proposer la mise à jour d’`organisation.md` en PR | **Sofiane / coordination**, en lien avec le **Product Owner** pour validation du backlog | Dès que possible après la réunion ; PR documentaire ouverte et partagée. |
| Vérifier la formulation, le propriétaire et l’estimation des US-01 à US-14 | **Chaque membre** pour ses US ; **Émilien (Product Owner)** pour validation produit | Avant validation du tableau des itérations ; commentaires dans la PR et les Issues. |
| Créer ou actualiser une Issue par US et l’ajouter au tableau Projects | **Chaque propriétaire** ; administration du tableau par le **Product Owner** | Avant la restitution des résultats, ou indiquer explicitement l’état si non fait ; lien Issue ↔ PR. |
| Vérifier les zones du socle et les conflits d’intégration | **Ahmed** avec les auteurs concernés | Avant fusion ; compilation depuis `main` / branche d’intégration contrôlée. |
| Définir et documenter le format et le chemin de fichier communs | **Mathieu + Émilien** ; aide de l’Intégrateur si besoin | Avant l’intégration des US-10 / US-12 ; compatibilité testée. |
| Préparer et exécuter les vérifications de l’itération 1 | **Chaque auteur** ; consolidation par **Marc-Raphaël** | **Vendredi 16 octobre** : tests réels, anomalies, commit testé dans `docs/verification.md`. |
| Présenter l’incrément 1 et consigner le bilan / ajustements | **Tous les membres** ; coordination **Sofiane** | **Vendredi 16 octobre** ; compte rendu dans `docs/iterations.md`. |
| Fixer la fin de l’itération 2 et confirmer la planification cible | **Toute l’équipe**, proposition **Émilien (Product Owner)** | Lors de la planification de l’itération 2 ; date et US consignées dans `organisation.md`. |

#### 8. Points restant à valider collectivement

1. **Validation du découpage** et de la nouvelle numérotation US-01 à US-14 par l’équipe complète, particulièrement par les membres non présents à la réunion.
2. **Contenu et estimations de chaque itération**, proposés dans `organisation.md` : répartition précise, priorités et engagements réalistes.
3. **Date de clôture de l’itération 2** et statut des tâches qui ne seraient pas intégrées au 16 octobre.
4. **Format/chemin du fichier**, coordination sauvegarde–chargement et stratégie d’intégration.
5. **Choix de la variante US-01** entre les PR #18 et #19, après revue technique ; aucune fusion des deux variantes en double.
6. **Réconciliation des Issues et des références existantes**, sans écraser les liens GitHub ni déclarer achevé un travail non vérifié.

**Conclusion :** le bilan a pour objectif de rendre les responsabilités visibles, de conserver les développements déjà engagés et d’obtenir un **premier incrément vérifiable le 16 octobre**, tout en préparant une **seconde itération complète**. `docs/organisation.md` — notamment sa **section 6** — est le repère partagé pour savoir **qui fait quoi, comment et quand**, sous réserve de validation collective des propositions détaillées.

### Mise à jour du suivi GitHub — 16 octobre 2026 (après la réunion)

Les éléments suivants décrivent l'état du dépôt **après** la réunion du 14 octobre. Ils ne sont pas présentés comme des décisions prises en présence des trois participants.

- **Backlog et traçabilité :** les **14 Issues individuelles [#35 à #48](https://github.com/inf1763-equipe-07/TaskFlow/issues)** ont été créées par Ahmed puis assignées aux responsables indiqués dans `docs/organisation.md`. Chaque membre doit en vérifier le contenu, les critères et l'estimation, puis y documenter ses résultats. Leur création ne vaut pas validation automatique du backlog par le Product Owner.
- **Ajout (Sofiane) :** la [PR #18](https://github.com/inf1763-equipe-07/TaskFlow/pull/18), liée à l'[Issue #35](https://github.com/inf1763-equipe-07/TaskFlow/issues/35), a fait l'objet d'une correction architecturale et de tests manuels ; ses cinq critères d'acceptation ont été cochés. La PR attend encore les décisions de revue et sa fusion. La [PR #19](https://github.com/inf1763-equipe-07/TaskFlow/pull/19), variante alternative, a été **fermée sans fusion**.
- **Consultation et modification (Ahmed) :** les [PR #51](https://github.com/inf1763-equipe-07/TaskFlow/pull/51) (US-04, Issue #38) et [#52](https://github.com/inf1763-equipe-07/TaskFlow/pull/52) (US-05, Issue #39) ont été ouvertes pour revue. Leur fonctionnement intégré doit encore être contrôlé après fusion, notamment parce que les deux modifient la zone « Consultation et modification » de `Main.java`.
- **Chargement (Émilien) :** la [PR #15](https://github.com/inf1763-equipe-07/TaskFlow/pull/15) reste en demande de modifications, notamment pour la compilation, le respect de l'interface `TacheRepository` et la compatibilité avec la sauvegarde.
- **Échéances et sauvegarde :** les Issues [#41](https://github.com/inf1763-equipe-07/TaskFlow/issues/41) (Marc-Raphaël, US-07) et [#44](https://github.com/inf1763-equipe-07/TaskFlow/issues/44) (Mathieu, US-10) existent. Les responsables doivent présenter leur code, les tests et la PR correspondante avant qu'un résultat puisse être considéré comme intégré.
- **Documentation :** la [PR #20](https://github.com/inf1763-equipe-07/TaskFlow/pull/20) propose la mise à jour d’`organisation.md` et, avec la présente correction, le transfert de ce compte rendu dans `docs/iterations.md`, conformément à la remarque d’Ahmed. La modification, la revue et la fusion restent à confirmer sur GitHub.

**À renseigner pendant le bilan du 16 octobre :** commits effectivement intégrés dans `main`, résultats de compilation et de vérification sur une version commune, décisions de revue, blocages restants, mesures correctives, amélioration retenue en rétrospective et date de fin de l'itération 2. Les résultats ne doivent pas être inventés avant la démonstration collective.

---

## 7. Réunion du 16 octobre 2026 — Suivi de l'itération 1

**Présents :** Ahmed Boussayri, Marc-Raphaël Chehab, Émilien Thibert et Sofiane Khider.
**Absent :** Mathieu Pagé.

**Objectif :** Faire le point sur les réalisations de l'itération 1, partager les difficultés rencontrées et coordonner les prochaines étapes, sans consacrer la réunion au dépannage technique.

### 1. Avancement et réalisations

**Ahmed — Affichage et gestion du statut des tâches (US-04 et US-05)**

Ahmed a réalisé deux fonctionnalités importantes :

- L'affichage de la liste des tâches avec leurs informations.
- Le changement de statut d'une tâche vers « Terminée », avec gestion des cas particuliers.

Les PR #51 et #52 ont été examinées, testées, approuvées et fusionnées dans `main`. Les fonctionnalités ont également été vérifiées dans la version intégrée de TaskFlow.

Ahmed a aussi contribué à la documentation des vérifications avec la PR #54, désormais fusionnée.

**Marc-Raphaël — Attribution des échéances (US-07)**

Marc-Raphaël a développé la fonctionnalité permettant d'attribuer une échéance à une tâche existante.

La fonctionnalité a été testée par Ahmed, notamment avec des dates valides et invalides ainsi que des identifiants incorrects. Les résultats sont conformes aux comportements attendus.

La PR #55 a été approuvée par Ahmed et fusionnée dans `main`. Quelques optimisations mineures ont été proposées, sans constituer de blocage à son intégration.

Marc-Raphaël a également commencé à documenter ses vérifications dans `docs/verification.md`.

**Sofiane — Ajout d'une tâche (US-01)**

La fonctionnalité d'ajout d'une tâche a été réalisée, vérifiée et intégrée dans `main` avec la PR #18.

**Émilien — Chargement des tâches (US-12)**

Les travaux sont engagés, mais la PR #53 nécessite encore des corrections et une coordination avec la fonctionnalité de sauvegarde.

**Mathieu — Sauvegarde des tâches (US-10)**

Mathieu était absent de la réunion. Sa fonctionnalité n'était pas encore intégrée au moment du bilan. Son avancement reste à confirmer avec lui.

### 2. Difficultés et points de coordination

Les échanges ont permis d'identifier plusieurs points à suivre :

- Finalisation de la sauvegarde et du chargement des tâches.
- Coordination entre Mathieu et Émilien pour utiliser un format de fichier compatible.
- Prise en compte des optimisations mineures relevées lors des revues.
- Poursuite de la documentation des tests dans `docs/verification.md`.

L'équipe privilégie des séances de dépannage spécifiques lorsque les difficultés nécessitent une analyse technique approfondie.

### 3. Organisation et communication

Chaque membre est invité à communiquer régulièrement son avancement, ses difficultés et ses besoins d'accompagnement.

Si un membre ne peut pas participer à une réunion à l'horaire proposé, il peut suggérer un autre créneau.

En l'absence de réponse à un message, il ne faut pas hésiter à relancer les personnes concernées ou à les contacter directement, y compris lorsque le Scrum Master n'a pas encore répondu.

### 4. Prochaine réunion

**Samedi 17 octobre 2026 à 10 h.**

Objectifs :
- Faire le point sur les développements restants.
- Confirmer l'avancement de Mathieu et d'Émilien.
- Coordonner les éventuelles séances de dépannage.
- Préparer la poursuite de l'intégration et des vérifications de l'itération 1.

L'horaire pourra être ajusté en fonction des disponibilités communiquées par les membres.

---

## 8. Réunion du 17 octobre 2026 — Bilan de l’itération 1 et préparation de l’itération 2

**Date :** samedi 17 octobre 2026.  
**Rédaction et suivi :** Sofiane Khider — Scrum Master, le 18 octobre 2026.

**Objectif :** Poursuivre l’examen des contributions, vérifier les fonctionnalités présentées, préciser les ajustements nécessaires et préparer la validation des récits de l’itération 2.

### 1. Contributions examinées et vérifications

Dans la continuité de la réunion du 16 octobre, l’équipe a examiné les contributions des membres et effectué des tests sur les fonctionnalités présentées.

Ces échanges ont permis de valider les comportements vérifiés et de formuler des remarques constructives pour affiner certains récits utilisateurs, leur réalisation et leurs vérifications.

| Membre | Récits concernés | Avancement et points de suivi |
|---|---|---|
| **Sofiane — Ajout** | US-01 | L’ajout simple est intégré dans `main` par la [PR #18](https://github.com/inf1763-equipe-07/TaskFlow/pull/18). La priorité et l’échéance à la création sont prévues dans US-02 et US-03, à l’itération 2. |
| **Ahmed — Consultation et statut** | US-04, US-05 | L’affichage et le changement de statut sont intégrés par les [PR #51](https://github.com/inf1763-equipe-07/TaskFlow/pull/51) et [#52](https://github.com/inf1763-equipe-07/TaskFlow/pull/52). Les vérifications documentées servent de référence pour la suite. |
| **Marc-Raphaël — Échéances** | US-07 | L’attribution d’une échéance est intégrée par la [PR #55](https://github.com/inf1763-equipe-07/TaskFlow/pull/55). Le suivi des vérifications et les améliorations signalées en revue se poursuivent. |
| **Mathieu — Sauvegarde** | US-10 | La [PR #59](https://github.com/inf1763-equipe-07/TaskFlow/pull/59) a été relue et approuvée par Ahmed le 17 octobre. Deux incohérences documentaires concernant le chemin du fichier restent à corriger avant fusion. |
| **Émilien — Chargement** | US-12 | Le travail se poursuit dans la [PR #58](https://github.com/inf1763-equipe-07/TaskFlow/pull/58). Des erreurs de compilation, notamment dans la déclaration de `charger()`, empêchent encore sa validation. |

### 2. Validation de l’itération 1 et conditions de passage à l’itération 2

Lors de la réunion, l’équipe a constaté le bon avancement des contributions et validé les PR présentées, à l’exception de celle d’Émilien concernant US-12, qui présentait encore des erreurs de compilation.

L’itération 1 a donc fait l’objet d’une **validation sous réserve des corrections à apporter à cette PR**. Sa clôture définitive et le passage formel à l’itération 2 nécessitent la validation de l’ensemble des PR associées à l’itération 1.

La règle commune est rappelée : **chaque membre doit vérifier que le projet compile localement avant de pousser ses modifications sur GitHub**. Les résultats des vérifications doivent être documentés et les éventuels blocages signalés rapidement.

Ahmed peut apporter son soutien en tant qu’intégrateur pour résoudre les difficultés de compilation et d’intégration. Les membres sont invités à le solliciter dès qu’un accompagnement est nécessaire.

Les remarques constructives formulées lors des échanges visent également à :

- Maintenir la cohérence entre le code, les critères d’acceptation et les vérifications.
- Respecter les responsabilités des différentes couches et réutiliser les interfaces communes.
- Harmoniser le chemin et le format du fichier entre sauvegarde, chargement et documentation.
- Décrire les corrections demandées avec des éléments concrets permettant de les reproduire.
- Compléter `docs/verification.md` avec les données utilisées, les résultats observés et le commit testé.

La validation en réunion doit être suivie de la finalisation des corrections, des vérifications et de l’intégration. Un récit devient « Terminé » lorsque la définition de terminé de l’équipe est satisfaite.

### 3. Suivi complémentaire du dimanche 18 octobre

Après la réunion, Sofiane a relancé Mathieu et Émilien afin de finaliser les éléments de l’itération 1 encore en attente.

| Destinataire | Relance et suivi |
|---|---|
| **Mathieu** | [Relance dans la PR #59](https://github.com/inf1763-equipe-07/TaskFlow/pull/59#issuecomment-6251724923) concernant les deux corrections documentaires signalées par Ahmed, afin de permettre la finalisation de l’US-10. |
| **Émilien** | [Relance dans la PR #58](https://github.com/inf1763-equipe-07/TaskFlow/pull/58#issuecomment-6252027441) concernant la compilation et l’intégration de l’US-12. Émilien a demandé de préciser les problèmes concernés. Une vérification technique complémentaire du commit publié `c3814e4`, avec le JDK 21, confirme notamment une erreur de syntaxe dans la déclaration de `charger()` dans `TacheRepository.java`. |

En préparation de l’itération 2, les PR de Sofiane [#61 — US-02](https://github.com/inf1763-equipe-07/TaskFlow/pull/61) et [#62 — US-03](https://github.com/inf1763-equipe-07/TaskFlow/pull/62) ont été ouvertes le 18 octobre. Les tests locaux sont documentés dans la branche US-03 ; la revue et le contrôle qualité restent à effectuer.

Ces travaux préparatoires ne lèvent pas la réserve portant sur la clôture de l’itération 1.

### 4. Actions de suivi

| Action | Responsable |
|---|---|
| Finaliser les ajustements de sauvegarde et la documentation du fichier. | Mathieu |
| Corriger les erreurs du chargement, confirmer la compilation et vérifier la compatibilité avec la sauvegarde. | Émilien, avec le soutien d’Ahmed au besoin |
| Préparer les démonstrations et les résultats des récits de l’itération 2. | Chaque auteur |
| Réaliser les revues et compléter le contrôle indépendant des vérifications. | Relecteurs désignés et Marc-Raphaël |
| Coordonner les fusions et vérifier le fonctionnement de la version intégrée. | Ahmed, avec les auteurs concernés |
| Suivre les blocages, les réponses aux relances et les décisions de validation. | Sofiane |

### 5. Prochaine réunion

**Lundi 19 octobre 2026 à 8 h.**

**Objectif principal :** examiner et valider les récits utilisateurs de l’itération 2 selon leurs critères d’acceptation et les vérifications présentées, après confirmation de la levée des réserves de l’itération 1.

La réunion permettra également de :

- Confirmer la résolution des éléments restants de l’itération 1.
- Présenter les contributions et les résultats de chaque membre.
- Examiner les remarques de revue et les éventuelles corrections.
- Déterminer les récits validés, ceux restant à vérifier et les prochaines actions d’intégration.

---

## 9. Réunion du 19 octobre 2026 — Revue des contributions et plan de finalisation

**Date :** lundi 19 octobre 2026.

**Membres présents :**

- Sofiane Khider : Scrum Master.
- Ahmed Boussayri : Intégrateur.
- Marc-Raphaël Chehab : Responsable qualité et tests.
- Émilien Thibert : Product Owner.

**Absent :** Mathieu Pagé.

**Objectif :** Examiner les contributions disponibles, identifier les blocages et définir les actions nécessaires à la finalisation des travaux.

### 1. Contributions examinées

Dans la continuité des réunions précédentes, l’équipe a examiné les contributions présentées pour l’itération 2.

| Membre | Contributions concernées | Constat et suivi |
|---|---|---|
| **Sofiane — Ajout** | US-02 et US-03 — [PR #61](https://github.com/inf1763-equipe-07/TaskFlow/pull/61) et [#62](https://github.com/inf1763-equipe-07/TaskFlow/pull/62) | Les versions présentées compilent. Les revues et l’intégration restent à finaliser, en respectant la dépendance de #62 envers #61. |
| **Ahmed — Consultation et modification** | US-06 — [PR #63](https://github.com/inf1763-equipe-07/TaskFlow/pull/63) | La version présentée compile. La revue et l’intégration avec les autres contributions restent à finaliser. |
| **Marc-Raphaël — Échéances** | US-08 et US-09 — [PR #65](https://github.com/inf1763-equipe-07/TaskFlow/pull/65) et [#66](https://github.com/inf1763-equipe-07/TaskFlow/pull/66) | Les versions présentées compilent. Les revues, les éventuelles corrections et l’intégration restent à finaliser. |
| **Émilien — Chargement** | US-12, US-13 et US-14 — [PR #58](https://github.com/inf1763-equipe-07/TaskFlow/pull/58) et [#60](https://github.com/inf1763-equipe-07/TaskFlow/pull/60) | Des erreurs de compilation subsistent et empêchent la validation des contributions. Un soutien au débogage et à l’intégration a été convenu avec Ahmed. |
| **Mathieu — Sauvegarde** | US-11 — [Issue #45](https://github.com/inf1763-equipe-07/TaskFlow/issues/45) | Mathieu était absent et aucune PR concernant sa contribution d’itération 2 n’a été présentée pour cette revue. Son avancement reste à confirmer. L’US-10 de l’itération 1 est déjà intégrée par la [PR #59](https://github.com/inf1763-equipe-07/TaskFlow/pull/59). |

**La compilation réussie constitue un prérequis à la vérification.** Elle ne remplace ni le contrôle des critères d’acceptation, ni l’approbation de la PR, ni les vérifications après intégration.

Les réserves précédemment formulées concernant le chargement restent ouvertes.

### 2. Accompagnement d’Émilien pour le chargement

L’équipe a identifié un besoin de soutien technique pour permettre à Émilien de corriger les erreurs de compilation et de finaliser ses contributions.

**Ahmed sera disponible lundi 19 octobre à partir de 22 h** pour apporter son soutien en tant qu’intégrateur. S’il est disponible plus tôt, il pourra en avertir Émilien.

Émilien doit préparer la version à examiner, les messages d’erreur et les difficultés rencontrées afin de faciliter la séance de débogage.

Cet accompagnement ne transfère pas la responsabilité des récits : **Émilien reste responsable de ses contributions, des corrections, des vérifications et de la publication de son travail.** Ahmed apporte son soutien technique et accompagne l’intégration.

### 3. Échéance commune et responsabilités individuelles

**Échéance décidée : mardi 20 octobre 2026 à 12 h, heure de Gatineau.**

À cette échéance, chaque membre doit avoir :

- Publié ses contributions dans les PR correspondantes sur GitHub.
- Vérifié au préalable que le projet compile avec ses modifications.
- Réalisé les vérifications nécessaires pour permettre la revue.
- Documenté les résultats observés et le commit testé dans `docs/verification.md`.
- Signalé les difficultés restantes et les besoins d’accompagnement.

La règle commune est rappelée : **la compilation locale doit être vérifiée avant chaque push et avant toute demande de revue.**

**Tout membre qui estime ne pas pouvoir respecter l’échéance doit avertir l’équipe sans attendre et demander un soutien à l’intégration.** Le signalement doit préciser l’état du travail, le problème rencontré et l’aide nécessaire, suffisamment tôt pour permettre une intervention avant mardi à 12 h.

Chaque membre est responsable de communiquer son avancement réel, de traiter les corrections qui lui reviennent et de répondre aux échanges concernant ses contributions.

L’objectif collectif est de disposer de contributions compilables et vérifiables, puis de confirmer la compilation et le fonctionnement de la version commune après intégration.

### 4. Absence de Mathieu et relance

Mathieu n’a pas participé à la réunion du 19 octobre. Sa contribution d’itération 2 n’a donc pas pu être examinée avec lui.

Après la réunion, Sofiane l’a relancé sur Teams pour lui demander de :

- Confirmer son avancement et publier sa contribution concernant l’US-11.
- Respecter l’échéance commune du mardi 20 octobre à 12 h.
- Signaler rapidement tout blocage nécessitant un accompagnement.
- Participer aux rendez-vous de suivi.
- Effectuer les revues des PR **#61 et #62**, dont il est le relecteur désigné conformément à la rotation de l’itération 2.

La réponse de Mathieu et les suites données à cette relance restent à consigner.

### 5. Plan d’action

| Action | Responsable | Échéance |
|---|---|---|
| Corriger les erreurs de compilation du chargement, effectuer les vérifications et publier les corrections. | Émilien, avec le soutien d’Ahmed | Mardi 20 octobre à 12 h |
| Accompagner Émilien pour le débogage et l’intégration ; le prévenir en cas de disponibilité plus tôt. | Ahmed | Lundi 19 octobre, à partir de 22 h |
| Confirmer l’avancement de l’US-11 et publier la contribution pour vérification. | Mathieu | Mardi 20 octobre à 12 h |
| Réaliser les revues des PR #61 et #62 et communiquer les corrections nécessaires. | Mathieu | Dès que possible pour permettre la finalisation |
| Finaliser les contributions, vérifier la compilation et documenter les résultats. | Chaque auteur | Mardi 20 octobre à 12 h |
| Signaler tout blocage ou risque de retard et demander l’aide nécessaire. | Chaque membre concerné | Dès identification du problème, avant l’échéance |
| Effectuer les revues croisées et répondre aux demandes de correction. | Relecteurs désignés et auteurs | Au fil des contributions disponibles |
| Coordonner les fusions et vérifier la compilation de la version commune. | Ahmed, avec les auteurs concernés | Au fil des intégrations |
| Poursuivre le contrôle qualité et le suivi des vérifications. | Marc-Raphaël, avec les relecteurs concernés | Sur les versions disponibles et intégrées |
| Consigner les réponses aux relances, les blocages et les mesures prises. | Sofiane | Suivi continu |

### 6. Point de contrôle du 20 octobre à 12 h

Le point de contrôle portera sur :

- Les PR effectivement publiées et les commits disponibles.
- Les résultats de compilation.
- Les vérifications documentées.
- Les revues réalisées et les corrections demandées.
- Les blocages signalés et l’accompagnement apporté.

L’état de chaque contribution sera consigné : **compilable et disponible pour revue**, **en attente de correction ou d’intégration**, ou **encore bloquée**.

Les difficultés persistantes seront documentées avec leur impact, l’aide demandée ou apportée et les prochaines actions convenues. Ce suivi permettra de rendre visibles les engagements de chacun et les mesures prises collectivement pour finaliser le projet.


---

## 10. Réunion du 20 octobre 2026 — Bilan des avancées et préparation de la finalisation

**Date :** mardi 20 octobre 2026.

**Membres présents :**

- Sofiane Khider : Scrum Master.
- Ahmed Boussayri : Intégrateur.
- Marc-Raphaël Chehab : Responsable qualité et tests.
- Émilien Thibert : Product Owner.

**Absent :** Mathieu Pagé.

**Objectif :** Faire le point sur les progrès réalisés depuis la réunion précédente et organiser la finalisation des contributions, des revues et de l’intégration.

### 1. Avancées constatées

La réunion a permis de constater une progression importante des contributions et une meilleure cohérence entre les différentes fonctionnalités du programme.

Ahmed a indiqué avoir compilé les dernières versions disponibles avec des résultats globalement satisfaisants. Les contributions examinées compilaient, y compris celles d’Émilien concernant le chargement, qui avaient précédemment présenté des difficultés.

Des remarques techniques et quelques anomalies restaient néanmoins à traiter, notamment sur le chargement. La compilation réussie constitue une avancée ; la validation finale reste liée aux critères d’acceptation, aux vérifications et aux revues.

### 2. Organisation de la finalisation

L’enseignant ayant reporté la remise à la semaine suivante, l’équipe a convenu d’utiliser ce délai pour affiner le programme, corriger les anomalies et compléter la documentation.

Chaque membre reste responsable de :

- Finaliser les contributions qui lui sont attribuées.
- Traiter les remarques reçues et documenter les vérifications.
- Effectuer les revues des PR pour lesquelles il est désigné.
- Signaler rapidement tout blocage nécessitant un accompagnement.
- Actualiser l’état de ses Issues et de ses tâches dans la vue projet.

L’objectif est de finaliser les PR restantes et leurs fusions, puis de vérifier le fonctionnement de la version commune. Le passage à « Terminé » reste soumis à la définition de terminé et à l’intégration effective.

### 3. Suivi de Mathieu

Mathieu était absent de la réunion. Il a répondu après celle-ci et a été informé sur Teams des responsabilités et des actions attendues concernant ses contributions et ses revues.

Ce suivi doit permettre de poursuivre la finalisation avec la participation de chaque membre.

### 4. Actions de suivi

| Action | Responsable |
|---|---|
| Finaliser les contributions et répondre aux remarques de revue. | Chaque auteur |
| Examiner les PR attribuées et communiquer les résultats de revue. | Chaque relecteur désigné |
| Coordonner les fusions, résoudre les conflits avec les auteurs et vérifier la version intégrée. | Ahmed |
| Compléter les vérifications et le contrôle qualité sur la version commune. | Marc-Raphaël, avec les auteurs et relecteurs |
| Finaliser le README et vérifier la cohérence documentaire. | Mathieu, avec les membres concernés |
| Actualiser la vue projet et les états des Issues. | Émilien, avec chaque responsable |
| Consigner les décisions et suivre les actions restantes. | Sofiane |

### 5. Prochaine réunion

**Samedi 24 octobre 2026 à 10 h.**

**Objectif :** Finaliser les PR restantes, effectuer les fusions après validation et mettre à jour la vue projet, les Issues et les tâches.

La version intégrée devra être compilée et vérifiée collectivement. L’objectif visé est de ne laisser aucune PR nécessaire à la livraison en attente de fusion, tout en identifiant explicitement les éventuelles réserves restantes.
