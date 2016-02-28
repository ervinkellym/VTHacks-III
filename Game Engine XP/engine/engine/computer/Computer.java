package engine.computer;

import engine.Engine;
import engine.computer.input.Input;

public class Computer {
    
    private Engine engine;
    private Input input;
    
    public Computer(Engine engine) {
        this.engine = engine;
        input = new Input();
    }
    
    public Engine getEngine() {
        
        return engine;
    }
    
    public Input getInput() {
       
        return input;
    }
            
}
