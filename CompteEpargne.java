/**
 * (Bonus) Représente un compte épargne, qui est un type de CompteBancaire
 * avec la capacité de calculer et d'ajouter des intérêts.
 */
public class CompteEpargne extends CompteBancaire {
    private double tauxInteretAnnuel;

    /**
     * Constructeur pour un compte épargne.
     * @param numeroDeCompte Le numéro unique du compte.
     * @param proprietaire Le client propriétaire.
     * @param tauxInteretAnnuel Le taux d'intérêt annuel (ex: 0.02 pour 2%).
     */
    public CompteEpargne(String numeroDeCompte, Client proprietaire, double tauxInteretAnnuel) {
        super(numeroDeCompte, proprietaire); // Appelle le constructeur de la classe mère
        this.tauxInteretAnnuel = tauxInteretAnnuel;
    }

    /**
     * Calcule et ajoute les intérêts annuels au solde du compte.
     */
    public void ajouterInteretsAnnuels() {
        double interets = getSolde() * this.tauxInteretAnnuel;
        if (interets > 0) {
            deposer(interets); // Utilise la méthode deposer pour mettre à jour le solde et l'historique
            System.out.println("Ajout des intérêts annuels (" + (tauxInteretAnnuel * 100) + "%) : " + interets + " EUR.");
            // La transaction est déjà enregistrée par l'appel à deposer()
        } else {
            System.out.println("Aucun intérêt à ajouter.");
        }
    }
}
