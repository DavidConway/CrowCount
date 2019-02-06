
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
	private Label filePath;
	@FXML
	private Label rez;
	@FXML
	private Label mode;
	@FXML
	private Label benchmark;
	@FXML
	private Label timeTaken;
	//
	// Elements needed for loading image
	File selectedImage;
	Image loadedImage;

	//
	// sets imadge back to normal by loading the original image
	@FXML
	void changeFull(ActionEvent event) {
		image.setImage(loadedImage);// changes image
		mode.setText("Full color");// changes appropriate text field
	}

	//

	@FXML
	public void changeWB(ActionEvent event) {// changes the imadge to black and white
		long time = System.currentTimeMillis();// starts bench watch clock
		int width = (int) loadedImage.getWidth();// gets image width
		int height = (int) loadedImage.getHeight();// gets image height

		WritableImage wb = new WritableImage(width, height);// Creates a blank image to be written to

		for (int x = 0; x < width; x++) {// loops throw each colom of pixels
			for (int y = 0; y < height; y++) {// Goes throw each pixel in a given colom

				Color color = loadedImage.getPixelReader().getColor(x, y);// gets the original color of the pixel
				Color newColor = color.grayscale();// grayscale's it
				wb.getPixelWriter().setColor(x, y, newColor);// makes the corresponding pixel in the black image the newcolor

			}
		}
		image.setImage(wb);// changes image
		mode.setText("Black/White");// changes appropriate text field
		time = System.currentTimeMillis() - time;
		timeTaken.setText("" + time + "ms");// changes appropriate text field
	}

	@FXML
	void changeRed(ActionEvent event) {
		long time = System.currentTimeMillis();
		int width = (int) loadedImage.getWidth();
		int height = (int) loadedImage.getHeight();

		WritableImage redImg = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Color color = loadedImage.getPixelReader().getColor(x, y);
				double red = (color.getRed());
				Color redColor = new Color(red, 0, 0, color.getOpacity());
				redImg.getPixelWriter().setColor(x, y, redColor);

			}

		}
		image.setImage(redImg);// changes image
		mode.setText("Red channel");// changes appropriate text field
		time = System.currentTimeMillis() - time;
		timeTaken.setText("" + time + "ms");// changes appropriate text field
	}

	@FXML
	void changeBlue(ActionEvent event) {
		long time = System.currentTimeMillis();
		int width = (int) loadedImage.getWidth();
		int height = (int) loadedImage.getHeight();

		WritableImage blueImg = new WritableImage(width, height);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				Color color = loadedImage.getPixelReader().getColor(x, y);

				double blue = (color.getBlue());
				Color redColor = new Color(0, 0, blue, color.getOpacity());
				blueImg.getPixelWriter().setColor(x, y, redColor);

			}
		}
		image.setImage(blueImg);// changes image
		mode.setText("Blue channel");// changes appropriate text field
		time = System.currentTimeMillis() - time;
		timeTaken.setText("" + time + "ms");// changes appropriate text field
	}

	@FXML
	void changeGreen(ActionEvent event) {
		long time = System.currentTimeMillis();
		int width = (int) loadedImage.getWidth();
		int height = (int) loadedImage.getHeight();

		WritableImage greenImg = new WritableImage(width, height);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {

				Color color = loadedImage.getPixelReader().getColor(x, y);

				double green = (color.getGreen());
				Color greenColor = new Color(0, green, 0, color.getOpacity());
				greenImg.getPixelWriter().setColor(x, y, greenColor);

			}
		}
		image.setImage(greenImg);// changes image
		mode.setText("Green channel");// changes appropriate text field
		time = System.currentTimeMillis() - time;
		timeTaken.setText("" + time + "ms");// changes appropriate text field
	}

	@FXML
	void openFileClick(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("image", "*.jpg", "*.png"));
		selectedImage = fc.showOpenDialog(null);
		if (fc != null) {
			loadedImage = new Image(selectedImage.toURI().toString());
			
			image.setImage(loadedImage);// changes image
			System.out.println(selectedImage.toURI().toString());
			rez.setText("X:" + loadedImage.getWidth() + " Y:" + loadedImage.getHeight());// changes appropriate text
			// field
			mode.setText("full color");// changes appropriate text field
			name.setText(selectedImage.getName());// changes appropriate text field
			filePath.setText(selectedImage.getPath());
		}

	}

}
