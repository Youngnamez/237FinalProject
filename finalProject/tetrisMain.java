package finalProject;


import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import sedgewick.StdDraw;

public class tetrisMain{
	static final Color BLUE = StdDraw.BLUE;
	static final Color BLACK = StdDraw.BLACK;
	static final Color WHITE = StdDraw.WHITE;
	static final int gameXScale = 10;
	static final int gameYScale = 20;
	static int [][] gameboard = new int[gameXScale][gameYScale];

public static int [] center = new int[2];
    
    public static void main(String[] args) {
    	StdDraw.setScale(gameXScale, gameYScale);
        setupKeyboard();
       
        while (true) {
        	clearBoard();
        	
        	gameboard[center[0]][center[1]] = 1;
        	System.out.println("(" + center[0] + " , " + center[1]+ ")");
        	visualizeBoard();
        	StdDraw.show(20);
        }
    }



	

	
	
	private static void clearBoard() {
        for(int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[0].length; j++) {
            	gameboard[i][j] = 0;
            }
        }
    }
	
	public static void visualizeBoard(){
        for(int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {

                if(gameboard[i][j] >= 1){
                    drawPosition(i,j, BLACK);
                }

                if(gameboard[i][j] == 2){
                    drawPosition(i,j, BLUE);
                }
                else {
                	drawPosition(i,j, WHITE);
                	}
            }

        }
    }

    public static void drawPosition(int x, int y, Color color){
            StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x * gameXScale/20.0, y * gameYScale/20.0, 0.5, 0.5);
    }


	private static void setupKeyboard() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
        
       
       
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (testingGround.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                    	 System.out.println("1");
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                        	if (center[0] > 0)
                        		center[0] -= 1;
                        }
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                        	if (center[0] < gameXScale-1)
                        	 center[0] += 1;
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
