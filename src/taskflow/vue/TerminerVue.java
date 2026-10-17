package taskflow.vue;

import java.util.OptionalInt;

import taskflow.modele.Tache;

/** La vue du domaine Consultation pour marquer une tâche comme terminée. */
public class TerminerVue extends Vue {

    public TerminerVue(Console console) {
        super(console);
    }

    /** Demande l'identifiant de la tâche à terminer. Vide si la saisie n'est pas un nombre. */
    public OptionalInt demanderId() {
        return lireEntier("Identifiant de la tâche à terminer : ");
    }

    public void afficherTerminee(Tache tache) {
        afficherSucces("Tâche " + tache.id() + " marquée comme terminée.");
    }

    public void afficherDejaTerminee(int id) {
        afficher("La tâche " + id + " est déjà terminée.");
    }

    public void afficherIdentifiantInvalide() {
        afficherErreur("l'identifiant doit être un nombre entier.");
    }

    public void afficherIdentifiantInconnu(int id) {
        afficherErreur("aucune tâche avec l'identifiant " + id + ".");
    }
}
