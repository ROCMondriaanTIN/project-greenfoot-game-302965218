
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
    int x = 63;
    int y = 33;
    
    Scorebord sb;

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
        opGrond();
        positie();
        checkpoint();
        getGoldCoin();
        velocityX *= drag;
        velocityY += acc;
        
        if(sb == null){
        sb= new Scorebord ();
        getWorld().addObject(sb,-10,-10);
      
        
        }
            
        
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                setLocation(250,1275);
                sb.HartjeErAf();
                break;
            }
        }
        
        for (Actor Spikes : getIntersectingObjects(Spikes.class)){
            if (Spikes !=null){
                //getWorld().removeObject(this);
                setLocation(250,1275);
                sb.HartjeErAf();
                return;
            }
        }
        for (Actor Water : getIntersectingObjects(Water.class)){
            if (Water !=null){
               // getWorld().removeObject(this);
               setLocation(250,1275);
               sb.HartjeErAf();
                break;
            }
        }
    }
    public String positie(){
    String k= "X"+getX()+" "+"Y"+getY();
    return k ;
    
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
         {
            if (opGrond ()==true)
              velocityY = -20;}
        }else if (Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")) {
            velocityY = 20;
        }

        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            velocityX = -15;
        } else if (Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")) {
            velocityX = 15;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
    public void checkpoint(){
      if (isTouching(Checkpoint.class)){
    x=getX();
    y=getY();
    }
}
    public void Spikes ()
    {if (isTouching (Spikes.class))
        {
            setLocation(x,y);                                                                                   
    }
    
    }
}
