/**
 * 
 */
package image.effects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Adrian
 *
 */
public class RectangleShape implements Shape {
	int x1; int y1; int x2; int y2;
	
	/**
	 * 
	 */
	public RectangleShape(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}

	
	
	@Override
	public void draw(Graphics g, boolean filled) {
		g.setColor(Color.RED);
		if (filled) { 
			g.fillRect(x1, y1, x2-x1, y2-y1);
		} else {
			g.drawRect(x1, y1, x2-x1, y2-y1);
		}
	}

}
