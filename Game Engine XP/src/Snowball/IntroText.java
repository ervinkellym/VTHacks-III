package Snowball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import engine.computer.input.Keyboard;
import engine.scene.Entity;
import engine.util.resource.visual.ImageLoader;

public class IntroText extends Entity {
    
    private boolean isClicked;
    private Image fightPic;
    
    public IntroText() {
        
        fightPic = ImageLoader.getImage("/visual/Fight.jpg");
    }

    public void render(Graphics g) {
        
        g.setColor(new Color(150, 50, 50));
        g.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 40));
        g.drawString("Welcome to VT Snowball Fight! ", 28, 60);
        g.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 32));
        g.drawString("Premise", 215, 430);
        g.drawString("Instructions", 190, 610);
        g.drawImage(fightPic, 40, 100, 450, 280, null);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        g.drawString("You are the last cadet standing at Virginia Tech's", 28, 460);
        g.drawString("annual Cadets versus Civilians snowball fight.", 28, 490);
        g.drawString("Your goal is to defend your position at the ", 28, 520);
        g.drawString("pylons against the hoardes of relentless civilians.", 28, 550);
        g.drawString("Press the left and right arrow keys to move and the", 28, 640);
        g.drawString("spacebar to throw snowballs.", 28, 670);
        g.drawString("Press the enter key to start.", 28, 700);
        
    }
    
    public void update() {
        
        Keyboard keyboard = getEngine().getComputer().getInput().getKeyboard();

        if (keyboard.isKeyPressed(KeyEvent.VK_ENTER)) {
            
            isClicked = true;
        }
    }
    
    public boolean getIsClicked() {
        
        System.out.println(isClicked);
        return isClicked;
    }
}