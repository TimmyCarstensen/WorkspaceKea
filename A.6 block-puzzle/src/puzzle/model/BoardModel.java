package puzzle.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

import puzzle.model.direction.Direction;
import puzzle.model.notification.INotification;
import puzzle.model.notification.Restarted;
import puzzle.model.position.Position;
import puzzle.model.position.PositionFactory;

import diku.oopd.Observable;
import diku.oopd.Observer;
import java.util.Stack;

public class BoardModel extends
        Observable<INotification, Observer<INotification>>
{
    private static final int DEFAULT_NUMBER_OF_SLOTS_IN_A_ROW = 4;
    private static final String DEFAULT_PATH_TO_BACKGROUND_IMAGE = "./wrong.jpg";

    private static BoardModel instance;

    private String pathToBackgroundImage;
    private BufferedImage backgroundImage;

    private int numberOfSlotsRow;
    private int numberOfSlotsBoard;
    
    private int[] board;
    private int emptySlot;
    private Stack<Integer> moves;
    
    private BoardModel()
    {
        this.initializeSlotsWithNewNumberOfSlotsInARow(BoardModel.DEFAULT_NUMBER_OF_SLOTS_IN_A_ROW);
        this.pathToBackgroundImage = BoardModel.DEFAULT_PATH_TO_BACKGROUND_IMAGE;
        this.tryLoadBackgroundImage();
    }

    public static BoardModel initialize()
    {
        if (BoardModel.instance == null)
            BoardModel.instance = new BoardModel();
        return BoardModel.instance;
    }

    public static BoardModel getCurrent()
    {
        return BoardModel.instance;
    }

    /**
     * FÆRDIG, MANGLER KOMMENTARER!!!
     * @param newNumberOfSlotsInARow
     */
    private void initializeSlotsWithNewNumberOfSlotsInARow(
            int newNumberOfSlotsInARow)
    {
    	moves = new Stack<Integer>();
    	numberOfSlotsRow = newNumberOfSlotsInARow;
    	numberOfSlotsBoard = (numberOfSlotsRow * numberOfSlotsRow);
    	board = new int[numberOfSlotsBoard];
    	moves.push(emptySlot);
    	initializeSlots();
    }

    /**
     * FÆRDIG, MANGLER KOMMENTARER!!!
     */
    private void initializeSlots()
    {
    	for(int i = 0; i < numberOfSlotsBoard; i++ ){
    		board[i] = i;
    		if (i == board.length-1){
    			emptySlot = i;
    		}
    	}
    }

    public BufferedImage getBackgroundImage()
    {
        return this.backgroundImage;
    }

    /**
     * FÆRDIG!!!
     * @return Number of slots in a row.
     */
    public int getNumberOfSlotsInARow()
    {
        return numberOfSlotsRow;
    }
    
    /**
     * FÆRDIG!!!
     * @return number of slots.
     */
    public int getNumberOfSlots()
    {
        return numberOfSlotsBoard;
    }

    /**
     * FÆRDIG, MANGLER KOMMENTARER!!!
     * @return positionOfEmptySlot
     */
    public int getPositionOfEmptySlot()
    {
    	int value = 0;
    	while(board.length > value){
    		if(board[value] == emptySlot){
    			break;
    		}
    		value++;
        }
    	return value;
    }

    private void tryLoadBackgroundImage()
    {
        try
        {
            this.backgroundImage = ImageIO.read(new File(
                    this.pathToBackgroundImage));
        } catch (Exception e)
        {
            this.backgroundImage = null;
        }
    }

    public void changeBackgroundImage(String pathToNewImage)
    {
        this.pathToBackgroundImage = pathToNewImage;

        int currentWidthOfBackgroundImage = backgroundImage.getWidth();
        int currentHeightOfBackgroundImage = backgroundImage.getHeight();

        this.tryLoadBackgroundImage();
        this.scaleBackgroundImage(currentWidthOfBackgroundImage,
                currentHeightOfBackgroundImage);
        this.restart();
    }

    public void resizeBoard(int newSize)
    {
        int newNumberOfSlotsInARow = (int) Math.floor(Math.sqrt(++newSize));
        this.initializeSlotsWithNewNumberOfSlotsInARow(newNumberOfSlotsInARow);
        this.restart();
    }

    public void restart()
    {
        this.initializeSlots();
        this.notifyObservers(new Restarted());
        //this.performASequenceOfRandomMoves(); comment this in when you are don whit the view part
    }

    public void scaleBackgroundImage(int newWidth, int newHeight)
    {
        try
        {
            // TODO: by student
            this.backgroundImage = null;
        } catch (Exception e)
        {
            this.backgroundImage = null;
        }
    }

    public void performASequenceOfRandomMoves()
    {
        int numberOfMoves = this.getNumberOfSlots() * this.getNumberOfSlots();

        Direction choice;
        Direction[] choices;
        Position position;
        for (int i = 0; i < numberOfMoves; ++i)
        {
            position = PositionFactory.positionOfEmptySlot(this);
            choices = position.possibleMoves();
            choice = choices[new Random().nextInt(choices.length)];

            this.move(choice);
        }
    }

    /**
     * IKKE FÆRDIG, MANGLER KOMMENTARER!!!
     * @param direction
     * @return
     */
    public boolean move(Direction direction)
    {
        int newPosition = direction.getNextPosition(this);
        if (newPosition < 0){
        	return false;
        }
        return true;
        // TODO: by student!
    }

    public void undoAllMoves()
    {
        // TODO: by student
    }

    /** FÆRDIG, MANGLER KOMMENTARER!!!
     * 
     * @return boolean - whether the game is finished or not.
     */
    public boolean isInAWinningState()
    {
    	for(int i = 0; i < board.length; i++){
    		if(board[i] != i){
    			return false;
    		}
    	}
        return true;
    }
}