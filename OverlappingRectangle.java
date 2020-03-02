/**
 * 
 */
package main.java;

/**
 * @author 503054866
 *
 */
public class OverlappingRectangle {

	
	public Rectangle overlapRectangle(Rectangle r1, Rectangle r2) {
		
		int overlapX;
		int overlapY;
		int overlapWidth;
		int overlapHeight;
		
		Rectangle leftRectangle;
		Rectangle rightRectangle;
		
		Rectangle upperRectangle;
		Rectangle lowerRectangle;
		
		//Decide left and Right Rectangles
		if (r1.x <= r2.x) {
			leftRectangle = r1;
			rightRectangle = r2;
		} else {
			leftRectangle = r2;
			rightRectangle = r1;
		}
		
		if(r1.y <= r2.y) {
			lowerRectangle = r1;
			upperRectangle = r2;
		} else { 
			lowerRectangle = r2;
			upperRectangle = r1;
		}
		
		//x-axis overlap check
		if (leftRectangle.x +leftRectangle.width <= rightRectangle.x) {
			//no overlap
			return null;
		} else if(leftRectangle.x + leftRectangle.width >= rightRectangle.x + rightRectangle.width) {
			//fullOverlap
			overlapWidth = rightRectangle.width;
		} else {
			//partial overlap
			overlapWidth = leftRectangle.x+leftRectangle.width - rightRectangle.x;
		}
		
		//y-axis overlap check
		if (lowerRectangle.y + lowerRectangle.height <= upperRectangle.y) {
			//no overlap
			return null;
		} else if(lowerRectangle.y+lowerRectangle.height >= upperRectangle.y + upperRectangle.height ) {
			//full overlap
			overlapHeight = rightRectangle.height;
		} else {
			overlapHeight = lowerRectangle.y + lowerRectangle.height - upperRectangle.y; 
		}
		
		overlapX = rightRectangle.x;
		overlapY = upperRectangle.y;
		
		return new Rectangle(overlapX, overlapY, overlapWidth, overlapHeight);
		
	}
	
	public class Rectangle {
		
		int x;
		int y;
		int width;
		int height;
		
		public Rectangle(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.width = w;
			this.height = h;
		}
		
		@Override
		public String toString() {
			return "X: " + this.x + "  Y: " + this.y + " width: " + this.width + " height: " + this.height; 
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OverlappingRectangle rect = new OverlappingRectangle();
		//Rectangle r1 = rect.new Rectangle(5, 10, 7, 8);
		Rectangle r2 = rect.new Rectangle(10, 3, 5, 8);
		Rectangle r3 = rect.new Rectangle(0, 0, 10, 10);
		
		System.out.println(rect.overlapRectangle(r2, r3));
		
	}

}
