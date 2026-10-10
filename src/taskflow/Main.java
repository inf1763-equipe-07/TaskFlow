package taskflow;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import taskflow.controleur.DemarrageControleur;
import taskflow.controleur.MenuControleur;
import taskflow.controleur.MenuControleur.Entree;
import taskflow.controleur.SelecteurTache;
import taskflow.modele.TacheRepository;
import taskflow.modele.TacheService;
import taskflow.persistance.FichierTacheRepository;
import taskflow.vue.Console;
import taskflow.vue.VueCommune;

/**
 * Le point d'entrée : crée les objets de l'application, les relie entre eux, puis lance le menu.
 * Il ne contient aucune règle. Chaque domaine y ajoute seulement ses entrées de menu, dans sa zone.
 */
public class Main {

    public static void main(String[] args) {
        // Les objets partagés
        TacheRepository repository = new FichierTacheRepository(Path.of("data/taches.txt"));
        TacheService service = new TacheService(repository);
        Console console = new Console();
        VueCommune vueCommune = new VueCommune(console);
        // Outil partagé : demande un identifiant et retrouve la tâche. Les domaines qui en ont besoin le reçoivent.
        SelecteurTache selecteur = new SelecteurTache(service, console);

        DemarrageControleur demarrage = new DemarrageControleur(service, console, vueCommune);
        if (!demarrage.demarrer()) {
            System.exit(1); // le code 1 signale que l'application s'est arrêtée sur une erreur
        }

        // Les entrées du menu, dans l'ordre des zones ci-dessous.
        // Un domaine y ajoute son contrôleur et son entrée, par exemple :
        //     AjoutControleur ajout = new AjoutControleur(service, new AjoutVue(console));
        //     entrees.add(new Entree("Ajouter une tâche", ajout::ajouter));
        List<Entree> entrees = new ArrayList<>();

        // --- Début domaine Ajout ---
        // ---

        // ---
        // --- Fin domaine Ajout ---



        // --- Début domaine Consultation et modification ---
        // ---

        // ---
        // --- Fin domaine Consultation et modification ---



        // --- Début domaine Échéance ---
        // ---

        // ---
        // --- Fin domaine Échéance ---



        // --- Début domaine Sauvegarde ---
        // ---

        // ---
        // --- Fin domaine Sauvegarde ---

        new MenuControleur(console, entrees).lancer();
    }
}
