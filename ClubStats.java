import java.util.Scanner;
import java.util.ArrayList;
/**
 *The ClubStats class provides methods which allows the user to add a new climber to a club, add details of a mountain to a climber,
 * as well as view statistics about the club, all in a graphical way though printing this information to the console.
 * Switch statements in the start method allow the user to navigate between these different options and will return them back to a
 * menu when they have completed one.
 * This class also contains the main method required to run the program
 * 
 * @author (Michael Westerby) 
 * @version 1.0 (08/11/2017)
 */
public class ClubStats
{
    private Scanner reader;
    private Club theClub;

    /**
     * The main method which creates a ClubStats object and runs the program by invoking the start method within that object
     */
    public static void main (String[] args) {
        ClubStats theStats = new ClubStats();
        theStats.start();
    }

    /**
     * Constructor method for Club Stats. This method also creates a new club (i.e. theClub) which
     * all the information about climbers will be stored within
     */
    public ClubStats()
    {
        reader = new Scanner(System.in);
        theClub = new Club();
    }

    /**
     * This method provides the functioning of the menu system which allows the user to add new climbers to the club,
     * add new mountains to these climbers and view statistics about the club by calling other methods in this class.
     * It also provides the user with a way to terminate the program with an 'exit' command.
     */
    public void start(){
        boolean finished = false;
        printWelcome();
        printMenu();

        while(!finished){
            String input = reader.nextLine().trim().toLowerCase();
            switch (input){
                case "1":   System.out.println("--- Add a Climber ---");

                            addClimber();
                            printMenu();
                            break;

                case "2":  if (theClub.getClimbers().size() < 1){ //Checks a climber exists before adding a mountain
                            System.out.println("");
                            System.out.println("--- INFORMATION ---");
                            System.out.println("You must add a climber before you can add");
                            System.out.println("a mountain.");
                            System.out.println("");
                            System.out.println("Please press enter to return to the menu.");
                            reader.nextLine();
                            printMenu();
                            break;
                          } 
                
                            System.out.println("--- Add a Mountain to a Climber ---");

                            addMountain();
                            printMenu();
                            break;

                case "3":   if (theClub.getClimbers().size() < 1 || hasMountains() == false){ //Checks at least 1 climber and a mountain exists before computing statistics
                            System.out.println("");
                            System.out.println("--- INFORMATION ---");
                            System.out.println("You must add both a climber and at least");
                            System.out.println("one mountian to their record to view ");
                            System.out.println("club stastics.");
                            System.out.println("");
                            System.out.println("Please press enter to return to the menu.");
                            reader.nextLine();
                            printMenu();
                            break;
                          }
                          
                          
                          
                          
                          
                          
                            System.out.println("--- CLUB STATS ---");
                            System.out.println("Please select a statistic you wish to view from the list below:");
                            System.out.println("");
                            System.out.println("1) The climber with the highest average climbed height");
                            System.out.println("2) The highest mountain recorded by a club member");
                            System.out.println("3) All mountains recorded above a given level");
                            input = reader.nextLine();
                            
                            switch (input){
                                case "1": System.out.println("--- Highest Average Climbed Height ---");
                                          System.out.println("The climber who has recorded the highest average mountain height is:");
                                          highestAverage();
                                          
                                          System.out.println("");
                                          System.out.println("Press enter to return to the menu");
                                          reader.nextLine();
                                          printMenu();
                                          break;
            
                                case "2": System.out.println("--- Highest Mountain Climbed ---");
                                          System.out.println("The highest mountain recorded by a member of this club is:");
                                          highestMountain();
                                          
                                          System.out.println("");
                                          System.out.println("Press enter to return to the menu");
                                          reader.nextLine();
                                          printMenu();
                                          break;
            
                                case "3": System.out.println("--- Mountain's Taller Than... ---");
                                          System.out.println("Please enter the height (m) in which all");
                                          System.out.println("mountains must be above:");
                                          int levelAbove = reader.nextInt();
                                          mountainsHigherThan(levelAbove);
                                          reader.nextLine(); //consume newline left over from newInt
                                          
                                          System.out.println("");
                                          System.out.println("Press enter to return to the menu");
                                          reader.nextLine();
                                          printMenu();
                                          break;
                            }
                              
                            break;
                default: if(input.startsWith("exit")) {
                            finished = true;
                          }
                        else System.out.println("Please select a valid option");}          
        }
        printGoodbye();
    }

    /**
     * Allows the user to create a new Climber which will be added to the club by specifying their
     * name, gender and age. These parameters are passed to the Climber constructor to create a 
     * new climber which is then added to the list of climbers in the club.
     * This method also provides a fast way to add a new mountain to the climber which has just been created
     */
    public void addClimber()
    {
        String name = null;
        String gender = null;
        int age = -1;
        
        System.out.println("Name:");
        name = reader.nextLine();
        System.out.println("");
        System.out.println("Gender:");
        gender = reader.nextLine();
        System.out.println("");
        System.out.println("Age:");
        
        while (age < 0){ //ensures a positive age is entered
            age = reader.nextInt();
            if (age < 0){
                System.out.println("Please enter a postive age");
            }
            } 
        
        reader.nextLine(); //consume newline left over from newInt

        Climber toAdd = new Climber(name, age, gender);
        theClub.addClimber(toAdd);
        
        System.out.println("");
        System.out.println("Would you like to add a mountain to " + name + "'s record?");
        System.out.println("y/n");
        
        if(reader.nextLine().toLowerCase().startsWith("y")) {
            addMountainToClimber(theClub.getClimbers().size()-1);
        }
    }

