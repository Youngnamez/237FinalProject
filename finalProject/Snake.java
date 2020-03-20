package finalProject;


//import edu.princeton.cs.introcs.StdDraw;
import sedgewick.StdDraw;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Snake {
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
    public static int [] goal = getNewGoalPosition(arr);
    public static void main (String [] args) {
        StdDraw.enableDoubleBuffering();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                synchronized (Final.class){
                    switch (keyEvent.getID() ){
                        case KeyEvent.KEY_PRESSED:
                            if (keyEvent.getKeyCode() == KeyEvent.VK_A){
                                if (direction != RIGHT)
                                    direction = LEFT;
                            }

                            if (keyEvent.getKeyCode() == KeyEvent.VK_S){
                                if (direction != UP)
                                direction = DOWN;
                            }
                            if (keyEvent.getKeyCode() == KeyEvent.VK_D){
                                if (direction != LEFT)
                                direction = RIGHT;
                            }
                            if (keyEvent.getKeyCode() == KeyEvent.VK_W){
                                if (direction != DOWN)
                                direction = UP;
                            }
                    }
                }

                return true;

            }
        });

        ArgsProcessor ap = new ArgsProcessor(args);
//        int scale = ap.nextInt("Choose Game Scale (5 minimum)");
        int scale = 25;

        initializeGame(scale);
        //start point and start goal
        arr[currXPos][currYPos] = 1;
        arr[goal[0]][goal[1]] = -1;


        while (true) {
            StdDraw.clear();
            moveBoard(arr, currXPos, currYPos, direction,goal);
            //if the player loses
            if (!isValidMove(currXPos, currYPos, arr)){
                restartGame();
            }

            arr[currXPos][currYPos] = currentLength + 1;

            //if player has touched goal;
            if (checkGoal(currXPos, currYPos, goal)){
                increaseSnakeScore();
            }

            decrementArray(arr);
            visualizeBoard(arr);
            StdDraw.show();
            StdDraw.pause(70);

        }

    }

    private static void initializeGame(int scale){
         currXPos = scale/2;
         currYPos = scale/2;
         arr = new int[scale][scale];
         goal = getNewGoalPosition(arr);
        StdDraw.setScale(0, scale);
    }

    private static void increaseSnakeScore() {
        currentLength++;
        drawPosition(currXPos, currYPos, BLACK);
        System.out.println("Current Length is now " + currentLength);
        arr[currXPos][currYPos] = currentLength;
        goal = getNewGoalPosition(arr);
        arr[goal[0]][goal[1]] = -1;
        System.out.println("New Goal is (" + goal[0] + ", " + goal[1] + ")");
    }

    private static void restartGame() {
        drawFailedPosition();
        System.out.println("You Lost. Restarting now.");
        clearBoard(arr);
        goal = getNewGoalPosition(arr);
        currentLength = 1;
        currXPos = 10;
        currYPos = 10;
        arr[currXPos][currYPos] = 1;
        arr[goal[0]][goal[1]] = -1;
    }

    private static void drawFailedPosition() {
        int xPos = currXPos;
        int yPos = currYPos;

        System.out.println("Start\n XPos : " + xPos + " \t YPos: " + yPos);

        switch (direction){
            case UP:
                yPos--;
                break;
            case DOWN:
                yPos++;
                break;
            case LEFT:
                xPos++;
                break;
            case RIGHT:
                xPos--;
                break;
        }

        System.out.println("------------\n After\n XPos : " + xPos + " \t YPos: " + yPos);


        visualizeBoard(arr);
        StdDraw.setPenColor(Color.red);
        StdDraw.filledRectangle(xPos + .5, yPos +.5, .5, .5);
        StdDraw.show();
        StdDraw.pause(1000);
    }

    private static boolean isValidMove(int x, int y, int [][]arr){
        if (x < 0 || x >= arr.length || y >= arr[0].length || y <0){

           return false;
        }
        if (arr[x][y] > 0 )
            return false;
        return true;
    }

    private static int[] getNewGoalPosition(int[][] arr) {

        boolean foundSpot = false;
        int newX = 0;
        int newY = 0;
        while (foundSpot == false){
            newX = (int)(Math.random() * (arr.length - 1));
            newY = (int)(Math.random() * (arr[0].length - 1));

            if (arr[newX][newY] == 0){
                foundSpot = true;
                drawPosition(newX, newY, BLUE);
            }
        }
        return new int[]{newX, newY};
    }

    private static boolean checkGoal(int x, int y, int [] goal) {
        if (goal[0] == x && goal [1] == y){
           return true;
        }
        return false;
    }


    public static void moveBoard(int [][]arr, int snakeHeadX, int snakeHeadY, int direction, int [] goal){
            if (direction == UP) {
                snakeHeadY++;
            }
            if (direction == DOWN) {
                snakeHeadY--;
            }
            if (direction == LEFT) {
                snakeHeadX--;
            }
            if (direction == RIGHT) {
                snakeHeadX++;
            }
        currXPos = snakeHeadX;
        currYPos =  snakeHeadY;
    }


    private static void clearBoard(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = 0;
            }
        }
    }

    private static void decrementArray(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > 0){
                    arr[i][j]--;
                }
            }
        }

    }

    public static void visualizeBoard(int [][] arr){
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if(arr[i][j] >= 1){
                    drawPosition(i,j, BLACK);
                }

                if(arr[i][j] == -1){
                    drawPosition(i,j, BLUE);
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
