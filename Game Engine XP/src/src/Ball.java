package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import engine.computer.input.Keyboard;
import engine.scene.Entity;

public class Ball extends Entity {
    
    private int xPos = 200;
    private int yPos = 200;
    
    public Ball() {
        
    }
    
    public void render(Graphics g) {
        
        g.setColor(Color.RED);
        
        g.fillOval(xPos, yPos, 100, 100);
    }
    
    public void update() {
        
        Keyboard keyboard = getEngine().getComputer().getInput().getKeyboard();
        
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)) {
            yPos--;
        }
        
        if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)) {
            yPos++;
        }
    }
}
