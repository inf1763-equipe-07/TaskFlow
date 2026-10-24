package taskflow.persistance;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import taskflow.modele.Tache;
import taskflow.modele.TacheRepository;

/**
 * Stocke les tâches dans un fichier texte.
 * Squelette du socle : rien n'est encore lu ni écrit, les domaines Sauvegarde et Chargement le complètent.
 */
public class FichierTacheRepository implements TacheRepository {

    // L'emplacement du fichier de données. Les domaines Sauvegarde et Chargement s'en servent.
    private final Path chemin;

    public FichierTacheRepository(Path chemin) {
        this.chemin = chemin;
    }

    // --- Début domaine Sauvegarde ---
    // ---
    @Override
    public void sauvegarder(List<Tache> taches) throws IOException {
        StringBuilder texte = new StringBuilder();
        for (Tache tache : taches) {
            texte.append(versLigne(tache)).append('\n');
        }
        try {
            // Le chemin absolu a toujours un dossier parent, même pour un simple « Sauvegarde.txt ».
            java.nio.file.Files.createDirectories(chemin.toAbsolutePath().getParent());
            // Crée le fichier ou remplace tout son contenu, en UTF-8 pour garder les accents.
            java.nio.file.Files.writeString(chemin, texte, java.nio.charset.StandardCharsets.UTF_8);
        } catch (java.nio.file.AccessDeniedException e) {
            throw new IOException("accès refusé à « " + e.getFile() + " »", e);
        } catch (java.nio.file.FileAlreadyExistsException e) {
            throw new IOException("« " + e.getFile() + " » est un fichier et non un dossier", e);
        } catch (IOException e) {
            throw new IOException("le fichier « " + chemin + " » n'a pas pu être écrit", e);
        }
    }

    /** Transforme une tâche en une ligne id;priorite;echeance;statut;titre, comme dans le README. */
    private static String versLigne(Tache tache) {
        // Sans échéance, le champ reste vide : le chargement le lira comme « aucune échéance ».
        String echeance = tache.echeance() == null ? "" : tache.echeance().toString();
        // Le titre est en dernier : lu avec split(";", 5), il peut contenir des « ; ».
        return String.join(";", String.valueOf(tache.id()), tache.priorite().name(), echeance,
                tache.statut().name(), tache.titre());
    }
    // ---
    // --- Fin domaine Sauvegarde ---



    // --- Début domaine Chargement ---
    // ---
    @Override
    public boolean existe() {
        return false;
    }

    @Override
    public List<Tache> charger() throws IOException {
        return List.of();
    }
    // ---
    // --- Fin domaine Chargement ---
    
}
