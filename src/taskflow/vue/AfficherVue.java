package taskflow.vue;

import java.util.List;

import taskflow.modele.Tache;

/** La vue du domaine Consultation pour afficher la liste des tâches. */
public class AfficherVue extends Vue {

    public AfficherVue(Console console) {
        super(console);
    }

    /** Affiche chaque tâche avec tous ses champs, ou un message si la liste est vide. */
    public void afficherListe(List<Tache> taches) {
        afficherTitre("Liste des tâches");

        if (taches.isEmpty()) {
            afficher("Aucune tâche enregistrée.");
            return;
        }

        for (Tache tache : taches) {
            afficher("Identifiant : " + tache.id());
            afficher("Titre : " + tache.titre());
            afficher("Priorité : " + tache.priorite().libelle());
            afficher("Échéance : " + (tache.echeance() != null ? tache.echeance() : "Aucune"));
            afficher("Statut : " + tache.statut().libelle());
            afficher("");
        }
    }
}
