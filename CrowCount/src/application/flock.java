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
		//checkUp(newPixel);
		//checkLeft(newPixel);
		addLinks(newPixel);//trys to link the pixel into the set
		
	}
	
	static private void addLinks(crowPixel pixel) {
		crowPixel check;//stors the curent pixel being cheked for linkage
		String upKey = ("x"+(pixel.pixelX)+"y"+(pixel.pixelY-1)).toString();// figers out what a pixel aboves key whould be
		String leftKey = ("x"+(pixel.pixelX-1)+"y"+(pixel.pixelY)).toString();//figers out what a pixel aboves key whould be
		if(crowDisjointSet.get(upKey) != null) {//if there is a usabule pixel above
			check = crowDisjointSet.get(upKey);// sets check to the above pixel
			if(check.parent == null) { //if the above pixel needs a perent the curent pixel becomes its perent otherwise it becomes the curent pixels perent
				check.parent = pixel;
			}
			else {
				pixel.parent = check;
			}
			
			if(crowDisjointSet.get(leftKey) != null) { //if the pixel to the left needs a perent the curent pixel becomes its perent
				check = crowDisjointSet.get(leftKey);
				if(check.parent == null) {
					check.parent = pixel;
				}
			}
		}
		else if(crowDisjointSet.get(leftKey) != null) {// if there is no pixel above it dose the same but for the left pixel insted
			check = crowDisjointSet.get(leftKey);
			if(check.parent == null) {
				check.parent = pixel;
			}
			else{
				pixel.parent = check;
			}
		}
	}
	

	public static int numberOfCrows() {
	//	Hashtable<String, crowPixel > test =crowDisjointSet;
		int crowCount = 0;
		for(String key: keyList) {
			if(crowDisjointSet.get(key).parent==null) {//for every root pixel the crow count is incramented
			crowCount++;	
			}
		}
		return crowCount;
		
	}
	
	public static void flaten() {
		for (String key: keyList) {
			crowPixel current = crowDisjointSet.get(key);
			crowPixel cheking;
			if(current.parent != null) {
				cheking = current.parent; 
				while (cheking.parent!=null) {
					cheking = cheking.parent;
				}
				current.parent = cheking;
			}
			else {
				box.listPfBoxes.add(new box(current));
			}
		}	
	}
}
