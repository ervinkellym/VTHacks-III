package Snowball;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import engine.computer.input.Keyboard;
import engine.scene.Entity;
import engine.util.math.Vector2;
import engine.util.resource.visual.ImageLoader;

public class Cadet extends Entity {

    private int xPos = 200;
    private int yPos = 700;
    private int time;
    private Image cadetPic;
    private int spawnHold;
    private int score;
    //private int numPylons = 8;
    
    public Cadet() {
        
        cadetPic = ImageLoader.getImage("/visual/VTCC_Crest.png");
        score = 0;
    }
    
    public void render(Graphics g) {
        
        g.drawImage(cadetPic, xPos, yPos, 60, 60, null);
    }
    
    public void update() {
        
        Keyboard keyboard = getEngine().getComputer().getInput().getKeyboard();
        
        if (keyboard.isKeyPressed(KeyEvent.VK_LEFT) && xPos > 0) {
            xPos -= 2;
        }
        
        if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && xPos < 457) {
            xPos += 2;
        }
        
        if (/*add up and w*/keyboard.isKeyPressed(KeyEvent.VK_SPACE) && time == 0) {
            getEngine().getScene().addEntity(new Bullet(this));
            time = 30;
        }
        
        if (time > 0) {
            
            time--;
        }
        if(spawnHold <= 0) {
            
            getEngine().getScene().addEntity(new Civilian(this));
            spawnHold = 180;
        }
        spawnHold--;
        
        checkCollide();
    }
    
    public void checkCollide() {
        
        ArrayList<Entity> entities = getEngine().getScene().getEntities();
        ArrayList<Bullet> snowballs = new ArrayList<Bullet>();
        ArrayList<Civilian> civilians = new ArrayList<Civilian>();
        Civilian c = new Civilian(this);
        Bullet s = new Bullet(this);
        
        for (int i = 0; i < entities.size(); i++) {
            
            if (entities.get(i).getClass().equals(c.getClass())) {
                
                civilians.add((Civilian)entities.get(i));
            }
            
            if (entities.get(i).getClass().equals(s.getClass())) {
                
                snowballs.add((Bullet)entities.get(i));
            }
        }
        
        for (int i = 0; i < civilians.size(); i++) {
            
            c = civilians.get(i);
            if (c.getY() >= 740) {
                
                entities.remove(c);
                //entities.remove(arg0);
            }
            
            for (int j = 0; j < snowballs.size(); j++) {
                
                c = civilians.get(i);
                s = snowballs.get(j);
                Vector2 sVec = new Vector2(s.getX(), s.getY());
                Vector2 cVec = new Vector2(c.getX(), c.getY());
                sVec.decrement(cVec);
                if (sVec.getMagnitude() <= 50) {
                    
                    entities.remove(c);
                    entities.remove(s);
                    score++;
                }
            }
        }
    }
    
    public int getXPos() {
        
        return xPos;
    }
    
    public int getYPos() {
        
        return yPos;
    }
    
    public int getScore() {
        
        return score;
    }
}
