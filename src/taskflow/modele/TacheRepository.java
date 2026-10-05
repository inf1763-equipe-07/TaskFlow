package taskflow.modele;

import java.util.List;

/**
 * Ce que le modèle attend de celui qui stocke les tâches.
 * Le modèle ne sait pas comment c'est stocké : c'est le travail du paquet persistance.
 */
public interface TacheRepository {

    /** Vrai si des données ont déjà été sauvegardées. */
    boolean existe();

    /** Lit toutes les tâches sauvegardées. */
    List<Tache> charger() throws DonneesIllisiblesException;

    /** Écrit toutes les tâches données. */
    void sauvegarder(List<Tache> taches) throws SauvegardeImpossibleException;
}
