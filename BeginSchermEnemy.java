import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class BeginSchermEnemy extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private int goldcoin;
    private boolean drown;
    private boolean inWater;

    public BeginSchermEnemy() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("C:/Users/302965218/Pictures/PNG/Enemies/wormPink.png");
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

    }
    
        public boolean opGrond() {
        Actor onder = getOneObjectAtOffset(0, getImage().getHeight() / 2, Tile.class);
        Tile tile = (Tile) onder;
        return tile != null && tile.isSolid == true;
    }
    
    public boolean inWater(){
        Actor ignore = getOneObjectAtOffset(0,getImage().getHeight()/2,Tile.class);
        return ignore != null;
    }
    public void handInput(){
        if (Greenfoot.isKeyDown("W")){
            if (opGrond ()==true){
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
            setImage("p1.png");
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
        } //else if (Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")) {
            if (true){
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