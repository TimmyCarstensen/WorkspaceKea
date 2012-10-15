package dikuPlus;

import java.util.ArrayList;

/**
 * Write a description of class DikuPlus here.
 * 
 * @author Timmy Carstensen 
 * @version 1.00
 */
public class DikuPlus
{
    private ArrayList<Person> persons;    

    /**
     * Creat a network
     */
    public DikuPlus()
    {
        persons = new ArrayList<Person>();
    }

    /**
     * 
     */
    public void addPerson(Person person)
    {
        persons.add(person);
    }
    
    public Person getPerson(int index)
    {
        Person person = null;
        if(index >= 0 && 0 < persons.size()){
            person = persons.get(index);
        }
        return person;
    }
    
    public ArrayList<Person> getPersons() {return persons;}    
    
    /**
     * 
     */
    public void removePersonWithName(String name)
    {
        for(int increment = 0; increment < persons.size(); )
        {
            String namep = persons.get(increment).getName();
            if (namep.equals(name))
            {
                persons.remove(increment);
                break;
            }
            increment++;
        }
    }
}
