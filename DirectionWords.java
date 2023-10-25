
/**
 * La classe DirectionWords représente les directions valides
 * Elle est utilisée pour reconnaître les commandes de directions saisie par le joueur pour savoir si elle existe
 *
 * @author Valentin
 * @version 12/10/2023
 */
public class DirectionWords
{
    // Un tableau contenant toutes les dierctions valides 
    private final String[] aValidDirections;

    /**
     * Constructeur - initialise the direction words
     */
    public DirectionWords()
    {
        // initialisation des variables d'instance
        this.aValidDirections = new String[6];
        this.aValidDirections[0] = "north";
        this.aValidDirections[1] = "south";
        this.aValidDirections[2] = "east";
        this.aValidDirections[3] = "west";
        this.aValidDirections[4] = "up";
        this.aValidDirections[5] = "down";
    } // DirectionWords()

    /**
     * Vérifie si la string donnée est une direction valide
     *
     * @param  pString   parameter enter by the users
     * @return true if command is the same, else, return false
     */
    public boolean isDirection( final String pString )
    {
        // Insérez votre code ici
        for ( int vI=0; vI<this.aValidDirections.length; vI++ ) {
            if ( this.aValidDirections[vI].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands :
        return false;
    } // isDirection()
} // DirectionWords
