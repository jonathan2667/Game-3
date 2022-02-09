import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionsSelectPlayer1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsSelectPlayer1 extends Writing
{
    /**
     * Act - do whatever the InstructionsSelectPlayer1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    
    public InstructionsSelectPlayer1(String text) {
        GreenfootImage image = new GreenfootImage(text, 65, Color.WHITE, new Color(0, 0, 0, 0 ), Color.BLACK); 
        setImage(image);
    }
    
    
    public void act()
    {
        wrapAtEdge(510, 600);
    }
    
    
}
