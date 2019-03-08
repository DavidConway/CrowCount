package application;

import java.util.ArrayList;
import java.util.Hashtable;

public class flock {
	static Hashtable<String, crowPixel > crowDisjointSet;
	static ArrayList<String> keyList;

	public static void addPixel(int x, int y) {
		crowPixel newPixel = new crowPixel(x,y);// creats a new crow pixel
		String key = ("x"+x+"y"+y).toString();
		crowDisjointSet.put(key, newPixel);// adds the pixel to the hash table
		keyList.add(key);// adds the flocks list of keys
		addLinks(newPixel);//trys to link the pixel into the set
		
	}
	
	private static void addLinks(crowPixel pixel) {
		String upKey = ("x"+(pixel.getPixelX())+"y"+(pixel.getPixelY()-1)).toString();// figers out what a pixel aboves key whould be
		String leftKey = ("x"+(pixel.getPixelX()-1)+"y"+(pixel.getPixelY())).toString();//figers out what a pixel aboves key whould be
		crowPixel up = crowDisjointSet.get(upKey);
		crowPixel left = crowDisjointSet.get(leftKey);
		
		if(up != null && left != null) {
			if(up.getParent() == null) {
				up.attachToRoot(pixel);
			}
			if(left.getParent() == null) {
				left.attachToRoot(pixel);
			}
			
			if(pixel.getParent() == null) {
				if(left.getParent() != pixel) {
					pixel.attachToRoot(left);
				}
				else if(up.getParent() != pixel){
					pixel.attachToRoot(up);
				}
			}
		}
		
		else if(left != null) {
			if(left.getParent() == null) {
				left.attachToRoot(pixel);
			}
			else {
				pixel.attachToRoot(left);
			}
		}
		
		else if(up != null) {
			if(up.getParent() == null) {
				up.attachToRoot(pixel);
			}
			else {
				pixel.attachToRoot(up);
			}
		}
	}

	
	public static void flaten() {
		box.listPfBoxes =  new ArrayList<box>();
		for (String key: keyList) {
			crowPixel current = crowDisjointSet.get(key);
			crowPixel cheking;
			if(current.getParent() != null) {
				cheking = current.getParent(); 
				while (cheking.getParent()!=null) {
					
					cheking = cheking.getParent();
					//System.out.println(cheking.pixelX+" "+ cheking.pixelY);
				}
				
				current.setParent(cheking);;
			}
			else {
				box.listPfBoxes.add(new box(current));
			}
		}	
	}
}
