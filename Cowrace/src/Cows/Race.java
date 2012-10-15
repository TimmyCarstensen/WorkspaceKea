package Cows;

/**
 * Representing the actual race.
 * 
 * @author Timmy Carstensen
 * @version Version 1.00
 */
public class Race
{
    private static RaceTrack race;
    // Cows speech
    private static Cowsay cowsay;
    
    /**
     * Creat a sample race of length 10.
     */
    public static void main(String[] args){
        race = new RaceTrack (10);
        cowsay = new Cowsay();
        run();
    }

    /**
     * Run a race, finally a cow wins and cows winning speech is printed to the terminal.
     */
    public static void run()
    {
        // Loop that take turns until winner is found.
        while (race.getWinner() == null){
            race.advance();
            race.winner();
        }
        // Cows winning speech
        cowsay.display("I, " + race.getWinner().getName() + ", a(n) " +
        race.getWinner().getBreed() + ", won the race");
    }
}
