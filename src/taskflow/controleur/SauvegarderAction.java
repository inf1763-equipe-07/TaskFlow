package taskflow.controleur;

import taskflow.modele.TacheService;
import taskflow.vue.Console;
import taskflow.vue.VueCommune;

/**
 * Point d'entrée du domaine Sauvegarde. Squelette du socle : le domaine le remplace.
 */
public class SauvegarderAction implements ActionMenu {

    private final VueCommune vueCommune;

    // Les outils reçus sont ceux que le domaine Sauvegarde pourra utiliser.
    public SauvegarderAction(TacheService service, SelecteurTache selecteur, Console console,
            VueCommune vueCommune) {
        this.vueCommune = vueCommune;
    }

    @Override
    public String libelle() {
        return "Sauvegarder les données";
    }

    @Override
    public void executer() {
        vueCommune.afficherPasEncoreDisponible();
    }
}
