# TaskFlow — Organisation de l'équipe · MP1

> Notre façon de travailler pour le mini-projet 1. Ce document fixe **comment** on travaille ; le **contenu** (récits, priorités, itérations) se construit ensemble dans GitHub.
>
> **Statut : proposition.** Elle est ouverte en PR. Chacun commente et propose ses modifications directement dans la PR ; la version finale est fusionnée au lancement de l'itération 1.
>

## 1. Objectif du produit et de l'équipe

**Le produit.** TaskFlow est un outil interne pour une équipe de soutien informatique : conserver une liste de tâches, leur donner une priorité et une échéance, les marquer comme terminées, et retrouver ses données à la prochaine utilisation. C'est une application Java en console.

**Ce qu'on livre et remet.** L'application, le dépôt GitHub avec tout son historique, et la documentation. À la remise (semaine 7, date sur Moodle) : le lien du dépôt, l'identifiant du commit final et l'archive `TaskFlow_MP1_EquipeXX.zip`.

**Ce qui compte le plus.** La qualité du produit **et** la démarche vérifiable : backlog, Issues, PR, revues, tests, versions intégrées et tableau de suivi.

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

### Domaines et responsabilités fonctionnelles

Le domaine (A à E) regroupe les fonctionnalités ; **l’identifiant US-xx désigne un récit utilisateur précis**. Les deux sont indiqués afin qu’aucun membre ne dépende d’une lettre seule pour comprendre sa mission.

| Domaine | Responsable | Fonctionnalités et limites | Récits attribués | Itération 1 | Itération 2 |
|---|---|---|---|---|---|
| **A — Ajout** | **Sofiane** | Créer une tâche ; proposer les choix facultatifs de priorité et d’échéance **à la création**. | **US-01, US-02, US-03** | US-01 | US-02, US-03 |
| **B — Consultation et modification** | **Ahmed** | Voir les tâches, terminer une tâche, changer la priorité **après création**. | **US-04, US-05, US-06** | US-04, US-05 | US-06 |
| **C — Gestion des échéances** | **Marc-Raphaël** | Ajouter, modifier ou retirer une date sur une tâche **déjà existante**. | **US-07, US-08, US-09** | US-07 | US-08, US-09 |
| **D — Sauvegarde** | **Mathieu** | Enregistrer les tâches ; signaler un échec d’écriture. | **US-10, US-11** | US-10 | US-11 |
| **E — Chargement** | **Émilien** | Restaurer les tâches au démarrage ; gérer fichier absent ou corrompu. | **US-12, US-13, US-14** | US-12 | US-13, US-14 |

**Total : 14 récits, répartis 3 + 3 + 3 + 2 + 3.** Chaque membre possède au moins deux récits ; leur réalisation effective et leur traçabilité devront être vérifiées à la livraison.

#### Historique de renumérotation (à utiliser pour mettre à jour les références)

L’ancienne US-01 a été divisée en trois : **US-01 — ajout simple ; US-02 — choix de la priorité à l’ajout ; US-03 — choix de l’échéance à l’ajout**. Les autres fonctionnalités et propriétaires sont conservés. Pour **regrouper les numéros de chaque membre**, l’ancien US-12 (échec de sauvegarde) prend sa place avec la sauvegarde avant les récits d’Émilien.

| Ancien récit | Nouveau récit | Responsable | Fonctionnalité conservée |
|---|---|---|---|
| US-01 | **US-01 + US-02 + US-03** | Sofiane | Ajout, désormais découpé en trois capacités |
| US-02 | **US-04** | Ahmed | Affichage de la liste |
| US-03 | **US-05** | Ahmed | Tâche terminée |
| US-04 | **US-06** | Ahmed | Modification de la priorité |
| US-05 | **US-07** | Marc-Raphaël | Attribution d’une échéance |
| US-06 | **US-08** | Marc-Raphaël | Modification d’une échéance |
| US-07 | **US-09** | Marc-Raphaël | Retrait d’une échéance |
| US-08 | **US-10** | Mathieu | Sauvegarde réussie |
| US-12 | **US-11** | Mathieu | Échec de sauvegarde |
| US-09 | **US-12** | Émilien | Rechargement automatique |
| US-10 | **US-13** | Émilien | Démarrage sans fichier |
| US-11 | **US-14** | Émilien | Fichier invalide / illisible |

**Important :** `US-xx` est une référence métier, différente du numéro GitHub `#xx` d’une Issue ou PR. Les numéros GitHub restent tels quels ; seuls les titres et références textuelles des récits devront être harmonisés. **Cette présentation chronologique par domaine est un choix éditorial proposé après le bilan, sans modifier la répartition fonctionnelle décidée en réunion.**

#### Zones communes et points de coordination

