/*Derek Guevara
 * CS 2013
 * Section 03
 This class will test all the methods from MyArray*/
package hw02;
public class Main {
	public static void main(String[] args) {
		MyArray <Integer> intArr = new MyArray<Integer>(10);
		MyArray <Integer> intArr2 = new MyArray<Integer>(5, 3, 6, 2, 5, 76, 2);
		MyArray<String> strArr = new MyArray<String>(10);
		MyArray<String> strArr2 = new MyArray<String>("hello", "this is java", "test", "mars", "computer science");
		System.out.println("ORIGINAL ARRAYS: " + intArr2 + " AND " + strArr2);
		//first get method
		System.out.println("\n" + "GET METHOD: ");
		System.out.println(intArr2.get(0));
		System.out.println(strArr2.get(3));
		//second get method
		System.out.println("\n" + "SECOND GET METHOD: ");
		intArr2.get(1, 3);
		strArr2.get(1, 2);
		//first put method
		System.out.println("\n" + "BEFORE PUT METHOD: " + intArr2 + "| STRING ARRAY: " + strArr2);
		intArr2.put(2, 10);
		strArr2.put(1, "put method");
		System.out.println("AFTER PUT METHOD: " + intArr2 + "| STRING ARRAY: " + strArr2);
		System.out.println("\n" + "PUT METHOD WITH COMMA SEPARATED VALUES:");
		//second put method
		System.out.println("BEFORE METHOD: " + intArr);
		System.out.println("BEFORE METHOD: " + strArr);
		intArr.put(0, 9, 29, 54, 36, 11, 8, 101, 9, 235, 40, 54, 96, 32);
		strArr.put(0, 9, "aliens", "hi", "derek", "this is array", "okay", "a", "z", "recursion", "java", "elon musk", "this is out of bounds");
		System.out.println("AFTER METHOD: " + intArr);
		System.out.println("AFTER METHOD: " + strArr);
		//equals
		System.out.println("\n" + "EQUALS METHOD: ");
		MyArray<String> strArr3 = new MyArray<String>("this", "is", "test");
		MyArray<String> strArr4 = new MyArray<String>("this", "test", "is");
		MyArray<String> strArr5 = new MyArray<String>("this", "is", "test");
		strArr3.equals(strArr4);
		strArr3.equals(strArr5);
		//max
		System.out.println("\n" + "MAX FROM "+ intArr + "\n"+ intArr.max());
		System.out.println("MAX FROM "+ strArr + "\n"+ strArr.max());
		//min
		System.out.println("\n" + "MIN FROM " + intArr + "\n" + intArr.min());
		System.out.println("MIN FROM " + strArr + "\n"+ strArr.min());
		//reverse
		System.out.println("\n" + "REVERSE: ");
		intArr.reverse();
		strArr.reverse();
		//shuffle
		System.out.println("\n" + "SUFFLE: ");
		intArr.shuffle();
		strArr.shuffle();
		//left shift
		System.out.println("\n" + "LEFT SHIFT");
		strArr.leftShift(2);
		intArr.leftShift(3);
		System.out.println(intArr + "\n" + strArr);
		//right shift
		System.out.println("\n" + "RIGHT SHIFT");
		strArr.rightShift(2);
		intArr.rightShift(3);
		System.out.println(intArr + "\n" + strArr);
		//size method
		System.out.println("\n" + "SIZE METHOD: ");
		System.out.println("ARR SIZE: " + strArr.size());
		//to string
		System.out.println("\n" + "TO STRING: ");
		System.out.println(intArr.toString());
		System.out.println(strArr.toString());
		//sort
		System.out.println("\n" + "SORT: ");
		intArr.sort();
		strArr.sort();
		System.out.println(intArr);
		System.out.println(strArr);
	}
}
