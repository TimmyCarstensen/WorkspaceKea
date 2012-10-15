package dikuPlus;


/**
 * 
 * 
 * @author Timmy Carstensen
 * @version 1.00
 */
public class Simulation
{
    private DikuPlus network;
    private Person ole, karl, oleks, nick;
    
    public static void main(String[] args)
    {
        new Simulation();
    }
    
    public Simulation ()
    {
        this.network = new DikuPlus();
        this.generatePeople();
        this.makeFriends();
        this.addPeopleToTheNetwork(new Person[]{ ole, karl, oleks, nick });
        this.makeConversation();
    }
    
    private void generatePeople(){
        oleks = new Person("Oleks");
        ole = new Person("Ole");
        karl = new Person("Karl");
        nick = new Person("Nick");
    }
    
    private void makeFriends(){
        ole.requestFriendship(karl);
        ole.requestFriendship(oleks);
        ole.requestFriendship(nick);
    }
    
    private void addPeopleToTheNetwork(Person[] people){
        for(Person person : people){
            network.addPerson(person);
        }
    }
    
    private void makeConversation(){
        this.ole.sendMessage(this.karl, "How's it going?");
        this.karl.sendMessage(this.ole, "All good!");
        
        this.ole.sendMessage(this.karl, "Anything interesting going on?");
        this.ole.sendMessage(this.nick, "Anything interesting going on?");
        
        this.karl.sendMessage(this.ole, "Yes!");
        this.nick.sendMessage(this.ole, "No.");
        
        this.ole.sendMessage(this.karl, "We should meet soon!");
        this.ole.sendMessage(this.nick, "We should meet soon!");
        
    }
    
    
    
}
