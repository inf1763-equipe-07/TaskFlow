package taskflow.persistance;

/** Échec contrôlé du chargement : le fichier d'origine reste intact. */
public final class DonneesIllisiblesException extends Exception {
    private static final long serialVersionUID = 1L;
    public DonneesIllisiblesException(String message) { super(message); }
    public DonneesIllisiblesException(String message, Throwable cause) { super(message, cause); }
}
