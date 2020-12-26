package com.mistymountains;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClubTest.
 *
 * @author (Michael Westerby) 
 * @version 1.0 (08/11/2017)
 */
public class ClubTest
{
    private Climber climber1;
    private Climber climber2;
    private Climber climber3;
    private Mountain mountain1;
    private Mountain mountain2;
    private Mountain mountain3;
    private Mountain mountain4;
    private Club club1;

    /**
     * Default constructor for test class ClubTest
     */
    public ClubTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     * Creates 3 new climbers and assigns 3 mountains to each.
     * A new club is then created and climbers 1 and 2 are added to it.
     */
    @Before
    public void setUp()
    {
        climber1 = new Climber("Jenny", 23, "Female");
        climber2 = new Climber("Jason", 35, "Male");
        climber3 = new Climber("Jack", 32, "Male");

        climber1.addMountain("Helvellyn", 950);
        climber1.addMountain("Scafell Pike", 978);
        climber1.addMountain("Skiddaw", 931);

        climber2.addMountain("Helvellyn", 950);
        climber2.addMountain("Skiddaw", 931);
        climber2.addMountain("Blencathra", 868);

        climber3.addMountain("Scafell Pike", 978);
        climber3.addMountain("Skiddaw", 931);
        climber3.addMountain("Blencathra", 868);

        club1 = new Club();
        club1.addClimber(climber1);
        club1.addClimber(climber2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }


    /**
     * Tests if the addClimber method adds a new climber (i.e. climber 3) to the list of climbers in the club
     */
    @Test
    public void testAddNewClimberToClub()
    {
        club1.addClimber(climber3);
        boolean climber3Added = false;
        int loopCount = 0;

        while(!climber3Added || loopCount >= club1.getClimbers().size()){
            for (int i =0; i < club1.getClimbers().size(); i++){
                loopCount = i;  
                if (club1.getClimbers().get(i).getName() == "Jack" && club1.getClimbers().get(i).getAge() == 32 && club1.getClimbers().get(i).getGender() == "Male"){
                    climber3Added = true;}
            }

        }
        assertEquals(true, climber3Added);
    }

    /**
     * Tests if the higherThanMethod returns a list of correct length, and only containing mountains of the right height, when searching for mountains over 930m
     * based on those stated in the test fixture climbers which are part of the club (i.e. climber1 and climber2)
     */
    @Test
    public void testListHigherThanLevel()
    {
        ArrayList<Mountain> higherThan;
        higherThan = club1.higherThanLevel(930);
        boolean mountainsHigherThan930 = false;
        boolean smallMountainFound = false;
        boolean correctMountainsFound = false;

        club1.higherThanLevel(930);
        int numberOfMountains = 0;

        if (higherThan.size() == 5){ //There are 5 mountains between the 2 climbers in the club which are higher than 930m
            mountainsHigherThan930 = true;
        }
        for (Mountain m : higherThan){
            if (m.getHeight() < 930){
                smallMountainFound = true;
            } 
        }
        if(mountainsHigherThan930 == true && smallMountainFound == false){
            correctMountainsFound = true;
        }

        assertEquals(true, correctMountainsFound);

    }
    /**
     * Tests if the HighestAverageInClub method returns the climber in the test fixtures (i.e. Jenny) who has
     * the highest average climbed height
     */
    @Test
    public void testHighestAverageInClub()
    {
        String highestAverageClimber = null;

        if (club1.highestAverageClimber().getName() == "Jenny"){ //Jenny is the climber with the higest average based on the test fixtures
            highestAverageClimber = "Jenny";
        }

        assertEquals("Jenny", highestAverageClimber);
    }

    /**
     * Tests if the highest mountain climbed by a member of the club from the test fixtures (i.e. Scafell Pike) is
     * the one returned when the highestMountainClimbed method is ran
     */
    @Test
    public void testHighestMountainInClub()
    {
        String highestMountain = null;

        if (club1.highestMountainClimbed().getName() == "Scafell Pike"){ //Scafell Pike is the highest mountain based on the test fixtures
            highestMountain = "Scafell Pike";
        }

        assertEquals("Scafell Pike", highestMountain);
    }
}



