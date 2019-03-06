
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class controler {
	// set up @fxml elaments
	@FXML
	private ImageView image;
	@FXML
	private Label name;
	@FXML
	private Label rez;
	@FXML
	private Label crowCount;
	@FXML 
	private StackPane stack;
	@FXML 
	private Pane pane;
	

	//
	// sets imadge back to normal by loading the original image
	@FXML
	void changeFull(ActionEvent event) {
		image.setImage(fileLoader.loadedImage);// changes image
	}

	@FXML
	public void changeWB(ActionEvent event) {// changes the imadge to black and white
		WritableImage wb = imadgeGenerator.blackWhiteGen();
		image.setImage(wb);// changes image
		box.addBoxes(stack,image);
		crowCount.setText("Crow Cont:"+ box.numberOfCrows);
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
