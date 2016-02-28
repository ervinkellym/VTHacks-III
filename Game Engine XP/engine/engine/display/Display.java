package engine.display;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import engine.Engine;

public class Display implements Runnable {
    
    private Engine engine;
    
    private Thread thread;
    
    private JFrame myFrame;
    private Renderer renderer;
    
    public Display(Engine engine) {
        
        this.engine = engine;
        
        thread = new Thread(this);
        
        myFrame = new JFrame();
        myFrame.setBackground(Color.WHITE);
        myFrame.setSize(500, 500);
        myFrame.setLocationRelativeTo(null);
        
        renderer = new Renderer(engine.getScene());
    }
    
    public void start() {
        
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myFrame.add(renderer);
        
        addListeners();
        
        thread.start();
    }
    
    public void addListeners() {
        
        myFrame.addKeyListener(
            
            new KeyListener() {
                
                public void keyPressed(KeyEvent keyEvent) {
                    engine.getComputer().getInput().getKeyboard().pressKey(keyEvent.getKeyCode());
                }
                
                public void keyReleased(KeyEvent keyEvent) {
                    engine.getComputer().getInput().getKeyboard().releaseKey(keyEvent.getKeyCode());
                }
                
                public void keyTyped(KeyEvent keyEvent) {
                    
                }
            }
        );
        
        myFrame.addFocusListener(
                
            new FocusListener() {
                
                public void focusGained(FocusEvent focusEvent) {
                    
                    engine.getComputer().getInput().refresh();
                }
                  
                public void focusLost(FocusEvent focuseEvent) {
                        
                    engine.getComputer().getInput().refresh();
                }
            }
        );
        
    }

    public void run() {
        
        while (true) {
            
            try {
                
                refresh();
                
                Thread.sleep(10);
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public Engine getEngine() {
        return engine;
    }
    
    public void refresh() {
        myFrame.repaint();
        myFrame.revalidate();
    }
    
    public void enableResizing() {
        myFrame.setResizable(true);
    }
    
    public void disableResizing() {
        myFrame.setResizable(false);
    }
    
    public void setSize(int x, int y) {
        
        myFrame.setSize(x, y);
    }
    
    public int getWidth() {
        
        return myFrame.getWidth();
    }
    
    public int getHeight() {
        
        return myFrame.getHeight();
    }
    
    public void changeColor(Color c) {
        
        renderer.setBackground(c);
    }
    
    public void setPosition(int x, int y) {
        
        myFrame.setLocation(x, y);
    }
    
    public void setTop(boolean top) {
        
        myFrame.setAlwaysOnTop(top);
    }
}