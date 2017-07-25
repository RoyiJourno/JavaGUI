package A;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * DrawFrame class constitutes the main window of the application
 * (extends {@link javax.swing.JFrame}). This class is responsible
 * for creating all the GUI elements and organize them.
 * @author Royi Journo
 */
public class DrawFrame extends JFrame{
	
	private JButton undoButton;
	private JButton clearButton;
	
	private JComboBox<String> colorChoices;
	private JComboBox<String> shapeChoices;
	
	private JCheckBox filledCheckBox;
	
	private JPanel buttonsLayout; // North side of frame - all the buttons
	
	private JLabel statusLabel; // South side of frame
	
	private DrawPanel drawSection; // center Jpanel for drawing
	
	 private static final String[] shapeName = { "Line", "Oval", "Rectangle"};
	 private static final String[] colorNames = {"Black", "Blue", "Cyan",
		      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
		      "Orange", "Pink", "Red", "White", "Yellow"};
	 private static final Color[] colors = {Color.BLACK, Color.BLUE,
		      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
		      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
		      Color.RED, Color.WHITE, Color.YELLOW};

	public DrawFrame(){
		 super("Shape Drawing");
		 statusLabel = new JLabel();
		 add(statusLabel, BorderLayout.SOUTH); 
		 drawSection = new DrawPanel(statusLabel, colors[0], 0, false);
		 add(drawSection, BorderLayout.CENTER);
		 initButtons(); // init all north side buttons and add them to frame
		 initHandlers(); // init handlers for all buttons
	 }

	/** 
	 * initializes all North buttons, adds them to ButtonsLayout that added to North side of the frame
	 */
	private void initButtons() {
		buttonsLayout = new JPanel();
		undoButton = new JButton("Undo");
		buttonsLayout.add(undoButton); 
		clearButton = new JButton("Clear");
		buttonsLayout.add(clearButton);
		colorChoices = new JComboBox<String>(colorNames);
		colorChoices.setMaximumRowCount(4);
		buttonsLayout.add(colorChoices);
		shapeChoices = new JComboBox<String>(shapeName);
		shapeChoices.setMaximumRowCount(3);
		buttonsLayout.add(shapeChoices);
		filledCheckBox = new JCheckBox("Filled");
		buttonsLayout.add(filledCheckBox);
		add(buttonsLayout, BorderLayout.NORTH);
	}

	 /**
	 * initialize all buttons handlers, including JButton, JComboBox and JCheckBox using {@link ButtonHandler}
	 * and {@link ItemHandler}.
	 */
	private void initHandlers() {
		 ButtonHandler BHandler = new ButtonHandler();
		 clearButton.addActionListener(BHandler);
		 undoButton.addActionListener(BHandler);
		 ItemHandler IHandler = new ItemHandler();
		 colorChoices.addItemListener(IHandler);
		 shapeChoices.addItemListener(IHandler);
		 filledCheckBox.addItemListener(IHandler);
	 }
 

	private class ButtonHandler implements ActionListener{
	 @Override
	 public void actionPerformed(ActionEvent e) {
		if (e.getSource() == undoButton)
			drawSection.undo();
		else if (e.getSource() == clearButton)
			drawSection.clear();
	}
 }
	 
private class ItemHandler implements ItemListener{
	 @Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()== filledCheckBox)
		{
			drawSection.setShapefilled(filledCheckBox.isSelected());
			return;
		}
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			if (e.getSource() == colorChoices)
				drawSection.setShapeColor(colors[colorChoices.getSelectedIndex()]);
			else if (e.getSource() == shapeChoices)
				drawSection.setShapeType(shapeChoices.getSelectedIndex());
		}
	 }
	}
}

