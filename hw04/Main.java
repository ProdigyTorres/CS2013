/*Derek Guevara
 * CS 2013
 * Section 03
 *This class has the test for the sortedSet hw*/

package hw04;

public class Main {
	public static void main(String[] args) {
		//many test cases. all work as intended
		SortedSet <Integer>sorted = new SortedSet<Integer>();
		SortedSet<Integer> sortedInt = new SortedSet<Integer>(3, 3, 3, 5, 12,23 ,32, 39, 39 , 200, 2000, 2000, 5, 12, 100, 200, 100, 100, 101, 101, 150, 150, 125, 125, 130, 130, 128, 128, 127, 1270, 0, 0, -1);
		SortedSet<Double>sortedDouble = new SortedSet<Double>(4.0, 6.0, 4.0, 128.0, 128.0, 127.0, 127.0, 126.9, 126.9);
		SortedSet<Double>sortedDouble2 = new SortedSet<Double>();
		sortedDouble2.addAll(4.0, 6.0, 4.0, 128.0, 128.0, 127.0, 127.0, 126.9, 126.90);
		SortedSet<String> sortedString2 = new SortedSet<String>("hello", "python", "okay");
		SortedSet<String> sortedString = new SortedSet<String>("math", "okay", "test", "a", "b " , "c", "cs", "de" , "derek", "h", "a", "b " , "c", "cs", "de","hello", "java", "javascript", "lol", "math", "okay", "test");
		SortedSet<String> sortedStringTest = new SortedSet<String>(sortedString);
		System.out.println("EXISTS: ");
		System.out.println(sortedInt);
		System.out.println("Expected: False; True" + "\n" + "Answer: ");
		System.out.println(sortedInt.exists(2));
		System.out.println(sortedInt.exists(12));
		System.out.println(sortedString);
		System.out.println("Expected: true; false" + "\n" + "Answer: ");
		System.out.println(sortedString.exists("test"));
		System.out.println(sortedString.exists("tes"));
		System.out.println("**********************************************" + "\n");
		System.out.println("ADD: ");
		System.out.println(sortedString);
		System.out.println("Expected:  " + "\n" + "{a, b , c, cs, de, derek, h, hello, java, javascript, lol, math, okay, test, this will be added}");
		sortedString.add("this will be added");
		sortedString.add("java");
		System.out.println("After method:");
		System.out.println(sortedString);
		System.out.println("**********************************************");
		System.out.println("ADD ALL: ");
		sorted.addAll(5, 3, 32, 5, 65, 4, 6, 7, 8, 9, 10, 11, 25, 25, 5);
		sorted.addAll(5, 3, 32, 5, 65, 4, 6, 7, 8, 9, 10, 11, 25);
		sortedString.addAll("lol","hello","java","okay", "de ", "a", "b ", "c", "h","javascript", "derek", "c", "cs", "math" );
		sortedString.addAll("lol","hello","java","okay", "de ", "a", "b ", "c", "h","javascript", "derek", "c", "cs", "math", "test" );
		sortedDouble2.addAll(4.0, 6.0, 4.0, 128.0, 128.0, 127.0, 127.0, 126.9, 126.90);
		System.out.println(sorted);
		System.out.println(sortedString);
		System.out.println(sortedDouble2);
		System.out.println("duplicate values don't get added");
		System.out.println("**********************************************");
		System.out.println("REMOVE: ");
		System.out.println(sortedDouble2);
		sortedDouble2.remove(126.9);
		sortedDouble2.remove(5.0);
		System.out.println(sortedDouble2);
		System.out.println("**********************************************");
		System.out.println("GET: ");
		System.out.println(sortedInt);
		System.out.println(sortedInt.get(4));
		System.out.println(sortedInt.get(99));
		System.out.println("**********************************************");
		System.out.println("SIZE:");
		System.out.println(sortedInt.size());
		System.out.println(sortedString);
		System.out.println(sortedString.size());
		System.out.println("**********************************************");
		System.out.println("EQUALS: ");
		System.out.println(sortedDouble);
		System.out.println(sortedDouble2);
		System.out.println(sortedDouble.equals(sortedDouble2));
		sortedDouble2.add(126.9);
		System.out.println("Add values to make both sets equal");
		System.out.println(sortedDouble);
		System.out.println(sortedDouble2);
		System.out.println(sortedDouble.equals(sortedDouble2));
		System.out.println("**********************************************");
		System.out.println("UNION: ");
		System.out.println(sorted);
		System.out.println(sortedInt);
		System.out.println("Expected: " + "\n" + "{-1, 0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 23, 25, 32, 39, 65, 100, 101, 125, 127, 128, 130, 150, 200, 1270, 2000}");
		System.out.println("Answer:");
		System.out.println(SortedSetUtils.union(sortedInt, sorted));
		System.out.println(SortedSetUtils.union(sorted, sortedInt));
		System.out.println("**********************************************");
		System.out.println("INTERSECTION: ");
		System.out.println(sortedString);
		System.out.println(sortedString2);
		System.out.println(SortedSetUtils.intersection(sortedString, sortedString2));
		System.out.println(SortedSetUtils.intersection(sortedString2, sortedString));
		System.out.println(sorted);
		System.out.println(sortedInt);
		System.out.println(SortedSetUtils.intersection(sortedInt, sorted));
		System.out.println(SortedSetUtils.intersection(sortedInt, sorted));
		System.out.println("Copy constructor test: ");
		SortedSet <Integer>sortedTest = new SortedSet<Integer>(sorted);
		System.out.println(sorted);
		System.out.println(sortedTest);
		sorted.add(118);
		sortedTest.remove(65);
		System.out.println(sorted);
		System.out.println(sortedTest);
	}
}
