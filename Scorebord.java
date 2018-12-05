import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Scorebord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scorebord extends Actor
{ int levens = 3;
    ArrayList<Leven> hartje =new ArrayList<Leven>();
    /**
     * Act - do whatever the Scorebord wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       LatenZien();
    }   
    public void HartjeErAf(){
    levens--;
    LatenZien ();
    DoodGaan();
    
    }
    public void LatenZien(){
    for(int i=0;i<hartje.size();i++){
    getWorld().removeObject(hartje.get(i));
    }
    hartje.clear();
    //System.out.print(levens);
    for(int i=0;i<levens;i++){
    Leven l = new Leven();
    l.setImage("hud_heartFull.png");
    getWorld().addObject(l,50+(i*60),50);
    hartje.add(l);
    }
    }
    public void DoodGaan(){
    if (levens==0){
    Greenfoot.setWorld(new GameOverScherm());
    }
    }
}
