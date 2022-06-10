package bonus_challenge.main;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import bonus_challenge.reader.HtmlReader;

public class IOController {
	private static IOController instance = null;
	private boolean isInitilazed = false;
	private List<String> fileNames;
	private String resourcesPath = "src/bonus_challenge/resources";
	private Map<String, String> fileContainer;
	private HtmlReader hr = null;
	
	public static synchronized IOController getInstance() {
		if(instance == null) {
			instance = new IOController();
		}
		return instance;
	}
	
	public void init() {
		
		try {
			if(isInitilazed) {
				return;
			}
			
			readHtmlNames();
			readHtmlContents();
			
			isInitilazed = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void readHtmlNames() {
		try {
			fileNames = new ArrayList<>();
			
			File file = new File(resourcesPath);
			
			File files[] = file.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					if(name.contains(".html")) return true;
					return false;
				}
			});

			for(File f: files) {
				fileNames.add(f.getName());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void readHtmlContents() {
		try {
			fileContainer = new LinkedHashMap<>();
		
			fileNames.forEach((fileName) -> {
			
				hr = new HtmlReader(resourcesPath+"/"+fileName);
			
				try {
					hr.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				String content = hr.getFileContent();
				
				fileContainer.put(fileName.substring(0, fileName.indexOf(".html")), content);
			
			});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Map<String, String> getFileContainer() {
		if(fileContainer == null) {
			fileContainer = new LinkedHashMap<>(); 
		}
		return fileContainer;
	}
	
}
