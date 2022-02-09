import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.util.Arrays;
/**
 * Write a description of class AdditionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdditionWorld extends World
{

    /**
     * Constructor for objects of class AdditionWorld.
     * 
     */

    FishPlayer fishPlayer = new FishPlayer();
    FishPlayer1 fishPlayer1 = new FishPlayer1();
    FishPlayer2 fishPlayer2 = new FishPlayer2();
    FishPlayer3 fishPlayer3 = new FishPlayer3();

    int timeLeft = 60;
    
    int score;
    int wrongAnswers;
    

    Date time1 = new Date();

    int initial = time1.getSeconds();

    int count = 0;

    boolean removedCrossingLine = false;
    boolean removedCrossingLine1 = false;

    boolean addedCrossingLine = false;
    boolean declaredWinner = false;
    
    int[] arrOrdered = { 0, 0, 0, 0};
    
    int firstOperand[] = new int[100];
    int secondOperand[] = new int[100];
    int thirdOperand[] = new int[100];
    int index = 0;
    
    boolean foundPosition = false;

    CrossingLine crossingLine = new CrossingLine();
    CrossingLine crossingLine1 = new CrossingLine();

    public AdditionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(1100, 600, 1);
        setPaintOrder(Writing.class, Solve.class, CrossingLine.class);
        prepare();
    }

    public void act() {

        if (count == 0) {     
            Instructions1 instructions1 = new Instructions1();
            addObject(instructions1, 580, 300);

            addObject(crossingLine, 230, 330);
            Greenfoot.delay(150);
            Greenfoot.playSound("startRace.wav");
            Greenfoot.delay(150);

            removeObject(instructions1);

        }
        if (removedCrossingLine == false)
            checkRemoveBanter();
        if (removedCrossingLine1 == false && addedCrossingLine == true)
            checkRemoveBanter1();
            
        count++;
        checkAddBanter();
        declareWinner();
        
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    public void findOutPositionsPlayers() {
        int fish1_X = fishPlayer.getX();
        int fish2_X = fishPlayer1.getX();
        int fish3_X = fishPlayer2.getX();
        int fish4_X = fishPlayer3.getX();
        int[] arr1 = {fish1_X, fish2_X, fish3_X, fish4_X};
        int[] arr= {fish1_X, fish2_X, fish3_X, fish4_X};
        
        
        Arrays.sort(arr);
  
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr1[j] == arr[i])
                    arrOrdered[i] = j;
            }
        }
        
        for (int i = 0; i < 4; i++)
            System.out.print("\norder"  + arrOrdered[i] + "\n");
    }
        
    
    public void findOutPositions() {
        if (declaredWinner == true && foundPosition == false) {
            foundPosition = true;
            findOutPositionsPlayers();
        }
    }
    
    public void declareWinner() {
        count++;
        if (count > 1000) {
            if (!declaredWinner) {
                if (fishPlayer.touching() ) {
                    Greenfoot.playSound("clap.wav");
                    declaredWinner = true;

                    Winner winner  = new Winner();
                    addObject(winner, fishPlayer.getX(), fishPlayer.getY());
                    findOutPositions();
                    Greenfoot.delay(100);
                }
                if ( fishPlayer1.touching()  ) {
                    Greenfoot.playSound("clap.wav");
                    declaredWinner = true;

                    Winner winner  = new Winner();
                    addObject(winner, fishPlayer1.getX(), fishPlayer1.getY());
                    findOutPositions();
                    Greenfoot.delay(100);
                }
                if ( fishPlayer2.touching()  ) {
                    Greenfoot.playSound("clap.wav");
                    declaredWinner = true;

                    Winner winner  = new Winner();
                    addObject(winner, fishPlayer2.getX(), fishPlayer2.getY());
                    findOutPositions();
                    Greenfoot.delay(100);
                }
                if ( fishPlayer3.touching() ) {
                    Greenfoot.playSound("clap.wav");
                    declaredWinner = true;

                    Winner winner  = new Winner();
                    addObject(winner, fishPlayer3.getX(), fishPlayer3.getY());
                    findOutPositions();
                    Greenfoot.delay(100);
                }
            }
        }
    }  

    public void checkAddBanter() {
        Date newTime1 = new Date();

        if (newTime1.getSeconds() != initial) {
            timeLeft--;
            initial = newTime1.getSeconds();

            if (timeLeft < 18 && !addedCrossingLine) {
                addObject(crossingLine1, getWidth(), 330);
                addedCrossingLine = true;
            }
        }
    }

    public void checkRemoveBanter() {
        if (crossingLine.getX() < 1) {
            removeObject(crossingLine);
            removedCrossingLine = true;
        }            
    }

    public void checkRemoveBanter1() {
        if (crossingLine1 != null) {
            if (crossingLine1.getX() < 1) {
                removeObject(crossingLine1);
                removedCrossingLine1 = true;
                
                Greenfoot.delay(60);
                
                System.out.print("\n");
                for (int i = 0; i < index; i++)
                    System.out.print(firstOperand[i] + " ");
                System.out.print("\n");
                for (int i = 0; i < index; i++)
                    System.out.print(secondOperand[i] + " ");
                System.out.print("\n");
                for (int i = 0; i < index; i++)
                    System.out.print(thirdOperand[i] + " ");
                    
                Greenfoot.setWorld(new WinnersAdditionWorld(arrOrdered,score, wrongAnswers, firstOperand, secondOperand, thirdOperand, index));
            }
        }            
    }

    private void prepare()
    {

        DropMovers dropMovers = new DropMovers();
        addObject(dropMovers,934,117);
        DropMovers dropMovers2 = new DropMovers();
        addObject(dropMovers2,707,71);
        DropMovers dropMovers3 = new DropMovers();
        addObject(dropMovers3,168,164);
        DropMovers dropMovers4 = new DropMovers();
        addObject(dropMovers4,87,361);
        DropMovers dropMovers5 = new DropMovers();
        addObject(dropMovers5,167,539);
        DropMovers dropMovers6 = new DropMovers();
        addObject(dropMovers6,348,513);
        DropMovers dropMovers7 = new DropMovers();
        addObject(dropMovers7,684,572);
        DropMovers dropMovers8 = new DropMovers();
        addObject(dropMovers8,984,531);
        DropMovers dropMovers9 = new DropMovers();
        addObject(dropMovers9,935,362);
        DropMovers dropMovers10 = new DropMovers();
        addObject(dropMovers10,740,219);
        DropMovers dropMovers11 = new DropMovers();
        addObject(dropMovers11,695,349);

        addObject(fishPlayer,156,487);
        addObject(fishPlayer1,155,362);
        addObject(fishPlayer2,154,245);
        addObject(fishPlayer3,151,144);

        Score score = new Score();
        addObject(score, 100, 80);

        TimeLeft timeLeft = new TimeLeft();
        addObject(timeLeft, 1000, 80);

        Timer timer = new Timer();
        addObject(timer,950,82);

        Equations equations = new Equations();
        addObject(equations, 880, 450);

        Squares1 squares1 = new Squares1("" + 1, "white-key.jpeg", "white-key-down.jpeg", ""+0, 1);
        addObject(squares1, 710, 540);

        Squares2 squares2 = new Squares2("" + 2, "white-key.jpeg", "white-key-down.jpeg",""+ 0, 2);
        addObject(squares2, 820, 540);

        Squares3 squares3 = new Squares3("" + 3, "white-key.jpeg", "white-key-down.jpeg",""+ 0, 3);
        addObject(squares3, 930, 540);

        Squares4 squares4 = new Squares4("" + 4, "white-key.jpeg", "white-key-down.jpeg", ""+0, 4);
        addObject(squares4, 1040, 540);

        for (int i = 0; i < 4; i++) {
            OrderBoxes orderBoxes = new OrderBoxes( i + 1);
            addObject(orderBoxes,710 + i * 110,585);
        }

    }
}
