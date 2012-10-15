package Cows;

/**
 * The cow speaks your input!
 * 
 * @author Timmy Carstensen
 * @version v 1.00
 */
public class Cowsay
{
     /**
     * Constructor for objects of class Cowsay
     */
    public Cowsay()
    {
    
    }
    
    /**
     * This method display what a cow say from the input String.
     * @param String - What the cow has to say.
     */
    public void display (String cowsay)
    {
        /* We have 3 if statements. 
         * First statement catches strings > 0 and <=80.
         * Secound statement catches strings > 80 and < 160.
         * Third statement catches strings >= 160.
         */
        if (cowsay.length() <= 75){
            
            drawLine((cowsay.length() + 2));
            System.out.println("< " + cowsay + " >");
            drawLine((cowsay.length() + 2));
            drawCow();
        } else if (cowsay.length() > 75 && cowsay.length() < 151){
            String line1 = cowsay.substring(0,75);
            String line2 = cowsay.substring(75, cowsay.length());
            String blank = "";
            // The loop create a amount of blank signs to fill secound line.
            for (int letter = 80 - (80 - line2.length()); letter < 75; letter++){
                blank = blank + " ";
            }
            
            //while loop omitted, look for in drawLine();
            drawLine(78);
            System.out.println("/ " + line1 + " \\");
            System.out.println("\\ " + line2 + blank + " /");
            drawLine(78);
            drawCow();
            
        } else if (cowsay.length() >= 151){
            String line1 = cowsay.substring(0,75);
            String line2 = cowsay.substring(75, 149);
            
            drawLine(78);
            System.out.println("/ " + line1 + " \\");
            // The star * show the some of the text has been omitted!
            System.out.println("\\ " + line2 + "* /");
            drawLine(78);
            drawCow();
        }
    }
     
    /**
     * Draw a lines used for print in display
     * @param int - endstate, how long must the line be.
     */
    private void drawLine(int endstate)
    {
        int counter = 0;
        String makeLine = "";
        // The loop create a line of 78 signs.
        while(counter < endstate){
            makeLine = makeLine + "-";
            counter++;
        }
        System.out.println(" " + makeLine);
    }
    
    /**
     * Draw a cow!
     */
    private void drawCow()
    {
        System.out.println("       \\    ^__^                    ");
        System.out.println("        \\   (xx)\\________          ");
        System.out.println("            (__)\\        )\\/\\     ");
        System.out.println("             U   ||----W |           ");
        System.out.println("                 ||     ||           ");
    }
}
