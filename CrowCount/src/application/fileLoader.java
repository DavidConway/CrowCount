package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class fileLoader {
	// Elements needed for loading image
	public static Image loadedImage;
	public static File selectedImage;
	
	public static void loadFile() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("image", "*.jpg", "*.png","*.jpeg"));
		selectedImage = fc.showOpenDialog(null);
		if (fc != null) {
			loadedImage = new Image(selectedImage.toURI().toString());

		}

	}

}
