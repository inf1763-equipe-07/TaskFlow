package taskflow.persistance;

import java.nio.file.Path;
import java.util.List;

import taskflow.modele.DonneesIllisiblesException;
import taskflow.modele.SauvegardeImpossibleException;
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
    public void sauvegarder(List<Tache> taches) throws SauvegardeImpossibleException {
        throw new UnsupportedOperationException("La sauvegarde n'est pas encore disponible.");
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
    public List<Tache> charger() throws DonneesIllisiblesException {
        return List.of();
    }
    // ---
    // --- Fin domaine Chargement ---
    
}
