import java.util.*;


/**
 * 
 */
public class Person{
    private String name;
    private Photograph photograph;
    private ArrayList<Person> friends;
    private ArrayList<Person> enemies;
    private ArrayList<String> wall;
    
    /**
     * Create a person in DikuPlus network.
     * @param name of person.
     */
    public Person(String name)
    {
        this.name = name;
        photograph = new Photograph(null);
        wall = new ArrayList<String>();
        friends = new ArrayList<Person>();
        enemies = new ArrayList<Person>();
    }
    
    public String getName(){ return name;}
    public Photograph getPhotograph(){return photograph;}
    public ArrayList<Person> getEnemies(){return enemies;}
    public ArrayList<Person> getFriends(){return friends;}
    private void addToWall(String message){wall.add(message);}
    private void addFriend(Person person){friends.add(person);}
    private void addEnemy(Person person){enemies.add(person);}
    
    public void changePhoto(String[] photograph){
        this.photograph.changePhotograph(photograph);
    }

    /**
     * @return 
     */
    public boolean requestFriendship(Person otherPerson){
        Message specialMessage = new Message(otherPerson, "/friend", this);
        return receiveMessage(specialMessage);

    }
    
    /**
     * @return boolean indicate whether message was rejected or accepted.
     */
    public boolean sendMessage(Person receiver, String message){
        return receiver.receiveMessage(new Message(receiver, message, this));
    }
    
    /**
     * @return boolean indicates whether message was rejected or accepted.
     */
    private boolean receiveMessage(Message message){
        Person receiver = message.getPerson();
        Person author = message.getAuthor();
        boolean accepted = false;
        // Make enemy med Oleks!
        if(receiver.getName().equals("Oleks") && !author.isEnemies(receiver)){
            addEnemy(receiver); // add friend to this person's friendlist
            receiver.addEnemy(author);
            
        } // Make friends.
        else if(message.getMessage().equals("/friend") && !isFriends(author, receiver)){ // make friends
            addFriend(receiver); // add friend to this person's friendlist
            receiver.addFriend(author); //add this person to receiver's friendlist.
            accepted = true;
        } // Receive a message from a friend.
        else if(isFriends(author, receiver)){//&& !message.getMessage().equals("/friend")){ 
            // Save the message to the persons wall.
            receiver.addToWall(message.getMessage());
            accepted = true;
        }
        return accepted;
    }
    
    /**
     * @param
     * @return true if to Person af friends
     */
    public boolean isFriends(Person author, Person receiver){
        boolean found = false;
        ArrayList AF = author.getFriends();
        ArrayList RF = receiver.getFriends();
        //Tjek the friendlist with otherPerson.
        for(int count = 0; count < friends.size(); count++){
        	// Compare this person with otherPerson.
            // if(author.getFriends().get(count).getName().equals(receiver.getName())){ 
                found = true;
                break;
            //}
        }

        return found;
    }
    
    private boolean isEnemies(Person otherPerson){
        boolean found = false;
        // Tjek the friendlist with otherPerson.
        for(int count = 0; count < enemies.size(); count++){
            // Compare this person with otherPerson.
            if(enemies.get(count).getName().equals(otherPerson.getName())){ 
                found = true;
                break;
            }
        }

        return found;
    }
    
    public void printWall(){
        for(int count = 0; count < wall.size(); count++){
            System.out.println(wall.get(count));
        }   
    }
}