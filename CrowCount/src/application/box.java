package application;

import java.util.ArrayList;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class box {
	public int topX = 10000,topY=10000,bottomX=0,bottomY=0,num=0;;
	static ArrayList<box> listPfBoxes = new ArrayList<box>();
	crowPixel root;
	box(crowPixel rootPix){
		root = rootPix;
		getxys();
	}
	
	
	public void getxys() {
		for(String key: flock.keyList) {
			crowPixel cheking = flock.crowDisjointSet.get(key);
			if(cheking.parent == root) {
				if(cheking.pixelX < topX) {
					topX = cheking.pixelX;
				}
				else if(cheking.pixelX > bottomX) {
					bottomX = cheking.pixelX;
				}
				if(cheking.pixelY < topY) {
					topY = cheking.pixelY;
				}
				else if(cheking.pixelY > bottomY) {
					bottomY = cheking.pixelY;
				}
			}
		}
	}
	
	static WritableImage addBoxes( WritableImage image) {
		for(box box: listPfBoxes) {
			box.getxys();
			int width = box.bottomX - box.topX;
			int height = box.bottomY - box.topY;
			for(int x = box.topX; x<=box.topX+width;x++) {
				image.getPixelWriter().setColor(x, box.topY, Color.BLUE);
			}
			for(int x = box.topX; x<=box.topX+width;x++) {
				image.getPixelWriter().setColor(x, box.bottomY, Color.BLUE);
			}
			for(int y = box.topY; y<=box.topY+height;y++) {
				image.getPixelWriter().setColor(box.topX, y, Color.BLUE);
			}
			for(int y = box.topY; y<=box.topY+height;y++) {
				image.getPixelWriter().setColor(box.bottomX, y, Color.BLUE);
			}	
		}
		return image;
	}
}
