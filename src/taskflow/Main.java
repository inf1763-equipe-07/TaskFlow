package taskflow;

import java.nio.file.Path;
import java.util.List;

import taskflow.controleur.AfficherTachesAction;
import taskflow.controleur.ActionMenu;
import taskflow.controleur.AjouterTacheAction;
import taskflow.controleur.DemarrageControleur;
import taskflow.controleur.GererEcheanceAction;
import taskflow.controleur.MenuControleur;
import taskflow.controleur.ModifierPrioriteAction;
import taskflow.controleur.SauvegarderAction;
import taskflow.controleur.SelecteurTache;
import taskflow.controleur.TerminerTacheAction;
import taskflow.modele.TacheRepository;
import taskflow.modele.TacheService;
import taskflow.persistance.FichierTacheRepository;
import taskflow.vue.Console;
import taskflow.vue.VueCommune;

/**
 * Le point d'entrée : crée les objets de l'application, les relie entre eux, puis lance le menu.
 * Il ne contient aucune règle et ne change plus après le socle.
 */
public class Main {

    public static void main(String[] args) {
        // Les objets partagés
        TacheRepository repository = new FichierTacheRepository(Path.of("data/taches.txt"));
        TacheService service = new TacheService(repository);
        Console console = new Console();
        VueCommune vueCommune = new VueCommune(console);
        SelecteurTache selecteur = new SelecteurTache(service, console);

        DemarrageControleur demarrage = new DemarrageControleur(service, console, vueCommune);

        // Les entrées du menu, dans l'ordre où elles s'affichent
        List<ActionMenu> actions = List.of(
                new AjouterTacheAction(service, selecteur, console, vueCommune),
                new AfficherTachesAction(service, selecteur, console, vueCommune),
                new TerminerTacheAction(service, selecteur, console, vueCommune),
                new ModifierPrioriteAction(service, selecteur, console, vueCommune),
                new GererEcheanceAction(service, selecteur, console, vueCommune),
                new SauvegarderAction(service, selecteur, console, vueCommune));

        if (!demarrage.demarrer()) {
            System.exit(1); // le code 1 signale que l'application s'est arrêtée sur une erreur
        }

        new MenuControleur(vueCommune, actions).lancer();
    }
}
