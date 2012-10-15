package dikuPlus;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * The test class DikuPlusTest.
 *
 * @author  Timmy
 * @version 1.0
 */
public class DikuPlusTest
{
    private DikuPlus dp;
    private Person ole;
    /**
     * Default constructor for test class DikuPlusTest
     */
    public DikuPlusTest()
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
        dp = new DikuPlus();
        ole = new Person("Ole");
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
    
    @Test
    public void testAddPerson()
    {   
        dp.addPerson(ole);
        assertEquals(dp.getPersons().get(0), ole);
    }
    
    @Test
    public void testRemovePersonWithName()
    {
        dp.addPerson(ole);
        dp.removePersonWithName("Ole");
        assertEquals(dp.getPerson(0), null);
    }
    
}
