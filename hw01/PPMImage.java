/*Derek Guevara
 *CS 2013
 * Section 03
 * This class contains the methods to read, write, and alter data from ppm files.
 * We will use these methods in the GUI. */
package hw01;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class PPMImage {
	private static String magicNumber;
	private static int width;
	private static int heigth;
	private static int maxColorValue;
	private static char[] raster = new char[heigth * width * 3];
	//the following chars correspond to space after width and lineFeeds after heigth & maxColorVal
	//LF1 is in magicNumber
	private static char spaceBetweenWidthHeigth;
	private static char LF2;
	private static char LF3;

	/*Constructor
	 * We ask the user to input a file name.
	 * If the file is not a ppm file, the program stops and prints a message.
	 * Once the user enters a ppm file, the program will continue.*/
	public PPMImage(String imageFileName) {
		int x = 0;
		while (x < 1) {
			Scanner in = new Scanner(System.in);
			imageFileName = in.next();
			if (imageFileName.contains(".ppm")) {
				readImage(imageFileName);
				x++;
			}
			else {
				System.out.println("File must be .ppm! Try again");
			}
		}
	}
	
	/*Method to get width and line feed 2. 
	 * Method reads 4 chars. Numeric value of space is -1. 
	 * Therefore, if the numeric value of the 4th char is -1, 4th char is a space, so 4th char corresponds to spaceBetweenWidthHeigth.
	 * If 4th char is not a space, width is 4 chars long.*/
	private static int getWidth(int val, BufferedInputStream bis) throws IOException {
		char width1 = (char)bis.read();
		char width2 = (char)bis.read();
		char width3 = (char)bis.read();
		char spaceOrWidth4 = (char)bis.read();
		int intSpaceOrWidth4 = Character.getNumericValue(spaceOrWidth4);
		if (intSpaceOrWidth4 == -1) {
			val = Integer.valueOf(String.valueOf(width1) + String.valueOf(width2) + String.valueOf(width3));
			spaceBetweenWidthHeigth = spaceOrWidth4;
		}
		else {
			val = Integer.valueOf(String.valueOf(width1) + String.valueOf(width2) + String.valueOf(width3) + String.valueOf(spaceOrWidth4));
			spaceBetweenWidthHeigth = (char)bis.read();
		}
		return val;	
	}
	
	/*For all pictures given, height and maxColorValue are ALWAYS 3 characters long.
	 * Therefore, the program reads 3 chars and sets them equal to height and maxColorVal.*/
	private static int getVal(int val, BufferedInputStream bis) throws IOException {
		char firstDigit = (char)bis.read();
		char secondDigit = (char)bis.read();
		char thirdDigit = (char)bis.read();
		val = Integer.valueOf(String.valueOf(firstDigit) + String.valueOf(secondDigit) + String.valueOf(thirdDigit));
		return val;
	}
	
	/* readImage is called by the constructor.
	 * The first 3 chars correspond to magicNumber. (P + 6 + LineFeed1).
	 * the getWidth and getVal methods are called here to get width, height and maxColorVal. */
	private static void readImage (String imageFileName){
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imageFileName));
			char firstChar = (char) bis.read();
			char secondChar = (char) bis.read();
			char LF1 =(char)bis.read();
			magicNumber = "" + firstChar + secondChar + LF1;
			PPMImage.width = getWidth(width, bis);
			PPMImage.heigth = getVal(heigth, bis);
			LF2 = (char)bis.read();
			PPMImage.maxColorValue = getVal(maxColorValue, bis);
			LF3 = (char)bis.read();
			int x = 0;
			raster = new char[heigth * width * 3];
			while (x < raster.length) {
				raster[x] = (char)bis.read();
				x++;
			}	
			bis.close();
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/*writeImage is called in the GUI to write the data to the file.
	 * The method asks user for a file name. If the file name is not .ppm, the program will ask again.
	 * Once the user enters a valid file, the program will write data to the file chosen.*/
	public static void writeImage(String outputFileName) {
		int i = 0;
		while (i < 1) {
			Scanner in = new Scanner(System.in);
			outputFileName = in.next();
			if (outputFileName.contains(".ppm")) {
				try {
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFileName));
					bos.write(magicNumber.charAt(0));
					bos.write(magicNumber.charAt(1));
					bos.write(magicNumber.charAt(2));
					int x = 0;
					while (x < (Integer.toString(width)).length()) {
						bos.write((Integer.toString(width)).charAt(x));
						x++;
					}
					bos.write(spaceBetweenWidthHeigth);
					x = 0;
					while (x < (Integer.toString(heigth)).length()) {
						bos.write((Integer.toString(heigth)).charAt(x));
						x++;
					}
					bos.write(LF2);
					x = 0;
					while (x < (Integer.toString(maxColorValue)).length()) {
						bos.write((Integer.toString(maxColorValue)).charAt(x));
						x++;
					}
					bos.write(LF3);
					int z = 0;
					while (z < raster.length) {
						bos.write((char)raster[z]);
						z++;
					}
					bos.flush();
					bos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				i++;
			}
			else {
				System.out.println("File must be .ppm! try again");
			}
		}
	}
	
	/*The grayscale methods makes a copy of the original raster array to change the values.
	 * It changes the raster array using the formula given. */
	public static void grayscale() {
		char [] copyRaster = new char [raster.length];
		for (int i = 0; i < raster.length; i++) {
			copyRaster[i] = raster[i];
		}
		int z = 0;
		while (z < raster.length) {
			if (z == 0) {
				raster[z] = ((char) ((copyRaster[z]*0.299)+(copyRaster[z+1]*0.587) + (copyRaster[z+2]*0.114)));
			}
			else if (z%3 == 0) {
				raster[z] = ((char) ((copyRaster[z]*0.299)+(copyRaster[z+1]*0.587) + (copyRaster[z+2]*0.114)));	
			}
			else if (z%3 == 1) {
				raster[z] = ((char) ((copyRaster[z-1]*0.299)+(copyRaster[z]*0.587) + (copyRaster[z+1]*0.114)));
			}
			else {
				raster[z] =((char) ((copyRaster[z-2]*0.299)+(copyRaster[z-1]*0.587) + (copyRaster[z]*0.114)));
			}
			if (raster[z] > (char)255) {
				raster[z] = (char)255;
			}
			z++;
		}
	}
	
	/*The reason why we make a copy is because we need the original values to change the RGB values.
	 *When we do [z-1] and [z-2], the original raster has altered values, while the copyRaster has the original values.*/
	public static void sepia() {	
		char [] copyRaster = new char [raster.length];
		for (int i = 0; i < raster.length; i++) {
			copyRaster[i] = raster[i];
		}
		int z = 0;
		while (z < raster.length) {
			if (z == 0) {
				raster[z] = ((char) ((copyRaster[z]*0.393)+(copyRaster[z+1]*0.769) + (copyRaster[z+2]*0.189)));
			}
			else if (z%3 == 0) {
				raster[z] = ((char) ((copyRaster[z]*0.393)+(copyRaster[z+1]*0.769) + (copyRaster[z+2]*0.189)));	
			}
			else if (z%3 == 1) {
				raster[z] = ((char) ((copyRaster[z-1]*0.349)+(copyRaster[z]*0.686) + (copyRaster[z+1]*0.168)));
			}
			else {
				raster[z] =((char) ((copyRaster[z-2]*0.272)+(copyRaster[z-1]*0.534) + (copyRaster[z]*0.131)));
			}
			if (raster[z] > (char)255) {
				raster[z] = (char)255;
			}
			z++;
		}
	}
	
	//Same as above. It goes through the array and changes the values.
	public static void negative() {
		int z = 0;
		while (z < raster.length) {
			raster[z] = ((char) (255 - raster[z]));				
			z++;
		}
	}
}