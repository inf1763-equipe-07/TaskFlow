package taskflow.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/** La validation du calendrier est centralisée et indépendante de la console. */
public final class ValidateurDate {
    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
    private ValidateurDate() { }

    public static LocalDate analyser(String saisie) {
        String texte = saisie == null ? "" : saisie.trim();
        if (!texte.matches("\\d{4}-\\d{2}-\\d{2}"))
            throw new IllegalArgumentException("« " + texte + " » n'est pas un format de date valide. "
                    + "Format attendu : AAAA-MM-JJ.");
        try {
            return LocalDate.parse(texte, FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("« " + texte + " » n'est pas une date valide.");
        }
    }
}
