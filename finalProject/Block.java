package finalProject;

import java.util.ArrayList;

public interface Block {

    public ArrayList<Point> getBlocks();
	
	public Point getCenter();

	public double getRadius();
	
	public void initializeBlock();
	
	public void moveLeft();
	
	public void moveRight();
}