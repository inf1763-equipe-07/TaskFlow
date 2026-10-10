package taskflow.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;

import taskflow.vue.VueCommune;

/**
 * La boucle principale : afficher le menu, lire le choix, exécuter l'action choisie, recommencer.
 * Le choix 0 quitte.
 */
public class MenuControleur {

    private final VueCommune vueCommune;
    private final List<ActionMenu> actions;

    public MenuControleur(VueCommune vueCommune, List<ActionMenu> actions) {
        this.vueCommune = vueCommune;
        this.actions = List.copyOf(actions);
    }

    public void lancer() {
        try {
            boolean continuer = true;
            while (continuer) {
                vueCommune.afficherMenu(libellesDesActions());
                OptionalInt choix = vueCommune.lireChoixMenu();
                if (choix.isEmpty() || choix.getAsInt() < 0 || choix.getAsInt() > actions.size()) {
                    vueCommune.afficherChoixInvalide();
                } else if (choix.getAsInt() == 0) {
                    continuer = false;
                } else {
                    actions.get(choix.getAsInt() - 1).executer();
                }
            }
        } catch (NoSuchElementException e) {
            // Plus rien à lire au clavier : on ferme comme si l'utilisateur avait choisi 0.
        }
        vueCommune.afficherFermeture();
    }

    private List<String> libellesDesActions() {
        List<String> libelles = new ArrayList<>();
        for (ActionMenu action : actions) {
            libelles.add(action.libelle());
        }
        return libelles;
    }
}
