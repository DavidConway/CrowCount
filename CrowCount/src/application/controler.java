
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class controler {
	WritableImage wb;
	
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
	@FXML
	private Slider sensativaty;
	@FXML
	private Slider crowTrigger;
	@FXML
	private Slider lowEnd;
	//
	// sets imadge back to normal by loading the original image
	@FXML
	void changeFull(ActionEvent event) {
		image.setImage(fileLoader.loadedImage);// changes image
	}

	@FXML
	public void changeWB(ActionEvent event) {// changes the imadge to black and white
		wb = imadgeGenerator.blackWhiteGen(sensativaty.getValue());
		image.setImage(wb);// changes image
	}
	
	@FXML
	public void clear(ActionEvent event) {
		stack.getChildren().clear();
		stack.getChildren().add(image);
	}
	
	@FXML
	public void generate(ActionEvent ecent) {
		wb = imadgeGenerator.blackWhiteGen(sensativaty.getValue());
		box.addBoxes(stack,image,crowTrigger.getValue(),lowEnd.getValue());
		crowCount.setText("Crow Cont:"+ box.numberOfCrows);
	}

	@FXML
	public void openFileClick(ActionEvent event) {
		stack.getChildren().clear();
		stack.getChildren().add(image);
		fileLoader.loadFile();
		image.setImage(fileLoader.loadedImage);// changes image
		rez.setText("X:" + fileLoader.loadedImage.getWidth() + " Y:" + fileLoader.loadedImage.getHeight());// changes appropriate text
		// field
		name.setText(fileLoader.selectedImage.getName());// changes appropriate text field
		wb = imadgeGenerator.blackWhiteGen(sensativaty.getValue());
		//test
	}
	
	@FXML
	public void sliderMoved(MouseEvent event) {
		stack.getChildren().clear();
		stack.getChildren().add(image);
		if(image.getImage().equals(wb)) {
			wb = imadgeGenerator.blackWhiteGen(sensativaty.getValue());
			image.setImage(wb);// changes image
		}
	}

}