- **Ajout (A) / Modifications (B, C)** : les choix pendant la création ne doivent pas être confondus avec les changements sur une tâche existante. Utiliser le socle et ses zones balisées pour limiter les conflits.
- **Sauvegarde (D) / Chargement (E)** : Mathieu et Émilien doivent convenir **avant intégration** d’un même fichier, format, ordre des champs, gestion des valeurs absentes et encodage ; Ahmed tranche les conflits d’intégration au besoin.
- **Intégration** : Ahmed préserve les interfaces communes ; chaque membre soumet ses changements par une PR. Une classe supplémentaire n’est pas interdite par l’énoncé ; l’équipe privilégie néanmoins la réutilisation du socle pour limiter la complexité.

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
- **14 récits (US-01 à US-14) dans la présente version**, satisfaisant le minimum de 12 demandé par l’énoncé ; au moins 2 récits par membre.
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

**Mise à jour du 15 octobre — traçabilité des 14 récits :**
- Chaque US-01 à US-14 doit avoir **sa propre Issue GitHub**, distincte de l’Issue collective **#4 « Propositions de récits »** et des tâches techniques.
- Le propriétaire crée ou corrige l’Issue, la nomme `US-xx — Intitulé`, lui attribue le responsable, l’itération cible, une priorité justifiée, une estimation à valider, les critères de la section 9 et les vérifications ; il évite tout doublon.
- Une PR peut prendre en charge une ou plusieurs US si les liens et critères sont explicites ; **les deux variantes PR #18 et PR #19 couvrent la même US-01**, pas deux récits distincts.
- Le tableau GitHub Projects reflète l’état **réel** des Issues et PR. Une PR ouverte est « À vérifier » ; **« Terminé »** exige l’intégration et la définition de terminé.
- **Contrôle du 15 octobre :** parmi les Issues repérées sur GitHub, aucune Issue individuelle explicitement titrée `US-xx` n’a été identifiée. Les propriétaires doivent contrôler à nouveau le dépôt, puis créer les Issues manquantes.

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

## 6. Itérations — référence commune de travail

> **À lire par tous les membres.** Cette section précise **qui réalise quel récit, ce qui doit être montré, quand et comment le vérifier**. Les critères détaillés se trouvent en section 9 ; l’état du code et des revues se vérifie dans GitHub. Le tableau ci-dessous est une **proposition opérationnelle issue du bilan**, à valider avec l’ensemble de l’équipe, notamment Émilien (Product Owner).

### 6.1 Dates et principes

- **Réunion de bilan : mercredi 14 octobre 2026**, en soirée (présents : Sofiane, Ahmed, Marc-Raphaël).
- **Vendredi 16 octobre 2026 : présentation des résultats de l’itération 1.** Chacun montre un résultat réel (fonctionnement, PR, tests, difficultés). Ce jalon **ne signifie pas que l’application complète est due le 16**.
- **Itération 2 :** poursuivre à partir de l’incrément obtenu, ajouter les comportements obligatoires restants et corriger les défauts. **Sa date de clôture n’a pas été fournie et doit être fixée collectivement.** Ne pas inventer de date dans les Issues ou le tableau.
- Le projet vise **deux incréments utilisables**, et non une première itération composée seulement de documents ou de code impossible à exécuter.
- Les critères de US-01 couvrent la création simple pour l’itération 1 ; **les critères d’ajout complets de l’énoncé seront couverts par US-01 + US-02 + US-03 à la fin de l’itération 2**.

### 6.2 Répartition des résultats par membre

Les colonnes ci-dessous définissent les livrables **cibles** ; elles ne prouvent pas que le code est déjà terminé. Chacun doit déclarer précisément **réalisé / à vérifier / bloqué** dans son Issue.

| Membre / domaine | **Itération 1 — résultat à montrer le 16/10** | **Itération 2 — travail à achever** | Vérification attendue |
|---|---|---|---|
| **Sofiane — Ajout** | **US-01** : saisir un titre, créer un ID unique, statut `À faire`, priorité `Normale`, aucune échéance ; rejet d’un titre vide. Soumettre **une seule** des variantes PR #18 / #19 à l’intégration. | **US-02** : choisir `Basse/Normale/Élevée` à la création, défaut `Normale`, erreur corrigée/annulée. **US-03** : saisir ou omettre une échéance à la création, contrôler le calendrier, pouvoir annuler l’ajout. | Ajout réussi, doublons de titre permis avec ID distinct, titre vide refusé ; puis priorité/date valide ou invalide, aucune tâche partielle. |
| **Ahmed — Consultation / modification** | **US-04** : afficher les tâches avec tous leurs champs et le cas de liste vide. **US-05** : terminer une tâche par ID, gérer ID inconnu / déjà terminée. | **US-06** : modifier la priorité d’une tâche existante sans changer les autres champs, refuser les valeurs et ID incorrects. | Liste vide et remplie ; terminaison ciblée et répétée ; valeur de priorité invalide sans altération. |
| **Marc-Raphaël — Échéances existantes** | **US-07** : attribuer une date réelle à une tâche existante, accepter une date passée, refuser une date impossible. | **US-08** : remplacer une échéance ; **US-09** : la retirer ; ne jamais modifier les autres champs. | Date valide / impossible / passée, ID inconnu ; modification puis retrait et intégrité des autres champs. |
| **Mathieu — Sauvegarde** | **US-10** : sauvegarder explicitement les tâches dans un fichier documenté et complet (ID, titre, priorité, échéance, statut). **Accorder format et chemin avec Émilien.** | **US-11** : sur échec d’écriture, afficher une erreur sans annoncer une réussite ; vérifier que les données ne sont pas présentées comme sauvegardées. | Contenu du fichier, écriture après modification ; dossier non accessible / erreur d’écriture et message correct. |
| **Émilien — Chargement** | **US-12** : recharger automatiquement au démarrage des tâches issues de US-10 ; conserver les ID et permettre un nouvel ID unique. **Aligner le format sur celui de Mathieu.** | **US-13** : démarrer sans fichier avec liste vide. **US-14** : refuser fichier illisible / mal formé, interrompre le démarrage et conserver le fichier intact. | Redémarrage et comparaison champ par champ ; nouveau titre après rechargement ; fichier absent ; fichier corrompu inchangé. |

