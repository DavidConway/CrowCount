package application;

import java.util.ArrayList;
import java.util.Hashtable;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class imadgeGenerator {
	public static double treshold = 0.5;



	public static WritableImage blackWhiteGen() {
		int width = (int) fileLoader.loadedImage.getWidth();// gets image width
		int height = (int) fileLoader.loadedImage.getHeight();// gets image height
		flock.crowDisjointSet = new Hashtable<String, crowPixel>();
		flock.keyList = new ArrayList<String>();

		WritableImage wb = new WritableImage(width, height);// Creates a blank image to be written to

		for (int y = 0; y < height; y++) {// loops throw each colom of pixels
			for (int x = 0; x < width; x++) {// Goes throw each pixel in a given colom

				Color color = fileLoader.loadedImage.getPixelReader().getColor(x, y);// gets the original color of the pixel
				Color newColor = color.grayscale();// grayscale's it
				if(newColor.getRed()<treshold) {
					newColor = new Color(0,0,0,1);
					flock.addPixel(x, y);
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
