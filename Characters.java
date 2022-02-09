import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Charactes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Characters extends Actor
{
    /**
     * Act - do whatever the Charactes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int position;
    int degrees;
    int count;
    
    boolean down = false;
    
    static int postionNew;
    
    public Characters(int position, String imageName) {
        setImage(imageName);
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
        this.position = position;
        
    }
    
    public void act()
    {
        // Add your action code here.
        count++;
        if (count % 3 == 0)
            setMovement(-10, 10);
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("" + position)) {
            postionNew = position;
            ((SelectPerson1)getWorld()).fishNumberChosen = position;
            Greenfoot.setWorld(new AdditionWorld());
        }
    }
    
    public static int selectedPerson() {
        return postionNew;
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
