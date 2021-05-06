/*Derek Guevara
 * CS 2013
 * Section 03
 *This class has the methods for the sortedSet hw
 *Both methods use an if/else statement.
 *The smaller set will be added  (or compared) to the larger set*/

package hw04;

public class SortedSetUtils {
	private SortedSetUtils() {	
	}

	//union method. will combine 2 sets. runtime is O(n)
	public static <E> SortedSet union(SortedSet set1, SortedSet set2) {
		//if set1 is greater than set2, we create a deep copy of set1 and add set2 to it.
		if (set1.size()>set2.size()) {
			SortedSet intersection = new SortedSet<>(set1);
			for (int i = 0;i < set2.size(); i++) {
				intersection.add(set2.get(i));
			}
			return intersection;
		}
		//if set2 is greater than (or equal to) set1, we create a deep copy of set2 and add set1 to it.
		else {
			SortedSet intersection = new SortedSet<>(set2);
			for (int i = 0;i < set1.size(); i++) {
				intersection.add(set1.get(i));
			}
			return intersection;
		}
	}

	//this method checks the values that both sets have in common. Similar to Union method
	public static <E> SortedSet intersection(SortedSet set1, SortedSet set2) {
		SortedSet intersection = new SortedSet<>();
		//checks if size of set1 is greater than size of set2
		if (set1.size()>set2.size()) {
			for (int i = 0;i < set2.size(); i++) {
				if (set1.exists(set2.get(i))) {
					//if both sets have the same value, it will be added to the new set
					intersection.add(set2.get(i));
				}
			}
		}
		else {
			//if size of set2 is greater than or equal to size of set1, it checks set2 instead of set1
			for (int i = 0; i < set1.size(); i++) {
				if (set2.exists(set1.get(i))) {
					//if both sets have the same value, it will be added to the new set
					intersection.add(set1.get(i));
				}
			}
		}
		return intersection;
	}
}