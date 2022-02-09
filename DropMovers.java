import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DropMovers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropMovers extends Movers
{
    /**
     * Act - do whatever the DropMovers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DropMovers() {
        getImage().scale(getImage().getWidth()/10, getImage().getHeight()/10);
    }
    public void act()
    {
        // Add your action code here.
        move(-2);
        wrapAtEdge();
    }
}
