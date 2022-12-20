package tictactoe;

public class Runner {
    /**
    main method in which the game runs (input, board display, prompts).
    @param args Command line arguments (not used).
    */
    public static void main(String[] args) {
        // Declare and Initialize variables and objects
        Board board = new Board();
        Tile tile = new Tile('X');
        int position;

        // The game runs within this loop
        while(true) {
            // Display the current state of the board
            board.displayBoard();   

            // Output current players turn   
            Game.outputTurn(tile.getTile()); 

            // Prompt user for position input until valid input
            position = Game.getPositionInput(board);

            // Set the inputted position to current players tile identity 
            board.setTile(tile.getTile(), position);    

            // Check if there is a win on the board, if not check if the board is full
            if(board.checkBoardForWin(tile.getTile())) {
                // Output winer
                board.displayBoard();
                Game.outputWinner(tile.getTile());
                break;
            } else if(board.isFull()) {
                // Output tie game
                board.displayBoard();
                Game.outputDraw();
                break;
            }

            tile.switchTile();
        }
    }
}