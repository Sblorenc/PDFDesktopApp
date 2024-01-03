module DesktopAppDemo {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires org.apache.pdfbox;
	requires org.apache.poi.poi;
	requires org.apache.poi.ooxml;
	
	opens openjfx to javafx.graphics, javafx.fxml;
	exports openjfx;
}
