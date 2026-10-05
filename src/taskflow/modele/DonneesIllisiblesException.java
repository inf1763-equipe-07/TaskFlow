package taskflow.modele;

/**
 * Signale que le fichier de données existe, mais qu'on ne peut pas le lire ou qu'il est mal formé.
 */
public class DonneesIllisiblesException extends Exception {

    public DonneesIllisiblesException(String message) {
        super(message);
    }

    public DonneesIllisiblesException(String message, Throwable cause) {
        super(message, cause);
    }
}
