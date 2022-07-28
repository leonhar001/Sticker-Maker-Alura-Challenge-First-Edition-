module APIViewer {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires ImersaoAlura;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
