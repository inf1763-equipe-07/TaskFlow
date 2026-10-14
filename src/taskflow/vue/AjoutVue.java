
package taskflow.vue;

import taskflow.modele.Tache;

public class AjoutVue {

    private final Console console;

    public AjoutVue(Console console) {
        this.console = console;
    }

    public String demanderTitre() {
        console.afficherTitre("Ajouter une tâche");
        return console.lire("Titre : ");
    }

    public void afficherSucces(Tache tache) {
        console.afficherSucces("Tâche ajoutée avec succès.");
        console.afficher("Identifiant : " + tache.id());
        console.afficher("Titre : " + tache.titre());
        console.afficher("Priorité : " + tache.priorite().libelle());
        console.afficher("Échéance : Aucune");
        console.afficher("Statut : À faire");
    }

    public void afficherErreur(String message) {
        console.afficherErreur(message);
    }
}
