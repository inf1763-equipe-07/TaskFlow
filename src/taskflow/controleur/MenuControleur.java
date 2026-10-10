package taskflow.controleur;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;

import taskflow.vue.Console;

/**
 * La boucle principale : afficher le menu, lire le choix, exécuter l'entrée choisie, recommencer.
 * Le choix 0 quitte. Le menu commence vide : chaque domaine ajoute ses entrées dans Main.
 */
public class MenuControleur {

    /** Une entrée du menu : le texte à afficher et le travail à exécuter quand on la choisit. */
    public record Entree(String libelle, Runnable action) {
    }

    private final Console console;
    private final List<Entree> entrees;

    public MenuControleur(Console console, List<Entree> entrees) {
        this.console = console;
        this.entrees = List.copyOf(entrees);
    }

    public void lancer() {
        try {
            boolean continuer = true;
            while (continuer) {
                afficherMenu();
                OptionalInt choix = console.lireEntier("Votre choix : ");
                if (choix.isEmpty() || choix.getAsInt() < 0 || choix.getAsInt() > entrees.size()) {
                    console.afficherErreur("choix invalide. Entrez un des numéros du menu.");
                } else if (choix.getAsInt() == 0) {
                    continuer = false;
                } else {
                    entrees.get(choix.getAsInt() - 1).action().run();
                }
            }
        } catch (NoSuchElementException e) {
            // Plus rien à lire au clavier : on ferme comme si l'utilisateur avait choisi 0.
        }
        console.afficher("");
        console.afficher("Fermeture de TaskFlow.");
        console.afficher("Au revoir !");
    }

    /** Affiche les entrées numérotées à partir de 1, puis « 0. Quitter ». */
    private void afficherMenu() {
        console.afficher("");
        for (int i = 0; i < entrees.size(); i++) {
            console.afficher((i + 1) + ". " + entrees.get(i).libelle());
        }
        console.afficher("0. Quitter");
        console.afficher("");
    }
}
