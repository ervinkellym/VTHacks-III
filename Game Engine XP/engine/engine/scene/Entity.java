package engine.scene;

import java.awt.Graphics;

import engine.Engine;

@SuppressWarnings("rawtypes")
public class Entity implements Comparable {
    
    private Engine engine;
    private boolean destroyed;
    private int renderPriority;
    
    public void update() {
        
    }
    
    public void render(Graphics g) {
        
    }
    
    public Engine getEngine() {
        
        return engine;
    }
    
    public void setEngine(Engine e) {
        
        engine = e;
    }
    
    public void destroy() {
        
        destroyed = true;
    }
    
    public boolean isDestroyed() {
        
        return destroyed;
    }
    
    public void setRenderPriority(int i) {
        
        renderPriority = i;
    }
    
    public int getRenderPriority() {
        
        return renderPriority;
    }
    
    public int compareTo(Object arg0) {
        
        return renderPriority - ((Entity)arg0).getRenderPriority();
    }
}