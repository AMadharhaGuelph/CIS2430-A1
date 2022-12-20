package tictactoe;

import java.util.Scanner;

public class Game {

    private static Scanner sc = new Scanner(System.in);

    /**
    Outputs the tile to be placed.
    @param tile The tile whos turn it is to be placed.
    */
    public static void outputTurn(char tile) {
        System.out.println("\nTurn: " + tile); 
    }

    /**
    Gets position input from the user.
    @param board Used to check validity of positions on the board.
    @return The position number.
    */
    public static int getPositionInput(Board board) {
        int position = 0;

        System.out.println("Enter Position between 0 and 8:");

        do {
            position = getValidInput(board);
        } while(position == -1);
        
        return position;
    }

    private static int getValidInput(Board board) {
        int position = 0;

        try{
            position = Integer.parseInt(sc.nextLine());
        } catch(NumberFormatException e) {
            System.err.println("Enter a valid INTEGER (0 - 8)!");
            return -1;
        }

        if(position < 0 || position > 8) {
            System.err.println("Out of Bounds (0 - 8)!");
            return -1;
        }

        if(!board.isValidPosition(position)) {
            System.err.println("Illegal Move! Try Again");
            return -1;
        }
        return position;
    }

    /**
    Outputs the tile that won.
    @param tile The specified tile that won.
    */
    public static void outputWinner(char tile) {
        System.out.println("\nThe winner is " + tile);
        sc.close();
    }

    /**
    Outputs the game resulted in a draw.
    */
    public static void outputDraw() {
        System.out.println("\nThe Game was a Tie!");
        sc.close();
    }
}
