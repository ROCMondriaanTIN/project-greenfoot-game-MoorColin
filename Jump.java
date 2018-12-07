import greenfoot.*;

/**
 * Write a description of class Jump here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jump extends Mover
{
    public Jump(){
        setImage("gemYellow.png");
    }
    public void act() 
    {
        applyVelocity();
    }    
}
