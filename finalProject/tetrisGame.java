package finalProject;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import sedgewick.StdDraw;

public class tetrisGame {
	
	public static cubeBlock currentBlock = new cubeBlock(new Point(5.5,5.5),1);
	public static ArrayList<Block> allBlocks = new ArrayList<>();

	
	public static void main(String [] args) {
		new gameBoard().setup();
		new gameBoard().drawBoard();
		setupKeyboard();
		
	
	
		
		for (int i = 0; i < 5; i++) {
			allBlocks.add(new cubeBlock (new Point(0.5 + (i * 2),1.5), 1));
		}
		allBlocks.add(currentBlock);
		
		
		for (Block b: allBlocks) {
			drawBlocks(b);
		}
		
		int [][] gameBoard = new int[20][10];
		gameBoard = new int[20][10];
		for(Block b: allBlocks) {
			for (Point p: b.getBlocks()) {
				System.out.println("Adding (" + p.getX() + " , " + p.getY() + ") ");
				gameBoard[(int)p.getY()][(int)p.getX()] = 1;
			}
			
		}
		
		for (int i =0; i < gameBoard.length; i++) {
			int count=0;
			for (int j = 0; j < gameBoard[0].length; j++) {
				if (gameBoard[i][j] == 1) {
					count++;
					System.out.println("Block at (" + i + " , " + j + ")" );
				}
			}
			if (count >= 10)
			System.out.println("Row " + i + " is full");
			
		}
		
		
		System.out.println("Done");
		
	
		
	
	}
	
	public static void reDraw() {
		clearBoard();
		new gameBoard().drawBoard();
		System.out.println(allBlocks.size());
		for (Block b: allBlocks) {
			drawBlocks(b);
		}
		
		StdDraw.show(20);
	}
	
	public static void clearBoard() {
		StdDraw.clear();
	}
	
	public static void drawBlocks(Block b) {
		StdDraw.setPenColor(StdDraw.BLUE);
		for (Point block: b.getBlocks()) {
		
//			StdDraw.filledSquare(block.getX() + 5, block.getY(), b.getRadius()/2);
			StdDraw.square(block.getX() + 5, block.getY(), b.getRadius()/2);
//			System.out.println("Block is located at ( " + block.getX() + ", " + block.getY() + " ) with a radius of " + b.getRadius());
		}
	}
	
	private static void setupKeyboard() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
        
       
       
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (testingGround.class) {
                    switch (ke.getID()) {
                  
                    case KeyEvent.KEY_PRESSED:
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                        	if (currentBlock.getBlocks().get(0).getX() > 0.5) {
	                        	currentBlock.moveLeft();
	                        	System.out.println("Moved to " + currentBlock.getBlocks().get(0).getX() );
	                        	reDraw();
                        	}
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                        	if (currentBlock.getBlocks().get(0).getX() < 8.5) {
	                        	currentBlock.moveRight();
	                        	System.out.println("Moved to " + currentBlock.getBlocks().get(0).getX() );
	                        	reDraw();
                        	}
                         }
                        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                            System.out.println("Space");
                         }
                        
                   
                    }
                    return false;
                }
            }
            
        });
	}
}
