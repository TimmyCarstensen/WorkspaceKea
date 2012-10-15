package dikuPlus;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MessageTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MessageTest
{
    private Message message;
    private Person ole,karl;
    /**
     * Default constructor for test class MessageTest
     */
    public MessageTest()
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
        ole = new Person("ole");
        karl = new Person("karl");
        message = new Message(ole, "Hej med dig ole!", karl);
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
    public void testGetAuthor(){
        assertEquals(karl, message.getAuthor());
    }
    
    @Test
    public void testGetMessage(){
        assertEquals("Hej med dig ole!", message.getMessage());
    }

    @Test
    public void testGetReceiver()
    {
        assertEquals(ole, message.getPerson());
    }
}

