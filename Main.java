
// Main.java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
      System.out.println("Enter board width: ");
      int x=(int)(input.nextInt());
      System.out.println("Enter board height: ");
      int y=(int)(input.nextInt());
      System.out.println();
    	
    	System.out.println("How many two-unit ships: ");
      int twoUnit=(int)(input.nextInt());
      System.out.println("How many two-unit ships: ");
      int threeUnit=(int)(input.nextInt());
      System.out.println("How many four-unit ships: ");
      int fourUnit=(int)(input.nextInt());
      System.out.println();
    	
    	int[][] board1=setupBoard(x,y,twoUnit,threeUnit,fourUnit);
    	int[][] board2=setupBoard(x,y,twoUnit,threeUnit,fourUnit);
    	
    	boolean player1=true;
    	
    	while (true){
    	  x=board1.length+1;
    	  y=board1[0].length+1;
    	  
    	  if (player1){
    	    System.out.println("Player 1's turn\n");
    	    printBoard(board2);
    	    while (x>board1.length && x>-1){
    	      System.out.println("Enter X value for guess");
    	      x=(int)(input.nextInt());
    	    }
    	    while (y>board1.length && x>-1){
    	      System.out.println("Enter Y value for guess");
    	      y=(int)(input.nextInt());
    	    }
          checkPos(board2,x,y);
          if (unfoundShips(board2)==0){
            System.out.println("Player 1 won");
            break;
          }
          player1=false;
    	  }
    	  else{
    	    System.out.println("Player 2's turn\n");
    	    printBoard(board1);
    	    while (x>board2.length && x>-1){
    	      System.out.println("Enter X value for guess");
    	      x=(int)(input.nextInt());
    	    }
    	    while (y>board2.length && x>-1){
    	      System.out.println("Enter Y value for guess");
    	      y=(int)(input.nextInt());
    	    }
          checkPos(board1,x,y);
          if (unfoundShips(board1)==0){
            System.out.println("Player 2 won");
            break;
          }
          player1=true;
    	  }
       // player1=not player1;
    	}

    }
    
    public static void printBoard(int[][] board){
      System.out.print("  ");
      for (int i=0;i<board.length;i++){
        System.out.print(i+" ");
      }
      System.out.println();
      for (int i=0;i<board.length;i++){
        System.out.print(i+" ");
        for (int j=0;j<board.length;j++){
          if (board[i][j]==0){
            System.out.print("- ");
          }
          else if (board[i][j]==1){
            System.out.print("- ");
          }
          else{
            System.out.print("X ");
          }
        }
        System.out.println();
      }
    }
    public static int[][] setupBoard(int x,int y,int twoUnit,int threeUnit,int fourUnit){
      Scanner input=new Scanner(System.in);
      int[][] board=new int[x][y];
      System.out.println("Enter position for two-unit ships: ");
      
      for (int i=0;i<twoUnit;i++){
        for (int j=0;j<2;j++){
          int xPos=board.length+1;
          int yPos=board[0].length+1;
          while ((xPos<board.length && yPos<board[0].length && board[xPos][yPos]==1) || xPos>board.length || yPos>board[0].length){
            
            while (xPos>board.length){
              System.out.println("Enter x coordinate for ship " + i);
              xPos=(int)(input.nextInt());
            }
            while (yPos>board[0].length){
              System.out.println("Enter y coordinate for ship " + i);
              yPos=(int)(input.nextInt());
            }
          }
          board[xPos][yPos]=1;
        }
      }
      
      System.out.println("\nEnter position for three-unit ships: ");
      
      for (int i=0;i<threeUnit;i++){
        for (int j=0;j<3;j++){
          int xPos=board.length+1;
          int yPos=board[0].length+1;
          while ((xPos<board.length && yPos<board[0].length && board[xPos][yPos]==1) || xPos>board.length || yPos>board[0].length){
            
            while (xPos>board.length){
              System.out.println("Enter x coordinate for ship " + i);
              xPos=(int)(input.nextInt());
            }
            while (yPos>board[0].length){
              System.out.println("Enter y coordinate for ship " + i);
              yPos=(int)(input.nextInt());
            }
          }
          board[xPos][yPos]=1;
        }
      }
      System.out.println("\nEnter position for four-unit ships: ");
      
      for (int i=0;i<fourUnit;i++){
        for (int j=0;j<4;j++){
          int xPos=board.length+1;
          int yPos=board[0].length+1;
          while ((xPos<board.length && yPos<board[0].length && board[xPos][yPos]==1) || xPos>board.length || yPos>board[0].length){
            
            while (xPos>board.length){
              System.out.println("Enter x coordinate for ship " + i);
              xPos=(int)(input.nextInt());
            }
            while (yPos>board[0].length){
              System.out.println("Enter y coordinate for ship " + i);
              yPos=(int)(input.nextInt());
            }
          }
          board[xPos][yPos]=1;
        }
      }
      
      return board;
    }
    public static void checkPos(int[][] board, int x, int y){
      if (board[x][y]==1){
        board[x][y]=2;
        System.out.println("You hit a ship\n");
      }
      else if (board[x][y]==2){
        System.out.println("You already guessed here");
      }
    }
    public static int unfoundShips(int[][] board){
      int unfound=0;
      for (int i=0;i<board.length;i++){
        for (int j=0;j<board[i].length;j++){
          if (board[i][j]==1){
            unfound+=1;
          }
        }
      }
      return unfound;
    }
}
