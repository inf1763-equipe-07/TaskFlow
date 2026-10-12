package taskflow.modele;

import java.io.IOException;
import java.util.List;

/**
 * Ce que le modèle attend de celui qui stocke les tâches.
 * Le modèle ne sait pas comment c'est stocké : c'est le travail du paquet persistance.
 * Les échecs de lecture ou d'écriture sont signalés par une IOException : celui qui implémente
 * le stockage choisit comment les organiser, et son message explique le problème.
 */
public interface TacheRepository {

    /** Vrai si des données ont déjà été sauvegardées. */
    boolean existe();

    /** Lit toutes les tâches sauvegardées. Lance une IOException si le fichier est illisible ou mal formé. */
    List<Tache> charger() throws IOException;

    /** Écrit toutes les tâches données. Lance une IOException si l'écriture est impossible. */
    void sauvegarder(List<Tache> taches) throws IOException;
}
