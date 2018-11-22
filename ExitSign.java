import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitSign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitSign extends Tile
{
    int level = 1;
    /**
     * Act - do whatever the ExitSign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ExitSign(String images,int width, int heigth ){
        super(images,width,heigth);
    }
    
    public ExitSign(String param1, int param2, int param3, int level){
        super(param1, param2, param3);
        this.level = level;
    
    
    }
    
    public void act() 
    {
       
       for (Actor hero  : getIntersectingObjects(Hero.class)) {
            if (hero!= null) {
                if(level ==144){
               MyWorld2 w2 = new MyWorld2();
                Greenfoot.setWorld(w2);
                break;
            }
            if(level ==145){
               MyWorld3 w3 = new MyWorld3();
                Greenfoot.setWorld(w3); 
                break;
            }
            if(level == 146){
            MyWorld4 w4 = new MyWorld4();
                Greenfoot.setWorld(w4);
                break;
            }
        }
    }    
}}
