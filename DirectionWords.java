
/**
 * Décrivez votre classe DirectionWords ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DirectionWords
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private final String[] aValidDirections;

    /**
     * Constructeur - initialise rhe direction words
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
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  pString   parameter enter by the users
     * @return     True if command is the same, else, return false
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
    }
}
