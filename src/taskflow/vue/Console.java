package taskflow.vue;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * La seule classe de l'application qui touche au clavier (System.in) et à l'écran (System.out).
 * Tout est lu et écrit en UTF-8, pour que les accents soient corrects.
 */
public class Console {

    private final Scanner clavier = new Scanner(System.in, StandardCharsets.UTF_8);
    private final PrintStream ecran = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    /**
     * Affiche l'invite puis lit une ligne.
     * Si on appuie seulement sur Entrée, on obtient un texte vide.
     * Lance une NoSuchElementException quand il n'y a plus rien à lire (par exemple Ctrl+D) :
     * le menu l'attrape pour fermer proprement l'application.
     */
    public String lire(String invite) {
        ecran.print(invite);
        ecran.flush(); // l'invite n'a pas de saut de ligne : on force son affichage avant la lecture
        if (!clavier.hasNextLine()) {
            throw new NoSuchElementException("fin de la saisie");
        }
        return clavier.nextLine();
    }

    /** Lit un nombre entier, ou rien du tout si ce que l'utilisateur a tapé n'en est pas un. */
    public OptionalInt lireEntier(String invite) {
        String texte = lire(invite).trim();
        try {
            return OptionalInt.of(Integer.parseInt(texte));
        } catch (NumberFormatException e) {
            return OptionalInt.empty();
        }
    }

    public void afficher(String texte) {
        ecran.println(texte);
    }

    public void afficherErreur(String message) {
        afficher("Erreur : " + message);
    }

    public void afficherSucces(String message) {
        afficher(message);
    }

    /** Affiche un titre en majuscules, avec une ligne vide avant et après. */
    public void afficherTitre(String titre) {
        afficher("");
        afficher(titre.toUpperCase(Locale.ROOT));
        afficher("");
    }
}
