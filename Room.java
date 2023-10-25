import java.util.HashMap; 
import java.util.Set;

/**
 * La classe Room représente un lieu du jeu d'aventure Astraeth
 * Chaque room a une description et des sorties vers d'autre room 
 *
 * @author Valentin
 */
public class Room
{
    private String aDescription; // description de la room
    private HashMap<String, Room> aExits; // sorties de la room
    private String aImageName;    
    /**
     * Constructeur de la classe Room
     * Créer une nouvelle pièce avec une description et initialise ses sorties
     */
    public Room(final String pDescription) {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
    } // Room()
    
    /**
     * Récupère la description de la room
     * @return La description de la room
     */
    public String getDescription() {
        return this.aDescription;
    } // getDescription()
    
    /**
     * Récupère la longue description de la room et affiche les sorties
     * @return La longue description de la room
     */
    public String getLongDescription() {
        return "You are " + this.aDescription +"\n"+ getExitString(); 
    }
    
    /**
     * Définit une sortie de la pièce dans une direction 
     * @param pDirection    La direction de la sortie 
     * @param pNeighbor     La room qui est dans la direction donnée
     */
    public void setExit(final String pDirection, final Room pNeighbor) {
        this.aExits.put(pDirection, pNeighbor);
    }
    
    /**
     * Récupère la room qui est dans la direction indiquée
     * @param pDirection    La direction de la sortie 
     * @return la room vers laquelle la sortie mène
     */
    public Room getExit(String pDirection) {
        return this.aExits.get(pDirection);
    } // getExits()
    
    /**
     * Récupère la liste des sorties disponnibles pour une room 
     * @return all possible outputs 
     */
    public String getExitString() {
        String returnString = "Exits :";
        Set<String> keys = aExits.keySet();
        for (String exit : keys) {
            returnString += "   " + exit;
        }
        
        System.out.println();
        return returnString;
    } // getExitString()
    
    /**
     * @return a string describing the room's image name
     */
    public String getImageName() {
        return this.aImageName;
    } // getImageName()
} // Room
