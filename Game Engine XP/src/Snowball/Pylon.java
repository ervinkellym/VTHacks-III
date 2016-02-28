package Snowball;

import java.awt.Graphics;
import java.awt.Image;
import engine.scene.Entity;
import engine.util.resource.visual.ImageLoader;

public class Pylon extends Entity {
    
    private int xPos;
    private int yPos = 780;
    private Image pylonPic;
    
    public Pylon(int x) {
        
        xPos = x;
        pylonPic = ImageLoader.getImage("/visual/HokieStone.png");
    }
    
    public void render(Graphics g) {
        
        g.drawImage(pylonPic, xPos, yPos, 55, 20, null);
    }
}