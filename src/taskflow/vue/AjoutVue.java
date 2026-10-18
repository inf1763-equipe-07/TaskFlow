
package taskflow.vue;

import taskflow.modele.Tache;

public class AjoutVue extends Vue {

    public AjoutVue(Console console) {
        super(console);
    }

    public String demanderTitre() {
        afficherTitre("Ajouter une tâche");
        return lire("Titre : ");
    }
    public String demanderEcheance() {
        return lire("Échéance (AAAA-MM-JJ, Entrée = aucune, 0 = Annuler) : ");
    }
    public void afficherSucces(Tache tache) {
        super.afficherSucces("Tâche ajoutée avec succès.");
        afficher("Identifiant : " + tache.id());
        afficher("Titre : " + tache.titre());
        afficher("Priorité : " + tache.priorite().libelle());
        afficher("Échéance : " +
           (tache.echeance() == null ? "Aucune" : tache.echeance()));;
        afficher("Statut : À faire");
    }
    @Override
    public void afficherErreur(String message) {
        super.afficherErreur(message);
    }
}