**Interfaces croisées à préparer sans attendre :** (1) le menu de démarrage et la collection de tâches pour les domaines A, B et C ; (2) le contrat du fichier entre D et E ; (3) l’intégration et les vérifications transversales avec Ahmed et Marc-Raphaël. Les choix de priorité/date **lors de l’ajout** (A) ne remplacent pas leur modification **après ajout** (B et C).

### 6.3 Tableau récapitulatif des itérations

| Itération | Objectif | Récits | Version (commit) | Vérifications | Observations |
|---|---|---|---|---|---|
| **1 — bilan du 16/10/2026** | Disposer d’un premier **TaskFlow compilable et démontrable** : créer, afficher, terminer, gérer une première échéance, préparer la sauvegarde et le rechargement compatibles. | **Cible : US-01, US-04, US-05, US-07, US-10, US-12**. Livrables réels à cocher après tests et intégration. | **À renseigner : SHA de `main` vérifié lors de la revue.** Les commits de branche ou PR ouvertes ne sont pas le commit livré. | Compilation et lancement depuis un clone propre, démonstration des six récits, tests nominaux et négatifs, résultats dans `docs/verification.md`. | Présenter les réussites **et les blocages** ; une US non validée/non fusionnée reste « À vérifier » ou « En cours ». Déterminer les ajustements de l’itération 2. |
| **2 — date à fixer** | Terminer le parcours complet de l’énoncé, les validations, les scénarios d’erreur et les intégrations ; préparer la version finale. | **Cible : US-02, US-03, US-06, US-08, US-09, US-11, US-13, US-14**, plus corrections ou reprises de l’itération 1. | **À renseigner : SHA final de `main`** après fusions et validation. | Bout en bout : ajout avec options → affichage → mise à jour → sauvegarde → redémarrage → nouvel ajout ; erreurs de saisie, fichier absent, fichier corrompu, sauvegarde impossible ; traces dans `docs/verification.md`. | Bilan de la progression, correction des anomalies, README et Issues à jour, approbation des PR, décision de livraison. |

### 6.4 Modalités de réalisation et preuves à présenter

**Pendant chaque itération — pour chaque récit :**

1. **Issue :** le propriétaire ouvre ou corrige l’Issue `US-xx`, reprend les critères section 9, indique responsable, itération, priorité, estimation et état.
2. **Code :** implémentation dans les fichiers balisés du socle autant que possible ; coordination préalable si une zone commune doit être modifiée.
3. **PR :** lier l’Issue, expliquer le changement, les vérifications, les limites et l’éventuel usage de l’IA ; faire relire par un autre membre.
4. **Vérifications :** consigner commande, entrée, résultat attendu, résultat réel et commit testé dans `docs/verification.md` ; signaler les écarts par Issue d’anomalie.
5. **Bilan :** mettre à jour l’Issue et GitHub Projects ; le responsable Qualité/Test contrôle sur un clone propre, le Scrum Master renseigne `docs/iterations.md`, l’Intégrateur consigne le commit de la version intégrée.

**Vendredi 16 octobre — minimum de restitution par personne :**

| À présenter | Support attendu | Responsable de préparation |
|---|---|---|
| Ce qui fonctionne effectivement pour les US de l’itération 1 | Démonstration et références d’Issues / PR | **Chaque auteur** |
| Ce qui ne compile pas, manque ou attend une revue | Blocage et prochaine action datée dans l’Issue | **Chaque auteur** ; coordination Scrum Master |
| Compatibilité du fichier sauvegardé et chargé | Format partagé, exemple réel et contrôle des champs | **Mathieu + Émilien**, avec Ahmed pour l’intégration |
| Résultats des scénarios testés | `docs/verification.md` avec commit et écarts | **Marc-Raphaël**, avec chaque auteur |
| Version commune et état des fusions | Commit `main`, PR approuvées / non fusionnées | **Ahmed** |
| Décisions, améliorations et planification de l’itération 2 | `docs/iterations.md` + présente section 6 mise à jour | **Sofiane**, avec validation collective / Product Owner |

