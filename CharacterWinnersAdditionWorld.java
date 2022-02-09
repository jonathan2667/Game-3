import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterWinnersAdditionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterWinnersAdditionWorld extends Actor
{
    /**
     * Act - do whatever the CharacterWinnersAdditionWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int position;
    int count;
    int degrees;
    
    boolean down = false;
    
    public CharacterWinnersAdditionWorld(int position, String imageName) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()*13/10, getImage().getHeight()*13/10);
        this.position = position;
        
    }
    
    public void act()
    {
        // Add your action code here.
        count++;
        if (count % 3 == 0)
            setMovement(-10, 10);
    }
    public void setMovement(int start, int stop) {
        if (degrees == stop) {
            down = true;
        }
        if (degrees == start) {
            down = false;
        }
        if (down) {
            degrees--;
        }
        else {
            degrees++;
        }
        setRotation(degrees);
    }
}
