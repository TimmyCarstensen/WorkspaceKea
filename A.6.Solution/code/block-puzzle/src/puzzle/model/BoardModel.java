package puzzle.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Stack;

import javax.imageio.ImageIO;

import puzzle.model.direction.Direction;
import puzzle.model.notification.MovedEmptySlot;
import puzzle.model.notification.Notification;
import puzzle.model.notification.Restarted;
import puzzle.model.notification.Winning;
import puzzle.model.position.Position;
import puzzle.model.position.PositionFactory;

import diku.oopd.Observable;
import diku.oopd.Observer;

public class BoardModel extends
        Observable<Notification, Observer<Notification>>
{
    private static final int DEFAULT_NUMBER_OF_SLOTS_IN_A_ROW = 4;
    private static final String DEFAULT_PATH_TO_BACKGROUND_IMAGE = "./wrong.jpg";
    private static final int EMPTY_SLOT = -1;

    private static BoardModel instance;

    private int numberOfSlotsInARow, numberOfSlots, positionOfEmptySlot;
    private int[] board;

    private Stack<Direction> historyOfMoves;

    private String pathToBackgroundImage;
    private BufferedImage backgroundImage;

    private BoardModel()
    {
        this.initializeSlotsWithNewNumberOfSlotsInArow(BoardModel.DEFAULT_NUMBER_OF_SLOTS_IN_A_ROW);
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

    private void initializeSlotsWithNewNumberOfSlotsInArow(
            int newNumberOfSlotsInARow)
    {
        this.numberOfSlotsInARow = newNumberOfSlotsInARow;
        this.numberOfSlots = newNumberOfSlotsInARow * newNumberOfSlotsInARow;
        this.initializeSlots();
    }

    private void initializeSlots()
    {
        this.historyOfMoves = new Stack<Direction>();
        this.positionOfEmptySlot = this.numberOfSlots - 1;
        this.initializeBoard();
        Runtime.getRuntime().gc();
    }

    private void initializeBoard()
    {
        this.board = new int[this.numberOfSlots];
        for (int i = 0; i < this.positionOfEmptySlot; ++i)
            this.board[i] = i;
        this.board[this.positionOfEmptySlot] = EMPTY_SLOT;
    }

    public BufferedImage getBackgroundImage()
    {
        return this.backgroundImage;
    }

    public int getNumberOfSlotsInARow()
    {
        return this.numberOfSlotsInARow;
    }

    public int getNumberOfSlots()
    {
        return this.numberOfSlots;
    }

    public int getPositionOfEmptySlot()
    {
        return this.positionOfEmptySlot;
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
        this.initializeSlotsWithNewNumberOfSlotsInArow(newNumberOfSlotsInARow);
        this.restart();
    }

    public void restart()
    {
        this.initializeSlots();
        this.notifyObservers(new Restarted());
        this.performASequenceOfRandomMoves();
    }

    public void scaleBackgroundImage(int newWidth, int newHeight)
    {
        try
        {
            BufferedImage rawImage = ImageIO.read(new File(
                    this.pathToBackgroundImage));

            this.backgroundImage = new BufferedImage(newWidth, newHeight,
                    rawImage.getType());

            Graphics2D graphics = this.backgroundImage.createGraphics();

            graphics.drawImage(rawImage, 0, 0, newWidth, newHeight, 0, 0,
                    rawImage.getWidth(), rawImage.getHeight(), null);

            graphics.dispose();
        } catch (Exception e)
        {
            this.backgroundImage = null;
        }
    }

    public void performASequenceOfRandomMoves()
    {
        int numberOfMoves = this.numberOfSlots * this.numberOfSlots;

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

    public boolean move(Direction direction)
    {
        int newPosition = direction.getNextPosition(this);
        if (newPosition < 0)
            return false;

        this.historyOfMoves.push(direction);

        int oldValue = this.board[newPosition];
        this.board[newPosition] = -1;
        this.board[this.positionOfEmptySlot] = oldValue;

        this.notifyObservers(new MovedEmptySlot(this.positionOfEmptySlot,
                newPosition));

        this.positionOfEmptySlot = newPosition;

        if (this.isInAWinningState())
            this.notifyObservers(new Winning());
        return true;
    }

    public void undoAllMoves()
    {
        Direction direction;
        int newPosition;
        while (!this.historyOfMoves.isEmpty())
        {
            direction = this.historyOfMoves.pop().opposite();

            newPosition = direction.getNextPosition(this);

            this.notifyObservers(new MovedEmptySlot(this.positionOfEmptySlot,
                    newPosition));

            this.positionOfEmptySlot = newPosition;
        }
    }

    public boolean isInAWinningState()
    {
        for (int i = 0; i < this.numberOfSlots - 1; ++i)
            if (this.board[i] != i)
                return false;
        return true;
    }
}
