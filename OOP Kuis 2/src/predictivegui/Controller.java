package predictivegui;

public class Controller {
	/**
	 * Class as mediator for model and view  
	 */

	private Model model;
	private View view;
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	// init frame with title
	public void initView(String title) {
		view.init(title);
	}
}
