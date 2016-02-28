package Snowball;

import java.awt.Graphics;
import java.awt.Image;
import engine.scene.Entity;
import engine.util.resource.visual.ImageLoader;

public class Bullet extends Entity {

    private int xPos;
    private int yPos;
    private Image snowballPic;
    
    public Bullet (Cadet c) {
        
        xPos = c.getXPos()+25;
        yPos = c.getYPos();
        snowballPic = ImageLoader.getImage("/visual/Snowball.png");
    }
    
    public void render(Graphics g) {
        
        g.drawImage(snowballPic, xPos, yPos, 10, 10, null);
    }
    
    public void update() {
        
        yPos -= 3;
        if (yPos <= -5) {
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