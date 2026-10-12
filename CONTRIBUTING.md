# Contribuer à TaskFlow

Les règles de ce fichier sont proposées dans la pull request T1 (Issue #2) et validées par l'équipe. Le fonctionnement de l'équipe (rôles, communication, tableau, définition de terminé, itérations) est dans `docs/organisation.md`.

## Dépôt et droits

Le dépôt appartient à l'organisation GitHub de l'équipe. Les droits suivent les rôles, pas les personnes.

| Rôle | Organisation | Dépôt | Tableau |
|---|---|---|---|
| Intégrateur | propriétaire | administrateur | écriture |
| Scrum Master | propriétaire (secours) | écriture | écriture |
| Product Owner | membre | écriture | administrateur |
| Responsable Qualité/Test, Responsable de la documentation | membres | écriture | écriture |
| Enseignant, correcteur | — | lecture | lecture |

- Les droits d'écriture suffisent pour tout le travail : branches, PR, fusion après approbation, Issues, labels.
- Quand un rôle change de titulaire, ses droits passent avec lui : un propriétaire nomme le nouveau titulaire, puis l'ancien redevient membre.

### Réglages du dépôt

| Réglage | Choix | Pourquoi |
|---|---|---|
| Visibilité | public | protection de `main` gratuite ; données fictives uniquement |
| Wiki | désactivé | la documentation doit être dans le dépôt, donc dans l'archive remise, et passer par des PR |
| Discussions | désactivées | les échanges passent par les Issues et les PR |
| Fusion des PR | commit de fusion uniquement | le détail de chaque PR reste visible dans l'historique de `main` |
| Protection de `main` | PR obligatoire, 1 approbation, aucun contournement, poussées forcées et suppression bloquées | personne ne fusionne sans revue, administrateurs compris |
| Tableau | public | l'enseignant y accède |

### Compte GitHub

- Un compte par personne, avec son vrai nom dans le profil et un identifiant reconnaissable.
- `git config user.email` doit être une adresse liée à son compte GitHub et vérifiée ; sinon, les commits ne sont pas attribués à la bonne personne.
- On utilise de préférence son courriel de l'université. Pour conserver l'accès au dépôt après les études, on ajoute aussi une adresse personnelle au compte.

## Branches

- Chacun utilise Git comme il préfère : en ligne de commande ou intégré à son IDE. Les commandes du README restent en ligne de commande, puisque c'est ainsi que le correcteur compilera.
- Une branche par Issue, créée depuis `main` à jour.
- Nom : `feature/<n°>-<sujet>`, `fix/<n°>-<sujet>` ou `docs/<n°>-<sujet>`, où `<n°>` est le numéro de l'Issue.

## Commits

- Petits et cohérents : un changement par commit.
- Le message est en français, tient en une ligne claire et commence par un nom d'action (« Ajout de… », « Correction de… », « Renommage de… »).
- On cite l'Issue avec `Refs #<n°>`. C'est la PR, pas le commit, qui ferme l'Issue.
- On ne commite jamais de données personnelles, de secret, `data/`, `out/` ni de fichiers d'IDE (`.idea/`, `.vscode/`, `*.iml`).

## Pull requests

- Une PR par Issue, avec l'objectif, comment vérifier, et `Closes #<n°>`. Le modèle de PR guide la description.
- Avant de l'ouvrir : `git fetch`, `git merge origin/main`, compiler, vérifier.
- Un relecteur est désigné. L'Intégrateur gère l'ordre des fusions et les conflits.
- La carte du tableau suit la PR (voir `docs/organisation.md`).

## Revue

- Le relecteur lit le code, l'exécute, et dit ce qu'il a lu et essayé : « OK » ne suffit pas.
- Il répond sous 48 h. Un commentaire de revue n'est jamais généré.
- Si la revue demande des changements, l'auteur corrige avec de nouveaux commits.
- Après approbation, la PR est fusionnée et l'Issue se ferme.

## Remise

L'archive de remise se crée à partir du commit final :

```
git archive --format=zip -o TaskFlow_MP1_EquipeXX.zip <commit>
```

Elle contient le code, la documentation et les données fictives nécessaires aux vérifications.

## Règles d'architecture

Quatre paquets :
- `modele` : les tâches et toutes les règles ;
- `vue` : l'affichage ;
- `controleur` : l'enchaînement et le menu ;
- `persistance` : le fichier.

**Règles :**
- Le modèle n'affiche rien et ne dépend de personne.
- Un contrôleur n'a aucune règle métier et ne fait pas de `System.out`. Il transmet au modèle le texte saisi, tel quel : c'est le modèle qui valide (titre, priorité, date AAAA-MM-JJ) et qui signale une saisie invalide par `SaisieInvalideException`.
- Une vue affiche, c'est tout.
- `Main` crée et relie les objets, rien d'autre.
- Une règle métier hors du modèle = PR refusée.

**Ce que le socle contient déjà, parce que plusieurs domaines s'en servent :**
- `SaisieInvalideException`, dans le modèle, pour toute saisie refusée (A, B, C) ;
- le compteur d'identifiant, dans `TacheService` : A s'en sert à chaque ajout, E le recalcule au chargement (plus grand identifiant + 1) ;
- `Console`, qui est la seule classe à toucher à `System.in` et `System.out`, et qui gère la fin de saisie (Ctrl+D) sans boucler à l'infini.

### Points d'entrée et zones

Chaque domaine dispose de deux choses dans le socle :
- **un point d'entrée :** son action du menu (ou le contrôleur de démarrage pour E), livrée vide ;
- **des zones dans les classes partagées** (`Tache`, `TacheService`, `FichierTacheRepository`) : c'est là qu'il ajoute ses méthodes, par exemple `terminer()` dans la zone « Consultation et modification » de `Tache`.

| Domaine | Point d'entrée | Ses zones |
|---|---|---|
| A — Ajout | `AjouterTacheAction` | `TacheService` |
| B — Consultation et modification | `AfficherTachesAction`, `TerminerTacheAction`, `ModifierPrioriteAction` | `Tache` |
| C — Échéance | `GererEcheanceAction` | `Tache` |
| D — Sauvegarde | `SauvegarderAction` | `TacheService`, `FichierTacheRepository` |
| E — Chargement | `DemarrageControleur` | `TacheService`, `FichierTacheRepository` |

**Règles des zones :**
- Chaque zone est encadrée par deux marqueurs nommés par fonctionnalité, jamais par lettre :

  ```java
  // --- Début domaine Échéance ---
  // --- Fin domaine Échéance ---
  ```

  On n'écrit qu'entre ses propres marqueurs.
- Deux zones sont séparées par au moins trois lignes inchangées (fin de l'une, ligne vide, début de l'autre), pour que Git fusionne sans conflit.
- Si un fichier partagé doit changer en dehors de sa zone, on en parle d'abord dans l'Issue.

Le reste est libre : chacun crée les classes dont son domaine a besoin, par exemple sa propre vue, tant que les règles ci-dessus sont respectées.

## IA

- L'IA travaille sur une Issue à la fois, jamais l'application d'un coup. Le socle suit la même idée : il est produit couche par couche, un commit par couche.
- Les critères, les vérifications et les revues restent humains.
- La PR dit si l'IA a été utilisée et pour quoi.
- Avant sa PR, l'auteur doit pouvoir répondre seul à ces questions :
  - Que fait mon code ?
  - Pourquoi est-il dans cette couche ?
  - Que se passe-t-il en cas d'erreur ?
  - Comment l'ai-je vérifié ?

## Choix techniques

La version du JDK et le format du fichier de données sont décrits dans le `README.md`. Ils y sont proposés dans la PR T1 et validés par l'équipe.
