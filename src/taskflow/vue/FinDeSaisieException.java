package taskflow.vue;

/**
 * Lancée quand il n'y a plus rien à lire au clavier (par exemple Ctrl+D).
 * Le menu l'attrape pour fermer proprement l'application au lieu de tourner en boucle.
 */
public class FinDeSaisieException extends RuntimeException {

    public FinDeSaisieException() {
        super("fin de la saisie");
    }
}
