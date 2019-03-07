package application;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class box {
	public double topX = fileLoader.loadedImage.getWidth()+1;
	public double topY = fileLoader.loadedImage.getHeight()+1;
	public int bottomX,bottomY,num=0;;
	static ArrayList<box> listPfBoxes = new ArrayList<box>();
	static int numberOfCrows = 0;
	crowPixel root;
	box(crowPixel rootPix){
		root = rootPix;
	}
	
	
	public void getxys() {
		for(String key: flock.keyList) {
			crowPixel cheking = flock.crowDisjointSet.get(key);
			if(cheking.parent == root) {
				if(cheking.pixelX < topX) {
					topX = cheking.pixelX;
				}
				if(cheking.pixelX > bottomX) {
					bottomX = cheking.pixelX;
				}
				if(cheking.pixelY < topY) {
					topY = cheking.pixelY;
				}
				if(cheking.pixelY > bottomY) {
					bottomY = cheking.pixelY;
				}
			}
		}
	}
	
	public static void addBoxes( StackPane Pane, ImageView image) {
		double Scale;
		numberOfCrows = 0;
		if(image.getImage().getHeight()>image.getImage().getWidth()) {
			Scale = (image.getFitHeight())/(image.getImage().getHeight());	
		}
		else {
			Scale = (image.getFitWidth())/(image.getImage().getWidth());
		}
		
		for(box box: listPfBoxes) {
			
			box.getxys();
			double width = box.bottomX - box.topX+1;
			double height = box.bottomY - box.topY+1;
			double X = box.topX*Scale;
			double H =Scale;
			double Y = box.topY*Scale;
			
			Rectangle rect = new Rectangle(width*Scale,height*Scale,Color.TRANSPARENT);
			rect.setStroke(Color.RED);
			rect.setStrokeWidth(5);
			rect.setTranslateX(X);
			rect.setTranslateY(Y);
			Pane.getChildren().add(rect);
			System.out.println(" topX:"+box.topX+" topY:"+box.topY+" bottomX:"+box.bottomX+" bottomY:"+box.bottomY);
			
			Label num = new Label(""+ ++numberOfCrows );
			num.setTextFill(Color.GREEN);
			num.setStyle("-fx-font: 24 arial;");
			num.setTranslateY(Y); 
			num.setTranslateX(X); //<<== if uncomented will display numbers but freze afterwirds 
			Pane.getChildren().add(num);


		}
	}
}
