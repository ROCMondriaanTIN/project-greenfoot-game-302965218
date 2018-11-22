
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
    private boolean drown;
    private boolean inWater;

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
        
        for (Actor Spikes : getIntersectingObjects(Spikes.class)){
            if (Spikes !=null){
                getWorld().removeObject(this);
                return;
            }
        }
        for (Actor Water : getIntersectingObjects(Water.class)){
            if (Water !=null){
                getWorld().removeObject(this);
                break;
            }
        }
    }
    public boolean onGround (){
        if (drown == true ){
       Actor under = getOneObjectAtOffset (0,getImage().getHeight()/2,Tile.class);
       return under == null;}
        else {
            Actor under = getOneObjectAtOffset(0,getImage().getHeight()/2,Tile.class);
            return under!= null;
        }
    }
    public boolean inWater(){
        Actor ignore = getOneObjectAtOffset(0,getImage().getHeight()/2,Tile.class);
        return ignore != null;
    }
    public void handInput(){
        if (Greenfoot.isKeyDown("W")){
            if (onGround ()==true){
                if (inWater()!=true){
                    velocityY=4;
                    drown= true;}
                else {
                    velocityY=-17;
                }
            }
    }
   
    if(Greenfoot.isKeyDown("a")){
        velocityX=-6;
        if (velocityY!=0){
            setImage("p1_jumpB.png");
        }
    }
}
    public String Inspect()
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
        if (Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")) {
            velocityY = -12;
        }else if (Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")) {
            velocityY = 12;
        }

        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            velocityX = -10;
        } else if (Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")) {
            velocityX = 10;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
