
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public int levens = 3;
    public boolean inlevel = false;
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

        velocityX *= drag;
        velocityY += acc; 
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                if (levens > 1) {
                    this.setLocation(300, 200);
                    levens --;
                }
                else{
                    Greenfoot.stop();
                    return;
                }
            }

        }
    }
        public void handleInput() {
            if (Greenfoot.isKeyDown("space") && onGround() == (true)) {
                velocityY = -13;
            }

            if (Greenfoot.isKeyDown("left")) {
                velocityX = -7.5;
            } else if (Greenfoot.isKeyDown("right")) {
                velocityX = 7.5;
            }
        }

        public int getWidth() {
            return getImage().getWidth();
        }

        public int getHeight() {
            return getImage().getHeight();
        }
    boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
        return under != null;
    }
    
    }
    