package dikuPlus;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    private Person ole, karl, nick, oleks;
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
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
        ole = new Person("Ole");
        karl = new Person("Karl");
        nick = new Person("Nick");
        oleks = new Person("Oleks");
        
        ole.requestFriendship(oleks);
        ole.requestFriendship(karl);
        
        ole.sendMessage(karl, "Hej Karl");
        karl.sendMessage(ole, "Hej Ole");
        
        ole.sendMessage(karl, "Hvordan går det?");
        karl.sendMessage(ole, "Det går godt, hvad med dig?");
        
        ole.sendMessage(karl, "Det går også godt, vi tales ved");
        karl.sendMessage(ole, "Det var godt at høre, vi tales ved!");
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
    public void testGetName()
    {
        assertEquals("Nick", nick.getName());
    }
    
    @Test
    public void testRequestFriendship()
    {
        assertEquals(ole.isFriends(ole, karl), true);
    }
    
    @Test
    public void testIsEnemiesWithOleks()
    {
        assertEquals(ole.isFriends(ole, oleks), false);
        assertEquals(ole.isEnemies(ole, oleks), true);
    }
    
    @Test 
    public void testSendMessage(){
        assertEquals(karl.getMessageFromWall(0), "Hej Karl");
        assertEquals(ole.getMessageFromWall(0), "Hej Ole");
    }
    
    @Test
    public void testSendMessageToOleks()
    {
        ole.sendMessage(oleks, "Oleks vi er fjender, så du ser ikke denne besked!");
        assertNull(oleks.getMessageFromWall(0), null);
    }
    
    /*
     * Print ole's and karl's conversation out from each their wall.
     */
    @Test
    public void testAddWall()
    {
        System.out.println("Oles wall:");
        ole.printWall();
        System.out.println("Karls wall:");
        karl.printWall();
    }
    
    @Test
    public void testGetFriends()
    {
        ArrayList<Person> friends = ole.getFriends();
        assertEquals(friends.get(0), karl);
    }
    
    @Test
    public void testGetEnemies()
    {
        ArrayList<Person> enemies = ole.getEnemies();
        assertEquals(enemies.get(0), oleks);
    }
    
    
}


