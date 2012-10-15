package Cows;

/**
 * Representing the cows in a race
 * 
 * @author Timmy Carstensen
 * @version Version 1.00
 */
public class Cow
{
    // cows name
    private String name;
    // cows breed
    private String breed;
    // cows position
    private int position;

    /**
     * Creates a cow with name and breed.
     */
    public Cow(String name, String breed)
    {
        // cow is initialised with 3 parameters, position, name and breed.
        position = 0;
        this.name = name;
        this.breed = breed;
    }
    
    /**
     * Make a string with name and breed.
     * @return String - name and breed.
     */
    public String detail()
    {
        return "Name: " + name + ", Breed: " + breed;
    }
    
    /**
     * Cow's name
     * @return String - name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Cow's breed
     * @return String - breed
     */
    public String getBreed()
    {
        return breed;
    }
    
    /**
     * Increment cow's position by one. Cow gets closer to goal.
     */
    public void move()
    {
        position++;
    }
    
    /**
     * Give the cow's position.
     * @return int - position
     */
    public int getPosition()
    {
        return position;
    }
}
