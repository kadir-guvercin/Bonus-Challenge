package bonus_challenge.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlReader implements IFileReader {
	
	private String fileName;
	private String fileContent;
	
	public HtmlReader(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void read() throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));		
		StringBuffer sb = new StringBuffer();
		String str;
		
		while((str = br.readLine()) != null) {
			sb.append(str);
		}
		
		br.close();
		fileContent = new String(sb);
	}

	@Override
	public String getFileContent() {
		// TODO Auto-generated method stub
		if(fileContent == null) {
			fileContent = "";
		}
		return fileContent;
	}
	
	

}
