package image.effects;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Adrian
 * Performs flood fill function around circle spots in given image
 */
public class FloodFill implements ImageEffects {
	private List<Shape> shapes = new ArrayList<Shape>();
	private java.awt.Color fillColour= Color.BLACK;
	
	
	/**
	 * 
	 */
	public FloodFill(List<Shape> shapes) {
		this.shapes=shapes; //how to clone list?
	}

	
	public void setFillColour(Color fillColour){
		this.fillColour=fillColour;
	}
	
	public void addShape(Shape shape){
		shapes.add(shape);
	}
	
	public BufferedImage applyEffect(BufferedImage image){
		/*1: create blank image of the size of img passed in (make background color G)
		 *2: create filled circles on areas passed in (x,y,+radius)
		 *3: combine this img w the one passed in: if img2.getColour(x,y)==G then origImg.pixel(x,y).setColour(BLACK)
		 */
		
		//TYPE_INT_ARGB
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.BITMASK);
        Graphics2D g = (Graphics2D)newImage.getGraphics();
        for (Shape shape: shapes){
        	shape.draw(g, true);
        }
		return newImage;
	}
	
}
