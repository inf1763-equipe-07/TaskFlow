package taskflow.controleur;

import taskflow.modele.TacheService;
import taskflow.vue.Console;
import taskflow.vue.VueCommune;

/**
 * Point d'entrée du domaine Échéance : attribuer, modifier ou retirer une échéance.
 * Squelette du socle : le domaine le remplace.
 */
public class GererEcheanceAction implements ActionMenu {

    private final VueCommune vueCommune;

    // Les outils reçus sont ceux que le domaine Échéance pourra utiliser.
    public GererEcheanceAction(TacheService service, SelecteurTache selecteur, Console console,
            VueCommune vueCommune) {
        this.vueCommune = vueCommune;
    }

    @Override
    public String libelle() {
        return "Gérer l'échéance d'une tâche";
    }

    @Override
    public void executer() {
        vueCommune.afficherPasEncoreDisponible();
    }
}
