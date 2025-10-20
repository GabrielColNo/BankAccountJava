import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Représente un compte bancaire générique.
 * Gère le solde, les dépôts et les retraits.
 */
public class CompteBancaire {
    private String numeroDeCompte;
    private double solde;
    private Client proprietaire;

    /**
     * Constructeur pour un compte bancaire.
     * @param numeroDeCompte Le numéro unique du compte.
     * @param proprietaire Le client propriétaire du compte.
     */
    public CompteBancaire(String numeroDeCompte, Client proprietaire) {
        this.numeroDeCompte = numeroDeCompte;
        this.proprietaire = proprietaire;
        this.solde = 0.0; // Le solde initial est toujours 0
    }

    // Getters
    public String getNumeroDeCompte() {
        return numeroDeCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    /**
     * Dépose un montant sur le compte.
     * @param montant Le montant à déposer (doit être positif).
     */
    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("Dépôt de " + montant + " EUR effectué. Nouveau solde : " + this.solde + " EUR.");
            enregistrerTransaction("Dépôt", montant);
        } else {
            System.out.println("Le montant du dépôt doit être positif.");
        }
    }

    /**
     * Retire un montant du compte.
     * @param montant Le montant à retirer (doit être positif).
     * @throws SoldeInsuffisantException Si le solde est inférieur au montant à retirer.
     */
    public void retirer(double montant) throws SoldeInsuffisantException {
        if (montant <= 0) {
            System.out.println("Le montant du retrait doit être positif.");
            return;
        }
        if (this.solde >= montant) {
            this.solde -= montant;
            System.out.println("Retrait de " + montant + " EUR effectué. Nouveau solde : " + this.solde + " EUR.");
            enregistrerTransaction("Retrait", montant);
        } else {
            throw new SoldeInsuffisantException("Opération impossible : solde insuffisant.");
        }
    }

    /**
     * Affiche le solde actuel du compte.
     */
    public void afficherSolde() {
        System.out.println("Le solde du compte " + this.numeroDeCompte + " est de : " + this.solde + " EUR.");
    }

    /**
     * (Bonus) Enregistre une transaction dans le fichier historique.txt.
     * @param type Le type de transaction (Dépôt, Retrait, Intérêts).
     * @param montant Le montant de la transaction.
     */
    protected void enregistrerTransaction(String type, double montant) {
        try (PrintWriter out = new PrintWriter(new FileWriter("historique.txt", true))) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            out.println("[" + date + "] Compte: " + this.numeroDeCompte + " | Type: " + type + " | Montant: " + montant + " EUR | Nouveau Solde: " + this.solde + " EUR");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier d'historique : " + e.getMessage());
        }
    }
}