package Snowball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import engine.scene.Entity;

public class Scorekeeper extends Entity {
    
    private Cadet cadet;
    private int score;
    
    public Scorekeeper(Cadet c) {
        
        cadet = c;
    }

    public void render(Graphics g) {
        
        g.setColor(new Color(150, 50, 50));
        g.setFont(new Font("Bernard MT Condensed", Font.BOLD, 28));
        g.drawString(""+score, 15, 832);
    }
    
    public void update() {
        
        score = cadet.getScore();
    }
}