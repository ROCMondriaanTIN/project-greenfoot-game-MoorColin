import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartScherm extends MyWorld
{
    public void act(){
		if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Level1());
        }
    }
    public StartScherm()
    {
        setBackground("ssChase.png");
    }
}
