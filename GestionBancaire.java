import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 * Classe principale qui gère l'interaction avec l'utilisateur
 * via un menu en console.
 */
public class GestionBancaire {

    // Utilisation d'une Map pour stocker les comptes avec leur numéro comme clé
    private static Map<String, CompteBancaire> comptes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le système de gestion bancaire !");
        int choix = 0;

        while (choix != 6) {
            afficherMenu();
            try {
                choix = scanner.nextInt();
                scanner.nextLine(); // Consomme le retour à la ligne

                switch (choix) {
                    case 1:
                        creerCompte();
                        break;
                    case 2:
                        effectuerDepot();
                        break;
                    case 3:
                        effectuerRetrait();
                        break;
                    case 4:
                        consulterSolde();
                        break;
                    case 5:
                        calculerInterets(); // Option Bonus
                        break;
                    case 6:
                        System.out.println("Merci d'avoir utilisé notre système. Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
                scanner.nextLine(); // Nettoie le buffer du scanner
                choix = 0; // Réinitialise le choix pour éviter une boucle infinie
            }
        }
        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Créer un nouveau compte");
        System.out.println("2. Effectuer un dépôt");
        System.out.println("3. Effectuer un retrait");
        System.out.println("4. Consulter le solde");
        System.out.println("5. (Bonus) Ajouter les intérêts annuels (pour comptes épargne)");
        System.out.println("6. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void creerCompte() {
        System.out.println("\n--- Création d'un compte ---");
        System.out.print("Nom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Adresse du client : ");
        String adresse = scanner.nextLine();

        Client client = new Client(nom, adresse);
        
        System.out.print("Type de compte (1: Courant, 2: Epargne) : ");
        int type = scanner.nextInt();
        scanner.nextLine();

        // Génération d'un numéro de compte unique
        String numeroCompte = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        CompteBancaire compte;

        if (type == 2) {
            System.out.print("Taux d'intérêt annuel (ex: 0.02 pour 2%) : ");
            double taux = scanner.nextDouble();
            scanner.nextLine();
            compte = new CompteEpargne(numeroCompte, client, taux);
            System.out.println("Compte Épargne créé avec succès !");
        } else {
            compte = new CompteBancaire(numeroCompte, client);
            System.out.println("Compte Courant créé avec succès !");
        }

        comptes.put(numeroCompte, compte);
        System.out.println("Votre numéro de compte est : " + numeroCompte);
    }

    private static CompteBancaire trouverCompte() {
        System.out.print("\nEntrez le numéro de compte : ");
        String numero = scanner.nextLine();
        CompteBancaire compte = comptes.get(numero);
        if (compte == null) {
            System.out.println("Compte non trouvé.");
        }
        return compte;
    }

    private static void effectuerDepot() {
        CompteBancaire compte = trouverCompte();
        if (compte != null) {
            try {
                System.out.print("Montant à déposer : ");
                double montant = scanner.nextDouble();
                scanner.nextLine(); // Consomme le retour à la ligne
                compte.deposer(montant);
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Montant invalide.");
                scanner.nextLine();
            }
        }
    }

    private static void effectuerRetrait() {
        CompteBancaire compte = trouverCompte();
        if (compte != null) {
            try {
                System.out.print("Montant à retirer : ");
                double montant = scanner.nextDouble();
                scanner.nextLine();
                compte.retirer(montant);
            } catch (SoldeInsuffisantException e) {
                System.err.println("Erreur de transaction : " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Montant invalide.");
                scanner.nextLine();
            }
        }
    }

    private static void consulterSolde() {
        CompteBancaire compte = trouverCompte();
        if (compte != null) {
            compte.afficherSolde();
        }
    }

    private static void calculerInterets() {
        CompteBancaire compte = trouverCompte();
        if (compte instanceof CompteEpargne) {
            ((CompteEpargne) compte).ajouterInteretsAnnuels();
        } else if (compte != null) {
            System.out.println("Cette opération n'est disponible que pour les comptes épargne.");
        }
    }
}
