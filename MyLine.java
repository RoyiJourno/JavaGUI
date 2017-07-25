package A;

import java.awt.Graphics;
import java.awt.Color;

//Declaration of class MyLine.
public class MyLine extends MyShape {

	//constructor
	public MyLine(){
		super(0,0,0,0,Color.BLACK);
	}
	
	public MyLine(int x1, int x2, int y1, int y2, Color color){
		super(x1,x2,y1,y2,color);
	}
	
	
	// draws a line in the specified color
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}

}