### 6.5 Validation et règles de sortie

- L’état **Terminé** exige la définition de terminé (section 5) et la fusion de la PR ; **une branche qui fonctionne localement ne suffit pas**.
- La première itération est un **incrément limité**, pas l’application complète. Les fonctions ou erreurs non encore traitées doivent être documentées et planifiées en itération 2.
- Après chaque revue, noter au moins **un ajustement concret** en section 7 et dans `docs/iterations.md`.
- Le calendrier définitif de l’itération 2, les priorités relatives et les estimations sont à **valider par l’équipe et le Product Owner**, sans attribuer une validation à une personne absente de la réunion du 14 octobre.

---

## 7. Ajustements et décisions de suivi

Cette section réunit les améliorations du processus. **Les ajustements de présentation proposés après la réunion restent soumis à validation**, comme le contenu détaillé des itérations.

| Ajustement | Problème traité / justification | État |
|---|---|---|
| Restreindre la fermeture automatique des Issues à l’état « Terminé » | Éviter une Issue fermée avant la fusion et la vérification. | Règle déjà décrite dans le document initial. |
| Livrer les modèles d’Issue et de PR avec le socle T2 | Les modèles doivent exister sur `main` avant la création des récits. | Organisation initiale du dépôt. |
| **Scinder l’ancienne US-01 en trois** | Distinguer l’ajout simple présentable en itération 1 des choix de priorité et d’échéance réservés à l’itération 2 ; rendre les contributions plus explicites. | **Orientation retenue lors du bilan du 14/10 ; détail à confirmer par l’équipe.** |
| **Regrouper US-01 à US-14 par domaine / propriétaire** | Éviter les numéros non consécutifs pour un même membre et préserver les 11 autres fonctionnalités. | **Renumérotation éditoriale proposée après le bilan ; validation collective requise.** |
| **Renseigner les récits dans le tableau Domaines et les deux itérations en section 6** | Chacun doit savoir ce qu’il produit, comment le tester et quand le présenter. | **Demande issue du bilan du 14/10 ; proposition opérationnelle à valider.** |
| **Exiger une Issue distincte pour chaque US** | Relier précisément backlog, auteur, critères, branche, PR, revue et résultats. | **Contrôle et création des Issues à faire.** |
| **Distinguer sauvegarde normale / échec et chargement normal / fichier absent / fichier corrompu** | Clarifier les frontières entre récits, tout en conservant les capacités prévues dans le backlog initial. | **Clarification rédactionnelle, à valider avec les propriétaires.** |

---

## 8. Contribution de chaque membre

**Suivi factuel à renseigner par chacun** : inscrire **uniquement** des Issues, PR, revues et commits réellement existants. Ne pas utiliser une PR ouverte comme preuve de fusion. Les identifiants de récits renvoient au backlog de la section 9.

| Membre | Rôle | US attribuées | Issues US (liens à compléter) | PR de code (liens) | Revues effectuées (liens) |
|---|---|---|---|---|---|
| Sofiane | Scrum Master | **US-01, US-02, US-03** | #35, #36, #37 | #18, #61, #62 — fusionnées | #51, #52, #65, #66 et #74 — revues et approuvées |
| Ahmed | Intégrateur | **US-04, US-05, US-06** | À compléter | À compléter | À compléter |
| Marc-Raphaël | Qualité/Test | **US-07, US-08, US-09** | À compléter | À compléter | À compléter |
| Mathieu | Documentation | **US-10, US-11** | À compléter | À compléter | À compléter |
| Émilien | Product Owner | **US-12, US-13, US-14** | À compléter | À compléter | À compléter |

---

## 9. Backlog détaillé — 14 récits utilisateurs

Le backlog d’origine (12 récits) a été établi à partir des propositions de l’Issue collective #4, synthétisées par Marc-Raphaël et mises en forme par Émilien. La présente révision **conserve les 11 autres capacités et leurs propriétaires**, scinde l’ajout en trois récits et regroupe les identifiants **dans l’ordre Sofiane → Ahmed → Marc-Raphaël → Mathieu → Émilien**.

### 9.1 Règles de lecture

- **US-01 à US-14** désignent les récits fonctionnels. **`#18`, `#19`**, etc. sont des numéros GitHub de PR, qui ne changent pas avec la renumérotation.
- **Les titres expriment des actions distinctes.** Les erreurs de saisie et les annulations sont des critères d’acceptation des récits correspondants.
- La **priorité P1 / P2 / P3** est la priorité produit ; elle ne doit pas être confondue avec `Priorite.BASSE`, `NORMALE` ou `ELEVEE`, qui sont des valeurs d’une tâche dans l’application.
- Les priorités et estimations indiquées ci-dessous sont des **propositions à valider collectivement**. L’itération cible désigne le moment prévu, pas le statut réel d’achèvement.
- Chaque récit doit être relié à sa propre Issue GitHub et à ses vérifications. L’ordre de numérotation facilite la lecture **mais n’impose pas de développer US-01 à US-14 séquentiellement** : les dépendances guident la réalisation.

