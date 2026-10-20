package taskflow.controleur;

import java.util.Optional;
import java.util.OptionalInt;

import taskflow.modele.Priorite;
import taskflow.modele.SaisieInvalideException;
import taskflow.modele.Tache;
import taskflow.modele.TacheService;
import taskflow.vue.ModifierPrioriteVue;

/** Le contrôleur du domaine Consultation pour modifier la priorité d'une tâche existante. */
public class ModifierPrioriteControleur {

    private final TacheService service;
    private final ModifierPrioriteVue vue;

    public ModifierPrioriteControleur(TacheService service, ModifierPrioriteVue vue) {
        this.service = service;
        this.vue = vue;
    }

    public void modifier() {
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
        try {
            Priorite priorite = Priorite.depuisLibelle(vue.demanderPriorite());
            tache.changerPriorite(priorite);
            vue.afficherModifiee(tache);
        } catch (SaisieInvalideException e) {
            vue.afficherErreur(e.getMessage());
        }
    }
}
