/**
 * 
 */
package main.java;

/**
 * @author 503054866
 *
 */
public class RectiLinearRectangle {

	
	public Rectangle overlapRectangle(Rectangle r1, Rectangle r2) {
		
		int overlapX;
		int overlapY;
		double overlapWidth;
		double overlapHeight;
		
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
		double width;
		double height;
		
		public Rectangle(int x, int y, double w, double h) {
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
		RectiLinearRectangle rect = new RectiLinearRectangle();
		//Rectangle r1 = rect.new Rectangle(5, 10, 7, 8);
		/*Rectangle r2 = rect.new Rectangle(10, 3, 5, 8);
		Rectangle r3 = rect.new Rectangle(0, 0, 10, 10);
		
		System.out.println(rect.overlapRectangle(r2, r3));*/
		
		int k = -4;
		int l = 1;
		int m = 2;
		int n = 6;
		int rectWidth = Math.abs(k) + Math.abs(m);
		int rectheight = n - l;
		
		System.out.println("Area of first rect:" + rectWidth * rectheight);
		
		int p = 0;
		int q = -1;
		int r = 4;
		int s = 3;
		int rect2Width = Math.abs(p) + Math.abs(r);
		int rect2height = s - q;
		
		System.out.println("Area of second rect:" + rect2Width * rect2height);
		int totalArea = (rectWidth * rectheight) + (rect2Width * rect2height);
		System.out.println("Total Area: " + totalArea);
		
		/*Rectangle r2 = rect.new Rectangle(10, 3, 5, 8);
		Rectangle r3 = rect.new Rectangle(10, 10, 10, 10);
		
		System.out.println(rect.overlapRectangle(r2, r3));*/
		
		Rectangle r12 = rect.new Rectangle(k,l, rectWidth,rectheight);
		Rectangle r13 = rect.new Rectangle(p, q,rect2Width, rect2height);
		
		Rectangle overlap = rect.overlapRectangle(r12, r13);
		System.out.println(rect.overlapRectangle(r12, r13));
		
		double unOverlappedArea  = totalArea - (overlap.width * overlap.height);
		
		System.out.println("UnoverlappedArea " + unOverlappedArea );
		
	}
	

}
