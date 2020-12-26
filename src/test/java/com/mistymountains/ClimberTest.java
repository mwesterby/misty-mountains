package com.mistymountains;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClimberTest.
 *
 * @author (Michael Westerby) 
 * @version 1.0 (08/11/2017)
 */
public class ClimberTest
{
    private Climber climber1;
    private Climber climber2;
    private Climber climber3;

    /**
     * Default constructor for test class ClimberTest
     */
    public ClimberTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     * Creates three new climbers.
     */
    @Before
    public void setUp()
    {
        climber1 = new Climber("Jenny", 23, "Female");
        climber2 = new Climber("Jason", 35, "Male");
        climber3 = new Climber("Jack", 32, "Male");
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
     * Tests if a new mountain is added to the climbers list of mountains by checking to see
     * if the new mountain's name and height appears in that climbers the list of mountains
     * (i.e. climbedList)
     */
    @Test
    public void testAddMountainToClimber()
    {
        climber1.addMountain("Tall", 200);
        boolean mountainMatch = false;

        while (!mountainMatch){
            for(Mountain m : climber1.listMountains()){
                if (m.getName() == "Tall" && m.getHeight() == 200){
                    mountainMatch = true;
                }
            }
        }
        assertEquals(true, mountainMatch);
    }

    /**
     * Tests if the get name method works by running this on test fixture "climber1"
     */
    @Test
    public void testClimberGetName()
    {
        assertEquals("Jenny", climber1.getName());
    }

    /**
     * Tests if the get age method works by running this on test fixture "climber1"
     */
    @Test
    public void testClimberGetAge()
    {
        assertEquals(23, climber1.getAge());
    }

    /**
     * Tests if the get gender method works by running this on test fixture "climber1"
     */
    @Test
    public void testClimberGetGender()
    {
        assertEquals("Female", climber1.getGender());
    }
}




