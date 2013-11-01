package image.manipulation;

import image.effects.CircleSpot;
import image.effects.RectangleShape;
import image.effects.Shape;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 */

import javax.swing.JPanel;

/**
 * @author Adrian
 * Record user input - where the circles are created and their size
 */
public class CircleMaker extends JPanel implements MouseMotionListener, MouseListener {
	BufferedImage image;
	int startX=0;
	int startY=0;
	int endX=0;
	int endY=0;
	
	//TODO change this to image instead of a list
	List<PhotoImage> images = new ArrayList<PhotoImage>();
	List<BufferedImage> results = new ArrayList<BufferedImage>();
	
	
	/**
	 * 
	 */
	public CircleMaker(BufferedImage image) {
		this.image=image;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		
		for (PhotoImage img : images){
			for (Shape shape : img.shapes){
				shape.draw(g, false);
			}
		}
		
		//draw rect for all for right now; Im too lazy to keep track of shape FIXME
		g.drawRect(startX, startY, endX-startX, endY-startY);
	}

	 
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("dragging");
		endX=e.getX();
		endY=e.getY();
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startX=e.getX();
		startY=e.getY();		
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		endX=e.getX();
		endY=e.getY();
		
		if (e.getButton() == e.BUTTON1){
			makeRectangleShape(startX,startY, endX, endY);
		} else if (e.getButton() == e.BUTTON3){
			makeCircleShape(startX,startY, endX, endY);
		} else if (e.getButton() == e.BUTTON2){
			applyEffects();
		}
	}


	private void applyEffects() {
		int i=0;
		for (PhotoImage img : images){
			img.addFloodFillEffect();
			BufferedImage flattenedImage= img.flattenImage();
			results.add(flattenedImage);
			
			saveImageToDisk("c:/delme/img "+i+".jpg", flattenedImage);
			i++;
		}
	}


	private void saveImageToDisk(String fileName, BufferedImage img) {
		 try {
			ImageUtils.saveJPEGImage(img, fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void makeCircleShape(int startX2, int startY2, int endX2, int endY2) {
		PhotoImage img= new PhotoImage(this.image);
		int r = (int) Math.round(Math.sqrt(Math.pow((endX2 - startX), 2) + Math.pow((endY2 - startY), 2)));
		img.addShape(new CircleSpot(startX, startY, r));
		images.add(img);
	}


	private void makeRectangleShape(int startX, int startY, int endX, int endY) {
		PhotoImage img= new PhotoImage(this.image);
		img.addShape(new RectangleShape(startX, startY, endX, endY));
		images.add(img);		
	}
	
	

}
