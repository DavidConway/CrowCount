package application;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class imadgeGenerator {



	public static WritableImage blackWhiteGen() {
		int width = (int) fileLoader.loadedImage.getWidth();// gets image width
		int height = (int) fileLoader.loadedImage.getHeight();// gets image height

		WritableImage wb = new WritableImage(width, height);// Creates a blank image to be written to

		for (int x = 0; x < width; x++) {// loops throw each colom of pixels
			for (int y = 0; y < height; y++) {// Goes throw each pixel in a given colom

				Color color = fileLoader.loadedImage.getPixelReader().getColor(x, y);// gets the original color of the pixel
				Color newColor = color.grayscale();// grayscale's it
				if(newColor.getRed()<0.5) {
					newColor = new Color(0,0,0,1);
				}
				else {
					newColor = new Color(1,1,1,1);
				}
				wb.getPixelWriter().setColor(x, y, newColor);// makes the corresponding pixel in the black image the newcolor

			}
		}
		return wb;
		
	}

}
