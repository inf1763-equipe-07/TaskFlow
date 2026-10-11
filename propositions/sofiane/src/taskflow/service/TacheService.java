package taskflow.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import taskflow.modele.Priorite;
import taskflow.modele.Statut;
import taskflow.modele.Tache;

/** Règles métier : ne lit ni le clavier ni les fichiers. */
public final class TacheService {
    private final List<Tache> taches = new ArrayList<>();
    private int prochainId = 1;
    private boolean modificationsNonSauvegardees = false;

    /** Reconstruit l'état à partir du chargement, sans modifier le fichier. */
    public TacheService(List<Tache> initiales) {
        Set<Integer> ids = new HashSet<>();
        int max = 0;
        for (Tache t : initiales) {
            if (!ids.add(t.id())) throw new IllegalArgumentException("identifiant en double : " + t.id());
            taches.add(t);
            max = Math.max(max, t.id());
        }
        if (max == Integer.MAX_VALUE) throw new IllegalArgumentException("identifiants épuisés.");
        prochainId = max + 1;
    }

    public List<Tache> lister() { return List.copyOf(taches); }
    public int taille() { return taches.size(); }

    public Tache trouver(int id) {
        for (Tache t : taches) if (t.id() == id) return t;
        throw new IllegalArgumentException("aucune tâche ne correspond à l'identifiant " + id + ".");
    }

    public Tache ajouter(String titre, Priorite priorite, LocalDate echeance) {
        if (prochainId <= 0 || prochainId == Integer.MAX_VALUE)
            throw new IllegalStateException("aucun nouvel identifiant disponible.");
        Tache t = new Tache(prochainId, titre, priorite, echeance, Statut.A_FAIRE);
        taches.add(t);
        prochainId++;
        modificationsNonSauvegardees = true;
        return t;
    }

    public boolean terminer(int id) {
        boolean change = trouver(id).terminer();
        if (change) modificationsNonSauvegardees = true;
        return change;
    }

    public Priorite changerPriorite(int id, Priorite nouvelle) {
        Tache t = trouver(id);
        Priorite ancienne = t.priorite();
        t.changerPriorite(nouvelle);
        if (ancienne != nouvelle) modificationsNonSauvegardees = true;
        return ancienne;
    }

    public void changerEcheance(int id, LocalDate nouvelle) {
        Tache t = trouver(id);
        if (!java.util.Objects.equals(t.echeance(), nouvelle)) {
            t.changerEcheance(nouvelle);
            modificationsNonSauvegardees = true;
        }
    }

    public boolean modificationsNonSauvegardees() { return modificationsNonSauvegardees; }
    public void confirmerSauvegarde() { modificationsNonSauvegardees = false; }
}
