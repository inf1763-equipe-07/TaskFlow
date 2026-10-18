
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
        String prioriteSaisie = vue.demanderPriorite();
        if (prioriteSaisie.trim().equals("0")) {
           return;
}
        try {
           Priorite priorite = null;

            while (priorite == null) {
                try {
                    priorite = prioriteSaisie.isBlank()
                            ? Priorite.NORMALE
                            : Priorite.depuisLibelle(prioriteSaisie);
                } catch (SaisieInvalideException e) {
                    vue.afficherErreur(e.getMessage());
                    prioriteSaisie = vue.demanderPriorite();

                    if (prioriteSaisie.trim().equals("0")) {
                        return;
                    }
                }
            }
            Tache nouvelle = service.ajouter(titre, priorite);
            vue.afficherSucces(nouvelle);
        } catch (SaisieInvalideException e) {
            vue.afficherErreur(e.getMessage());
        }
    }
}
