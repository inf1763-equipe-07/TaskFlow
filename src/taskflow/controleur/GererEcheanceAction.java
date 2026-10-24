
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
            if (id <= 0) {
                vue.afficherErreur(
                        "l'identifiant doit être un entier positif.");
                return;
            }
        } catch (NumberFormatException e) {
            vue.afficherErreur(
                    "l'identifiant doit contenir uniquement un nombre valide.");
            return;
        }

        Tache tache = service.trouver(id).orElse(null);

        if (tache == null) {
            vue.afficherErreur(
                    "aucune tâche ne possède cet identifiant.");
            return;
        }

        String action = vue.demanderAction(tache);

        switch (action) {
            case "1":
                String texteDate = vue.demanderDate();

                try {
                    tache.definirEcheance(texteDate);
                    vue.afficherSucces(tache);
                } catch (SaisieInvalideException e) {
                    vue.afficherErreur(e.getMessage());
                }
                break;

            case "2":
                tache.retirerEcheance();
                vue.afficherRetraitSucces(tache);
                break;

            case "0":
                // Annulation : aucune modification.
                break;

            default:
                vue.afficherErreur(
                        "choix invalide. Sélectionnez 1, 2 ou 0.");
                break;
        }
    }
}
