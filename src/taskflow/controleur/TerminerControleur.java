package taskflow.controleur;

import java.util.Optional;
import java.util.OptionalInt;

import taskflow.modele.Statut;
import taskflow.modele.Tache;
import taskflow.modele.TacheService;
import taskflow.vue.TerminerVue;

/** Le contrôleur du domaine Consultation pour marquer une tâche comme terminée. */
public class TerminerControleur {

    private final TacheService service;
    private final TerminerVue vue;

    public TerminerControleur(TacheService service, TerminerVue vue) {
        this.service = service;
        this.vue = vue;
    }

    public void terminer() {
        OptionalInt saisie = vue.demanderId();
        if (saisie.isEmpty()) {
            vue.afficherIdentifiantInvalide();
            return;
        }

        int id = saisie.getAsInt();
        Optional<Tache> trouvee = service.trouver(id);
        if (trouvee.isEmpty()) {
            vue.afficherIdentifiantInconnu(id);
            return;
        }

        Tache tache = trouvee.get();
        if (tache.statut() == Statut.TERMINEE) {
            vue.afficherDejaTerminee(id);
            return;
        }

        tache.terminer();
        vue.afficherTerminee(tache);
    }
}
