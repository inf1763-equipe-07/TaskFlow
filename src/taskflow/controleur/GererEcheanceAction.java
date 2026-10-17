package taskflow.controleur;

import taskflow.modele.SaisieInvalideException;
import taskflow.modele.Tache;
import taskflow.modele.TacheService;
import taskflow.vue.EcheanceVue;

public class GererEcheanceAction {

    private final TacheService service;
    private final EcheanceVue vue;

    public GererEcheanceAction(TacheService service, EcheanceVue vue) {
        this.service = service;
        this.vue = vue;
    }

    public void gerer() {
        String texteIdentifiant = vue.demanderIdentifiant();

        final int id;
        try {
            id = Integer.parseInt(texteIdentifiant);
        } catch (NumberFormatException e) {
            vue.afficherErreur("l'identifiant doit contenir uniquement des chiffres.");
            return;
        }

        Tache tache = service.trouver(id).orElse(null);
        if (tache == null) {
            vue.afficherErreur("aucune tâche ne possède cet identifiant.");
            return;
        }

        String texteDate = vue.demanderDate();
        try {
            tache.definirEcheance(texteDate);
            vue.afficherSucces(tache);
        } catch (SaisieInvalideException e) {
            vue.afficherErreur(e.getMessage());
        }
    }
}