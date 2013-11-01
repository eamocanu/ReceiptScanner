package image.manipulation;

import image.effects.CircleSpot;
import image.effects.FloodFill;
import image.effects.ImageEffects;
import image.effects.RectangleShape;
import image.effects.Shape;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * 
 */
import java.util.List;

/**
 * @author Adrian
 *
 */
public class PhotoImage {
	BufferedImage image;
	//List<CircleSpot> circlesList= new ArrayList<CircleSpot>();
	List<Shape> shapes= new ArrayList<Shape>();
	List<ImageEffects> imageEffects= new ArrayList<ImageEffects>();
			 
	/**
	 * 
	 */
	public PhotoImage( BufferedImage image) {
		this.image=image;
	}

	
//	public void addCircleSpot(CircleSpot circle){
//		circlesList.add(circle);
//	}
	
	
	//This should only be called once ..or perhaps I can force this by clearing imageEffects first
	public void addFloodFillEffect(Shape...  newShapes){
		imageEffects = null;
		imageEffects= new ArrayList<ImageEffects>();
		
		//List<CircleSpot>x=Arrays.asList(circle);
		if (newShapes!=null) shapes.addAll(Arrays.asList(newShapes));
		//OR
		//Collections.addAll(circlesList, circle);
		
		imageEffects.add(new FloodFill(shapes));
	}
	
	
	/** Flattens image by apply circle spots to it as well as other effects */
	public BufferedImage flattenImage() {
		BufferedImage imageResult=image;
		
		for (ImageEffects effect: imageEffects){
			imageResult= effect.applyEffect(imageResult);
		}
		
		return imageResult;
	}


	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	
}
