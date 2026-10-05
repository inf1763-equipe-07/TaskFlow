package taskflow.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Garde la liste des tâches et applique les règles qui les concernent.
 */
public class TacheService {

    private final TacheRepository repository;
    private final List<Tache> taches = new ArrayList<>();

    // L'identifiant que recevra la prochaine tâche créée.
    // Le domaine Ajout s'en sert ; le domaine Chargement le recalcule (plus grand identifiant + 1).
    private int prochainId = 1;

    public TacheService(TacheRepository repository) {
        this.repository = repository;
    }

    /** Toutes les tâches, dans l'ordre où elles ont été créées. */
    public List<Tache> lister() {
        return List.copyOf(taches);
    }

    /** La tâche portant cet identifiant, ou rien si elle n'existe pas. */
    public Optional<Tache> trouver(int id) {
        for (Tache tache : taches) {
            if (tache.id() == id) {
                return Optional.of(tache);
            }
        }
        return Optional.empty();
    }

    /** Donne l'identifiant à utiliser pour une nouvelle tâche, puis avance le compteur. */
    private int prendreProchainId() {
        return prochainId++;
    }

    // --- Début domaine Ajout ---
    // ---

    // ---
    // --- Fin domaine Ajout ---



    // --- Début domaine Sauvegarde ---
    // ---

    // ---
    // --- Fin domaine Sauvegarde ---



    // --- Début domaine Chargement ---
    // ---

    // ---
    // --- Fin domaine Chargement ---

}
