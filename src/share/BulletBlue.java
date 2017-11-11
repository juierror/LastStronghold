package share;


import javafx.scene.canvas.GraphicsContext;

public class BulletBlue extends Bullet implements IRenderable {
	
	// Constructor
	public BulletBlue() {
		super();
	}
	
	public BulletBlue(double posX, double posY, double veloX) {
		super(posX, posY, veloX);
	}

	// Method
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.bulletBlue, super.getX(), super.getY());
	}
	
}