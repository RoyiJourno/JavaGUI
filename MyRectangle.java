package A;

import java.awt.Color;
import java.awt.Graphics;

//Declaration of class MyRectangle.
public class MyRectangle extends MyBoundedShape {

	//constructor
	public MyRectangle() {
		super(0,0,0,0,Color.BLACK,false);
	}

	public MyRectangle(int x1, int x2, int y1, int y2, Color color,	boolean filled) {
		super(x1, x2, y1, y2, color, filled);
	}

	// draws an rectangle in the specified color
	public void draw(Graphics g) {
		g.setColor(getColor());
		if(isFilled()){
			g.fillRect(upperLeftCoordinateX(), upperLeftCoordinateY(), getWidth(), getHeight());
		}else
			g.drawRect(upperLeftCoordinateX(), upperLeftCoordinateY(), getWidth(), getHeight());
	}

}
