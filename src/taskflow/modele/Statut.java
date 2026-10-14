package taskflow.modele;

/**
 * Les deux statuts possibles d'une tâche.
 */
public enum Statut {
    A_FAIRE("À faire"),
    TERMINEE("Terminée");

    private final String libelle;

    Statut(String libelle) {
        this.libelle = libelle;
    }

    /** Le texte affiché à l'utilisateur, avec ses accents. */
    public String libelle() {
        return libelle;
    }
}
