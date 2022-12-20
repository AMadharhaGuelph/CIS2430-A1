package tictactoe;

public class Board {
    private char[][] displayBoard = {{' ','|',' ','|',' '},
                                     {'-','+','-','+','-'},
                                     {' ','|',' ','|',' '},
                                     {'-','+','-','+','-'},
                                     {' ','|',' ','|',' '}};
    private char[][] logicBoard = new char[3][3];

    /**
    Contructs a new board to be displayed with position numbers.
    */
    public Board() {
        for(int i = 0; i < 9; i++) {
            setTile(Character.forDigit(i,10), i);
        }
    }

    /**
    Sets a specified position to a specified tile.
    @param tile The tile that the position is to be set to.
    @param position The position to be set to the tile.
    */
    public void setTile(char tile, int position) {
        switch(position) {
            case 0:
                logicBoard[0][0] = tile;
                displayBoard[0][0] = tile;
                break;
            case 1:
                logicBoard[0][1] = tile;
                displayBoard[0][2] = tile;
                break;
            case 2:
                logicBoard[0][2] = tile;
                displayBoard[0][4] = tile;
                break;
            case 3:
                logicBoard[1][0] = tile;
                displayBoard[2][0] = tile;
                break;
            case 4:
                logicBoard[1][1] = tile;
                displayBoard[2][2] = tile;
                break;
            case 5:
                logicBoard[1][2] = tile;
                displayBoard[2][4] = tile;
                break;
            case 6:
                logicBoard[2][0] = tile;
                displayBoard[4][0] = tile;
                break;
            case 7:
                logicBoard[2][1] = tile;
                displayBoard[4][2] = tile;
                break;
            case 8:
                logicBoard[2][2] = tile;
                displayBoard[4][4] = tile;
                break;
            default:

        }
    }  
    
    /**
    Retrieve the tile of a specified position on the board.
    @param position The position of the desired tile.
    @return The character at the specified position.
    */
    public char getTile(int position) {
        switch(position) {
            case 0:
                return logicBoard[0][0];
            case 1:
                return logicBoard[0][1];
            case 2:
                return logicBoard[0][2];
            case 3:
                return logicBoard[1][0];
            case 4:
                return logicBoard[1][1];
            case 5:
                return logicBoard[1][2];
            case 6:
                return logicBoard[2][0];
            case 7:
                return logicBoard[2][1];
            case 8:
                return logicBoard[2][2];
            default:
                System.out.println("Error - Out of Bounds");
                return logicBoard[0][0];
        }
    }

    /**
    Display the current state of the board.
    */
    public void displayBoard() {
        for(int row = 0; row < displayBoard.length; row++) {
            for(int col = 0; col < displayBoard[row].length; col++) {
                System.out.print(displayBoard[row][col]);
            }
            System.out.print("\n");
        }
    }

    /**
    Check if a specified position contains a tile.
    @param position The position to be validated.
    @return True: If the position does not contain a tile. False: If the position contains a tile.
    */
    public boolean isValidPosition(int position) {
        if(getTile(position) == 'X' || getTile(position) == 'O') {
            return false;
        }
        return true;
    }

    /**
    Checks the current state of the board for a win (3 in a row vertically, horizontally, or diagonally).
    @param tile The tile used to check for a win (3 in a row of a specified tile).
    @return True: If there is a win on the board. False: If there is no win on the board.
    */
    public boolean checkBoardForWin(char tile) {
        for(int i = 0; i < 3; i++) {
            if(logicBoard[i][0] == logicBoard[i][1] && logicBoard[i][1] == logicBoard[i][2]) {
                return true;
            }
            if(logicBoard[0][i] == logicBoard[1][i] && logicBoard[1][i] == logicBoard[2][i]) {
                return true;
            }
        }
        if(logicBoard[0][0] == logicBoard[1][1] && logicBoard[1][1] == logicBoard[2][2]) {
            return true;
        }
        if(logicBoard[0][2] == logicBoard[1][1] && logicBoard[1][1] == logicBoard[2][0]) {
            return true;
        }

        return false;
    }

    /**
    Check if the current state of the board has all positions filled
    @return True: If all positions are filled with tiles. False: If there is one position with no tile.
    */
    public boolean isFull() {
        for(int row = 0; row < logicBoard.length; row++) {
            for(int col = 0; col < logicBoard[row].length; col++) {
                if(logicBoard[row][col] != 'X' && logicBoard[row][col] != 'O') {
                    return false;
                } 
            }
        }

        return true;
    }
}
