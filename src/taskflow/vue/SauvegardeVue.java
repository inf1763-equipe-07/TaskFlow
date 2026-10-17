package taskflow.vue;

/** La vue du domaine Sauvegarde : annonce la réussite ou l'échec d'une sauvegarde. */
public class SauvegardeVue extends Vue {

    public SauvegardeVue(Console console) {
        super(console);
    }

    public void afficherReussite() {
        afficherSucces("Tâches sauvegardées avec succès.");
    }

    public void afficherEchec(String raison) {
        afficherErreur("impossible de sauvegarder les tâches (" + raison + ").");
    }
}
