import java.util.Scanner;

/**
 * La classe game est le moteur du jeu d'aventure AStraeth
 * Elle gère le lancement du jeu, les room et les commandes
 *
 * @author Valentin
 * @version 25/10/2023
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    private DirectionWords aValidDirections; 
    private CommandWords aValidCommands;
    
    /**
     * Créer les différentes room du jeu et les connexions entre elles
     */
    private void createRooms() {
        // Créations des room et leurs descriptions 
        Room vAubval = new Room("in the village of Aubval, \nhome to the Homozeniths, an ethnic group that resembles human beings in every way.");
        Room vSylvanea = new Room("in the magnificent Sylvanea forest. \nThe only sound to be hear the wind blowing through the trees and birdsong.\nThe forest is home to the Sylvain ethnic group.");
        Room vUniterra = new Room("in the Uniterra capital, \nwhich brings together all the world's ethnic groups. Even the gods sometimes visit here. \nIt's a place of peace where there's no room for conflict.");
        Room vCryofrost = new Room("in Cryofrost, \nan area of intense blizzard and snow occupied by the Frostlings.");
        Room vPyronera = new Room("in Pyronera inside a volcano. \nThe ground is covered with molten lava and magma. \nThe Drakorians occupy these lands.");
        Room vMonterac = new Room("in the mountain town of montérac. \nThe Georians dig tunnels and underground passageways to live in.");
        Room vLuminaurore = new Room("In the desert of Luminaurore. \nIn the middle of this desert lies the city of the Auroriennes. \nThis ethnic group is made up entirely of women. ");
        Room vVesperia = new Room("in Vesperia. \nA plain permanently immersed in twilight. \nThis land is home to the Umbrans, malevolent shadows.");
        Room vLaboratoire = new Room("in the laboratory. \nThese walls are not home to any ethnic group. \nThe door, imbued with teleportation magic, will teleport you into a random zone.");
        Room vCelestia = new Room("in god's valley Célestia");
        Room vAbyssalem = new Room("in abyssera");
        
        // Configuration des sorties
        vAubval.setExit("north", vSylvanea);
        vAubval.setExit("east", vUniterra);
        vAubval.setExit("west", vVesperia);
        
        vSylvanea.setExit("south", vAubval);
        
        vUniterra.setExit("north", vMonterac);
        vUniterra.setExit("south", vCryofrost);
        vUniterra.setExit("east", vPyronera);
        vUniterra.setExit("west", vAubval);
        vUniterra.setExit("up", vCelestia);
        
        vCryofrost.setExit("north", vUniterra);
        
        vPyronera.setExit("west", vUniterra);
        
        vMonterac.setExit("south", vUniterra);
        vMonterac.setExit("east", vLuminaurore);
        
        vLuminaurore.setExit("west", vMonterac);
        
        vVesperia.setExit("south", vLaboratoire);
        vVesperia.setExit("east", vAubval);
        vVesperia.setExit("down", vAbyssalem);
        
        vLaboratoire.setExit("north", vVesperia);
        // si possible, remplacer direction Vesperia par zone aléatoire 
        
        vCelestia.setExit("down", vUniterra);
        vAbyssalem.setExit("up", vVesperia);
        
        this.aCurrentRoom = vAubval; // pièce de démarrage au lancement du jeu
    } // createRooms
    
    /**
     * Constructeur par défaut
     * Initialise les room du jeu et le parser pour les commandes
     */
    public Game() {
        this.createRooms();
        this.aParser = new Parser();
    } 
    
    /**
     * Méthode privée pour déplacer le joueur dans une autre room
     * @param pGo   La commande de déplacement 
     */
    private void goRoom(final Command pGo) {        
        String vDirection = pGo.getSecondWord();
        
        if (!pGo.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        
        DirectionWords vOk = new DirectionWords();
        if (!vOk.isDirection(vDirection)) {
            System.out.println("Unknown direction!");
            return;
        }
        Room vNextRoom = this.aCurrentRoom.getExit(vDirection);

        if (vNextRoom == null) {
            System.out.println("There is no door!");
        }
        // afficher les sorties disponibles
        else {
            this.aCurrentRoom = vNextRoom;
            this.printLocationInfo();
        }
    } // goRoom
    
    /**
     * Affiche le message de bienvenue au début du jeu.
     */
    private void printWelcome() {
        System.out.println("Welcome to the world of Astraeth !");
        System.out.println("A world of magic and many different ethnic groups.");
        System.out.println("You have been forcibly teleported here to become this world's new god of war.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        this.printLocationInfo(); 
    } // printWelcome
    
    /**
     * Affiche les commandes disponibles pour le joueur.
     */
    private void printHelp() {
        System.out.println("Your task is to find the lost pieces of the teleporter to return to your world.");
        System.out.println("You need to explore the world and talk to people to advance your quest.");
        System.out.println("Your command words are :");
        aParser.showCommands();
        // System.out.println("go   help   look   eat   quit");
    } // printHelp
    
    /**
     * Commande "quit" pour quitter le jeu 
     * @param pQuit LA commande pour quitter le jeu
     * @return true si le jeu doit se terminer sinon false.
     */
    private boolean quit(final Command pQuit) {
        if (pQuit.hasSecondWord() == true) {
            System.out.println("Quit What ?");
            return false;
        }
        else {
            return true;
        }
    } // quit 
    
    /**
     * Affiche la description de la room actuelle
     */
    private void look() {
        System.out.println(this.aCurrentRoom.getLongDescription());
    }
    
    /**
     * Affiche un message
     */
    private void eat() {
        System.out.println("You have eaten now and you are not hungry any more");
    }
    
    /**
     * Analyse et exécute les commandes du joueur
     * @param pCom La commande qu'effectue le joueur
     * @return true si le joueur a quitté le jeu sinon false
     */
    private boolean processCommand(final Command pCom) {
        if (pCom.isUnknown()) {
            System.out.println("I don't know what you mean ...");
        }
        if (pCom.getCommandWord().equals("help")) {
            printHelp();
        }
        else if (pCom.getCommandWord().equals("go")) {
            goRoom(pCom);
        }
        else if (pCom.getCommandWord().equals("look")) {
            look();
        }
        else if (pCom.getCommandWord().equals("eat")) {
            eat();
        }
        else if (pCom.getCommandWord().equals("quit")) {
            return quit(pCom);
        }
        return false;
    } // processCommad
    
    /**
     * Affiche la description de la room actuelle
     */
    private void printLocationInfo() {
        System.out.println(this.aCurrentRoom.getLongDescription());
    } // printLocationInfo()
    
    /**
     * Main method to start and end the game
     */
    public void play() {
        this.printWelcome();
        boolean vFinished = false;
        while (vFinished == false) {
            Command vVariable = this.aParser.getCommand();
            vFinished = this.processCommand(vVariable);
        } // while
        System.out.println("Thank you for playing. Good bye!!");
    } // play()
} // Game
