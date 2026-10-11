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
