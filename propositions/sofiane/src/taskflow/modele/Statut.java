package taskflow.modele;

public enum Statut {
    A_FAIRE("À faire"), TERMINEE("Terminée");
    private final String libelle;
    Statut(String libelle) { this.libelle = libelle; }
    public String libelle() { return libelle; }
}
