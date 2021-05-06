/*Derek Guevara
 * CS 2013
 * Section 3
 * This class creates the data fields for the hexagons. Has setters & getters*/

package hw03;

public class Hexagon {
	boolean alreadyPlaced = false;
	private int num;
	private char[] tile = new char[6];
	public Hexagon(char[] tile, int num) {
		for (int i = 0; i < tile.length; i++) {
			this.tile[i] = tile[i];
		}
		this.num = num;
	}
	
	public char getIndex(int x) {
		return tile[x];
	}
	
	public char[] getTile() {
		return tile;
	}
	
	public void setTile(char[] tile) {
		this.tile = tile;
	}
	
	//to string method
    @Override
    public String toString() {
    	String toStr = "tile #" + this.num + " ";
    	int x = 0;
    	//Similar to last homework. This creates a string with all values EXCEPT the last value
    	while (x < (tile.length-1)) {
    		toStr+= tile[x] + "  ";
    		x++;
    	}
    	//tile[x] is the LAST value. this is done to not have a trailing space
    	toStr = toStr + tile[x];
    	return toStr;
    }
}
