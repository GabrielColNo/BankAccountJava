/**
 * Représente un client de la banque.
 * Chaque client a un nom et une adresse.
 */
public class Client {
    private String nom;
    private String adresse;

    /**
     * Constructeur pour créer un nouveau client.
     * @param nom Le nom du client.
     * @param adresse L'adresse du client.
     */
    public Client(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    // Getters pour accéder aux informations du client
    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return "Client [Nom=" + nom + ", Adresse=" + adresse + "]";
    }
}