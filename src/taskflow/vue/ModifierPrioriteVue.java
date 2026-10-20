package taskflow.vue;

import java.util.OptionalInt;

import taskflow.modele.Tache;

/** La vue du domaine Consultation pour modifier la priorité d'une tâche existante. */
public class ModifierPrioriteVue extends Vue {

    public ModifierPrioriteVue(Console console) {
        super(console);
    }

    /** Demande l'identifiant de la tâche à modifier. Vide si la saisie n'est pas un nombre. */
    public OptionalInt demanderId() {
        return lireEntier("Identifiant de la tâche : ");
    }

    public String demanderPriorite() {
        return lire("Nouvelle priorité (Basse/Normale/Élevée) : ");
    }

    public void afficherModifiee(Tache tache) {
        afficherSucces("Priorité de la tâche " + tache.id() + " changée pour " + tache.priorite().libelle() + ".");
    }

    public void afficherIdentifiantInvalide() {
        afficherErreur("l'identifiant doit être un nombre entier.");
    }

    public void afficherIdentifiantInconnu(int id) {
        afficherErreur("aucune tâche avec l'identifiant " + id + ".");
    }

    @Override
    public void afficherErreur(String message) {
        super.afficherErreur(message);
    }
}
