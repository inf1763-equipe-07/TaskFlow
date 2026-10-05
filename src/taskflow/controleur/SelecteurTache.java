package taskflow.controleur;

import java.util.Optional;
import java.util.OptionalInt;

import taskflow.modele.Tache;
import taskflow.modele.TacheService;
import taskflow.vue.VueCommune;

/**
 * Demande un identifiant à l'utilisateur et retrouve la tâche correspondante.
 * Plusieurs domaines s'en servent : terminer une tâche, changer sa priorité, gérer son échéance.
 */
public class SelecteurTache {

    private final TacheService service;
    private final VueCommune vueCommune;

    public SelecteurTache(TacheService service, VueCommune vueCommune) {
        this.service = service;
        this.vueCommune = vueCommune;
    }

    /**
     * Retourne la tâche choisie. Si l'identifiant n'est pas un nombre ou ne correspond à aucune tâche,
     * le message d'erreur est déjà affiché et on retourne « rien ».
     */
    public Optional<Tache> selectionner() {
        OptionalInt saisie = vueCommune.lireIdentifiant();
        if (saisie.isEmpty()) {
            vueCommune.afficherIdentifiantInvalide();
            return Optional.empty();
        }
        Optional<Tache> tache = service.trouver(saisie.getAsInt());
        if (tache.isEmpty()) {
            vueCommune.afficherIdentifiantInconnu(saisie.getAsInt());
        }
        return tache;
    }
}
