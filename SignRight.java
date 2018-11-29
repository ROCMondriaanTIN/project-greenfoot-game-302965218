import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SignRight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class SignRight extends Tile
{int level =1;
    /**
     * Act - do whatever the SignRight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SignRight(String images,int width, int heigth ){
        super(images,width,heigth);
    }
    
    public  SignRight(String param1, int param2, int param3, int level){
        super(param1, param2, param3);
        this.level = level;
    
    
    }
    public void act() 
    {
       
       for (Actor BeginSchermHero  : getIntersectingObjects(BeginSchermHero.class)) {
            if ( BeginSchermHero!= null) {
                if(true){
              MyWorldBeginScherm bsh = new  MyWorldBeginScherm();
                Greenfoot.setWorld(bsh);
                break;
            }
        // Add your action code here.
        
    }}
}}

