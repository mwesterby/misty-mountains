

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MountainTest.
 *
 * @author (Michael Westerby) 
 * @version 1.0 (08/11/2017)
 */
public class MountainTest
{
    /**
     * Default constructor for test class MountainTest
     */
    public MountainTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {

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
     * Tests the get name methods in the Mountain class
     */
    @Test
    public void testGetName()
    {
        Mountain mountain1 = new Mountain("Tall", 200);
        assertEquals("Tall", mountain1.getName());
    }

    /**
     * Tests the get height methods in the Mountain class
     */
    @Test
    public void testGetHeight()
    {
        Mountain mountain2 = new Mountain("Tall2", 400);
        assertEquals(400, mountain2.getHeight());
    }

}