### 9.2 Priorités et estimations

- **P1 — Très élevée :** capacité indispensable au premier parcours utilisable.
- **P2 — Élevée :** comportement obligatoire à compléter pour le parcours final.
- **P3 — Normale :** cas obligatoire particulier ; sa moindre urgence **n’autorise pas son omission**.
- **Estimation :** effort relatif sur l’échelle `1, 2, 3, 5, 8` ; à confirmer par l’auteur, le Product Owner et l’équipe.

---

### US-01 — Créer une tâche simple

**Responsable :** Sofiane  
**Itération cible :** 1  
**Priorité proposée :** P1 — Très élevée (capacité de base nécessaire aux autres récits)  
**Estimation proposée :** 2 points — interface console et logique d’ajout simple déjà développées ; à confirmer collectivement.

#### Récit utilisateur

En tant que membre du soutien informatique, je veux créer une tâche en indiquant son titre afin de consigner un travail à effectuer.

#### Critères d’acceptation

- [ ] CA1 : Un titre non vide crée **une seule** tâche avec un identifiant entier positif **unique** et le statut `À faire`.
- [ ] CA2 : Sans options supplémentaires, la tâche est créée avec la priorité `Normale` et **sans échéance**.
- [ ] CA3 : Un titre vide ou composé uniquement d’espaces est refusé avec un message explicite, sans création de tâche.
- [ ] CA4 : L’application confirme la création et affiche au minimum le nouvel identifiant.
- [ ] CA5 : Deux tâches ayant le même titre restent distinctes par leurs identifiants.

#### Dépendances et limites

- Aucun récit préalable ; utilise les classes communes `Tache`, `TacheService` et le menu du socle.
- **Livrable de l’itération 1 :** ajout simple vérifiable ; **le choix d’une priorité et d’une date sera apporté par US-02 et US-03 en itération 2**.
- Les PR #18 et #19 sont deux implémentations alternatives de ce même récit ; une seule sera retenue à l’intégration.

#### Vérification

- Ajouter `Vérifier la sauvegarde du serveur` et contrôler l’ID, la priorité `Normale`, l’absence d’échéance et le statut `À faire`.
- Ajouter une deuxième tâche, y compris avec un titre identique, et contrôler l’unicité des ID.
- Essayer un titre vide puis des espaces seuls ; vérifier le message et l’absence de tâche supplémentaire.

---

### US-02 — Choisir une priorité lors de l’ajout

**Responsable :** Sofiane  
**Itération cible :** 2  
**Priorité proposée :** P2 — Élevée (complète la création conformément à l’énoncé)  
**Estimation proposée :** 2 points — ajout d’une étape facultative au parcours US-01 et validation des entrées.

#### Récit utilisateur

En tant que membre du soutien informatique, je veux **choisir la priorité d’une nouvelle tâche au moment de sa création** afin de signaler son importance dès l’ajout.

#### Critères d’acceptation

- [ ] CA1 : Pendant la création, l’utilisateur peut choisir `Basse`, `Normale` ou `Élevée` et la valeur retenue est enregistrée.
- [ ] CA2 : Si l’utilisateur ne précise aucune priorité, la valeur est `Normale`.
- [ ] CA3 : Une priorité non reconnue est signalée ; l’application permet une correction ou l’annulation, **sans créer une tâche avec une valeur invalide**.
- [ ] CA4 : La création réussie conserve l’identifiant unique et le statut `À faire` du récit US-01.

#### Dépendances et limites

- **Dépend de US-01.** Il s’agit du **choix lors de la création**, et non de la modification de la priorité d’une tâche existante (**US-06, Ahmed**).
- L’action peut enrichir la même entrée de menu `Ajouter une tâche` ; une nouvelle option de menu n’est pas exigée.

#### Vérification

- Créer successivement des tâches avec les trois priorités permises.
- Omettre la priorité : vérifier `Normale`.
- Entrer une priorité invalide : vérifier que l’erreur est expliquée et qu’aucune tâche incorrecte n’est ajoutée.

---

### US-03 — Définir une échéance lors de l’ajout

**Responsable :** Sofiane  
**Itération cible :** 2  
**Priorité proposée :** P2 — Élevée (complète la création conformément à l’énoncé)  
**Estimation proposée :** 3 points — saisie d’une date facultative, validation calendaire, correction ou annulation.

#### Récit utilisateur

En tant que membre du soutien informatique, je veux **définir ou omettre une échéance pendant la création d’une tâche** afin de préciser immédiatement sa date limite lorsqu’elle est connue.

#### Critères d’acceptation

