package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller implements Initializable {
	
	@FXML
	private Button saveButton;
	@FXML
	private Button setDirectory;
	@FXML
	private TextField URLField;
	@FXML
	private TextField directoryField;
	private String url;
	private String directory = null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event)
			{
				try {
					if(directory != null) {
						url = URLField.getText();
						ThreadToPNG ttpng = new ThreadToPNG(url,directory);
						directory = null;
						url = "";
					}
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
					fileChooser.getExtensionFilters().addAll(
			                new FileChooser.ExtensionFilter("PNG", "*.png")
			            );
					directory = fileChooser.showSaveDialog(null).getAbsolutePath();
					directoryField.setText(directory);
				
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
