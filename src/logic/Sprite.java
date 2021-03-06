package logic;

import javafx.geometry.Rectangle2D;

public abstract class Sprite
{
	protected double positionX;
    protected double positionY;    
    protected double velocityX;
    protected double velocityY;
    protected double width;
    protected double height;
    protected int tick;

    public Sprite()
    {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
    }

    public void setPosition(double x, double y)
    {
        positionX = x;
        positionY = y;
    }
    
    public double getX() {
    		return this.positionX;
    }
    
    public double getY() {
    		return this.positionY;
    }

    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

    public void update(double x, double y)
    {
        positionX += x;
        positionY += y;
    }

    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }
    
    public String toString()
    {
        return " Position: [" + positionX + "," + positionY + "]" 
        + " Velocity: [" + velocityX + "," + velocityY + "]";
    }

    public void tickIncrease() {
    		this.tick++;
    }
    
    public void tickReset() {
    		this.tick = 0;
    }
    
    public int getTick() {
    	return this.tick;
    }
}