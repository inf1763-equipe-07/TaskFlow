package taskflow.controleur;

import taskflow.modele.TacheService;
import taskflow.vue.AfficherVue;

/** Le contrôleur du domaine Consultation pour afficher la liste des tâches. */
public class AfficherControleur {

    private final TacheService service;
    private final AfficherVue vue;

    public AfficherControleur(TacheService service, AfficherVue vue) {
        this.service = service;
        this.vue = vue;
    }

    public void afficher() {
        vue.afficherListe(service.lister());
    }
}
