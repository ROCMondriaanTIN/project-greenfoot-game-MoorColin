
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public static int levens = 3;
    public boolean inlevel = false;
    public static boolean inCave = false;
    public static boolean alive = true;
    
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }

    @Override
    public void act() {
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
                velocityX = -5.5;
            } else if (Greenfoot.isKeyDown("right")) {
                velocityX = 5.5;
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
    