package taskflow;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import taskflow.controleur.MenuControleur;
import taskflow.controleur.MenuControleur.Entree;
import taskflow.controleur.SelecteurTache;
import taskflow.modele.Priorite;
import taskflow.modele.SaisieInvalideException;
import taskflow.modele.Statut;
import taskflow.modele.Tache;
import taskflow.modele.TacheRepository;
import taskflow.modele.TacheService;
import taskflow.persistance.FichierTacheRepository;
import taskflow.vue.Console;

/**
 * Le point d'entrée : crée les objets de l'application, les relie entre eux, puis lance le menu.
 * Il ne contient aucune règle. Chaque domaine y ajoute seulement ses entrées de menu, dans sa zone.
 */
public class Main {

    public static void main(String[] args) {
        // Les objets partagés
        TacheRepository repository = new FichierTacheRepository(cheminDesDonnees(args));
        TacheService service = new TacheService(repository);
        Console console = new Console();
        // Outil partagé : demande un identifiant et retrouve la tâche. Les domaines qui en ont besoin le reçoivent.
        SelecteurTache selecteur = new SelecteurTache(service, console);

        console.afficher("TASKFLOW — Gestion des tâches");

        // Avec --demo, on part de deux tâches de test au lieu du fichier de données :
        // chaque domaine peut ainsi essayer son travail sans attendre celui des autres.
        if (List.of(args).contains("--demo")) {
            service.remplacer(tachesDeDemonstration());
            console.afficher("Mode démonstration : 2 tâches de test chargées.");
        } else {
            // Au démarrage, le domaine Chargement retrouve les tâches sauvegardées. Si le fichier est
            // illisible, il affiche l'erreur puis arrête l'application avec System.exit(1)
            // (le code 1 signale une erreur).

            // --- Début domaine Chargement ---
            // ---

            // ---
            // --- Fin domaine Chargement ---
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

    /**
     * Le fichier de données : data/taches.txt, ou le chemin donné en argument
     * (par exemple donnees-test/exemple.txt pour essayer avec le fichier d'exemple).
     */
    private static Path cheminDesDonnees(String[] args) {
        for (String argument : args) {
            if (!argument.equals("--demo")) {
                return Path.of(argument);
            }
        }
        return Path.of("data/taches.txt");
    }

    /** Les deux tâches de l'exemple de l'énoncé, les mêmes que dans donnees-test/exemple.txt. */
    private static List<Tache> tachesDeDemonstration() {
        try {
            return List.of(
                    new Tache(1, "Vérifier la sauvegarde du serveur", Priorite.ELEVEE,
                            LocalDate.of(2026, 10, 5), Statut.TERMINEE),
                    new Tache(2, "Mettre à jour le guide utilisateur", Priorite.NORMALE, null, Statut.A_FAIRE));
        } catch (SaisieInvalideException e) {
            throw new IllegalStateException("Les tâches de démonstration doivent être valides.", e);
        }
    }
}
