
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
        // 1. Saisie et validation du titre
        String titre = vue.demanderTitre();

        while (true) {
            if ("0".equals(titre.trim())) {
                return;
            }

            try {
                service.validerTitre(titre);
                break;
            } catch (SaisieInvalideException e) {
                vue.afficherErreur(e.getMessage());
                titre = vue.demanderTitre();
            }
        }

        // 2. Saisie et validation de la priorité (US-02)
        String prioriteSaisie = vue.demanderPriorite();

        while (true) {
            if ("0".equals(prioriteSaisie.trim())) {
                return;
            }

            try {
                service.interpreterPriorite(prioriteSaisie);
                break;
            } catch (SaisieInvalideException e) {
                vue.afficherErreur(e.getMessage());
                prioriteSaisie = vue.demanderPriorite();
            }
        }

        // 3. Saisie et validation de l'échéance (US-03)
        String echeanceSaisie = vue.demanderEcheance();
        java.time.LocalDate echeance;

        while (true) {
            if ("0".equals(echeanceSaisie.trim())) {
                return;
            }

            try {
                echeance = service.interpreterEcheance(echeanceSaisie);
                break;
            } catch (SaisieInvalideException e) {
                vue.afficherErreur(e.getMessage());
                echeanceSaisie = vue.demanderEcheance();
            }
        }

        // 4. Création uniquement après validation
        try {
            Tache nouvelle = service.ajouter(titre, prioriteSaisie, echeance);
            vue.afficherSucces(nouvelle);
        } catch (SaisieInvalideException e) {
            vue.afficherErreur(e.getMessage());
        }
    }

}
