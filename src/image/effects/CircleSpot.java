package image.effects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * 
 */

/**
 * @author Adrian
 *
 */
public class CircleSpot implements Shape {
	int x;
	int y;
	int radius;
	
	/**
	 * 
	 */
	public CircleSpot(int x, int y, int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	/*
	public BufferedImage applyEffect(){
		return null;//TODO this not needed reallysince flood fill MAY have spots
	}*/

	
	@Override
	public void draw(Graphics g, boolean filled) {
		g.setColor(Color.RED);
		if (filled) {
			g.fillOval(x, y, radius, radius);
		} else {
			g.drawOval(x, y, radius, radius);
		}
	}
	

}
