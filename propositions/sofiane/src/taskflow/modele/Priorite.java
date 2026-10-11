package taskflow.modele;

import java.text.Normalizer;
import java.util.Locale;

/** Trois valeurs admises ; la présentation est indépendante du nom technique. */
public enum Priorite {
    BASSE("Basse"), NORMALE("Normale"), ELEVEE("Élevée");

    private final String libelle;
    Priorite(String libelle) { this.libelle = libelle; }
    public String libelle() { return libelle; }

    /** Retourne null pour une saisie inconnue ; le contrôleur présente l'erreur. */
    public static Priorite analyser(String texte) {
        if (texte == null) return null;
        String entree = normaliser(texte);
        for (Priorite p : values()) {
            if (normaliser(p.libelle).equals(entree) || normaliser(p.name()).equals(entree)) return p;
        }
        return null;
    }

    private static String normaliser(String s) {
        return Normalizer.normalize(s.trim().toLowerCase(Locale.ROOT), Normalizer.Form.NFD)
                .replaceAll("\\p{M}+", "");
    }
}
