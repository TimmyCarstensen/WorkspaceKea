package dikuPlus;

/**
 * Contain a message.
 */
public class Message{
    private String message;
    private Person person;
    private Person author;
    /**
     * 
     */
    public Message(Person person, String message, Person author)
    {
        this.person = person;
        this.message = message;
        this.author = author;
    }
    
    public Person getAuthor(){return author;}
    public Person getPerson(){return person;}
    public String getMessage(){ return message;}
}