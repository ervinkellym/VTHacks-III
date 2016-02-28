package engine.scene;

import java.util.ArrayList;
import java.util.Collections;

import engine.Engine;

public class Scene implements Runnable{
    
    private Engine engine;
    private Thread thread;
    private ArrayList<Entity> entities;
    
    public Scene(Engine engine) {
        
        this.engine = engine;
        
        entities = new ArrayList<Entity>();
        
        thread = new Thread(this);
    }
    
    public void start() {
        
        thread.start();
    }
    
    public Engine getEngine() {
        
        return engine;
    }
    
    public void addEntity(Entity e) {
        
        e.setEngine(engine);
        entities.add(e);
    }
    
    public ArrayList<Entity> getEntities() {
        
        return entities;
    }

    public void run() {
        
        while (true) {
            
            try {
                
                update();
                
                Thread.sleep(10);
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public void update() {
        
        Collections.sort(entities);
        
        for (int i = 0; i < entities.size(); i++) {
            
            if (!entities.get(i).isDestroyed()) {
            
                entities.get(i).update();
            }
            else {
                
                entities.remove(i);
                i--;
            }
                
        }
    }
}