package predictivegui;
import java.awt.*;
import javax.swing.*;
public class main {
	/**
	 * Main class to run GUI
	 */
	public static void main(String[] args) throws Exception {
		// button and text field model
        	javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		// model object
       		Model model = new Model();
		
		// view object
		View view = new View();
		
		// controller object
		Controller controller = new Controller(model, view);

		// init GUI frame
		controller.initView("Predictive Text");
	}
}
