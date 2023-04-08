package predictivegui;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
	/**
	 * Class for the GUI design
	 */
	
	// button and text field 
	private JTextField text = new JTextField(25);
	protected JButton key0 = new JButton("0 -");
    	protected JButton key1 = new JButton("1");
    	protected JButton key2 = new JButton("2 abc");
    	protected JButton key3 = new JButton("3 def");
    	protected JButton key4 = new JButton("4 ghi");
    	protected JButton key5 = new JButton("5 jkl");
    	protected JButton key6 = new JButton("6 mno");
    	protected JButton key7 = new JButton("7 pqrs");
    	protected JButton key8 = new JButton("8 tuv");
    	protected JButton key9 = new JButton("9 wxyz");
    	protected JButton keyHash = new JButton("#");
    	protected JButton keyStar = new JButton("*");
    
    
	public MyPanel() {	
		// grid for the layout
        	GridLayout layout = new GridLayout(5, 1);
        
		// set layout 
		setLayout(layout);
        
		// 5 container for the grid layout
		JPanel txt = new JPanel();
		JPanel buttons1 = new JPanel();
		JPanel buttons2 = new JPanel();
		JPanel buttons3 = new JPanel();
		JPanel buttons4 = new JPanel();

		// size of the button and text field
		text.setPreferredSize(new Dimension(0, 40));
		text.setText("predictive text : enter text with 8 keys.");
		key1.setPreferredSize(new Dimension(74, 40));
		key2.setPreferredSize(new Dimension(74, 40));
		key3.setPreferredSize(new Dimension(74, 40));
		key4.setPreferredSize(new Dimension(74, 40));
		key5.setPreferredSize(new Dimension(74, 40));
		key6.setPreferredSize(new Dimension(74, 40));
		key7.setPreferredSize(new Dimension(74, 40));
		key8.setPreferredSize(new Dimension(74, 40));
		key9.setPreferredSize(new Dimension(74, 40));
		key0.setPreferredSize(new Dimension(74, 40));
		keyHash.setPreferredSize(new Dimension(74, 40));
		keyStar.setPreferredSize(new Dimension(74, 40));

		// adding each components to certain container
		txt.add(text);
		buttons1.add(key1);
		buttons1.add(key2);
		buttons1.add(key3);
		buttons2.add(key4);
		buttons2.add(key5);
		buttons2.add(key6);
		buttons3.add(key7);
		buttons3.add(key8);
		buttons3.add(key9);
		buttons4.add(keyHash);
		buttons4.add(key0);
		buttons4.add(keyStar);

		// adding each container to the grid
		add(txt);
		add(buttons1);
		add(buttons2);
		add(buttons3);
		add(buttons4);

		// set uneditable to the text field
		text.setEditable(false);

		// set each command for each button
		key0.setActionCommand("0");
		key1.setActionCommand("1");
		key2.setActionCommand("2");
		key3.setActionCommand("3");
		key4.setActionCommand("4");
		key5.setActionCommand("5");
		key6.setActionCommand("6");
		key7.setActionCommand("7");
		key8.setActionCommand("8");
		key9.setActionCommand("9");
		keyHash.setActionCommand("#");
		keyStar.setActionCommand("*");
	}
	
	// method to initialize the text on the text field 
	public void setText(String value) {
		text.setText(value);
	}
}
