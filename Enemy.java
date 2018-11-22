

import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Enemy extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;
    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    public static boolean enemyWon = false;

    public Enemy() {
        super();
        setImage("p3_stand.png");
        walkRange = 170;
        firstAct = true;
        speed = 4;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
    }

    @Override
    public void act() {

        velocityX *= drag;
        velocityY += acc; 
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        if(isTouching(DoorTile.class)){
            enemyWon = true;
        }
        velocityX = speed;
        applyVelocity();
        if(getX() >= 1040 && getX() <= 1050 || getX() >= 1520 && getX() <= 1530 || 
        getX() >= 2060 && getX() <= 2070 || 
        getX() >= 2570 && getX() <= 2580 || getX() >= 2785 && getX() <= 2795
        || getX() >= 3235 && getX() <= 3245 || getX() >= 4125 && getX() <= 4135){
            velocityY = -15;
        }
        if (getX() >= 3795 && getX() <= 3805 ){
            setLocation(3880 , 252);
        }
    }
}
