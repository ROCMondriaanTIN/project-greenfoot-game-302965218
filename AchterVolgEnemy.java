import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PressEnter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AchterVolgEnemy extends Mover
{
    /**
     * Act - do whatever the PressEnter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        applyVelocity();
        handleInput();
    } 
    public void handleInput() {
       //else if (Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")) {
            if (true){
            velocityX =5;
        }
    }
}
