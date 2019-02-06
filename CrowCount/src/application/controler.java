
package application;

import java.awt.Graphics2D;
import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class controler {
	@FXML
	private BorderPane main;
	// set up @fxml elaments
	@FXML
	private ImageView image;
	@FXML
	private Label name;
	@FXML
	private Label rez;
	

	//
	// sets imadge back to normal by loading the original image
	@FXML
	void changeFull(ActionEvent event) {
		image.setImage(fileLoader.loadedImage);// changes image
	}

	//

	@FXML
	public void changeWB(ActionEvent event) {// changes the imadge to black and white
		WritableImage wb = imadgeGenerator.blackWhiteGen();
		image.setImage(wb);// changes image
	}
	
	@FXML
	public void showBoth(ActionEvent event) {
		
	}
	
	@FXML
	public void generate(ActionEvent ecent) {
		
	}

	@FXML
	void openFileClick(ActionEvent event) {
		fileLoader.loadFile();
		image.setImage(fileLoader.loadedImage);// changes image
		rez.setText("X:" + fileLoader.loadedImage.getWidth() + " Y:" + fileLoader.loadedImage.getHeight());// changes appropriate text
		// field
		name.setText(fileLoader.selectedImage.getName());// changes appropriate text field
	}

}
