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
            switch(MyWorld.level){
                case 1: Greenfoot.setWorld(new Level2());
                break;
                case 2: Greenfoot.setWorld(new Level3());
                break;
                case 3: Greenfoot.setWorld(new Level4());
                break;
                case 4: Greenfoot.setWorld(new StartScherm());
                break;
            }
        }
    }
    public Gewonnen()
    {
        setBackground("bg2(win).png");
        clearScreen();
    }
}