- [ ] CA1 : L’utilisateur peut indiquer une échéance au format `AAAA-MM-JJ` correspondant à une date réelle ; cette date est enregistrée.
- [ ] CA2 : S’il ne saisit pas de date, la tâche est créée sans échéance.
- [ ] CA3 : Une date impossible (ex. `2026-02-30`) ou mal formatée est rejetée avec une explication ; l’utilisateur peut corriger ou annuler sans ajouter de tâche invalide.
- [ ] CA4 : Une date passée valide est acceptée.
- [ ] CA5 : L’utilisateur peut annuler le processus de création avant validation finale ; **aucune tâche partielle n’est ajoutée**.
- [ ] CA6 : La création aboutie conserve le titre et la priorité choisis conformément à US-01 et US-02.

#### Dépendances et limites

- **Dépend de US-01 et complète le parcours enrichi par US-02.** Cela concerne uniquement la **création**.
- L’attribution, la modification et le retrait d’une échéance sur une tâche **déjà existante** relèvent de **US-07, US-08 et US-09 (Marc-Raphaël)**.
- L’annulation n’est pas un récit artificiel indépendant : elle est un critère de validité du processus d’ajout, conformément à l’énoncé.

#### Vérification

- Créer une tâche avec une date réelle au format attendu et contrôler la valeur enregistrée.
- Créer une tâche sans échéance et vérifier son absence.
- Saisir une date impossible, puis corriger ; vérifier qu’une seule tâche valide est créée.
- Annuler l’ajout : vérifier que la liste et le prochain identifiant utilisable restent cohérents.

---

### US-04 — Afficher la liste des tâches

**Priorité :** P1 — Très élevée  
**Estimation :** 2 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Ahmed  
**Itération cible :** 1 *(proposition de planification à valider)*

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

### US-05 — Marquer une tâche comme terminée

**Priorité :** P1 — Très élevée  
**Estimation :** 2 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Ahmed  
**Itération cible :** 1 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux marquer une tâche comme terminée afin de suivre l'avancement du travail.

#### Critères d'acceptation

- [ ] CA1 : Lorsqu'un identifiant existant est fourni, le statut de la tâche sélectionnée passe à `Terminée`.
- [ ] CA2 : L'application confirme le changement de statut.
- [ ] CA3 : Les autres informations de la tâche et les autres tâches restent inchangées.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application affiche un message d'erreur.
- [ ] CA5 : Si la tâche est déjà terminée, l'application le signale sans effectuer de modification inutile.

#### Dépendances

- Dépend de **US-01 — Créer une tâche simple**, pour disposer d'une tâche existante.
- Dépend de **US-04 — Afficher la liste des tâches**, pour faciliter la consultation des identifiants.

#### Vérification

- Marquer une tâche existante comme terminée et vérifier son nouveau statut.
- Vérifier que les autres champs de la tâche restent inchangés.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.
- Tenter de terminer une tâche déjà terminée et vérifier le comportement.

---

### US-06 — Modifier la priorité d’une tâche existante

**Priorité :** P2 — Élevée  
**Estimation :** 2 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Ahmed  
**Itération cible :** 2 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux modifier la priorité d'une tâche afin d'adapter son importance aux besoins du service.

#### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut sélectionner une tâche existante à l'aide de son identifiant.
- [ ] CA2 : Les valeurs `Basse`, `Normale` et `Élevée` sont acceptées.
- [ ] CA3 : Une priorité invalide est refusée et la priorité actuelle reste inchangée.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.
- [ ] CA5 : La modification de la priorité ne change pas les autres informations de la tâche.

#### Dépendances

- Dépend de **US-01 — Créer une tâche simple**, pour disposer d'une tâche à modifier.

#### Vérification

- Modifier la priorité d'une tâche vers chacune des valeurs autorisées.
- Saisir une priorité invalide et vérifier que l'ancienne valeur est conservée.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.
- Vérifier que les autres informations restent inchangées.

---

### US-07 — Attribuer une échéance à une tâche existante

**Priorité :** P3 — Normale  
**Estimation :** 2 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Marc-Raphaël  
**Itération cible :** 1 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux attribuer une échéance à une tâche afin de connaître la date prévue pour son exécution.

#### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut attribuer une date valide à une tâche existante.
- [ ] CA2 : La date respecte le format `AAAA-MM-JJ` et correspond à une date réelle du calendrier.
- [ ] CA3 : Une date impossible ou un format incorrect est refusé sans modifier l'échéance existante.
- [ ] CA4 : Les dates passées sont acceptées.
- [ ] CA5 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

#### Dépendances

- Dépend de **US-01 — Créer une tâche simple**, pour disposer d'une tâche existante.

#### Vérification

- Attribuer une date valide et vérifier qu'elle est enregistrée.
- Essayer une date impossible, par exemple `2026-02-30`, et vérifier son refus.
- Essayer un format incorrect et vérifier que l'échéance reste inchangée.
- Vérifier qu'une date passée est acceptée.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

### US-08 — Modifier une échéance existante

