package engine;

import engine.computer.Computer;
import engine.display.Display;
import engine.scene.Scene;

public class Engine {
    
    private Computer computer;
    private Display display;
    private Scene scene;
    
    public Engine() {
        computer = new Computer(this);
        scene = new Scene(this);
        display = new Display(this);
    }
    
    public void start() {
        display.start();
        scene.start();
    }
    
    public void terminate() {
        System.exit(0);
    }
    
    public Computer getComputer() {
        return computer;
    }
    
    public Display getDisplay() {
        return display;
    }
    
    public Scene getScene() {
        return scene;
    }
}