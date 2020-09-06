import java.util.ArrayList;
/**
 * The Climber class stores information about individual climbers including: name, age, gender and a list of mountains they have climbed.
 * 
 * @author (Michael Westerby) 
 * @version 1.0 (08/11/2017)
 */
public class Climber
{
    private String name;
    private int age;
    private String gender;
    private ArrayList<Mountain> climbedList;
    private ArrayList<Mountain> mountainsAboveHeight;

    /**
     * Creates a new climber as well as an empty array list of mountains to be climbed
     * 
     * @param setName   The name of a new climber
     * @param setAge    The age of a new climber
     * @param setGender The gender of a new climber
     */
    public Climber(String setName, int setAge, String setGender)
    {
        name = setName;
        age = setAge;
        gender = setGender;
        climbedList = new ArrayList<Mountain>();
    }

    /**
     * Creates a new mountain which the climber has climbed and adds it to their climbed list
     * @param mountainName      The name of the mountain the climber had climbed
     * @param mountainHeight    The height (m) of the mountain the climber has climbed
     */
    public void addMountain(String mountainName, int mountainHeight)
    {
        Mountain toAdd = new Mountain(mountainName, mountainHeight);
        climbedList.add(toAdd);
    }
    
    
    /**
     * Adds a new mountain to the climbers climbed list
     * @param mountainClimbed   The mountain the climber has climbed
     */
    public void addMountainToList(Mountain mountainClimbed)
    {
        climbedList.add(mountainClimbed);
    }

    /**
     * Lists mountains and height that the climber has climbed
     * @return Returns an ArrayList of mountains the climber has climbed
     */
    public ArrayList<Mountain> listMountains() {
        return climbedList;
    }    

    /**
     * Calculates the average height of all Mountains a Climber has climbed
     * @return  The average height (m) of all the mountains the climber has climbed
     */
    public double averageHeight() {
        int totalHeight = 0;
        double averageHeight = 0;
        for (Mountain m : climbedList){
            totalHeight = totalHeight + m.getHeight();
        }
        averageHeight = (totalHeight/climbedList.size() );
        return averageHeight;
    }   

    /**
     * Get the highest mountain climbed OBJECT
     * @return  The highest mountain the climber has climbed
     */
    public Mountain climbersHighestMountain() {
        double maxHeight = 0;
        Mountain highestMountain = null;
        for (Mountain m : climbedList){
                if(m.getHeight() > maxHeight){
                maxHeight = m.getHeight();
                highestMountain = m;
            }
        }
        return highestMountain;
    }

    /**
     * Creates a list of mountains above a specified height (m)
     * @param aboveHeight           The height (m) at which mountains must be taller than to appear in the list
     * @return mountainsAboveHeight A list of mountains which are above the height specified in the aboveHeight parameter
     */
    public ArrayList listMountainAbove(int aboveHeight) {
        mountainsAboveHeight = new ArrayList<Mountain>();
        for (Mountain m : climbedList){
            if (m.getHeight() > aboveHeight){
                mountainsAboveHeight.add(m);
            }
        }
        return mountainsAboveHeight;
    }

    /**
     * Returns the name of the climber
     * @return  The climbers name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the age of the climber
     * @return  The climbers age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Returns the gender of the climber
     * @return  The climbers gender
     */
    public String getGender()
    {
        return gender;
    }

}
