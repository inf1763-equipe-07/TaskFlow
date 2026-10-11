package taskflow.persistance;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.AtomicMoveNotSupportedException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import taskflow.modele.Priorite;
import taskflow.modele.Statut;
import taskflow.modele.Tache;

/** Persistence UTF-8 simple : id|titre|PRIORITE|date|STATUT. */
public final class FichierTacheRepository {
    private static final String ENTETE = "# TaskFlow v1 | id | titre | priorite | echeance | statut";
    private final Path fichier;

    public FichierTacheRepository(Path fichier) { this.fichier = fichier; }
    public Path fichier() { return fichier; }
    public boolean existe() { return Files.exists(fichier); }

    /** Ne modifie jamais le fichier en lecture ; rejette l'ensemble si une ligne est incorrecte. */
    public List<Tache> charger() throws IOException, DonneesIllisiblesException {
        List<String> lignes = Files.readAllLines(fichier, StandardCharsets.UTF_8);
        List<Tache> resultat = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();
        for (int i = 0; i < lignes.size(); i++) {
            String ligne = lignes.get(i);
            if (ligne.isBlank() || ligne.startsWith("#")) continue;
            String[] champs = ligne.split("\\|", -1);
            if (champs.length != 5)
                throw new DonneesIllisiblesException("ligne " + (i + 1) + " : cinq champs attendus.");
            try {
                int id = Integer.parseInt(champs[0].trim());
                LocalDate date = champs[3].isBlank() ? null : LocalDate.parse(champs[3].trim());
                Tache t = new Tache(id, champs[1], Priorite.valueOf(champs[2].trim()), date,
                        Statut.valueOf(champs[4].trim()));
                if (!ids.add(id)) throw new IllegalArgumentException("identifiant dupliqué : " + id);
                resultat.add(t);
            } catch (IllegalArgumentException e) {
                throw new DonneesIllisiblesException("ligne " + (i + 1) + " : " + e.getMessage(), e);
            }
        }
        return resultat;
    }

    /** Écriture temporaire puis remplacement : pas de succès annoncé avant la fin. */
    public void sauvegarder(List<Tache> taches) throws IOException {
        List<String> lignes = new ArrayList<>();
        lignes.add(ENTETE);
        for (Tache t : taches) {
            String date = t.echeance() == null ? "" : t.echeance().toString();
            lignes.add(t.id() + "|" + t.titre() + "|" + t.priorite().name() + "|"
                    + date + "|" + t.statut().name());
        }
        Path cheminAbsolu = fichier.toAbsolutePath();
        Path parent = cheminAbsolu.getParent();
        if (parent != null) Files.createDirectories(parent);
        Path temporaire = Files.createTempFile(parent, ".taskflow-", ".tmp");
        try {
            Files.write(temporaire, lignes, StandardCharsets.UTF_8);
            try {
                Files.move(temporaire, cheminAbsolu, StandardCopyOption.ATOMIC_MOVE,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (AtomicMoveNotSupportedException e) {
                // Refuser une substitution non atomique plutôt que risquer les données existantes.
                throw new IOException("remplacement atomique non disponible sur ce système de fichiers.", e);
            }
        } finally {
            Files.deleteIfExists(temporaire);
        }
    }
}
