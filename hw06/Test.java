/*Derek Guevara
 * CS 2013
 * Section 3
 * In this class, we read the text files and test the sorting algorithms*/
package hw06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.time.Duration;
import java.time.Instant;

public class Test {
	 static int count = 0;
	public static void main(String[] args) throws ArithmeticException {
		//Create 35 different Integer arraylists.
		/*Could also do:
		 * ArrayList<Integer> list = new ArrayList<Integer>();
 		 * and do list.clear() after each method, and reuse the same list
		 */
		
		ArrayList<Integer> insertion50 = new ArrayList<Integer>();
		ArrayList<Integer> insertion100 = new ArrayList<Integer>();
		ArrayList<Integer> insertion150 = new ArrayList<Integer>();
		ArrayList<Integer> insertion200 = new ArrayList<Integer>();
		ArrayList<Integer> insertion250 = new ArrayList<Integer>();
		ArrayList<Integer> bubble50 = new ArrayList<Integer>();
		ArrayList<Integer> bubble100 = new ArrayList<Integer>();
		ArrayList<Integer> bubble150 = new ArrayList<Integer>();
		ArrayList<Integer> bubble200 = new ArrayList<Integer>();
		ArrayList<Integer> bubble250 = new ArrayList<Integer>();
		ArrayList<Integer> selection50 = new ArrayList<Integer>();
		ArrayList<Integer> selection100 = new ArrayList<Integer>();
		ArrayList<Integer> selection150 = new ArrayList<Integer>();
		ArrayList<Integer> selection200 = new ArrayList<Integer>();
		ArrayList<Integer> selection250 = new ArrayList<Integer>();
		ArrayList<Integer> merge50 = new ArrayList<Integer>();
		ArrayList<Integer> merge100= new ArrayList<Integer>();
		ArrayList<Integer> merge150 = new ArrayList<Integer>();
		ArrayList<Integer> merge200 = new ArrayList<Integer>();
		ArrayList<Integer> merge250 = new ArrayList<Integer>();
		ArrayList<Integer> quick50 = new ArrayList<Integer>();
		ArrayList<Integer> quick100 = new ArrayList<Integer>();
		ArrayList<Integer> quick150 = new ArrayList<Integer>();
		ArrayList<Integer> quick200 = new ArrayList<Integer>();
		ArrayList<Integer> quick250 = new ArrayList<Integer>();
		ArrayList<Integer> counting50 = new ArrayList<Integer>();
		ArrayList<Integer> counting100 = new ArrayList<Integer>();
		ArrayList<Integer> counting150 = new ArrayList<Integer>();
		ArrayList<Integer> counting200 = new ArrayList<Integer>();
		ArrayList<Integer> counting250 = new ArrayList<Integer>();
		ArrayList<Integer> radix50 = new ArrayList<Integer>();
		ArrayList<Integer> radix100 = new ArrayList<Integer>();
		ArrayList<Integer> radix150 = new ArrayList<Integer>();
		ArrayList<Integer> radix200 = new ArrayList<Integer>();
		ArrayList<Integer> radix250 = new ArrayList<Integer>();
		//Do this 35 times. Method to read file is called. values get added to the arraylist. 
		// * values are sorted. We record the time it takes for the list to be sorted *	
		readFile("numberFiles/50000.txt", insertion50);
		Instant start1 = Instant.now();
		Sorting.insertionSort(insertion50);
		Instant end1 = Instant.now();
		Duration insertion50time= Duration.between(start1, end1);
		
		readFile("numberFiles/100000.txt", insertion100);
		Instant start2 = Instant.now();
		Sorting.insertionSort(insertion100);
		Instant end2 = Instant.now();
		Duration insertion100time = Duration.between(start2, end2);
			
		readFile("numberFiles/150000.txt", insertion150);
		Instant start3 = Instant.now();
		Sorting.insertionSort(insertion150);
		Instant end3 = Instant.now();
		Duration insertion150time = Duration.between(start3, end3);
		
		readFile("numberFiles/200000.txt", insertion200);
		Instant start4 = Instant.now();
		Sorting.insertionSort(insertion200);
		Instant end4 = Instant.now();
		Duration insertion200time = Duration.between(start4, end4);
		
		readFile("numberFiles/250000.txt", insertion250);
		Instant start5 = Instant.now();
		Sorting.insertionSort(insertion250);
		Instant end5 = Instant.now();
		Duration insertion250time = Duration.between(start5, end5);
		
		readFile("numberFiles/50000.txt", bubble50);
		Instant start6 = Instant.now();
		Sorting.bubbleSort(bubble50);
		Instant end6 = Instant.now();
		Duration bubble50time= Duration.between(start6, end6);
		
		readFile("numberFiles/100000.txt", bubble100);
		Instant start7 = Instant.now();
		Sorting.bubbleSort(bubble100);
		Instant end7 = Instant.now();
		Duration bubble100time= Duration.between(start7, end7);
		
		readFile("numberFiles/150000.txt", bubble150);
		Instant start8 = Instant.now();
		Sorting.bubbleSort(bubble150);
		Instant end8 = Instant.now();
		Duration bubble150time= Duration.between(start8, end8);
		
		readFile("numberFiles/200000.txt", bubble200);
		Instant start9 = Instant.now();
		Sorting.bubbleSort(bubble200);
		Instant end9 = Instant.now();
		Duration bubble200time= Duration.between(start9, end9);
		
		readFile("numberFiles/250000.txt", bubble250);
		Instant start10 = Instant.now();
		Sorting.bubbleSort(bubble250);
		Instant end10 = Instant.now();
		Duration bubble250time= Duration.between(start10, end10);
		
		readFile("numberFiles/50000.txt", selection50);
		Instant start11 = Instant.now();
		Sorting.selectionSort(selection50);
		Instant end11 = Instant.now();
		Duration selection50time= Duration.between(start11, end11);
		
		readFile("numberFiles/100000.txt", selection100);
		Instant start12 = Instant.now();
		Sorting.selectionSort(selection100);
		Instant end12 = Instant.now();
		Duration selection100time= Duration.between(start12, end12);
		
		readFile("numberFiles/150000.txt", selection150);
		Instant start13 = Instant.now();
		Sorting.selectionSort(selection150);
		Instant end13 = Instant.now();
		Duration selection150time= Duration.between(start13, end13);
	
		readFile("numberFiles/200000.txt", selection200);
		Instant start14 = Instant.now();
		Sorting.selectionSort(selection200);
		Instant end14 = Instant.now();
		Duration selection200time= Duration.between(start14, end14);
		
		readFile("numberFiles/250000.txt", selection250);
		Instant start15 = Instant.now();
		Sorting.selectionSort(selection250);
		Instant end15 = Instant.now();
		Duration selection250time= Duration.between(start15, end15);
	
		readFile("numberFiles/50000.txt", merge50);
		Instant start16 = Instant.now();
		Sorting.mergeSort(merge50);
		Instant end16 = Instant.now();
		Duration merge50time= Duration.between(start16, end16);
	
		readFile("numberFiles/100000.txt", merge100);
		Instant start17 = Instant.now();
		Sorting.mergeSort(merge100);
		Instant end17 = Instant.now();
		Duration merge100time= Duration.between(start17, end17);
		
		readFile("numberFiles/150000.txt", merge150);
		Instant start18 = Instant.now();
		Sorting.mergeSort(merge150);
		Instant end18 = Instant.now();
		Duration merge150time= Duration.between(start18, end18);
	
		readFile("numberFiles/200000.txt", merge200);
		Instant start19 = Instant.now();
		Sorting.mergeSort(merge200);
		Instant end19 = Instant.now();
		Duration merge200time= Duration.between(start19, end19);
	
		readFile("numberFiles/250000.txt", merge250);
		Instant start20 = Instant.now();
		Sorting.mergeSort(merge250);
		Instant end20 = Instant.now();
		Duration merge250time= Duration.between(start20, end20);
	
		readFile("numberFiles/50000.txt", quick50);
		Instant start21 = Instant.now();
		Sorting.quickSort(quick50);
		Instant end21 = Instant.now();
		Duration quick50time= Duration.between(start21, end21);
	
		readFile("numberFiles/100000.txt", quick100);
		Instant start22 = Instant.now();
		Sorting.quickSort(quick100);
		Instant end22 = Instant.now();
		Duration quick100time= Duration.between(start22, end22);
	
		readFile("numberFiles/150000.txt", quick150);
		Instant start23 = Instant.now();
		Sorting.quickSort(quick150);
		Instant end23 = Instant.now();
		Duration quick150time= Duration.between(start23, end23);
		
		readFile("numberFiles/200000.txt", quick200);
		Instant start24 = Instant.now();
		Sorting.quickSort(quick200);
		Instant end24 = Instant.now();
		Duration quick200time= Duration.between(start24, end24);
		
		readFile("numberFiles/250000.txt", quick250);
		Instant start25 = Instant.now();
		Sorting.quickSort(quick250);
		Instant end25 = Instant.now();
		Duration quick250time= Duration.between(start25, end25);
	
		readFile("numberFiles/50000.txt", counting50);
		Instant start26 = Instant.now();
		Sorting.countingSort(counting50, 1000);
		Instant end26 = Instant.now();
		Duration counting50time= Duration.between(start26, end26);
	
		readFile("numberFiles/100000.txt", counting100);
		Instant start27 = Instant.now();
		Sorting.countingSort(counting100, 1000);
		Instant end27 = Instant.now();
		Duration counting100time= Duration.between(start27, end27);
	
		readFile("numberFiles/150000.txt", counting150);
		Instant start28 = Instant.now();
		Sorting.countingSort(counting150, 1000);
		Instant end28 = Instant.now();
		Duration counting150time= Duration.between(start28, end28);
	
		readFile("numberFiles/200000.txt", counting200);
		Instant start29 = Instant.now();
		Sorting.countingSort(counting200, 1000);
		Instant end29 = Instant.now();
		Duration counting200time= Duration.between(start29, end29);

		readFile("numberFiles/250000.txt", counting250);
		Instant start30 = Instant.now();
		Sorting.countingSort(counting250, 1000);
		Instant end30 = Instant.now();
		Duration counting250time= Duration.between(start30, end30);

		readFile("numberFiles/50000.txt", radix50);
		Instant start31 = Instant.now();
		Sorting.radixSort(radix50);
		Instant end31 = Instant.now();
		Duration radix50time= Duration.between(start31, end31);
		
		readFile("numberFiles/100000.txt", radix100);
		Instant start32 = Instant.now();
		Sorting.radixSort(radix100);
		Instant end32 = Instant.now();
		Duration radix100time= Duration.between(start32, end32);
		
		readFile("numberFiles/150000.txt", radix150);
		Instant start33 = Instant.now();
		Sorting.radixSort(radix150);
		Instant end33 = Instant.now();
		Duration radix150time= Duration.between(start33, end33);
		
		readFile("numberFiles/200000.txt", radix200);
		Instant start34 = Instant.now();
		Sorting.radixSort(radix200);
		Instant end34 = Instant.now();
		Duration radix200time= Duration.between(start34, end34);
		
		readFile("numberFiles/250000.txt", radix250);
		Instant start35 = Instant.now();
		Sorting.radixSort(radix250);
		Instant end35 = Instant.now();
		Duration radix250time= Duration.between(start35, end35);
		
		//table to show results
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("----------------" + "50,000 numbers: " + "  100,000 numbers" + "     150,000 numbers" + "    200,000 numbers" + "    250,000 numbers" );
		System.out.println("Insertion Sort: " + insertion50time + "       " + insertion100time + "        " + insertion150time + "       " + insertion200time + "     " + insertion250time );
		System.out.println("Bubble Sort:    " + bubble50time + "      " + bubble100time + "      " + bubble150time + "     " + bubble200time + "      " + bubble250time );
		System.out.println("Selection Sort: " + selection50time + "       " + selection100time + "        " + selection150time + "       " + selection200time + "     " + selection250time );
		System.out.println("Merge Sort:     " + merge50time + "       " + merge100time + "         " + merge150time + "        " + merge200time + "        " + merge250time ); 
		System.out.println("Quick Sort:     " + quick50time + "       " + quick100time + "         " + quick150time + "        " + quick200time + "        " + quick250time ); 
		System.out.println("Counting Sort:  " + counting50time + "       " + counting100time + "         " + counting150time + "        " + counting200time + "        " + counting250time );
		System.out.println("Radix Sort:     " + radix50time + "       " + radix100time + "         " + radix150time + "        " + radix200time + "        " + radix250time );
		
		
		
	}
	
	//method to read file. values get added to arraylist from parameter
	private static void readFile(String fileName, ArrayList<Integer> list) {
		try {
			Scanner in = new Scanner(new File(fileName));
			while (in.hasNextLine()) {
				//the value from the text file gets added to the arraylist.
				//lines are read as Strings, so we must parse the info to Integer
				list.add(Integer.parseInt(in.nextLine()));
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
