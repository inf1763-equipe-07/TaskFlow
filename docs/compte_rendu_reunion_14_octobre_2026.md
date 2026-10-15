# TaskFlow — Compte rendu de la réunion du 14 octobre 2026

**Projet :** INF1763 — Mini-projet 1 (TaskFlow)  
**Date :** mercredi 14 octobre 2026, en soirée  
**Participants présents :** Sofiane (Scrum Master), Ahmed (Intégrateur) et Marc-Raphaël (Responsable qualité/test)  
**Objet :** bilan du travail en cours, cohérence du backlog, répartition des récits, préparation du suivi des itérations  
**Rédaction :** 15 octobre 2026  
**Statut :** compte rendu des constats rapportés par les participants, accompagné de propositions documentaires **soumises à validation de l’équipe**.

> Ce texte distingue **les constats et orientations exprimés lors de la réunion** de **la mise en forme proposée ensuite dans `docs/organisation.md`**. Il ne présente ni les tâches proposées, ni les estimations, ni les récits non fusionnés comme des réalisations déjà validées.

## 1. Constat partagé : répartition des récits et progression du projet

Le backlog existant comprend **12 récits utilisateurs**, mais leur répartition ne rend pas compte d’au moins deux récits principaux par membre : le domaine d’**ajout de tâches ne comportait qu’une seule US-01**, malgré plusieurs capacités distinctes attendues par l’énoncé.

Les participants ont retenu **le principe de découper cette ancienne US-01 en trois récits** pour mieux faire apparaître le travail déjà réalisé et répartir les fonctionnalités restantes sur les deux itérations, **sans redistribuer les fonctions des autres membres ni bouleverser leurs travaux en cours**.

Les trois capacités sont les suivantes :

| Récit | Capacité utilisateur | Positionnement proposé |
|---|---|---|
| **US-01** | Créer une tâche simple avec titre, ID automatique, statut `À faire`, priorité `Normale` et sans échéance. Refuser un titre vide. | **Itération 1**, correspondant au travail d’ajout simple déjà présenté ; la validation et la fusion restent à vérifier. |
| **US-02** | Choisir une priorité autorisée lors de la création ; valeur par défaut si aucun choix, erreur et correction si choix invalide. | **Itération 2**. |
| **US-03** | Définir ou omettre une échéance valide pendant la création ; corriger une date invalide ou annuler l’ajout. | **Itération 2**. |

**Nuance importante :** le titre vide, la date invalide, la priorité invalide et l’annulation sont des **critères d’acceptation**, pas des récits ajoutés artificiellement pour augmenter le total. À la fin de l’itération 2, les trois récits doivent ensemble couvrir l’intégralité de l’ajout demandé par l’énoncé.

## 2. Maintenir les responsabilités sans perturber les travaux engagés

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

## 3. Clarifier qui fait quoi et à quel moment

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

## 4. Jalon fixé : vendredi 16 octobre 2026

La date du **vendredi 16 octobre 2026** a été retenue pour **présenter les résultats de l’itération 1**. Chaque membre devra pouvoir montrer ce qui fonctionne réellement, ce qui a été testé et ce qui reste à corriger ou à intégrer.

Le bilan doit inclure les **Issues, les PR, les résultats de vérification, les éventuels blocages et les décisions d’intégration**. L’objectif n’est **pas** de déclarer le projet complet ce vendredi : les fonctions complémentaires et les scénarios d’erreur restent prévus pour l’itération 2.

**La date de fin de l’itération 2 n’a pas été précisée** dans les informations communiquées ; elle doit être décidée collectivement. Le commit de référence d’une itération correspond au **commit intégré de `main`**, à consigner lors du bilan, et non à un commit resté sur une branche de travail.

## 5. Exigences GitHub : une Issue par récit et suivi vérifiable

Les participants ont souligné la nécessité de se conformer à l’énoncé et de **vérifier l’existence d’une Issue dédiée à chaque User Story**, puis de créer les Issues manquantes et de relier les contributions au bon récit.

Un contrôle du dépôt accessible le **15 octobre** a identifié des Issues de documentation, de socle et de **propositions collectives (#4)**, mais **pas d’Issues individuelles explicitement titrées US-01 à US-14**. Ce constat doit être revérifié au moment de la création pour éviter les doublons.

Le fonctionnement prévu est : **une US = une Issue identifiable**, avec propriétaire, formulation, critères d’acceptation, priorité justifiée, estimation, itération et tests ; le code est relié par PR et la progression est suivie dans GitHub Projects. **Les PR #18 et #19** sont deux variantes de la **même US-01** ; **une seule doit être choisie et fusionnée**.

## 6. Points de vigilance techniques et coordination

- **Socle commun :** réutiliser autant que possible les classes et zones déjà prévues afin de garder une architecture légère. L’équipe accepte les interactions sur les fichiers communs, sous contrôle de l’Intégrateur.
- **Frontière entre domaines :** la priorité et l’échéance **lors de la création** relèvent de l’ajout ; leur modification sur une tâche **déjà existante** relève des domaines de consultation/modification et d’échéance.
- **Format de données :** Mathieu et Émilien doivent partager un même chemin et format de fichier pour garantir la compatibilité sauvegarde/chargement ; les erreurs de lecture et d’écriture doivent être vérifiées.
- **Intégration :** aucune US ne doit être déclarée « Terminée » tant que les critères ne sont pas vérifiés, la PR relue, et le changement fusionné dans `main`.

Ces points sont **des précisions opérationnelles pour prévenir les ambiguïtés de réalisation**. Ils ne prétendent pas constituer des décisions techniques nouvelles adoptées formellement pendant la réunion.

## 7. Actions à effectuer et validations en attente

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

## 8. Points restant à valider collectivement

1. **Validation du découpage** et de la nouvelle numérotation US-01 à US-14 par l’équipe complète, particulièrement par les membres non présents à la réunion.
2. **Contenu et estimations de chaque itération**, proposés dans `organisation.md` : répartition précise, priorités et engagements réalistes.
3. **Date de clôture de l’itération 2** et statut des tâches qui ne seraient pas intégrées au 16 octobre.
4. **Format/chemin du fichier**, coordination sauvegarde–chargement et stratégie d’intégration.
5. **Choix de la variante US-01** entre les PR #18 et #19, après revue technique ; aucune fusion des deux variantes en double.
6. **Réconciliation des Issues et des références existantes**, sans écraser les liens GitHub ni déclarer achevé un travail non vérifié.

**Conclusion :** le bilan a pour objectif de rendre les responsabilités visibles, de conserver les développements déjà engagés et d’obtenir un **premier incrément vérifiable le 16 octobre**, tout en préparant une **seconde itération complète**. `docs/organisation.md` — notamment sa **section 6** — est le repère partagé pour savoir **qui fait quoi, comment et quand**, sous réserve de validation collective des propositions détaillées.
