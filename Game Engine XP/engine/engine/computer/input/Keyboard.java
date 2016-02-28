package engine.computer.input;

import java.util.ArrayList;

public class Keyboard {

    private ArrayList<Integer> keys;
    
    public Keyboard() {
        
        keys = new ArrayList<Integer>();
    }
    
    public void pressKey(int key) {
        
        for(int i = 0; i < keys.size(); i++) {
            
            if(keys.get(i) == key){
                
                return;
            }
        }
        keys.add(key);
    }
    
    public void releaseKey(int key) {
        
        for (int i = 0; i < keys.size(); i++) {
            
            if (keys.get(i) == key) {
                
                keys.remove(i);
                break;
            }
        }
    }
    
    public boolean isKeyPressed(int key) {
        
        for (int i = 0; i < keys.size(); i++) {
            
            if(keys.get(i) == key) {
                return true;
            }
        }
        
        return false;
    }
    
    public void refresh() {
        
        keys = new ArrayList<Integer>();
    }
}
