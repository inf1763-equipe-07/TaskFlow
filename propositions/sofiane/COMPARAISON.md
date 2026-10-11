# Comparaison des trois architectures — Discussion, pas validation

| Critère | PR #6 — Socle initial | PR #12 — Socle allégé d'Ahmed | Prototype alternatif — Sofiane |
|---|---|---|---|
| Nombre de classes au moment de la proposition | 23 | 11 | **9 classes de production** |
| Nature du code | Socle préstructuré, actions initiales largement vides | Socle minimal, fonctions des domaines à implémenter | **Prototype fonctionnel**, fonctionnalités illustrées |
| Couche vue | `Console`, `VueCommune`, actions | `Console` + `Vue` abstraite + vues créées par domaines | `ConsoleUI` unique |
| Couche métier | `TacheService`, `Tache`, énumérations | Même principe, `remplacer()` et ID après chargement | `TacheService`, `Tache`, énumérations, `ValidateurDate` |
| Persistance | Interface et classe fichier à compléter | Interface et classe fichier à compléter | Fichier texte **effectivement lu/écrit** |
| Menu | Une classe par action | `MenuControleur.Entree` + `Runnable`, branchement par domaine | `switch` dans `ConsoleUI` |
| Tests autonomes | À compléter | Mode `--demo` (2 tâches, sans lire le fichier) | Fichier de test isolé passé en argument |
| Autonomie de développement | Fichiers d'actions distincts | Contrôleurs/vues de domaines distincts à créer | **Plus de conflits potentiels dans ConsoleUI** |
| Risque fonctionnel | À évaluer après développement | À évaluer après développement | Comportements déjà démontrables, mais sans revue de l'équipe |

**Précaution :** on ne compare pas directement « 9 » et « 11 » comme deux tailles finales. Les 11 classes de la PR #12 sont un **socle** : les contrôleurs et vues métier seront ensuite créés. Le prototype à 9 classes contient déjà leur logique. Le nombre de classes n'est donc pas, à lui seul, un indicateur de meilleure conception.

## Trois choix techniques défendus

1. **ValidateurDate dédié.** La priorité et la date sont traitées comme de véritables règles métier : `2026-02-30` est rejetée ; Entrée seule reste une omission autorisée. Le code est réutilisable entre la création et la modification.
2. **Gestion d'état indépendante du fichier.** `TacheService` ne sait rien du disque. `Main` charge, la console demande la sauvegarde, le dépôt gère le fichier. Cela permet de tester les règles métier seules.
3. **Fichier protégé contre la corruption.** Le chargement refuse les entrées mal formées, la sauvegarde utilise un fichier temporaire et un déplacement atomique, et l'échec ne produit pas de message de succès.

## Trois limites à reconnaître

1. **Goulot d'étranglement de `ConsoleUI`** : les cinq domaines devront potentiellement modifier le même fichier pendant les deux itérations.
2. **Contrôleurs non isolés par domaine** : plus compact, mais moins robuste pour des PR distribuées et des tests indépendants de la console.
3. **Prototype déjà complet** : il est pédagogique pour comparer les conceptions, mais une fusion telle quelle ne démontrerait pas les contributions de code individuelles attendues des membres.

## Recommandation à soumettre, sans anticiper le vote

Retenir une **architecture hybride** si l'équipe le souhaite : modèle et validation simples, persistance sécurisée et tests de prototype, **mais contrôleurs/vues distincts pour les domaines** et interface de lecture commune pour éviter les doublons. Une taille cible éventuelle de 12–15 classes *au départ* peut être discutée ; il ne faut pas viser un nombre fixe au détriment du découpage réel.

## Points de vérification avant le choix collectif

- Les deux versions compilent-elles dans l'environnement Windows/Java retenu par l'équipe ?
- Les erreurs de saisie sont-elles signalées dès la création, sans remplacement implicite ?
- Le chargement du fichier corrompu s'arrête-t-il sans l'écraser ?
- Un autre domaine peut-il réaliser et tester sa fonctionnalité sans attendre les autres ?
- Les zones partagées et le mécanisme d'intégration dans `Main` sont-ils convenus ?
