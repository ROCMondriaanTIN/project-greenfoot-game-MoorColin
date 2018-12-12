
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
        speed = 5;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
    }

    @Override
    public void act() {
        velocityY += acc; 
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        if(isTouching(DoorTile.class)){
            enemyWon = true;
        }
        applyVelocity(1);

        switch(MyWorld.level){

            case 1: 
            if(getX() >= 1044 && getX() <= 1047 || getX() >= 1527 && getX() <= 1530
            || getX() >= 2065 && getX() <= 2068 || getX() >= 2565 && getX() <= 2568
            || getX() >= 2784 && getX() <= 2787 || getX() >= 3200 && getX() <= 3203
            || getX() >= 3300 && getX() <= 3303 || getX() >= 4129 && getX() <= 4132){
                velocityY = -15;
            }
            if (getX() >= 3795 && getX() <= 3805 ){
                setLocation(3880 , 252);
            }
            break;

            case 2:
            if(getX() >= 872 && getX() <= 875 || 
            getX() >= 1265 && getX() <= 1268 || 
            getX() >= 1617 && getX() <= 1620 || getX() >= 2011 && getX() <= 2014 || 
            getX() >= 2307 && getX() <= 2310 || getX() >= 2729 && getX() <= 2732 || 
            getX() >= 3467 && getX() <= 3470 || getX() >= 3826 && getX() <= 3829){
                velocityY = -15;
            }
            break;

            case 3:
            if(getX() >= 390 && getX() <= 393 || getX() >= 940 && getX() <= 943  
            || getX() >= 1378 && getX() <= 1381 || getX() >= 1952 && getX() <= 1955
            || getX() >= 2194 && getX() <= 2197 || getX() >= 2550 && getX() <= 2553
            || getX() >= 2796 && getX() <= 2799 || getX() >= 3045 && getX() <= 3048
            || getX() >= 3339 && getX() <= 3343 || getX() >= 3572 && getX() <= 3575
            || getX() >= 3809 && getX() <= 3812 || getX() >= 4046 && getX() <= 4049){
                velocityY = -15;
            }
            break;

            case 4:
            if(getX() >= 406 && getX() <= 409 || getX() >= 915 && getX() <= 918  
            || getX() >= 1296 && getX() <= 1299 || getX() >= 1677 && getX() <= 1680 
            || getX() >= 2195 && getX() <= 2197 || getX() >= 2506 && getX() <= 2509
            || getX() >= 3219 && getX() <= 3222 || getX() >= 3525 && getX() <= 3528
            || getX() >= 3836 && getX() <= 3839){
                velocityY = -15;
            }
            break;

        }

    }
}
