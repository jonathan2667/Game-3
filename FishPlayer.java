import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fishPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FishPlayer extends Solve
{
    /**
     * Act - do whatever the fishPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.

     */

    public int distance = 0;
    public void act()
    {
        setMovement(-30, 30);
        checkMotion(1);
    }

    
}
