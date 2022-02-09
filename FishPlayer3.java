import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fishPlayer3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FishPlayer3 extends Solve
{
    /**
     * Act - do whatever the fishPlayer3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setMovement(-10, 10);
        checkMotion(4);
        
    }
}
