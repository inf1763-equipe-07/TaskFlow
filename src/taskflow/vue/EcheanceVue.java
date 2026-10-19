
package taskflow.vue;

import taskflow.modele.Tache;

public class EcheanceVue extends Vue {

    public EcheanceVue(Console console) {
        super(console);
    }

    @Override
    public void afficherErreur(String message) {
        super.afficherErreur(message);
    }

    public String demanderIdentifiant() {
        afficherTitre("Gérer une échéance");
        return lire("Identifiant de la tâche : ");
    }

    public String demanderAction() {
        afficher("Échéance actuelle : ");
        return lire(
                "1. Définir ou modifier l'échéance\n"
                + "2. Retirer l'échéance\n"
                + "0. Annuler\n"
                + "Votre action : ");
    }

    public String demanderDate() {
        return lire("Nouvelle échéance (AAAA-MM-JJ) : ");
    }

    public void afficherSucces(Tache tache) {
        super.afficherSucces("Échéance attribuée avec succès.");
        afficher("Tâche : " + tache.titre());
        afficher("Échéance : " + tache.echeance());
    }

    public void afficherRetraitSucces(Tache tache) {
        super.afficherSucces("Échéance retirée avec succès.");
        afficher("Tâche : " + tache.titre());
        afficher("Échéance : "
                + (tache.echeance() == null ? "Aucune" : tache.echeance()));
    }
}