**Priorité :** P3 — Normale  
**Estimation :** 2 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Marc-Raphaël  
**Itération cible :** 2 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux modifier l'échéance d'une tâche afin de tenir compte d'un changement de calendrier.

#### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut remplacer l'échéance d'une tâche existante par une nouvelle date valide.
- [ ] CA2 : La nouvelle date remplace l'ancienne sans modifier le titre, la priorité ou le statut.
- [ ] CA3 : Une date invalide est refusée et l'ancienne échéance est conservée.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

#### Dépendances

- Dépend de **US-07 — Attribuer une échéance à une tâche**, pour disposer du mécanisme de gestion des échéances.
- Dépend de **US-01 — Créer une tâche simple**, pour disposer d'une tâche existante.

#### Vérification

- Remplacer une échéance par une autre date valide et vérifier le résultat.
- Saisir une date invalide et vérifier que l'ancienne échéance est conservée.
- Vérifier que les autres informations ne changent pas.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

### US-09 — Retirer l’échéance d’une tâche

**Priorité :** P3 — Normale  
**Estimation :** 2 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Marc-Raphaël  
**Itération cible :** 2 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux retirer l'échéance d'une tâche afin de ne plus lui associer de date limite.

#### Critères d'acceptation

- [ ] CA1 : L'utilisateur peut retirer l'échéance d'une tâche existante à l'aide de son identifiant.
- [ ] CA2 : Après le retrait, la tâche est conservée et son échéance est indiquée comme absente.
- [ ] CA3 : Le titre, la priorité, l'identifiant et le statut restent inchangés.
- [ ] CA4 : Si l'identifiant n'existe pas ou comprend des caractères autres que des chiffres, l'application signale le problème.

#### Dépendances

- Dépend de **US-01 — Créer une tâche simple**, pour disposer d'une tâche existante.
- Dépend de **US-07 — Attribuer une échéance à une tâche**, pour utiliser le mécanisme de gestion des échéances.

#### Vérification

- Retirer l'échéance d'une tâche et vérifier qu'elle est désormais absente.
- Vérifier que la tâche et ses autres informations sont conservées.
- Utiliser un identifiant inexistant et vérifier le message d'erreur.

---

### US-10 — Sauvegarder les tâches dans un fichier

**Priorité :** P1 — Très élevée  
**Estimation :** 5 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Mathieu  
**Itération cible :** 1 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux sauvegarder explicitement les tâches dans un fichier local afin de conserver mes données après la fermeture du programme.

#### Critères d'acceptation

- [ ] CA1 : Une commande explicite permet de sauvegarder les données dans un fichier local.
- [ ] CA2 : La sauvegarde conserve toutes les informations des tâches, y compris les identifiants, les priorités, les statuts et les échéances absentes.
- [ ] CA3 : Un message de réussite est affiché uniquement si la sauvegarde réussit.
- [ ] CA4 : Le fichier produit peut être relu par le chargement (US-12) sans perte de champs. Le scénario d’échec d’écriture est vérifié dans US-11.

#### Dépendances

- Dépend d'un jeu de test pour disposer de données à sauvegarder.
- Nécessite un mécanisme d'écriture dans un fichier local.

#### Vérification

- Ajouter plusieurs tâches et lancer la sauvegarde.
- Vérifier que le fichier contient toutes les informations nécessaires.
- Vérifier qu'un message de réussite apparaît après une sauvegarde réussie.
- Vérifier que le fichier sauvegardé est compatible avec le chargement US-12 ; voir US-11 pour les erreurs d’écriture.

---

### US-11 — Signaler un échec de sauvegarde

**Priorité :** P2 — Élevée  
**Estimation :** 3 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Mathieu  
**Itération cible :** 2 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux être averti lorsqu'une sauvegarde échoue afin de savoir que mes données n'ont pas été enregistrées correctement.

#### Critères d'acceptation

- [ ] CA1 : Si le fichier ne peut pas être écrit, l'application affiche un message clair indiquant l'échec.
- [ ] CA2 : L'application n'affiche jamais un message de réussite lorsque l'écriture a échoué.
- [ ] CA3 : L'échec peut être reproduit manuellement, par exemple en utilisant un emplacement de sauvegarde non accessible en écriture.

**Limite du récit :** ce scénario concerne une tentative de sauvegarde qui échoue ; le scénario nominal est couvert par US-10.

#### Dépendances

- Dépend de **US-10 — Sauvegarder les tâches dans un fichier**, car ce récit vérifie spécifiquement le comportement en cas d'échec de sauvegarde.

#### Vérification

- Tenter une sauvegarde vers un emplacement non accessible en écriture.
- Vérifier que l'application affiche un message d'échec.
- Vérifier qu'aucun message de réussite n'est affiché à tort.

---

### US-12 — Recharger les tâches au démarrage

**Priorité :** P2 — Élevée  
**Estimation :** 2 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Émilien  
**Itération cible :** 1 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux retrouver automatiquement mes tâches sauvegardées au démarrage afin de reprendre le travail sans ressaisir les données.

