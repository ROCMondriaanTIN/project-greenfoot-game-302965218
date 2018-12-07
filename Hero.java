
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
    int frame = 1;
    int animationTimer = 0;
    int animationTimerFrame = 10;
    int kleur = 1;
    int direction = 2;
    int doubleJump = 0;
    
     public boolean left=true;
    public boolean mirror=true;
    Scorebord sb;
int spring = -16;
    
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }
 public void Enemy(){

        switch(frame){
            case 1:
            setImage("p1_walk01.png");
            break;
            case 2:
            setImage("p1_walk02.png");
            break;
            case 3:
            setImage("p1_walk03.png");
            break;
            case 4:
            setImage("p1_walk04.png");
            break;
            case 5 :
            setImage("p1_walk05.png");
            case 6 :
            setImage("p1_walk06.png");
            break;
            case 7:
            setImage("p1_walk07.png");
            break;
            case 8 :
            setImage("p1_walk08.png");
            case 9 :
            setImage("p1_walk09.png");
            break;
            case 10:
            setImage("p1_walk10.png");
            break;
            case 11:
            setImage("p1_walk11.png");

            frame=0;
            break;   
        }
        frame++;
        mirrorImage();}
            public void mirrorImage(){
        if (mirror && left){ 
            getImage().mirrorHorizontally();
        }
        else if (!mirror && left){
            getImage().mirrorHorizontally();
        }
    }
    @Override
    public void act() {
       handInput();
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
     boolean onGround(){Actor under = getOneObjectAtOffset(0,getImage().getHeight()/2, Tile.class);
        return under != null;}
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
        
        if ((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("space"))&&onGround() == true) {
            setImage("p1_jump.png");
            Greenfoot.playSound("jump.mp3");

            velocityY = spring;
              
        }
        if(onGround() == true){
            setImage("p1.png");}
        if ((Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s"))) {
            setImage("p1_duck.png");
            velocityX =2;
            
        }
        if((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("space"))){
            setImage("p1.png");
            }
                if ((Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a"))) {

            velocityX = -10;  
            left=true;
            Enemy();
        }  if ((Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d"))) {
            velocityX =10;
           
            Enemy();
            left=false;
        }
        
        
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
    
    




    public void animateJump() {

        if (velocityY != 0) {

            setImage("alien" + kleur + "_jump" + direction + ".png");

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
