package taskflow.controleur;

import taskflow.modele.TacheService;
import taskflow.vue.Console;
import taskflow.vue.VueCommune;

/**
 * Point d'entrée du domaine Ajout. Squelette du socle : le domaine le remplace.
 */
public class AjouterTacheAction implements ActionMenu {

    private final VueCommune vueCommune;

    // Les outils reçus sont ceux que le domaine Ajout pourra utiliser.
    public AjouterTacheAction(TacheService service, SelecteurTache selecteur, Console console,
            VueCommune vueCommune) {
        this.vueCommune = vueCommune;
    }

    @Override
    public String libelle() {
        return "Ajouter une tâche";
    }

    @Override
    public void executer() {
        vueCommune.afficherPasEncoreDisponible();
    }
}
