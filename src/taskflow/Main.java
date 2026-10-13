package taskflow;

import java.nio.file;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import taskflow.controleur.MenuControleur;
import taskflow.controleur.MenuControleur.Entree;
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

            if (!repository.exists()){                 //Si un repo n'existe pas, un est creer
                repository.mkdir();
            }
            File sauvegarde = new File(repository+"/Sauvegarde.txt");
            
            int id_tache;

            if(sauvergarde.exists()){                                         //Verifie si un fichier de sauvegarde existe
                try (Scanner reader = new Scanner(sauvegarde)){
                    while (reader.hasNextLine()){
                        String contenu = reader.nextLine();
                        
                        if(contenu=="Echeance"){
                            String echeance = reader.readLine();              //Depend de la strucutre du fichier et du contenu necessaire
                        
                        }else if(contenu=="Priorite"){
                            String priorite = reader.readLine();
                        
                        }else if(contenu=="Titre"){
                            String titre = reader.readLine();                                   //US-09, id a regler apres le chargement du fichier
                        }else{
                            id_tache++;
                        }
                    }
                
                }catch(FileNotFoundException FNF){
                    System.out.println("Le fichier n'existe pas");
                
                }
            }else if(!sauvegarde.canRead()){                                                     //US-11
                
                System.out.println("Le fichier de sauvegarde est corrompue");
                System.out.println("Voulez-vous supprimer le fichier ? (Y/N)");                 //Demande a l'utilisateur ce qu'il veut faire le fichier corrompu
                Scanner reponse_corruption = new Scanner(System.in);
                String reponse = reponse_corruption.nextLine();
                
                if(reponse_corruption=="Y"){                                                     //Si oui, le fichier corrompu est supprime et un nouveau est cree
        
                    sauvegarde.delete();
                    
                    sauvegarde.createNewFile();
                    
                    System.out.println("Le fichier a ete supprimer et un nouveau a ete cree");
                
                }else{                                                                           //Si non, le fichier est laisse tel quel
                    System.out.println("Le fichier n'a pas ete supprime");
                }
            
            }else{                                                                              //US-10
                
                try{
                    
                    sauvegarde.createNewFile();
                    
                    System.out.println("Aucun fichier de sauvegarde trouve, un nouveau a ete cree");
                
                }catch(IOException IO){
                    System.out.println("Une erreur s'est produite");
                }
            }

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
