package taskflow;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import taskflow.modele.Tache;
import taskflow.persistance.DonneesIllisiblesException;
import taskflow.persistance.FichierTacheRepository;
import taskflow.service.TacheService;
import taskflow.vue.ConsoleUI;

/** Assemble le programme ; aucune règle métier ici. */
public final class Main {
    private Main() { }
    public static void main(String[] args) {
        Path chemin = Path.of(args.length == 0 ? "data/taches.txt" : args[0]);
        FichierTacheRepository depot = new FichierTacheRepository(chemin);
        System.out.println("TASKFLOW — Gestion des tâches\n");
        List<Tache> depart = new ArrayList<>();
        if (!depot.existe()) {
            System.out.println("Aucun fichier de données trouvé.");
            System.out.println("L'application démarre avec une liste vide.");
        } else {
            System.out.println("Chargement du fichier de données...");
            try {
                depart = depot.charger();
                System.out.println(depart.size() + " tâches chargées avec succès.");
            } catch (DonneesIllisiblesException | IOException e) {
                System.out.println("Erreur : le fichier de données est illisible ou mal formé.");
                System.out.println("Détail : " + e.getMessage());
                System.out.println("Démarrage interrompu. Le fichier n'a pas été modifié.");
                System.exit(1);
                return;
            }
        }
        try {
            TacheService service = new TacheService(depart);
            new ConsoleUI(service, depot, new Scanner(System.in, StandardCharsets.UTF_8)).executer();
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : le fichier de données contient des éléments invalides.");
            System.out.println("Démarrage interrompu. Le fichier n'a pas été modifié.");
            System.exit(1);
        }
    }
}
