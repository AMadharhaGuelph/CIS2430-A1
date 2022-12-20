package tictactoe;

public class Tile {
    private char tile;

    /**
    Contructs a Tile X.
    */
    public Tile() {
        tile = 'X';
    }

    /**
    Contructs a Tile with a specified identity.
    @param identity The identity to be set.
    */
    public Tile(char identity) {
        tile = identity;
    }

    /**
    Sets the Tile to a specified identity.
    @param identity The identity to be set.
    */
    public void setTile(char identity) {
        tile = identity;
    }

    /**
    Get the current tile.
    @return The current tile.
    */
    public char getTile() {
        return tile;
    }

    /**
    Switch the tile from X to O or vice verse depending on the current tile.
    */
    public void switchTile() {
        if(getTile() == 'X') {
            setTile('O');
        } else {
            setTile('X');
        }
    }
}
