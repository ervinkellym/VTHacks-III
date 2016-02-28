package Snowball;

import java.awt.Graphics;
import java.awt.Image;
import engine.scene.Entity;
import engine.util.resource.visual.ImageLoader;

public class Civilian extends Entity {

    private int xPos;
    private int yPos;
    //private Cadet cadet;
    private Image crestPic;
    
    public Civilian(Cadet c) {
        
        yPos = 0;
        xPos = (int) (Math.random()*440 + 30);
        //cadet = c;
        crestPic = ImageLoader.getImage("/visual/Civil.png");
    }
    
    public void render(Graphics g) {

        g.drawImage(crestPic, xPos, yPos, 60, 40, null);
    }
    
    public void update() {
        
        yPos++;
        if (yPos >= 785) {
            destroy();
        }
    }
    
    public int getX() {
        
        return xPos;
    }
    
    public int getY() {
        
        return yPos;
    }
}