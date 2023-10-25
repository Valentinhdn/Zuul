 /**
 * La classe Command représente une commande du jeu d'aventure AStraeth
 * Chaque commande est composé d'une commande principale et éventuellement d'une commande secandaire
 * Cette classe gère les commandes entrées par le joueur
 *
 * @author Valentin
 */
public class Command
{
    private String aCommandWord; // commande principal
    private String aSecondWord; // commande secondaire
    
    /**
     * Constructeur naturel
     * Créer une nouvelle instance de la classe deux commande en paramètre
     * @param pCommandWord  La commande principal
     * @param pSecondWord   La commande secondaire
     */
    public Command (final String pCommandWord, final String pSecondWord) 
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    /**
     * Récupère la commande principal 
     * @return La commande principal
     */
    public String getCommandWord() 
    {
        return this.aCommandWord;
    }
    
    /**
     * Récupère la commande secondaire si celà est possible
     * @return La commande secondaire si elle existe
     */
    public String getSecondWord() 
    {
        return this.aSecondWord;
    }
    
    /**
     * Vérifie si la commande à une commande secondaire 
     * @return true si la commande secondaire existe et false sinon
     */
    public boolean hasSecondWord() 
    {
        return this.aSecondWord != null;
    } 
    
    /**
     * Vérifie si la commande est inconnue
     * @return true si la commande est inconnue et false sinon
     */
    public boolean isUnknown() {
        return this.aCommandWord == null;
    }
} // Command
