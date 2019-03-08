package application;

public class crowPixel {
	private int pixelX,pixelY;
	private crowPixel parent = null;

	public crowPixel(int x, int y) {
		this.pixelX=x;
		this.pixelY=y;
		
	}

	public void attachToRoot(crowPixel node) {
		while(node.getParent() != null) {
			node = node.getParent();
		}
		if(node != this) {
			this.setParent(node);
		}
	}
	
	public int getPixelX() {
		return pixelX;
	}
	public void setPixelX(int pixelX) {
		this.pixelX = pixelX;
	}
	public int getPixelY() {
		return pixelY;
	}
	public void setPixelY(int pixelY) {
		this.pixelY = pixelY;
	}
	public void setParent(crowPixel newParent) {
		this.parent = newParent;
	}
	public crowPixel getParent() {
		return this.parent;
	}

}
