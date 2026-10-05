package taskflow.controleur;

/**
 * Une entrée du menu principal : un texte à afficher et un travail à exécuter quand on la choisit.
 */
public interface ActionMenu {

    /** Le texte de l'entrée dans le menu, par exemple « Ajouter une tâche ». */
    String libelle();

    /** Ce qui se passe quand l'utilisateur choisit cette entrée. */
    void executer();
}
