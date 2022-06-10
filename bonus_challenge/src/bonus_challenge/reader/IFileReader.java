package bonus_challenge.reader;

import java.io.IOException;

public interface IFileReader {
	
	void read() throws IOException;
	String getFileContent();
}
