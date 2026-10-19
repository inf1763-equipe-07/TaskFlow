package taskflow.modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDate;

/**
 * Garde la liste des tâches et applique les règles qui les concernent.
 */
public class TacheService {

    private final TacheRepository repository;
    private final List<Tache> taches = new ArrayList<>();

    // L'identifiant que recevra la prochaine tâche créée.
    // Le domaine Ajout s'en sert ; remplacer() le recalcule (plus grand identifiant + 1).
    private int prochainId = 1;

    public TacheService(TacheRepository repository) {
        this.repository = repository;
    }

    /** Toutes les tâches, dans l'ordre où elles ont été créées. */
    public List<Tache> lister() {
        return List.copyOf(taches);
    }

    /** La tâche portant cet identifiant, ou rien si elle n'existe pas. */
    public Optional<Tache> trouver(int id) {
        for (Tache tache : taches) {
            if (tache.id() == id) {
                return Optional.of(tache);
            }
        }
        return Optional.empty();
    }


/**
 * Remplace toutes les tâches par la liste fournie, puis recalcule
 * l'identifiant de la prochaine tâche (le plus grand identifiant + 1).
 * La liste est validée avant de modifier les tâches existantes afin
 * de préserver leur contenu si la liste reçue est invalide.
 *
 * Cette méthode sert au chargement du fichier et au mode de démonstration.
 *
 * @param nouvelles liste des tâches qui remplacera la liste actuelle
 * @throws NullPointerException si la liste ou l'une de ses tâches est null
 */
    public void remplacer(List<Tache> nouvelles) {
        List<Tache> copie = List.copyOf(nouvelles);

        taches.clear();
        taches.addAll(copie);

        prochainId = taches.stream()
            .mapToInt(Tache::id)
            .max()
            .orElse(0) + 1;
    }


    /** Donne l'identifiant à utiliser pour une nouvelle tâche, puis avance le compteur. */
    private int prendreProchainId() {
        return prochainId++;
    }

    // --- Début domaine Ajout ---
    // ---
public Tache ajouter(String titre) throws SaisieInvalideException {

    if (titre == null || titre.isBlank()) {
        throw new SaisieInvalideException("le titre est obligatoire.");
    }

    Tache nouvelle = new Tache(
        prendreProchainId(),
        titre,
        Priorite.NORMALE,
        null,
        Statut.A_FAIRE
    );

    taches.add(nouvelle);

    return nouvelle;
}
    // ---
    // --- Fin domaine Ajout ---



    // --- Début domaine Sauvegarde ---
    // ---
    /** Confie toutes les tâches au repository, qui les écrit. Lance une IOException si l'écriture échoue. */
    public void sauvegarder() throws java.io.IOException {
        repository.sauvegarder(lister());
    }
    // ---
    // --- Fin domaine Sauvegarde ---



    // --- Début domaine Chargement ---
    // ---


    public static List<Tache> charger(Path sauvegarde) throws IOException {
    List<String> lignes = Files.readAllLines(sauvegarde, StandardCharsets.UTF_8);
    List<Tache> resultat = new ArrayList<>();

    for (int i = 0; i < lignes.size(); i++) {
        String ligne = lignes.get(i).trim();
        if (ligne.isEmpty()) continue;

        String[] champs = ligne.split(";", 5);
        if (champs.length < 5) {
            System.err.println("Ligne " + (i + 1) + " ignorée");
            continue;
        }
        try {
            int id = Integer.parseInt(champs[0].trim());
            Priorite priorite = Priorite.valueOf(champs[1].trim().toUpperCase());
            LocalDate echeance = champs[2].trim().isEmpty()
                    ? null
                    : LocalDate.parse(champs[2].trim());
            Statut statut = Statut.valueOf(champs[3].trim().toUpperCase());
            String titre = champs[4].trim();

            resultat.add(new Tache(id, titre, priorite, echeance, statut));
        } catch (Exception e) {
            System.err.println("Ligne " + (i + 1) + " ignorée (" + e.getMessage() + ")");
        }
        }
    return resultat;
    }

    public void chargement(Path sauvegarde) {
    try {
        remplacer(charger(sauvegarde));
    } catch (NoSuchFileException e) {
        System.out.println("Le fichier n'existe pas");
    } catch (IOException e) {
        System.out.println("Erreur de lecture : " + e.getMessage());
    }
    }



    public static Path newDir(Path dossier) throws IOException{
        return Files.createDirectories(dossier);
    }
    
    public void newFichier(File sauvegarde){
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
