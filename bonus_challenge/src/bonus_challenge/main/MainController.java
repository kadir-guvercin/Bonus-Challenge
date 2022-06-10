package bonus_challenge.main;

import java.util.Map;

public class MainController {
	private static MainController instance = null;
	private boolean isInitilazed = false;
	
	public static synchronized MainController getInstance() {
		if(instance == null) {
			instance = new MainController();
		}
		return instance;
	}
	
	public void init() {
		
		try {
			if(isInitilazed) {
				return;
			}
			
			IOController.getInstance().init();
			ViewController.getInstance().init();
			
			isInitilazed = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Map<String, String> getFileContainer() {
		return IOController.getInstance().getFileContainer();
	}
}
