package src;

import java.awt.Color;

import engine.Engine;

public class Game {
    
    public static void main(String[] args) {
        
        Engine engine = new Engine();
        
        engine.getScene().addEntity(new Ball());
        
        engine.start();
    }
}