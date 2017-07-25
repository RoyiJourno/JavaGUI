package A;

import java.awt.Color;
import java.awt.Graphics;

//Declaration of class MyOval.
public class MyOval extends MyBoundedShape {

	//constructor
	public MyOval() {
		super(0,0,0,0,Color.BLACK,false);
	}

	public MyOval(int x1, int x2, int y1, int y2, Color color, boolean filled) {
		super(x1, x2, y1, y2, color, filled);
	}

	// draws an oval in the specified color
	public void draw(Graphics g) {
		g.setColor(getColor());
		if(isFilled()){
			g.fillOval(upperLeftCoordinateX(), upperLeftCoordinateY(), getWidth(), getHeight());
		}else
			g.drawOval(upperLeftCoordinateX(), upperLeftCoordinateY(), getWidth(), getHeight());

	}

}
