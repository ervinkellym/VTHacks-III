package engine.util.math;

public class Vector2 {

    private double x;
    private double y;
    
    public Vector2() {
        
        x = 0;
        y = 0;
    }
    
    public Vector2(double x, double y) {
        
        this.x = x;
        this.y = y;
    }
    
    public Vector2(Vector2 vec) {
        
        x = vec.getX();
        y = vec.getY();
    }
    
    public double getX() {
        
        return x;
    }
    
    public double getY() {
        
        return y;
    }
    
    public void setX(double x) {
        
        this.x = x;
    }
    
    public void setY(double y) {
        
        this.y = y;
    }
    
    public void incrementX(double x) {
        
        this.x += x; 
    }
    
    public void incrementY(double y) {
        
        this.y += y;
    }
    
    public void decrementX(double x) {
        
        this.x -= x;
    }
    
    public void decrementY(double y) {
        
        this.y -= y;
    }
    
    public void increment(Vector2 vec) {
        
        x += vec.getX();
        y += vec.getY();
    }
    
    public void decrement(Vector2 vec) {
        
        x -= vec.getX();
        y -= vec.getY();
    }
    
    public void copy(Vector2 vec) {
        
        x = vec.getX();
        y = vec.getY();
    }
    
    public void setMagnitude(double magnitude) {
        
        if(getMagnitude() == 0) {
            setX(1);
            setY(1);
        }
        
        Vector2 unitVector = getUnitVector();
        
        setX(unitVector.getX() * magnitude);
        setY(unitVector.getY() * magnitude);
    }
    
    public double getMagnitude() {
        
        return Math.sqrt(
                (x * x) + 
                (y * y));
    }
    
    public Vector2 getUnitVector() {
        
        if (getMagnitude() > 0) {
            
            return new Vector2(x / getMagnitude(), y / getMagnitude());
        }
        
        else {
            
            return new Vector2(0, 0);
        }
    
    }
}