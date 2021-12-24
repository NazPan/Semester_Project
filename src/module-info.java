module Assignment04 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	requires junit;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
