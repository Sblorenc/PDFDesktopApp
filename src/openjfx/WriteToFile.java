package openjfx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
	
	public void writeDataToFile(List<String>resultList) {
		File file = new File("data.txt");
		try {
		FileWriter fileWriter = new FileWriter(file);
		for (int i=0; i<resultList.size();i++) {
			fileWriter.append(resultList.get(i)+"\n");
		}
		fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
