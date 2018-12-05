
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public static int levens = 2;
    public static boolean inLevel = false;
    public static boolean inCave = false;
    public static boolean alive = true;
    public static boolean win = false;
    public static boolean touchingEnemy = false;
    public static boolean levenLvl1 = true;
    Enemy en;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_right.png");
    }

    public void touchingLevens(){
        if(isTouching(Levens.class)){
            levenLvl1 = false;
            levens ++;
            removeTouching(Levens.class);
        }
    }

    @Override
    public void act() {
        touchingLevens();
        handleInput();
        backgroundChange();
        velocityX *= drag;
        velocityY += acc; 
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        if(isTouching(Enemy.class)){
            removeTouching(Enemy.class);
            win = true;
        }
        if(isTouching(WaterTile.class)){
            inLevel = false;
            if (levens > 1) {
                touchingEnemy = true;
                levens --;
            }
            else{
                en.enemyWon = true;
                levens = 3;
                return;
            }   
        }
        /*for (Actor enemy : getIntersectingObjects(Enemy.class)) {
        if (enemy != null isTouching(Enemy.class) == true) {
        if (levens > 1) {
        this.setLocation(300, 200);
        levens --;
        }
        else{
        Greenfoot.stop();
        return;
        }
        }

        //}*/
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space") && onGround() == (true)) {
            velocityY = -13;
        }

        if (Greenfoot.isKeyDown("left")) {
            velocityX = -5.7;
            setImage("p1_left.png");
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 5.7;
            setImage("p1_right.png");
        }
        if(Greenfoot.isKeyDown("l")){
            System.out.println(getX() + ", " + getY());
            Greenfoot.delay(10);
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

    private void backgroundChange(){
        if(getY() > 400 || getX() > 1100){
            inCave = true;
        }
        else{
            inCave = false;
        }
    }

    boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
        return under != null;
    }

}
 