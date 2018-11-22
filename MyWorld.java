
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class MyWorld extends World {

    private CollisionEngine ce;
    Hero hr = new Hero();
    Enemy en;

    @Override
    public void act() {
        backgroundChange();
        hudUpdate();
        isDead();
        if(en.enemyWon == true){
            en.enemyWon = false;
            removeObjects(getObjects(Enemy.class));
            Greenfoot.setWorld(new Verloren());
        }
        if(hr.win == true){
            hr.win = false;
            Greenfoot.setWorld(new Gewonnen());
        }
        if(Greenfoot.isKeyDown("enter")){
            hr.levens = 2;
            Greenfoot.setWorld(new Level1());
        }
    }

    public MyWorld() {
        super(1000, 800, 1, false);
        hr.inLevel = false;
        this.setBackground("ssChase.png");
        Greenfoot.start();
    }

    public void isDead(){

            if(hr.touchingEnemy == true){
                hr.touchingEnemy = false;
                clearScreen();
                Greenfoot.setWorld(new Level1());
            }

    }

    private void backgroundChange(){
        if(hr.inCave == true && hr.inLevel == true){
            setBackground("castleCenter2.png");
            //System.out.println("1: " + hr.inCave);
        }
        else if(hr.inCave == false && hr.inLevel == true){
            setBackground("bg.png");
        }
        else{
            this.setBackground("ssChase.png");
        }
    }

    public void hud(){
        if(hr.inLevel == true){
            for (int i = 0; i < hr.levens; i ++){
                addObject(new NewHud_p1(),(50 + (i * 15)),40);
            }
        }
    }   

    public void hudUpdate(){
        if(getObjects(NewHud_p1.class).size() != hr.levens){
            removeObjects(getObjects(NewHud_p1.class));
            hud();
        }
    }

    public void clearScreen(){
        removeObjects(getObjects(Tile.class));
        removeObjects(getObjects(Hero.class));
        removeObjects(getObjects(Enemy.class));
    }
}
