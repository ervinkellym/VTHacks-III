package engine.display;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import engine.scene.Entity;
import engine.scene.Scene;

@SuppressWarnings("serial")
public class Renderer extends JPanel {

    private Scene scene;
    
    public Renderer(Scene s) {
        
        scene = s;
    }
    
    public void paintComponent(Graphics g) {
        
        ArrayList<Entity> entities = scene.getEntities();
        
        for (int i = 0; i < entities.size(); i++) {
            
            entities.get(i).render(g);
        }
    }
}