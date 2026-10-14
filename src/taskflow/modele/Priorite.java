package taskflow.modele;

/**
 * Les trois priorités possibles d'une tâche.
 */
public enum Priorite {
    BASSE("Basse"),
    NORMALE("Normale"),
    ELEVEE("Élevée");

    private final String libelle;

    Priorite(String libelle) {
        this.libelle = libelle;
    }

    /** Le texte affiché à l'utilisateur, avec ses accents. */
    public String libelle() {
        return libelle;
    }

    /**
     * Retrouve une priorité à partir d'un texte saisi.
     * On accepte « Élevée » comme « elevee » ou « ELEVEE » : majuscules et accents ne comptent pas.
     */
    public static Priorite depuisLibelle(String texte) throws SaisieInvalideException {
        if (texte != null) {
            String saisie = texte.trim();
            for (Priorite priorite : values()) {
                if (priorite.libelle.equalsIgnoreCase(saisie) || priorite.name().equalsIgnoreCase(saisie)) {
                    return priorite;
                }
            }
        }
        throw new SaisieInvalideException("la priorité doit être Basse, Normale ou Élevée.");
    }
}
