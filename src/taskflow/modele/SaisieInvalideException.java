package taskflow.modele;

/**
 * Signale une saisie refusée : titre vide, priorité inconnue, date impossible…
 * Le message explique le problème à l'utilisateur.
 */
public class SaisieInvalideException extends Exception {

    public SaisieInvalideException(String message) {
        super(message);
    }
}
