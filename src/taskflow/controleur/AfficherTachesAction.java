package taskflow.controleur;

import taskflow.modele.TacheService;
import taskflow.vue.Console;
import taskflow.vue.VueCommune;

/**
 * Point d'entrée du domaine Consultation et modification : afficher la liste.
 * Squelette du socle : le domaine le remplace.
 */
public class AfficherTachesAction implements ActionMenu {

    private final VueCommune vueCommune;

    // Les outils reçus sont ceux que le domaine pourra utiliser.
    public AfficherTachesAction(TacheService service, SelecteurTache selecteur, Console console,
            VueCommune vueCommune) {
        this.vueCommune = vueCommune;
    }

    @Override
    public String libelle() {
        return "Afficher les tâches";
    }

    @Override
    public void executer() {
        vueCommune.afficherPasEncoreDisponible();
    }
}
