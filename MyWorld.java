import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1); 
        prepare();
        ShipPlayer mainPlayer = new ShipPlayer();
        addObject(mainPlayer, getWidth() / 2, getHeight() / 2);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    GreenfootSound sound = new GreenfootSound("background_monkey.wav");
    boolean started = false;
    public void act() {
        if (started == false) {

            sound.play();
            started = true;
        }
    }


    private void prepare()
    {
        Plus plus = new Plus();  
        addObject(plus,889,141);

    }

}
