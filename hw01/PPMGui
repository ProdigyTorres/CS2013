/*Derek Guevara
 *CS 2013
 * Section 03
 * This GUI class will ask the user for input.
 * It will read the data, then it will alter the data, and write the data to a new file from user input*/
package hw01;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class PPMGui {
	
	public PPMGui(String imageFileName) {
	}
	
	/* ppm1 calls the readImage method, which asks user for input. User must enter file name.
	 * Then program goes through switch loop and asks user to choose an option. 
	 * Program will run until user exits. */
	public static void main (String[] args) throws IOException {
		System.out.println("enter file name");
		PPMImage ppm1 = new PPMImage(null);
		Scanner input = new Scanner(System.in);
		int user = 0;
		while (user != 4) {
			System.out.println("1: Sepia; 2: Grayscale; 3: Negative; 4: Exit");
			user = input.nextInt();
			switch (user) {
			case 1:
				System.out.println("enter file where you want to save");
				PPMImage.sepia();
				PPMImage.writeImage(null);
				break;
			case 2: 
				System.out.println("enter file where you want to save");
				PPMImage.grayscale();
				PPMImage.writeImage(null);
				break;
			case 3:
				System.out.println("enter file where you want to save");
				PPMImage.negative();
				PPMImage.writeImage(null);
				break;
			case 4:
				System.out.println("Program ended");
				break;
			}
		}
	}
}
