package openjfx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PdfReader {

	public List<String> findInPdf(List <File> listOfPdfFiles, String index, List<String> resultList) {
		
		
		try {
		for (int i=0;i<listOfPdfFiles.size();i++){
			File file = listOfPdfFiles.get(i);
			PDDocument document = Loader.loadPDF(file);
			PDFTextStripper findPhrase = new PDFTextStripper();
			String text = findPhrase.getText(document);
			if (text.contains(index)) {
				 resultList.add(index+" "+file.getName());
				
				}
			else if (index.contains("5")){
				index = index.replace('5','S').toUpperCase();
				if (text.contains(index)) {
					resultList.add(index+" "+file.getName());
				}
			}
			else if (index.contains("0")) {
				index = index.replace("0", "O").toUpperCase();	
				
				if (text.contains(index)) {
					resultList.add(index+" "+file.getName());
				}
				}
			else if (index.contains("1")) {
				index = index.replace("1", "L").toUpperCase();
				
				if (text.contains(index)) {
					resultList.add(index+" "+file.getName());
				} else {
					index = index.replace("l", "I").toUpperCase();
					
						if (text.contains(index)) {
							resultList.add(index+" "+file.getName());
						}
					
				}
			}
			}
		}
			catch (IOException e) {
				System.out.print("asd");
			}
		
		return resultList;
	}
}
