import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrossingLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrossingLine extends Movers
{
    /**
     * Act - do whatever the CrossingLine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CrossingLine() {
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }
    
    public void act()
    {
        // Add your action code here.
        move(-1);
    }
}
