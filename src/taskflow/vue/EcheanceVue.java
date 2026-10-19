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

    public String demanderDate() {
        return lire("Nouvelle échéance (AAAA-MM-JJ) : ");
    }

    public void afficherSucces(Tache tache) {
        super.afficherSucces("Échéance attribuée avec succès.");
        afficher("Tâche : " + tache.titre());
        afficher("Échéance : " + tache.echeance());
    }
}