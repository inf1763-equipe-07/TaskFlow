
package taskflow.controleur;

import taskflow.modele.Tache;
import taskflow.modele.TacheService;
import taskflow.modele.SaisieInvalideException;
import taskflow.vue.AjoutVue;

public class AjoutControleur {

    private final TacheService service;
    private final AjoutVue vue;

    public AjoutControleur(TacheService service, AjoutVue vue) {
        this.service = service;
        this.vue = vue;
    }

    public void ajouter() {
        String titre = vue.demanderTitre();

        try {
            Tache nouvelle = service.ajouter(titre);
            vue.afficherSucces(nouvelle);
        } catch (SaisieInvalideException e) {
            vue.afficherErreur(e.getMessage());
        }
    }
}
