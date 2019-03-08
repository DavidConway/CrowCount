package application;

public class crowPixel {
	int pixelX,pixelY;
	private crowPixel parent = null;

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
	
	public void attachToRoot(crowPixel node) {
		while(node.getParent() != null) {
			node = node.getParent();
		}
		if(node != this) {
			this.setParent(node);
		}
	}
	
}
