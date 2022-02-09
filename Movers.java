import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;

/**
 * Write a description of class Movers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movers extends Actor
{
   
    int degrees = 0;
    boolean down = false;
    boolean goFront =true;
    int speed = 3;
    /**
     * Act - do whatever the Movers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the enviroment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public boolean touching()
    {
        return isTouching(CrossingLine.class);
    }

    public void checkMotion(int fishNumber) {
        Date time = new Date();
        
        int speedAhead = Greenfoot.getRandomNumber(3);
        int speedBackwards = Greenfoot.getRandomNumber(2);
        
        if (time.getSeconds() == 34 && fishNumber == 1) {
            motionAhead(speedAhead);
        } 
        if (time.getSeconds() == 56 && time.getSeconds() == 13 && fishNumber == 2) {
            motionAhead(speedAhead);
        } 
        if (time.getSeconds() == 15 && time.getSeconds() == 10  && fishNumber == 3) {
            motionAhead(speedAhead);
        } 
        if (time.getSeconds() == 7 && time.getSeconds() == 45 && time.getSeconds() == 57 && time.getSeconds() == 15  &&fishNumber == 4) {
            motionAhead(speedAhead);
        } 
        
        if (time.getSeconds() == 0 && fishNumber == 1) {
            motionBackwards(speedBackwards);
        } 
        if (time.getSeconds() == 29 && fishNumber == 2) {
            motionBackwards(speedBackwards);
        } 
        if (time.getSeconds() == 38 && fishNumber == 3) {
            motionBackwards(speedBackwards);
        } 
        if (time.getSeconds() == 44 && fishNumber == 4) {
            motionBackwards(speedBackwards);
        } 
    }

    
    public void motionAhead(int speed1) {
        int x = getX();
        int y = getY();

        setLocation(x + speed1, y);
    }
    
    
    public void motionBackwards(int speed1) {
        int x = getX();
        int y = getY();

        setLocation(x - speed1, y);
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

    public void wrapAtEdge() {
        int x = getX();
        int y = getY();
        int worldWidth = getWorld().getWidth() - 1;
        int worldHeight = getWorld().getHeight() - 1;
        if (x >= worldWidth) {
            setLocation(1, y);            
        }
        if (x <=  0) {
            setLocation(worldWidth - 1, y);            
        }
        if (y >= worldHeight) {
            setLocation(x, 1);            
        }
        if (y <=  0) {
            setLocation(x, worldWidth - 1);            
        }
    }
    
    public void wrapAtEdgeSpecific(int min, int max) {
        int x = getX();
        int y = getY();
        
        if (goFront) {
            setLocation(x + speed, y);
            if (x > max)
                goFront = false;
        }
        else {
            setLocation(x - speed, y);
            if (x < min)
                goFront = true;
        }
        
    }
}

