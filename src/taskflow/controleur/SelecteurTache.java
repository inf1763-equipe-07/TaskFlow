package taskflow.controleur;

import java.util.Optional;
import java.util.OptionalInt;

import taskflow.modele.Tache;
import taskflow.modele.TacheService;
import taskflow.vue.Console;

/**
 * Demande un identifiant à l'utilisateur et retrouve la tâche correspondante.
 * Plusieurs domaines s'en servent : terminer une tâche, changer sa priorité, gérer son échéance.
 */
public class SelecteurTache {

    private final TacheService service;
    private final Console console;

    public SelecteurTache(TacheService service, Console console) {
        this.service = service;
        this.console = console;
    }

    /**
     * Retourne la tâche choisie. Si l'identifiant n'est pas un nombre ou ne correspond à aucune tâche,
     * le message d'erreur est déjà affiché et on retourne « rien ».
     */
    public Optional<Tache> selectionner() {
        OptionalInt saisie = console.lireEntier("Identifiant de la tâche : ");
        if (saisie.isEmpty()) {
            console.afficherErreur("l'identifiant doit être un nombre entier.");
            return Optional.empty();
        }
        Optional<Tache> tache = service.trouver(saisie.getAsInt());
        if (tache.isEmpty()) {
            console.afficherErreur("aucune tâche ne correspond à l'identifiant " + saisie.getAsInt() + ".");
            console.afficher("Aucune donnée n'a été modifiée.");
        }
        return tache;
    }
}