    /**
     * Presents the user with a list of climbers (ordered by their index value in the climber list
     * array) so they can select which one they would like to add a new mountain too. This index value
     * is then passed to the addMountainToClimber method
     */
    public void addMountain(){
        int climberIndex;
        
        System.out.println("Enter the number of a climber whoes record");
        System.out.println("you would like to add a mountain too:");
        System.out.println("");

        ArrayList<Climber> climbers = theClub.getClimbers();
        for (int i = 0; i < climbers.size(); i++){
            System.out.println(i + ") " + climbers.get(i).getName() + ", " + climbers.get(i).getGender() + ", " + climbers.get(i).getAge());
        }

        climberIndex = reader.nextInt();
        reader.nextLine(); //consume newline left over from newInt

        addMountainToClimber(climberIndex);
    }
    
    /**
     * Adds a new mountain to a climber. This method asks the user for the name and height of
     * a new mountain. These parameters are then passed to the Mountain constructor to create a
     * new mountain object. This object is then added to the list of climbed mountains for the
     * climber who resides at the specified index position in the cilmbers list array
     * 
     * @param climberIndex  The index position of the climber in the climbers list array
     * 
     */
    public void addMountainToClimber(int climberIndex){
        String mountainName = null;
        int mountainHeight = -1;
        
        System.out.println("");
        System.out.println("What is the name of the mountain:");
        mountainName = reader.nextLine();
        System.out.println("");
        System.out.println("What is the height (m) of the mountain:");
        
        while (mountainHeight < 0){ //checks a positve height is entered
            mountainHeight = reader.nextInt();
            if (mountainHeight < 0){
                System.out.println("Please enther a postive height");
            }
            } 
        
        reader.nextLine(); //consume newline left over from newInt

        Mountain toAdd = new Mountain(mountainName, mountainHeight);

        theClub.getClimbers().get(climberIndex).addMountainToList(toAdd);
        
        System.out.println("");
        System.out.println("Would you like to add another mountain to " + theClub.getClimbers().get(climberIndex).getName() + "'s record?");
        System.out.println("y/n");
        if(reader.nextLine().toLowerCase().startsWith("y")) {
            addMountainToClimber(climberIndex);
        }
        
    }

    /**
     * Prints the name of the climber who has recorded the highest average mountain height
     * to the console as well as their average climbed height (m)
     */
    public void highestAverage(){
        Climber highestAverageClimber = theClub.highestAverageClimber();
        System.out.println(highestAverageClimber.getName() + ", with an average height of " + highestAverageClimber.averageHeight() + "m");
    }

    /**
     * Prints the name and height of the highest mountain recorded by a member of the
     * club to the console
     */
    public void highestMountain(){
        Mountain highestMountain = theClub.highestMountainClimbed();
        System.out.println(highestMountain.getName() + ", with a height of " + highestMountain.getHeight() + "m");
    }
    
    /**
     * Prints a list of mountains which club members have climbed that are higher than 
     * a specified value.
     * @param levelAbove The height (m) a mountain must be taller than to appear in the list
     */
    public void mountainsHigherThan(int levelAbove){
        ArrayList<Mountain> mountainsTallerThan;
        mountainsTallerThan = theClub.higherThanLevel(levelAbove);
        System.out.println("");
        System.out.println("--- Mountains Taller Than " + levelAbove + "m ---");
        for (Mountain m : mountainsTallerThan){
            System.out.println(m.getName() + " " + m.getHeight() + "m");
        }
    }
    
    /**
     * Checks to see if at least one mountain is present
     * @return True if at least one mountain has been entered
     */
    private boolean hasMountains(){
        int totalMountains = 0;
        boolean hasMountains = false;
        
        for (Climber c : theClub.getClimbers()){
            totalMountains += c.listMountains().size();
        }
        if (totalMountains > 0){
            hasMountains = true;
        }

        return hasMountains;
    }
    
    
    
    /**
     * Prints a welcome message to the console when the program starts
     */
    private void printWelcome()
    {
        System.out.println("*******************");
        System.out.println("  Misty Mountains");
        System.out.println("*******************");
    }

    /**
     * Prints the menu to the console with the list of options relating to the switch statement in
     * the start method as well as instructions on how to quit the program
     */
    private void printMenu(){
        System.out.println();
        System.out.println("--- MAIN MENU ---");
        System.out.println("Please type an option number to complete");
        System.out.println("one of the following actions:");
        System.out.println();
        System.out.println("1) Add a climber");
        System.out.println("2) Add a mountain to a climber's record");
        System.out.println("3) View club stats");
        System.out.println("");
        System.out.println("Or type Exit to quit");
    }

    /**
     * Prints a goodbye message to the console upon exiting the program
     */
    private void printGoodbye()
    {
        System.out.println("");
        System.out.println("Goodbye");
    }

}
