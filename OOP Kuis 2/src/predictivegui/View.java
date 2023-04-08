package predictivegui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class View implements Observer, ActionListener {
	/**
	 * Class to implement interactive GUI
	 */
	
	// initialize object
	private MyPanel panel = new MyPanel();
	private Model model = new Model();
	
	// method for initialize the frame
	public void init(String title) {
		
		// frame
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// make the frame to appear in the middle of the screen
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) screen.getWidth() / 2 - frame.getWidth() / 2,
			(int) screen.getHeight() / 2 - frame.getHeight() / 2);

		// action for the key to take input on click
		model.addObserver(this);
		panel.key0.addActionListener(this);
		panel.key1.addActionListener(this);
		panel.key2.addActionListener(this);
		panel.key3.addActionListener(this);
		panel.key4.addActionListener(this);
		panel.key5.addActionListener(this);
		panel.key6.addActionListener(this);
		panel.key7.addActionListener(this);
		panel.key8.addActionListener(this);
		panel.key9.addActionListener(this);
		panel.keyHash.addActionListener(this);
		panel.keyStar.addActionListener(this);

		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	// method to update the text field
	public void update(Observable o, Object arg) {
        if (o instanceof Model) {
            	panel.setText("" + arg);
        }
    }
	// method to take action on click
	public void actionPerformed(ActionEvent e) {
		 String s = e.getActionCommand();
		 model.press(s.charAt(0));
	}
}
