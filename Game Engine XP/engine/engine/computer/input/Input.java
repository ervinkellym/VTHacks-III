package engine.computer.input;

public class Input {
    
    private Keyboard keyboard;
    private Mouse mouse;
    
    public Input() {
        
        keyboard = new Keyboard();
        mouse = new Mouse();
    }
    
    public Keyboard getKeyboard()
    {
        return keyboard;
    }
     
    public Mouse getMouse()
    {
        return mouse;
    }
    
    public void refresh() {
        
        keyboard.refresh();
    }
   
}