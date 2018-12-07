
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class MyWorld extends World {

    private CollisionEngine ce;
    Enemy en;    
    public static int level;

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
        if(Hero.win == true){
            Hero.win = false;
            Greenfoot.setWorld(new Gewonnen());
        }
        if(Greenfoot.isKeyDown("enter")){
            Hero.levens = 2;
            Greenfoot.setWorld(new Level1());
        }
    }

    public MyWorld() {
        super(1000, 800, 1, false);
        Hero.inLevel = false;
        setBackground("ssChase.png");
        Greenfoot.start();
    }

    public void isDead(){

        if(Hero.touchingEnemy == true){
            Hero.touchingEnemy = false;
            clearScreen();
            levelGenerator();
        }
        
        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
       

    }
    public static void levelGenerator(){
        switch(level){
            case 1:
            Greenfoot.setWorld(new Level1());
            break;
            case 2:
            Greenfoot.setWorld(new Level2());
            break;
            case 3:
            Greenfoot.setWorld(new Level3());
            break;
            default:
            break;
        }
    }
    private void backgroundChange(){
        if(level == 3){
            setBackground("bglvl3.png");
        }
        else if(Hero.inCave == true && Hero.inLevel == true ){
            setBackground("castleCenter2.png");
            //System.out.println("1: " + Hero.inCave);
        }
        else if(Hero.inCave == false && Hero.inLevel == true){
            setBackground("bg.png");
        }
        else{
            this.setBackground("ssChase.png");
        }
    }

    public void hud(){
        if(Hero.inLevel == true){
            for (int i = 0; i < Hero.levens; i ++){
                addObject(new NewHud_p1(),(50 + (i * 15)),40);
            }
        }
    }   

    public void hudUpdate(){
        if(getObjects(NewHud_p1.class).size() != Hero.levens){
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
