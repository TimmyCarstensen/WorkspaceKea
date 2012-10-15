



/**
 * Write a description of class similation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Simulation
{
    private Simulation simula;
    private DikuPlus dikuplus;
    private Person ole;
    private Person karl;
    private Person oleks;
    private Person nick;
    
    public Simulation ()
    {
        dikuplus = new DikuPlus();
        
        oleks = new Person("Oleks");
        ole = new Person("Ole");
        karl = new Person("Karl");
        nick = new Person("Nick");
        
        dikuplus.addPerson(ole);
        dikuplus.addPerson(karl);
        
        ole.sendMessage(karl, "How are you doing?");
        
        ole.requestFriendship(karl);
        ole.requestFriendship(oleks);
        ole.requestFriendship(nick);
        
        ole.sendMessage(karl, "How are you doing?");        
        
        
        
        
        
        
    }
    
    public static void main(String[] args)
    {
        new Simulation();
    }
}
