package Snowball;

import java.awt.Color;
import engine.Engine;
import engine.util.resource.audio.Audio;

public class Snowball {

    public static void main(String[] args) {
        
        Engine engine = new Engine();
        
        IntroText screen = new IntroText();
        engine.getScene().addEntity(screen);
        
        engine.getDisplay().setSize(550, 900);
        engine.getDisplay().changeColor(Color.WHITE);
        engine.getDisplay().setPosition(500, 75);
        engine.getDisplay().setTop(true);
        engine.start();
        
        boolean clickedEnter = false;
        while (!clickedEnter) {
            clickedEnter = screen.getIsClicked();
        }
        
        engine.getScene().getEntities().remove(screen);
        
        Cadet jerry = new Cadet();
        engine.getScene().addEntity(jerry);
        
        engine.getScene().addEntity(new Scorekeeper(jerry));
        
        engine.getScene().addEntity(new Pylon(2));
        engine.getScene().addEntity(new Pylon(59));
        engine.getScene().addEntity(new Pylon(116));
        engine.getScene().addEntity(new Pylon(173));
        engine.getScene().addEntity(new Pylon(301));
        engine.getScene().addEntity(new Pylon(358));
        engine.getScene().addEntity(new Pylon(415));
        engine.getScene().addEntity(new Pylon(472));
        
        
        Audio audio = new Audio("/audio/Megalovania.mp3");
        audio.play();
        
    }
}
