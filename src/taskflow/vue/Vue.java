package taskflow.vue;

import java.util.OptionalInt;

/**
 * La vue dont héritent toutes les vues de domaine (par exemple AjoutVue extends Vue).
 * Elle donne les outils communs d'affichage et de saisie, tous passés par la console partagée :
 * une seule classe lit le clavier, sinon les lectures se mélangent.
 * Elle reste petite et stable : on la modifie seulement après en avoir parlé sur l'Issue.
 */
public abstract class Vue {

    private final Console console;

    protected Vue(Console console) {
        this.console = console;
    }

    protected void afficher(String texte) {
        console.afficher(texte);
    }

    /** Affiche un titre en majuscules, avec une ligne vide avant et après. */
    protected void afficherTitre(String titre) {
        console.afficherTitre(titre);
    }

    /** Affiche « Erreur : » suivi du message. */
    protected void afficherErreur(String message) {
        console.afficherErreur(message);
    }

    protected void afficherSucces(String message) {
        console.afficherSucces(message);
    }

    /** Affiche l'invite puis lit une ligne. Entrée seule donne un texte vide. */
    protected String lire(String invite) {
        return console.lire(invite);
    }

    /** Lit un nombre entier, ou rien du tout si ce que l'utilisateur a tapé n'en est pas un. */
    protected OptionalInt lireEntier(String invite) {
        return console.lireEntier(invite);
    }
}
