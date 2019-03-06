package application;

import java.util.ArrayList;

import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
	
	static void addBoxes( StackPane pane) {
		
		
		double Scale = pane.getWidth()/fileLoader.loadedImage.getWidth();
		
		for(box box: listPfBoxes) {
			box.getxys();
			int width = box.bottomX - box.topX;
			int height = box.bottomY - box.topY;
			Rectangle rect = new Rectangle(width*Scale,height*Scale,Color.TRANSPARENT);
			rect.setStroke(Color.RED);
			rect.setStrokeWidth(5);
			rect.setTranslateX(box.topX*Scale);
			rect.setTranslateY(box.topY*Scale);
			pane.getChildren().add(rect);
		}
	}
}
