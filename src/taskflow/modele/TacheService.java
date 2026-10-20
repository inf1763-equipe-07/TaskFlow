package taskflow.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
    public void validerTitre(String titre) throws SaisieInvalideException {
        if (titre == null || titre.isBlank()) {
            throw new SaisieInvalideException("Le titre est obligatoire.");
        }
    }

    public Priorite interpreterPriorite(String saisie)
            throws SaisieInvalideException {
        if (saisie == null || saisie.isBlank()) {
            return Priorite.NORMALE;
        }

        return Priorite.depuisLibelle(saisie);
    }

    public LocalDate interpreterEcheance(String saisie)
            throws SaisieInvalideException {
        if (saisie == null || saisie.isBlank()) {
            return null;
        }

        if (!saisie.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new SaisieInvalideException(
                    "La date doit respecter le format AAAA-MM-JJ.");
        }

        try {
            return LocalDate.parse(saisie);
        } catch (DateTimeParseException e) {
            throw new SaisieInvalideException(
                    "La date indiquée n'existe pas dans le calendrier.");
        }
    }

    public Tache ajouter(String titre) throws SaisieInvalideException {
        return ajouter(titre, null, null);
    }

    public Tache ajouter(String titre, String prioriteSaisie)
            throws SaisieInvalideException {
        return ajouter(titre, prioriteSaisie, null);
    }

    public Tache ajouter(String titre, String prioriteSaisie,
                         LocalDate echeance)
            throws SaisieInvalideException {
        validerTitre(titre);
        Priorite priorite = interpreterPriorite(prioriteSaisie);

        Tache nouvelle = new Tache(
                prendreProchainId(),
                titre,
                priorite,
                echeance,
                Statut.A_FAIRE
        );

        taches.add(nouvelle);
        return nouvelle;
    }
    // ---
    // --- Fin domaine Ajout ---



    // --- Début domaine Sauvegarde ---
    // ---
    /** Confie toutes les tâches au repository, qui les écrit. Lance une IOException si l'écriture échoue. */
    public void sauvegarder() throws java.io.IOException {
        repository.sauvegarder(lister());
    }
    // ---
    // --- Fin domaine Sauvegarde ---



    // --- Début domaine Chargement ---
    // ---

    // ---
    // --- Fin domaine Chargement ---

}
