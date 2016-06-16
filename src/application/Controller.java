package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class Controller implements Initializable {
	
	@FXML
	private Button saveButton;
	@FXML
	private Button setDirectory;
	@FXML
	private TextField URLField;
	@FXML
	private TextField directoryField;
	
	String url;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event)
			{
				try {
					url = URLField.getText();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setDirectory.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event)
			{
				try {
					FileChooser fileChooser = new FileChooser();
					fileChooser.setTitle("Set Save Directory");
					fileChooser.showSaveDialog(null);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
