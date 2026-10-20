
package taskflow.controleur;

import taskflow.modele.Tache;
import taskflow.modele.TacheService;
import taskflow.modele.SaisieInvalideException;
import taskflow.vue.AjoutVue;
import taskflow.modele.Priorite;

public class AjoutControleur {

    private final TacheService service;
    private final AjoutVue vue;

    public AjoutControleur(TacheService service, AjoutVue vue) {
        this.service = service;
        this.vue = vue;
    }

    public void ajouter() {
        String titre = vue.demanderTitre();
        while (true) {
            try {
                service.validerTitre(titre);
                break;
            } catch (SaisieInvalideException e) {
                vue.afficherErreur(e.getMessage());
                titre = vue.demanderTitre();

                if ("0".equals(titre)) {
                    return;
                }
            }
        }
        String prioriteSaisie = vue.demanderPriorite();
        if (prioriteSaisie.trim().equals("0")) {
           return;
}
        try {
           Priorite priorite = null;

            while (priorite == null) {
                try {
                    priorite = service.interpreterPriorite(prioriteSaisie);
                } catch (SaisieInvalideException e) {
                    vue.afficherErreur(e.getMessage());
                    prioriteSaisie = vue.demanderPriorite();

                    if (prioriteSaisie.trim().equals("0")) {
                        return;
                    }
                }
            }
            Tache nouvelle = service.ajouter(titre, prioriteSaisie);
            vue.afficherSucces(nouvelle);
        } catch (SaisieInvalideException e) {
            vue.afficherErreur(e.getMessage());
        }
    }
}
