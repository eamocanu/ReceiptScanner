/**
 * 
 */
package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

import image.manipulation.CircleMaker;
import image.manipulation.ImageUtils;

/**
 * @author Adrian
 *
 */
public class Main extends JFrame {
	CircleMaker circleMaker;
	
	
	
	public Main() {
		BufferedImage image;
		try {
			image = ImageUtils.openImage("c:/delme/sampleinvoice.jpg");

			circleMaker=new CircleMaker(image);
			this.add(circleMaker);
			setVisible(true);
			setTitle("Work that Image!");
			//isnt there ann auto resize?
			setSize(image.getWidth(), image.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	public static void main(String[] args) {
		Main main= new Main();
		
	}

}
