/**
 * Exception personnalisée levée lorsqu'une tentative de retrait
 * dépasse le solde disponible sur un compte.
 */
public class SoldeInsuffisantException extends Exception {
    
    /**
     * Constructeur qui accepte un message d'erreur.
     * @param message Le message décrivant l'erreur.
     */
    public SoldeInsuffisantException(String message) {
        super(message);
    }
}