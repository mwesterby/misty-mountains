import java.util.ArrayList;
/**
 * The Club class holds information about all climbers in the club including:
 * The Climber within the Club who has recorded the highest average mountain height
 * The highest Mountain recorded by a member of a Club
 * A list of all Mountains that have been recorded, that are higher than a given level
 * 
 * @author (Michael Westerby) 
 * @version 1.0 (08/11/2017)
 */
public class Club
{
    private ArrayList<Climber> climbersList;
    
    /**
     * Creates a new Club with an empty list of club members
     */
    public Club()
    {
        climbersList =  new ArrayList<Climber>();
    }

    public ArrayList<Climber> getClimbers(){
        return climbersList;
    }
        
    /**
     * Adds a new climber to the club
     * @param toAdd Climber object to be added to the Club
     */
    public void addClimber(Climber toAdd){
        climbersList.add(toAdd);
    }
    
    /**
     * Returns the climber in the club who has recorded the highest average mountain height
     * @return Climber with the highest average mountain height in the club
     */
    public Climber highestAverageClimber() {
        double maxAverage = 0;
        Climber maxAvClimber = null;
        for (Climber c : climbersList){
            if (c.listMountains().size() > 0){ //Checks a mountain exists in the climbers record
            if (c.averageHeight() > maxAverage) {
                maxAverage = c.averageHeight();
                maxAvClimber = c;
            }
        }
        }
        return maxAvClimber;
    }
    
    /**
     * Returns the highest mountain recorded by a member of the club
     * @return  The highest mountain climbed by a member in the club
     */
    public Mountain highestMountainClimbed() {
        ArrayList<Mountain> highestMountainsClimbed;
        double maxHeight = 0;
        highestMountainsClimbed = new ArrayList<>();
        Mountain highestMountain = null;
        
         for (Climber c : climbersList) {
             if (c.listMountains().size() > 0){ //Checks a mountain exists in the climbers record
             highestMountainsClimbed.add(c.climbersHighestMountain());
        }
        }
        for (Mountain m : highestMountainsClimbed) {
            if (m.getHeight() > maxHeight){
                maxHeight = m.getHeight();
                highestMountain = m;
            }
        
        }
        return highestMountain;
    }

    /**
     * Returns a list of all mountains that have been recorded, that are higher than a given level
     * @param levelAbove    The height (m) at mich mountains must be taller than to appear in the list
     * @return  List of mountains climbed by all members of the club that are higher than the level specified in the parameter levelAbove
     */
    public ArrayList higherThanLevel(int levelAbove){
        ArrayList<Mountain> higherThanLevel;
        higherThanLevel = new ArrayList<>(); 
        for (Climber c : climbersList) {
            higherThanLevel.addAll(c.listMountainAbove(levelAbove));
        }
        return higherThanLevel;
    }
    
    
}

