import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gewonnen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gewonnen extends MyWorld
{

    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Level2());
        }
    }
    public Gewonnen()
    {
        setBackground("bg2(win).png");
        clearScreen();
    }
}
