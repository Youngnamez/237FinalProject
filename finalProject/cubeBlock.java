package finalProject;

import java.util.ArrayList;

public class cubeBlock implements Block {

	private ArrayList<Point> blocks;
	private Point center;
	private double radius;
	
	public cubeBlock(Point topLeftCenter, double radius) {
		this.center = topLeftCenter;
		this.blocks = new ArrayList<>();
		this.radius = radius;
		initializeBlock();
	}
	
	public ArrayList<Point> getBlocks(){
		return this.blocks;
	}
	
	public Point getCenter() {
		return this.center;
	}

	public double getRadius() {
		return this.radius;
	}
	
	public void initializeBlock() {
		//Make upperLeft Block
		this.blocks.add(new Point(this.center.getX(), this.center.getY()));
		
		//Upper Right
		this.blocks.add(new Point(this.center.getX() + radius, this.center.getY()));
		
		//Bottom Left
		this.blocks.add(new Point(this.center.getX(), this.center.getY() - radius));
		
		///Bottom Right
		this.blocks.add(new Point(this.center.getX() + radius, this.center.getY() - radius));
				
	}
	
	public void moveLeft() {
		for (Point b: blocks) {
			b.moveLeft();
		}
	}
	public void moveRight() {
		for (Point b: blocks) {
			b.moveRight();
		}
	}
}
