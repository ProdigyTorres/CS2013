/*Derek Guevara
 * CS 2013
 * Section 3
 * this class creates the 7 tiles that are used for the board*/
package hw03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	//method to get chars from line
	public void getTile(char[] tileset, String line) {
		int x = 0;
		int y = 8;
		while (x < 6) {
			tileset[x] = line.charAt(y);
			x++;
			y = y + 2;
		}
	}
	
	//method to read file
	public ArrayList<Hexagon> readFile(ArrayList<Hexagon> leftover) {
		try {
			leftover = new ArrayList<>();
			Hexagon hexagon = new Hexagon(new char [6], 1);
			Hexagon hexagon2 = new Hexagon(new char[6], 2);
			Hexagon hexagon3 = new Hexagon(new char[6], 3);
			Hexagon hexagon4 = new Hexagon(new char[6], 4);
			Hexagon hexagon5 = new Hexagon(new char[6], 5);
			Hexagon hexagon6 = new Hexagon(new char[6], 6);
			Hexagon hexagon7 = new Hexagon(new char[6], 7);
			Scanner in = new Scanner(System.in); 
			System.out.println("enter file name");
			String fileName = in.nextLine();
			File file = new File(fileName);
			Scanner input = new Scanner(file);
			getTile(hexagon.getTile(), input.nextLine());
			getTile(hexagon2.getTile(), input.nextLine());
			getTile(hexagon3.getTile(), input.nextLine());
			getTile(hexagon4.getTile(), input.nextLine());
			getTile(hexagon5.getTile(), input.nextLine());
			getTile(hexagon6.getTile(), input.nextLine());
			getTile(hexagon7.getTile(), input.nextLine());	
			//all arrays are added to the leftover arraylist (arraylist of tiles)
			leftover.add(hexagon);
			leftover.add(hexagon2);
			leftover.add(hexagon3);
			leftover.add(hexagon4);
			leftover.add(hexagon5);
			leftover.add(hexagon6);
			leftover.add(hexagon7);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
		return leftover;
	}	
}
