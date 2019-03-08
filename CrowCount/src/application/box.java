package application;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class box {
	
	private double topX = fileLoader.loadedImage.getWidth()+1;
	private double topY = fileLoader.loadedImage.getHeight()+1;
	private int bottomX,bottomY,num=0;
	static ArrayList<box> listPfBoxes = new ArrayList<box>();
	static int numberOfCrows = 0;
	private int numberOfPixels=1;
	private crowPixel root;
	
	public box(crowPixel rootPix){
		root = rootPix;
	}
	
	public void getxys() {
		for(String key: flock.keyList) {
			crowPixel cheking = flock.crowDisjointSet.get(key);
			if(cheking.getParent() == root) {// <========= Find if elament of set
				if(cheking.getPixelX() < topX) {
					topX = cheking.getPixelX();
				}
				if(cheking.getPixelX() > bottomX) {
					bottomX = cheking.getPixelX();
				}
				if(cheking.getPixelY() < topY) {
					topY = cheking.getPixelY();
				}
				if(cheking.getPixelY() > bottomY) {
					bottomY = cheking.getPixelY();
				}
			numberOfPixels++;
			}
		}
	}
	
	public static void addBoxes( StackPane Pane, ImageView image ,double trigg,double lowEndTrig) {
		double Scale;
		numberOfCrows = 0;
		Pane.getChildren().clear();
		Pane.getChildren().add(image);
		if(image.getImage().getHeight()>image.getImage().getWidth()) {
			Scale = (image.getFitHeight())/(image.getImage().getHeight());	
		}
		else {
			Scale = (image.getFitWidth())/(image.getImage().getWidth());
		}
		
		for(box box: listPfBoxes) {
			
			box.getxys();
			double width = box.bottomX - box.topX +1;
			double height = box.bottomY - box.topY +1;
			double X = box.topX*Scale;
			double Y = box.topY*Scale;
			
			Rectangle rect = new Rectangle(width*Scale,height*Scale,Color.TRANSPARENT);
			Label num = new Label();
			
			int groupNumber = (int) Math.round(box.numberOfPixels/trigg);
			
			if(groupNumber > 1 && groupNumber <10) {
				rect.setStroke(Color.GREEN);
				int lowEnd = ++numberOfCrows;
				numberOfCrows=numberOfCrows+(groupNumber-1);
				num.setText(""+lowEnd+"-"+numberOfCrows);
				num.setTextFill(Color.RED);
			}
			else if(box.numberOfPixels < lowEndTrig ) {
				rect.setStroke(Color.TRANSPARENT);
				num.setTextFill(Color.TRANSPARENT);
			}
			else if(groupNumber > 10) {
				rect.setStroke(Color.RED);
				num.setText("ERROR");
				num.setTextFill(Color.GREEN);
			}
			else {
				rect.setStroke(Color.BLUE);
				numberOfCrows++;
				num.setText(""+numberOfCrows);
				num.setTextFill(Color.ORANGE);
			}
			
			rect.setStrokeWidth(5);
			rect.setTranslateX(X);
			rect.setTranslateY(Y);
			
			//System.out.println(" topX:"+box.topX+" topY:"+box.topY+" bottomX:"+box.bottomX+" bottomY:"+box.bottomY);
			
			num.setStyle("-fx-font: 24 arial;");
			num.setTranslateY(Y); 
			num.setTranslateX(X); //<<== if uncomented will display numbers but freze afterwirds 
			Pane.getChildren().add(rect);
			Pane.getChildren().add(num);
			
		}
	}
	
	public double getTopX() {
		return topX;
	}
	public void setTopX(double topX) {
		this.topX = topX;
	}
	public double getTopY() {
		return topY;
	}
	public void setTopY(double topY) {
		this.topY = topY;
	}
	public int getBottomX() {
		return bottomX;
	}
	public void setBottomX(int bottomX) {
		this.bottomX = bottomX;
	}
	public int getBottomY() {
		return bottomY;
	}
	public void setBottomY(int bottomY) {
		this.bottomY = bottomY;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}


