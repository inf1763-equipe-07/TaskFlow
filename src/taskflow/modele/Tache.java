package taskflow.modele;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Une tâche. Elle ne peut pas exister avec un identifiant ou un titre invalide.
 */
public class Tache {

    // L'identifiant et le titre ne changent jamais après la création.
    private final int id;
    private final String titre;
    private Priorite priorite;
    private LocalDate echeance; // null veut dire « aucune échéance »
    private Statut statut;

    public Tache(int id, String titre, Priorite priorite, LocalDate echeance, Statut statut)
            throws SaisieInvalideException {
        if (id <= 0) {
            throw new SaisieInvalideException("l'identifiant doit être un entier positif.");
        }
        if (titre == null || titre.isBlank()) {
            throw new SaisieInvalideException("le titre est obligatoire.");
        }
        this.id = id;
        this.titre = titre.trim();
        this.priorite = Objects.requireNonNull(priorite, "priorite");
        this.echeance = echeance;
        this.statut = Objects.requireNonNull(statut, "statut");
    }

    public int id() {
        return id;
    }

    public String titre() {
        return titre;
    }

    public Priorite priorite() {
        return priorite;
    }

    /** L'échéance, ou null si la tâche n'en a pas. */
    public LocalDate echeance() {
        return echeance;
    }

    public Statut statut() {
        return statut;
    }

    // --- Début domaine Consultation et modification ---

    /** Marque la tâche comme terminée. Les autres informations ne changent pas. */
    public void terminer() {
        this.statut = Statut.TERMINEE;
    }

    // --- Fin domaine Consultation et modification ---



    // --- Début domaine Échéance ---
    // ---

    // ---
    // --- Fin domaine Échéance ---
    
}
