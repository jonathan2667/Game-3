import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fishPlayer1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FishPlayer1 extends Solve
{
    /**
     * Act - do whatever the fishPlayer1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setMovement(-15, 15);
        checkMotion(2);
    }
}
