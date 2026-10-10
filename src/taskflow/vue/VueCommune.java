package taskflow.vue;

import java.util.List;
import java.util.OptionalInt;

/**
 * Les affichages et les saisies que tous les domaines partagent : le menu, les choix invalides,
 * les identifiants inconnus, la fermeture.
 */
public class VueCommune {

    private final Console console;

    public VueCommune(Console console) {
        this.console = console;
    }

    public void afficherBienvenue() {
        console.afficher("TASKFLOW — Gestion des tâches");
    }

    /** Affiche les entrées numérotées à partir de 1, puis « 0. Quitter ». */
    public void afficherMenu(List<String> libelles) {
        console.afficher("");
        for (int i = 0; i < libelles.size(); i++) {
            console.afficher((i + 1) + ". " + libelles.get(i));
        }
        console.afficher("0. Quitter");
        console.afficher("");
    }

    /** Lit le choix de l'utilisateur dans le menu, ou rien si ce n'est pas un nombre. */
    public OptionalInt lireChoixMenu() {
        return console.lireEntier("Votre choix : ");
    }

    public void afficherChoixInvalide() {
        console.afficherErreur("choix invalide. Entrez un des numéros du menu.");
    }

    /** Message provisoire des fonctionnalités que les domaines n'ont pas encore écrites. */
    public void afficherPasEncoreDisponible() {
        console.afficher("Pas encore disponible.");
    }

    public void afficherFermeture() {
        console.afficher("");
        console.afficher("Fermeture de TaskFlow.");
        console.afficher("Au revoir !");
    }
}
