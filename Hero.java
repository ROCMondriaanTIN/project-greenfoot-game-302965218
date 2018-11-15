
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private int goldcoin;

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
        getGoldCoin();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
    }
    
    public String Inspect ()
    {
        String Inspect="X:"+this.getX()+"Y:"+this.getY();
        return Inspect;
    }
    
    public int getGoldCoin()
    {
    if(isTouching(GoldCoin.class))
    {
    removeTouching(GoldCoin.class);
    goldcoin++;
    }
    return goldcoin;
    }
    
    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {
            velocityY = -20;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -2;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 2;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
