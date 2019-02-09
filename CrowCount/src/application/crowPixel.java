package application;

public class crowPixel {
	int pixelX,pixelY;
	crowPixel parent = null;

	public crowPixel(int x, int y) {
		this.pixelX=x;
		this.pixelY=y;
		
	}
	
	public void setParent(crowPixel newParent) {
		this.parent = newParent;
	}
	
	public crowPixel getParent() {
		return this.parent;
	}
	
}
