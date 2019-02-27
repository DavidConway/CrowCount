package application;

public class box {
	int topX,topY,bottomX,bottomY;
	crowPixel root;
	box(crowPixel rootPix){
		root = rootPix;
		getxys();
	}
	
	private void getxys() {
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
				else if(cheking.pixelX > bottomX) {
					bottomY = cheking.pixelY;
				}
			}
		}
	}
}
