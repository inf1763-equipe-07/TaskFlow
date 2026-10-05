package taskflow.controleur;

import taskflow.modele.TacheService;
import taskflow.vue.Console;
import taskflow.vue.VueCommune;

/**
 * Point d'entrée du domaine Consultation et modification : modifier la priorité d'une tâche.
 * Squelette du socle : le domaine le remplace.
 */
public class ModifierPrioriteAction implements ActionMenu {

    private final VueCommune vueCommune;

    // Les outils reçus sont ceux que le domaine pourra utiliser.
    public ModifierPrioriteAction(TacheService service, SelecteurTache selecteur, Console console,
            VueCommune vueCommune) {
        this.vueCommune = vueCommune;
    }

    @Override
    public String libelle() {
        return "Modifier la priorité d'une tâche";
    }

    @Override
    public void executer() {
        vueCommune.afficherPasEncoreDisponible();
    }
}
