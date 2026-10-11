package taskflow.modele;

import java.time.LocalDate;
import java.util.Objects;

/** Objet métier : valide dès sa construction, identifiant et titre immuables. */
public final class Tache {
    private final int id;
    private final String titre;
    private Priorite priorite;
    private LocalDate echeance; // null = pas d'échéance
    private Statut statut;

    public Tache(int id, String titre, Priorite priorite, LocalDate echeance, Statut statut) {
        if (id <= 0) throw new IllegalArgumentException("l'identifiant doit être positif.");
        this.id = id;
        this.titre = validerTitre(titre);
        this.priorite = Objects.requireNonNull(priorite, "priorité obligatoire");
        this.echeance = echeance;
        this.statut = Objects.requireNonNull(statut, "statut obligatoire");
    }

    /** '|' est réservé au format de sauvegarde. */
    public static String validerTitre(String valeur) {
        if (valeur == null || valeur.isBlank())
            throw new IllegalArgumentException("le titre est obligatoire.");
        if (valeur.indexOf('|') >= 0)
            throw new IllegalArgumentException("le titre ne peut pas contenir '|'.");
        return valeur.trim();
    }

    public int id() { return id; }
    public String titre() { return titre; }
    public Priorite priorite() { return priorite; }
    public LocalDate echeance() { return echeance; }
    public Statut statut() { return statut; }
    public String echeanceAffichee() { return echeance == null ? "Aucune" : echeance.toString(); }

    public void changerPriorite(Priorite nouvelle) {
        priorite = Objects.requireNonNull(nouvelle, "priorité obligatoire");
    }
    public void changerEcheance(LocalDate nouvelle) { echeance = nouvelle; }
    public boolean terminer() {
        if (statut == Statut.TERMINEE) return false;
        statut = Statut.TERMINEE;
        return true;
    }
}
