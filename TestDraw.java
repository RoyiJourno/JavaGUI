package A;

import javax.swing.JFrame;

//Declaration of class TestDraw.
public class TestDraw {

	public static void main(String[] args) {
		DrawFrame Painter = new DrawFrame();
		Painter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Painter.setSize(625, 625); 
		Painter.setResizable(true);
		Painter.setVisible(true);
	}
}
