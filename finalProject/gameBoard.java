package finalProject;

import sedgewick.StdDraw;

public class gameBoard {

	public void setup() {

		StdDraw.setCanvasSize(850,850);
		StdDraw.setScale(-1, 20);
	}
	
	public void drawBoard() {
//		StdDraw.setXscale(-5, 35);
//		StdDraw.setYscale(-5, 25);
		
//		StdDraw.setPenColor();
		//Main Square
//		StdDraw.filledRectangle(10, 10, 5, 10);
		StdDraw.rectangle(10, 10, 5, 10);
		
		//Hold Block Square
		StdDraw.rectangle(3, 18, 2, 2);
		
		//Next Block Square
		StdDraw.rectangle(16.5, 15, 1.5, 5);
	}

}
