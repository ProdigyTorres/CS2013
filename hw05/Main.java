/*Derek Guevara
 * CS 2013
 * Section 03
 *This class is to test the Array2D hw
 *Coudln't figure out the null pointer exceptions*/
package hw05;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array2D <String> test = new Array2D<String>();
		System.out.println("works");
		Array2D <Integer> test2 = new Array2D<Integer>(3, 4);
		System.out.println("works");
		String [][] arr = new String[10][9];
		Array2D <String> test3 = new Array2D<String>(arr);
		System.out.println("works");
		System.out.println(test);
		System.out.println("works");
		System.out.println(test.colSize() + " test " + test.rowSize());
		test.addFirstCol();
		test.addFirstRow();
		System.out.println(test.colSize() + " " + test.rowSize());
		test.addLastCol();
		test.addLastRow();
		System.out.println(test.colSize() + " " + test.rowSize());
		System.out.println(test2.colSize() + " test 2 " + test2.rowSize());
		test2.addFirstCol();
		test2.addFirstRow();
		System.out.println(test2.colSize() + " " + test2.rowSize());
		System.out.println(test3.colSize() + " test3 " + test3.rowSize());
		test3.addFirstRow();
		test3.addFirstCol();
		test.deleteFirstCol();
		System.out.println(test3.colSize() + " " + test3.rowSize());
		System.out.println(test.rowSize() + "\n" + test.colSize());
		System.out.println(test);
		System.out.println(test.rowSize() + "\n" + test.colSize());
		System.out.println(test3.colSize() + " " + test3.rowSize());
		test3.deleteFirstCol();
		System.out.println(test3.colSize() + " " + test3.rowSize());
		System.out.println(test3);
	}

}
