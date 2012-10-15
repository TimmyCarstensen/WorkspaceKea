package Cows;

import java.util.*;

/**
 * Representing the race track.
 * 
 * @author Timmy Carstensen
 * @version Version 1.00
 */
public class RaceTrack
{
    // Racetracks length
    private int length;
    // The four competing cows.
    private Cow cow0;
    private Cow cow1;
    private Cow cow2;
    private Cow cow3;
    // The cow who wun the race
    private Cow winner;
    
    /**
     * Creates a Racetrack for cows to race.
     * @param int - length of racetrack.
     */
    public RaceTrack(int length)
    {
        // length cannot be negative, if it is, then it become length 10.
        if (length > 0){
            this.length = length;
        } else
        {
            this.length = 10;
        }
        // Cows is created.
        cow0 = new Cow("Jylle","Jysk Kvæg");
        cow1 = new Cow("Trille","Vælte Køer");
        cow2 = new Cow("Tamos","Tamkvæg");
        cow3 = new Cow("Rødgus","Røde ko");
    }

    /**
     * Make a move for one of the cows.
     */
    public void advance()
    {
        // Randomnumber makes sure that a random cow is chosen to move.
        int ranNumber = new Random().nextInt(4);
        switch(ranNumber)
        {
            case 0: cow0.move();
            break;
            case 1: cow1.move();
            break;
            case 2: cow2.move();
            break;
            case 3: cow3.move();
            break;
        }
        
        
    }
    
    /**
     * Winning cow is selected by if statments
     */
    public void winner()
    {
        if (cow0.getPosition() == length){
            winner = cow0;
        } else if (cow1.getPosition() == length){
            winner = cow1;
        } else if (cow2.getPosition() == length){
            winner = cow2;
        } else if (cow3.getPosition() == length){
            winner = cow3;
        }
        
    }
    
    /**
     * @return Cow - winning cow.
     */
    public Cow getWinner()
    {
        return winner;
    }

}

