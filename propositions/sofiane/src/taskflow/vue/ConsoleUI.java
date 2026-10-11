package taskflow.vue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import taskflow.modele.Priorite;
import taskflow.modele.Tache;
import taskflow.persistance.FichierTacheRepository;
import taskflow.service.TacheService;
import taskflow.service.ValidateurDate;

/** Présentation et dialogue utilisateur. Une seule classe manipule le Scanner. */
public final class ConsoleUI {
    private final TacheService service;
    private final FichierTacheRepository fichier;
    private final Scanner entree;

    public ConsoleUI(TacheService service, FichierTacheRepository fichier, Scanner entree) {
        this.service = service;
        this.fichier = fichier;
        this.entree = entree;
    }

    public void executer() {
        try {
            while (true) {
                System.out.println("\n1. Ajouter une tâche");
                System.out.println("2. Afficher les tâches");
                System.out.println("3. Marquer une tâche comme terminée");
                System.out.println("4. Modifier la priorité d'une tâche");
                System.out.println("5. Gérer l'échéance d'une tâche");
                System.out.println("6. Sauvegarder les données");
                System.out.println("0. Quitter");
                switch (lire("\nVotre choix : ").trim()) {
                    case "1" -> ajouter();
                    case "2" -> afficher();
                    case "3" -> terminer();
                    case "4" -> priorite();
                    case "5" -> echeance();
                    case "6" -> sauvegarder();
                    case "0" -> { if (quitter()) return; }
                    default -> System.out.println("Erreur : choix invalide.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("\nFermeture de TaskFlow.\nAu revoir !");
        }
    }

    private String lire(String demande) {
        System.out.print(demande);
        System.out.flush();
        if (!entree.hasNextLine()) throw new NoSuchElementException("fin de saisie");
        return entree.nextLine();
    }

    /** La tâche n'est créée qu'une fois toutes les données valides. */
    private void ajouter() {
        System.out.println("\nAJOUTER UNE TÂCHE (tapez annuler pour revenir au menu)");
        String titre;
        while (true) {
            String s = lire("Titre : ");
            if (annule(s)) { annulation(); return; }
            try { titre = Tache.validerTitre(s); break; }
            catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
                System.out.println("Veuillez saisir un titre ou annuler l'ajout.");
            }
        }
        Priorite priorite;
        while (true) {
            String s = lire("Priorité (Basse, Normale, Élevée ; Entrée = Normale) : ");
            if (annule(s)) { annulation(); return; }
            if (s.isBlank()) { priorite = Priorite.NORMALE; break; }
            priorite = Priorite.analyser(s);
            if (priorite != null) break;
            System.out.println("Erreur : la priorité doit être Basse, Normale ou Élevée.");
        }
        LocalDate date;
        while (true) {
            String s = lire("Échéance AAAA-MM-JJ (Entrée = aucune) : ");
            if (annule(s)) { annulation(); return; }
            if (s.isBlank()) { date = null; break; }
            try { date = ValidateurDate.analyser(s); break; }
            catch (IllegalArgumentException e) { System.out.println("Erreur : " + e.getMessage()); }
        }
        Tache t = service.ajouter(titre, priorite, date);
        System.out.println("Tâche ajoutée avec succès.");
        System.out.println("Identifiant : " + t.id());
        System.out.println("Titre       : " + t.titre());
        System.out.println("Priorité    : " + t.priorite().libelle());
        System.out.println("Échéance    : " + t.echeanceAffichee());
        System.out.println("Statut      : " + t.statut().libelle());
    }

    private void afficher() {
        List<Tache> taches = service.lister();
        if (taches.isEmpty()) { System.out.println("Aucune tâche à afficher."); return; }
        System.out.println("\nLISTE DES TÂCHES");
        String fmt = "%-4s %-40s %-9s %-12s %s%n";
        System.out.printf(fmt, "ID", "Titre", "Priorité", "Échéance", "Statut");
        for (Tache t : taches) {
            String titre = t.titre().length() > 40 ? t.titre().substring(0, 39) + "…" : t.titre();
            System.out.printf(fmt, t.id(), titre, t.priorite().libelle(), t.echeanceAffichee(),
                    t.statut().libelle());
        }
        System.out.println("Nombre de tâches : " + taches.size());
    }

    private Integer saisirId() {
        String s = lire("Identifiant de la tâche : ");
        try { return Integer.valueOf(s.trim()); }
        catch (NumberFormatException e) {
            System.out.println("Erreur : identifiant invalide (entier attendu). Aucune donnée modifiée.");
            return null;
        }
    }

    private void terminer() {
        Integer id = saisirId(); if (id == null) return;
        try {
            Tache t = service.trouver(id);
            if (service.terminer(id))
                System.out.println("La tâche « " + t.titre() + " » est maintenant terminée.");
            else System.out.println("La tâche " + id + " est déjà terminée. Aucune modification nécessaire.");
        } catch (IllegalArgumentException e) { erreurId(e); }
    }

    private void priorite() {
        Integer id = saisirId(); if (id == null) return;
        try {
            Tache t = service.trouver(id);
            System.out.println("Priorité actuelle : " + t.priorite().libelle());
            Priorite nouvelle = Priorite.analyser(lire("Nouvelle priorité : "));
            if (nouvelle == null) {
                System.out.println("Erreur : la priorité doit être Basse, Normale ou Élevée.");
                System.out.println("La priorité actuelle est conservée.");
                return;
            }
            Priorite avant = service.changerPriorite(id, nouvelle);
            System.out.println("La priorité de la tâche " + id + " a été modifiée : "
                    + avant.libelle() + " → " + nouvelle.libelle() + ".");
        } catch (IllegalArgumentException e) { erreurId(e); }
    }

    private void echeance() {
        Integer id = saisirId(); if (id == null) return;
        try {
            Tache t = service.trouver(id);
            System.out.println("Échéance actuelle : " + t.echeanceAffichee());
            System.out.println("1. Définir ou modifier l'échéance\n2. Retirer l'échéance\n0. Annuler");
            switch (lire("Votre action : ").trim()) {
                case "1" -> {
                    String s = lire("Nouvelle échéance : ");
                    try {
                        LocalDate date = ValidateurDate.analyser(s);
                        service.changerEcheance(id, date);
                        System.out.println("L'échéance de la tâche " + id + " est maintenant : " + date + ".");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur : " + e.getMessage());
                        System.out.println("L'échéance actuelle est conservée.");
                    }
                }
                case "2" -> {
                    service.changerEcheance(id, null);
                    System.out.println("L'échéance de la tâche " + id + " a été retirée.");
                }
                case "0" -> System.out.println("Aucune modification.");
                default -> System.out.println("Erreur : action invalide. Aucune modification.");
            }
        } catch (IllegalArgumentException e) { erreurId(e); }
    }

    private void sauvegarder() {
        try {
            fichier.sauvegarder(service.lister());
            service.confirmerSauvegarde();
            System.out.println("Sauvegarde réussie : " + service.taille() + " tâches enregistrées.");
        } catch (IOException e) {
            System.out.println("Erreur : impossible d'écrire dans le fichier de données.");
            System.out.println("Les modifications n'ont pas été sauvegardées.");
        }
    }

    private boolean quitter() {
        if (service.modificationsNonSauvegardees()) {
            String s = lire("Modifications non sauvegardées. Quitter quand même ? (o/n) : ");
            if (!s.trim().equalsIgnoreCase("o")) {
                System.out.println("Retour au menu.");
                return false;
            }
        }
        System.out.println("Fermeture de TaskFlow.\nAu revoir !");
        return true;
    }

    private void erreurId(IllegalArgumentException e) {
        System.out.println("Erreur : " + e.getMessage());
        System.out.println("Aucune donnée n'a été modifiée.");
    }
    private static boolean annule(String s) { return s.trim().equalsIgnoreCase("annuler"); }
    private static void annulation() { System.out.println("Ajout annulé. Aucune tâche n'a été créée."); }
}
