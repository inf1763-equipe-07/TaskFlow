package taskflow.controleur;

import taskflow.modele.TacheService;
import taskflow.vue.Console;
import taskflow.vue.VueCommune;

/**
 * Ce qui se passe au démarrage : le domaine Chargement y retrouve les tâches sauvegardées.
 */
public class DemarrageControleur {

    private final VueCommune vueCommune;

    // Le service et la console sont reçus pour le domaine Chargement, qui en aura besoin.
    public DemarrageControleur(TacheService service, Console console, VueCommune vueCommune) {
        this.vueCommune = vueCommune;
    }

    /**
     * Retourne vrai si l'application peut continuer, faux si elle doit s'arrêter
     * (par exemple parce que le fichier de données est illisible).
     */
    public boolean demarrer() {
        vueCommune.afficherBienvenue();
        return true;
    }
}
