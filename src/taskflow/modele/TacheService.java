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
    // Le domaine Ajout s'en sert ; remplacer() le recalcule (plus grand identifiant + 1).
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


/**
 * Remplace toutes les tâches par la liste fournie, puis recalcule
 * l'identifiant de la prochaine tâche (le plus grand identifiant + 1).
 * La liste est validée avant de modifier les tâches existantes afin
 * de préserver leur contenu si la liste reçue est invalide.
 *
 * Cette méthode sert au chargement du fichier et au mode de démonstration.
 *
 * @param nouvelles liste des tâches qui remplacera la liste actuelle
 * @throws NullPointerException si la liste ou l'une de ses tâches est null
 */
public void remplacer(List<Tache> nouvelles) {
    List<Tache> copie = List.copyOf(nouvelles);

    taches.clear();
    taches.addAll(copie);

    prochainId = taches.stream()
            .mapToInt(Tache::id)
            .max()
            .orElse(0) + 1;
}


    /** Donne l'identifiant à utiliser pour une nouvelle tâche, puis avance le compteur. */
    private int prendreProchainId() {
        return prochainId++;
    }

    // --- Début domaine Ajout ---
    // ---
public Tache ajouter(String titre, Priorite priorite) throws SaisieInvalideException {

    if (titre == null || titre.isBlank()) {
        throw new SaisieInvalideException("le titre est obligatoire.");
    }

    Tache nouvelle = new Tache(
        prendreProchainId(),
        titre,
        priorite,
        null,
        Statut.A_FAIRE
    );

    taches.add(nouvelle);

    return nouvelle;
}
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
