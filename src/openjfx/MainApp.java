package openjfx;
	



import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;


public class MainApp extends Application  {
	PdfReader pdfReader = new PdfReader();
	List <File> listOfPdfFiles = new ArrayList();
	ExcelReader excelReader = new ExcelReader();
	File excelFile = new File("excelFile");
	WriteToFile writeToFile = new WriteToFile();
	List<String>resultList = new ArrayList();
	
	
	
	
	
	@Override
	
	public void start(Stage primaryStage) {
		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view/Test.fxml"));
			primaryStage.setTitle("JavaFX Demo");
			FileChooser pdfChooser = new FileChooser();
			FileChooser excelChooser = new FileChooser();
			pdfChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
			excelChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
			
			Popup popup= new Popup();
			Label label = new Label("Files are null");
			label.setStyle("-fx-background-color: grey");
			label.setMinWidth(80);
			label.setMinHeight(50);
			popup.getContent().add(label);
			popup.setAutoHide(true);
			
			
			Button button1 = new Button("PDF Files");
			
			button1.setOnAction(e ->{
				listOfPdfFiles= pdfChooser.showOpenMultipleDialog(primaryStage);
			});
			
			Button button2 = new Button("Excel File");
			button2.setOnAction(e ->{
				excelFile = excelChooser.showOpenDialog(primaryStage);
			});
			Button button3 = new Button("Compare");
			button3.setOnAction(e ->{
				try {
				
				FileWriter fileWriter = new FileWriter("data.txt");
				List <String> listOfIndexes = excelReader.createListOfIndex(excelFile);
				
				listOfIndexes.parallelStream().forEach(string ->
				pdfReader.findInPdf(listOfPdfFiles,string,resultList));
				for (String s: resultList) {
					
					fileWriter.append(s+"\n");
					
				}
				fileWriter.close();
				} catch (NullPointerException f) {
					popup.show(primaryStage);
				} catch (IOException g) {
					g.printStackTrace();
					}
			
				
				
			});
			Button button4 = new Button("Clear");
			button4.setOnAction(e-> {
				excelFile = null;
				listOfPdfFiles = null;
			});
			
			
			HBox hbox = new HBox(50, button1, button2, button3, button4);
			Scene scene = new Scene(hbox,437, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
