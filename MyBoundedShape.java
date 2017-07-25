package A;

import java.awt.Color;

//abstract class that Represents close shapes like Oval and Rectangle. 
public abstract class MyBoundedShape extends MyShape {
	// whether this shape is filled
	private boolean filled;

	//constructor
	public MyBoundedShape() {
		super(0,0,0,0,Color.BLACK);
		this.filled=false;
	}

	public MyBoundedShape(int x1, int x2, int y1, int y2, Color color,boolean filled) {
		super(x1, x2, y1, y2, color);
		this.filled=filled;
	}

	
	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public int upperLeftCoordinateX(){
		return Math.min(getX1(),getX2());
	}
	
	public int upperLeftCoordinateY(){
		return Math.min(getY1(),getY2());
	}
	
	public int getWidth(){
		return Math.abs(getX1()-getX2());
	}
	
	public int getHeight(){
		return Math.abs(getY1()-getY2());
	}	
}