#### Critères d'acceptation

- [ ] CA1 : Au démarrage, si un fichier de données valide existe, l'application recharge automatiquement les tâches.
- [ ] CA2 : Les informations et les identifiants restent identiques après le rechargement.
- [ ] CA3 : Une nouvelle tâche créée après le rechargement reçoit un identifiant distinct de ceux déjà présents.
- [ ] CA4 : Les tâches sans échéance sont également rechargées correctement.

**Point d’intégration :** convenir du même chemin, du même format et des mêmes champs de données avec Mathieu (US-10) avant la fusion.

#### Dépendances

- Dépend de **US-10 — Sauvegarder les tâches dans un fichier**, pour disposer d'un fichier de données à recharger.
- Nécessite un mécanisme de lecture du fichier local.

#### Vérification

- Créer plusieurs tâches, les sauvegarder, fermer l'application et la redémarrer.
- Vérifier que toutes les tâches et leurs informations sont restaurées.
- Comparer les identifiants avant et après le redémarrage.
- Ajouter une nouvelle tâche après le rechargement et vérifier l'unicité de son identifiant.

---

### US-13 — Démarrer sans fichier de données

**Priorité :** P3 — Normale  
**Estimation :** 2 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Émilien  
**Itération cible :** 2 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux pouvoir démarrer l'application sans fichier de données existant afin de commencer à gérer mes tâches.

#### Critères d'acceptation

- [ ] CA1 : Si le fichier de données n'existe pas au démarrage, l'application démarre avec une liste vide.
- [ ] CA2 : L'absence du fichier ne provoque pas d'erreur empêchant l'utilisation de l'application.
- [ ] CA3 : L'affichage de la liste vide présente un message explicite.

**Cas particulier :** le démarrage sans fichier est distinct du chargement d’un fichier valide (US-12) et du refus d’un fichier corrompu (US-14).

#### Dépendances

- Dépend de **US-12 — Recharger les tâches au démarrage**, car cette fonctionnalité doit distinguer un fichier absent d'un fichier valide existant.

#### Vérification

- Lancer l'application dans un environnement où le fichier de données n'existe pas.
- Vérifier que l'application démarre normalement.
- Afficher la liste et vérifier qu'elle est vide.

---

### US-14 — Gérer un fichier illisible ou mal formé

**Priorité :** P3 — Normale  
**Estimation :** 3 points — estimation initiale du backlog ; à réviser et justifier collectivement.

**Responsable :** Émilien  
**Itération cible :** 2 *(proposition de planification à valider)*

#### Récit utilisateur

En tant qu'utilisateur, je veux être averti si le fichier de données est illisible ou mal formé afin d'éviter d'utiliser des données incorrectes.

#### Critères d'acceptation

- [ ] CA1 : Si le fichier existant est illisible ou mal formé, l'application affiche un message d'erreur clair.
- [ ] CA2 : Le démarrage est interrompu plutôt que de poursuivre avec des données potentiellement incorrectes.
- [ ] CA3 : Le fichier d'origine n'est pas modifié par cette tentative de chargement.

**Cas particulier :** le fichier d’origine ne doit ni être supprimé, ni être réécrit lors d’un échec de chargement.

#### Dépendances

- Dépend de **US-12 — Recharger les tâches au démarrage**, car ce récit couvre les erreurs rencontrées lors du chargement.

#### Vérification

- Créer un fichier de données mal formé et démarrer l'application.
- Vérifier qu'un message d'erreur clair est affiché.
- Vérifier que l'application interrompt son démarrage.
- Comparer le fichier avant et après la tentative pour vérifier qu'il n'a pas été modifié.

---

### 9.3 Contrôle de cohérence du backlog

- **14 récits distincts**, dans l’ordre US-01 à US-14, sans doublon ni numéro manquant.
- **Propriétaires** : Sofiane (US-01 à US-03), Ahmed (US-04 à US-06), Marc-Raphaël (US-07 à US-09), Mathieu (US-10 à US-11), Émilien (US-12 à US-14).
- **Itération 1 proposée** : US-01, US-04, US-05, US-07, US-10, US-12. **Itération 2 proposée** : US-02, US-03, US-06, US-08, US-09, US-11, US-13, US-14.
- **Frontières** : priorité **à l’ajout** (US-02) / priorité **après ajout** (US-06) ; échéance **à l’ajout** (US-03) / échéance **après ajout** (US-07 à US-09) ; sauvegarde réussie (US-10) / échec (US-11) ; chargement normal (US-12) / fichier absent (US-13) / fichier invalide (US-14).
- **Traçabilité** : une Issue par US et des liens vers PR, essais et commit intégré ; la date de fin de l’itération 2 reste à confirmer.
- **État « Terminé »** : satisfaire les critères, vérifier, relire, fusionner et documenter ; aucun récit ne devient terminé par sa seule inscription au présent document.
