package finalProject;

import java.util.ArrayList;

public class lineBlock implements Block {

	private ArrayList<Point> blocks;
	private Point center;
	private double radius;
	
	public lineBlock(Point topLeftCenter, double radius) {
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
		//Make bottom block
		this.blocks.add(new Point(this.center.getX(), this.center.getY()));
		
		//Make 2nd from bottom
		this.blocks.add(new Point(this.center.getX(), this.center.getY() + radius));
		
		//Make 3rd from bottom
		this.blocks.add(new Point(this.center.getX(), this.center.getY() + (2 * radius)));
		
		///Make Top Block
		this.blocks.add(new Point(this.center.getX(), this.center.getY() + (3 * radius)));
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}
}
