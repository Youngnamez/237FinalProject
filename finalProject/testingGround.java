package finalProject;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import sedgewick.StdDraw;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class testingGround {
    static final int LEFT = 1;
    static final int RIGHT = 2;
    static final int UP = 3;
    static final int DOWN = 4;

    static final int BLACK = 1;
    static final int BLUE = 2;
    static final int WHITE = 3;
    static final int RED = 4;
    static int direction = UP;


    public static int currentLength = 1;
    public static int currXPos = 10;
    public static int currYPos = 10;
    public static int [][] arr = new int[20][20];
    public static void main (String [] args) {
//        StdDraw.enableDoubleBuffering();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                synchronized (testingGround.class){
                    switch (keyEvent.getID() ){
                        case KeyEvent.KEY_PRESSED:
                            if (keyEvent.getKeyCode() == KeyEvent.VK_A){
                               currXPos -= 1;
                            }

                           
                            if (keyEvent.getKeyCode() == KeyEvent.VK_D){
                            	currXPos += 1;
                            }
                          
                    }
                }

                return true;

            }
        });

//        int scale = ap.nextInt("Choose Game Scale (5 minimum)");
        int scale = 25;

        initializeGame(scale);
        //start point and start goal
        arr[currXPos][currYPos] = 1;


        while (true) {
            StdDraw.clear();
            System.out.println(currXPos);
            arr[currXPos][currYPos] = 1;
            visualizeBoard(arr);
            StdDraw.show(20);
            StdDraw.pause(70);

        }

    }

    private static void initializeGame(int scale){
         currXPos = scale/2;
         currYPos = scale/2;
         arr = new int[scale][scale];
        StdDraw.setScale(0, scale);
    }

    private static boolean isValidMove(int x, int y, int [][]arr){
        if (x < 0 || x >= arr.length || y >= arr[0].length || y <0){

           return false;
        }
        if (arr[x][y] > 0 )
            return false;
        return true;
    }









    private static void clearBoard(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = 0;
            }
        }
    }

   

    public static void visualizeBoard(int [][] arr){
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if(arr[i][j] == 1){
                    drawPosition(i,j, BLACK);
                }

                if(arr[i][j] == 2){
                    drawPosition(i,j, BLUE);
                }
                
                else {
                	drawPosition(i,j, WHITE);
                }
                
            }

        }
    }

    public static void drawPosition(int x, int y, int color){
        if (color == WHITE){
            StdDraw.setPenColor(Color.white);
        }

        else if (color == BLUE){
            StdDraw.setPenColor(Color.blue);
        }
        else if (color == -1){
            StdDraw.setPenColor(Color.red);
            System.out.println("HI");
        }
        else{
            StdDraw.setPenColor(Color.black);

        }
        StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
    }
}
