package bonus_challenge.main;

import java.util.Map;

import bonus_challenge.view.controller.MainFrameController;

public class ViewController {
	private static ViewController instance = null;
	private boolean isInitilazed = false;
	
	public static synchronized ViewController getInstance() {
		if(instance == null) {
			instance = new ViewController();
		}
		return instance;
	}
	
	public void init() {
		
		try {
			if(isInitilazed) {
				return;
			}
			
			MainFrameController.getInstance().init();
			
			isInitilazed = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Map<String, String> getFileContainer() {
		return MainController.getInstance().getFileContainer();
	}
}
