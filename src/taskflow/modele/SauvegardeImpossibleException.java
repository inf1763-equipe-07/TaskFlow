package taskflow.modele;

/**
 * Signale que la sauvegarde a échoué : on ne doit alors jamais annoncer une réussite.
 */
public class SauvegardeImpossibleException extends Exception {

    public SauvegardeImpossibleException(String message) {
        super(message);
    }

    public SauvegardeImpossibleException(String message, Throwable cause) {
        super(message, cause);
    }
}
