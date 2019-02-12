package application;

import java.util.ArrayList;
import java.util.Hashtable;

public class flock {
	static Hashtable<String, crowPixel > crowDisjointSet;
	static ArrayList<String> keyList;

	public static void addPixel(int x, int y) {
		crowPixel newPixel = new crowPixel(x,y);
		String key = ("x"+x+"y"+y).toString();
		System.out.println(key);
		crowDisjointSet.put(key, newPixel);
		keyList.add(key);
		//checkUp(newPixel);
		//checkLeft(newPixel);
		addLinks(newPixel);
		
	}
	
	static private void addLinks(crowPixel pixel) {
		crowPixel check;
		String upKey = ("x"+(pixel.pixelX)+"y"+(pixel.pixelY-1)).toString();
		String leftKey = ("x"+(pixel.pixelX-1)+"y"+(pixel.pixelY)).toString();
		if(crowDisjointSet.get(upKey) != null) {
			check = crowDisjointSet.get(upKey);
			if(check.parent == null) {
				check.parent = pixel;
			}
			else {
				pixel.parent = check;
			}
			
			if(crowDisjointSet.get(leftKey) != null) {
				check = crowDisjointSet.get(leftKey);
				if(check.parent == null) {
					check.parent = pixel;
				}
			}
		}
		else if(crowDisjointSet.get(leftKey) != null) {
			check = crowDisjointSet.get(leftKey);
			if(check.parent == null) {
				check.parent = pixel;
			}
			else{
				pixel.parent = check;
			}
		}
	}
	/*private static void checkUp(crowPixel pixel) {
		String findKey = ("x"+(pixel.pixelX)+"y"+(pixel.pixelY-1)).toString();
		crowPixel check;
		
		try {
			check = crowDisjointSet.get(findKey);
		} catch (Exception e) {
			check = null;
		}
		
		if(check != null) {
			if(check.parent == null) {
				check.parent = pixel;
			}
			else {
				pixel.parent = check;
			}
		System.out.println(" UP"+findKey);
		}
		
		
	}
	
	private static void checkLeft(crowPixel pixel) {
		String findKey = ("x"+(pixel.pixelX-1)+"y"+(pixel.pixelY)).toString();
		crowPixel check;
		
		try {
			check = crowDisjointSet.get(findKey);
		} catch (Exception e) {
			check = null;
		}
		
		if(check != null) {
			if(check.parent == null) {
				check.parent = pixel;
			}
			else if(check.parent == null){
				pixel.parent = check;
			}
		System.out.println(" Left"+findKey);
		}
		
	}*/

	public static int numberOfCrows() {
	//	Hashtable<String, crowPixel > test =crowDisjointSet;
		int crowCount = 0;
		for(String key: keyList) {
			if(crowDisjointSet.get(key).parent==null) {
			crowCount++;	
			}
		}
		return crowCount;
		
	}
}
