package taskflow.controleur;

import java.io.IOException;

import taskflow.modele.TacheService;
import taskflow.vue.SauvegardeVue;

/** Le contrôleur du domaine Sauvegarde : lance la sauvegarde et en annonce le résultat. */
public class SauvegarderAction {

    private final TacheService service;
    private final SauvegardeVue vue;

    public SauvegarderAction(TacheService service, SauvegardeVue vue) {
        this.service = service;
        this.vue = vue;
    }

    public void sauvegarder() {
        try {
            service.sauvegarder();
            // Atteint seulement si l'écriture s'est terminée sans exception.
            vue.afficherReussite();
        } catch (IOException e) {
            vue.afficherEchec(e.getMessage());
        }
    }
}
