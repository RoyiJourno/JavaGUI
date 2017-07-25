package A;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class DrawPanel extends JPanel{
	private MyShape[] shapes;
	private int shapeSize;
	private MyShape currentShape;
	private JLabel statusLabel;
	private Color shapeColor;
	private int shapeType; // 0 -> Line, 1 -> Oval, 2 -> Rectangle
	private boolean shapefilled, newShapeInStack;

	public DrawPanel(JLabel statusLabel,Color shapeColor, int shapeType, boolean shapefilled){
	      initPanel();
	      this.statusLabel = statusLabel;
	      setShapeColor(shapeColor);
	      setShapeType(shapeType);
	      setShapefilled(shapefilled);
	      initHandlers();
	}

	private void initPanel(){
		setBackground(Color.WHITE);
	      shapes = new MyShape[100];
	      shapeSize = 0;
	      newShapeInStack = false;
	}
	
	private void initHandlers() {
	      MouseHandler MHandler = new MouseHandler();
	      addMouseMotionListener(MHandler);
	      addMouseListener(MHandler);		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 for (int i = 0; i < shapeSize;i++)
	         shapes[i].draw(g); 
		 if (newShapeInStack == true)
			 currentShape.draw(g);
	}

	private class MouseHandler implements MouseListener, MouseMotionListener{
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1){ // check if left click is trigger
			if (shapeSize == shapes.length) // limited for array size, in this case - 100
			{
				JOptionPane.showMessageDialog(null, "Cannot exceed the current number of shapes:"+shapeSize,"Capacity Overload", JOptionPane.WARNING_MESSAGE);
				return;
			}
			newShapeInStack = true;
			int x = e.getX();
			int y = e.getY();
			 switch(shapeType)
			 {
			 case 0: currentShape = new MyLine(x, y, x, y, shapeColor); break;
			 case 1: currentShape = new MyOval(x, y, x, y, shapeColor, shapefilled); break;
			 case 2: currentShape = new MyRectangle(x, y, x, y, shapeColor, shapefilled);break;
			 default: throw new IndexOutOfBoundsException("wrong shapeType number");
			 }
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			mouseMoved(e);
			if (newShapeInStack == true) // check if left click is triggerd
			{
				currentShape.setX2(e.getX());
				currentShape.setY2(e.getY());
				repaint();
			}
		}
		




		@Override
		public void mouseReleased(MouseEvent e) {
			if (newShapeInStack == true) // check if left click is triggerd
			{
				if (e.getX() != currentShape.getX1() || e.getY() != currentShape.getY1()){
				currentShape.setX2(e.getX());
				currentShape.setY2(e.getY());
				shapes[shapeSize++] = currentShape;
				}
				newShapeInStack = false;
				repaint();
			}
		}
		
		
		@Override
		public void mouseMoved(MouseEvent e) {
			statusLabel.setText(String.format("(%d,%d)", e.getX(), e.getY()));
		}	
		
		@Override
		public void mouseEntered(MouseEvent e) {}
		
		@Override
		public void mouseExited(MouseEvent e) {}
		
		@Override
		public void mouseClicked(MouseEvent e) {}
	}
	

	public void undo(){
		shapeSize -= (shapeSize>0)? 1 : 0 ;
		repaint();
	}

	public void clear(){
		shapeSize = 0;
		repaint();
	}
	
	public void setShapeColor(Color shapeColor) {
		this.shapeColor = shapeColor;
	}

	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}

	public void setShapefilled(boolean shapefilled) {
		this.shapefilled = shapefilled;
	}
}
