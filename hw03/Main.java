/*Derek Guevara
 * CS 2013
 * Section 3
 * main class for recursion*/
package hw03;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		int solutions = 0;
		Main main  = new Main();
		Board board2 = new Board();
		ArrayList <Hexagon> leftover = new ArrayList<>();
		//leftover arraylist gets the tiles from the text file
		leftover = board2.readFile(leftover);
		ArrayList <Hexagon> board = new ArrayList<>();
		solutions = main.solve(board, leftover, 0, solutions);
		if (solutions == 0) {
			System.out.println("No solution");
		}
	}
	
	//recursion method. 
	private int solve(ArrayList<Hexagon> board, ArrayList<Hexagon> leftover, int currentRow, int solutions) {
		if (board.size()== 7) {
			//double check that the board is safe. If we uncomment the if statement, there are less solutions
			//if (isSafe(board)) {
				printSolutions(board, solutions);
				solutions++;
			//}
		}
		else {	
			for (int currentTile = 0; currentTile < 7; currentTile++) {
				if (leftover.get(currentTile).alreadyPlaced == false) {
					//tile gets added
					board.add(currentRow, leftover.get(currentTile));
					leftover.get(currentTile).alreadyPlaced = true;
					//check if its safe
					if (isSafe(leftover, currentRow)){
						//recursion
						solutions = solve(board, leftover, currentRow, solutions);
					}
					//backtracking
					board.remove(currentRow);
					leftover.get(currentTile).alreadyPlaced= false;
					rightShiftAll(leftover.get(currentTile).getTile());
					}
				//method to  shift tiles gets called.
				//rightShift(leftover);
				}
			}
		return solutions;
	}
				
    //LINE 26 & 29. This method checks ALL tiles at the same time (used when a solution is reached to MAKE SURE its safe)
    private static boolean isSafe(ArrayList<Hexagon> hex) {
    	if (hex.get(1).getIndex(3) != hex.get(0).getIndex(0))
    		return false;
    	if (hex.get(2).getIndex(5) != hex.get(1).getIndex(2) || hex.get(2).getIndex(4) != hex.get(0).getIndex(1))
    		return false;
    	if (hex.get(3).getIndex(0) != hex.get(2).getIndex(3) || hex.get(3).getIndex(5) != hex.get(0).getIndex(2))
    		return false;
    	if (hex.get(4).getIndex(1) != hex.get(3).getIndex(4) || hex.get(4).getIndex(0) != hex.get(0).getIndex(3))
    		return false;
    	if (hex.get(5).getIndex(2) != hex.get(4).getIndex(5) || hex.get(5).getIndex(1) != hex.get(0).getIndex(4))
    		return false;
    	if (hex.get(6).getIndex(3) != hex.get(5).getIndex(0)|| hex.get(6).getIndex(1) != hex.get(1).getIndex(4)  || hex.get(6).getIndex(2) != hex.get(0).getIndex(5))
    		return false;
    	return true;
    }
    
    //method to check if its safe to place a tile. checks one by one
    private boolean isSafe(ArrayList<Hexagon> list, int count) {
    	int x = 0;
    	int hex1 = 0;
    	int hex2 = 0;
    	int index1 = 0;
    	int index2 = 0;
    	int index3 =0;
    	//the indexes depend on count. this is so that we dont get an out of bounds error
    	if (count == 0) {
    		hex1 = 0;
    		hex2 = 1;
    		index1 = 0;
    		index2 = 3;
    		index3=0;
    	}
    	if (count == 1) {
    		hex1 = 1;
    		hex2 = 2;
    		index1 = 2;
    		index2 = 5;
    		index3=4;
    	}
    	if (count == 2) {
    		hex1 = 2;
    		hex2 = 3;
    		index1 = 1;
    		index2 = 3;
    		index3=5;
    	}
    	if (count == 3) {
    		hex1 = 3;
    		hex2 = 4;
    		index1 = 1;
    		index2 = 3;
    		index3=0;
    	}
    	if (count == 4) {
    		hex1 = 4;
    		hex2 = 5;
    		index1 = 1;
    		index2 = 3;
    		index3=1;
    	}
    	if (count == 5) {
    		hex1 = 5;
    		hex2 = 6;
    		index1 = 1;
    		index2 = 3;
    		index3=1;
    	}
    	if (count == 6) {
    		hex1 = 6;
    		hex2 = 0;
    		index1 = 1;
    		index2 = 3;
    		index3=1;
    	}	
    	if (list.get(hex1).getIndex(index1) != list.get(hex2).getIndex(index2)) {
    		//helper method gets called here
    		while (x < 6 && isSafe(list, hex1, hex2, index1, index2, index3) == false){
            	rightShiftAll(list.get(hex2).getTile());	
            	x++;
            	isSafe(list, hex1, hex2, index1, index2, index3);
    		}
    	}
    	if (x == 6) {
    		return false;
    	}
    		return true;
    }
    
    //helper method to check if its safe
    private boolean isSafe(ArrayList<Hexagon> list, int hex1, int hex2, int index1, int index2, int index3) {
    	if (list.get(hex1).getIndex(index1) != list.get(hex2).getIndex(index2) || (list.get(hex1).getIndex(index3) != list.get(0).getIndex(hex2))) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
     
    //method to rotate tiles
    private char[] rightShiftAll( char [] arr) {
        	int x = arr.length;
        	//temp holds value from last index
            char temp = arr[x-1];
            //values shift
            for(int i =x-1; i>0; i--) {
            	arr[i] = arr[i-1];
            }
            //temp gets placed at index zero
            arr[0] = temp;
    	return arr;
    }  
    
    //LINE 48. Method to shift tiles
    private ArrayList<Hexagon> rightShift(ArrayList<Hexagon> list) {
    	int x = list.size();
    	Hexagon temp = list.remove(x-1);
    	list.add(1, temp);
    	return list;
    }

    //method to print solutions 
	private void printSolutions(ArrayList<Hexagon> board, int solution) {
		System.out.println("Solution #" + solution + "-----------------------");
		System.out.println("                     SA SB SC SD SE SF");
		for (int i = 1; i < 8; i++) {
			System.out.println("Position " + i + ":  " + board.get(i-1));
		}
		System.out.println("--------------------------------------");
	}  
}
