/*Derek Guevara
 * CS 2013
 * Section 03
 *This class has the methods for the sortedSet hw*/

package hw04;
import java.util.Arrays;

public class SortedSet <E extends Comparable<E>>{
	private int size;
	//the default capacity for the set is 10
	private E[] set = (E[])(new Comparable[10]);
	
	SortedSet() {
		set = (E[])(new Comparable[10]);
	}
	
	//constructor where capacity is set by the constructor
	SortedSet(int capacity){
		set = (E[])(new Comparable[capacity]);
	}
	
	//the values set by the constructor get added to the sortedSet
	SortedSet(E... values){
		addAll(values);
	}
	
	//constructor takes one SortedSet as a parameter, creates a deep copy of that SortedSet
	SortedSet(SortedSet<E> set1){
		//the size and capacity(length) of the set are equal to the set it is copying from
		set = (E[])(new Comparable[set1.set.length]);
		size=set1.size;
		//System.arraycopy(set1.set, 0, set, 0, size);
		for (int i = 0; i < size; i++) {
			set[i]=set1.set[i];
		}
	}
	
	//method to check if a value exists.
	//linear search, checks all values
	public boolean exists (E value) {
			for (E val: set) {
				if (value.equals(val)) {
					return true;
				}
			}
		return false;
	}
	
	//method to add values
	public void add(E value) {
		//checks if the value already exists in the set
		if (exists(value) == false) {
			//if the set is full, it gets resized
			if (this.set.length <= this.size) {
				resize();
			}
			set[size]= value;
			size++;
			Arrays.sort(set, 0, size);
		}
	}
	
	//method to add comma separated values
	public void addAll(E... values) {
		for (int i = 0; i < values.length; i++) {
			//adds
			add(values[i]);
		}
	}
	
	//method to remove value in parameter
	public void remove(E value) {
		//checks all values in the set
		for (int i = 0; i < size; i++) {
			//if it finds the value, the value becomes null
			if (set[i].equals(value)) {
				set[i]=null;
				//the set will shift until null value is at the end of the set (shift similar to hw02)
				while (set[size-1]!=null) {
		        	//temp holds value from last index
		            E temp = set[size-1];
		            //values shift
		            for(int j =size-1; j>0; j--) {
		            	set[j]=set[j-1];
		            }
		            //temp gets placed at index zero
		            set[0]=temp; 
				}
				//the null value will be removed
				size--;
				Arrays.sort(set, 0, size);
			}
		}
	}
	
	  //Initially, this was my get method. It works. Then I noticed you
	  //said to use try/catch. 
	  /*public E get(int index) {
		if (index >= 0 && index < size) {
			return set[index];
		}
		else {
			System.out.println("index invalid");
		}
		return null;
	}*/
	
	//returns value at indicated index
	public E get(int index) {
		try {
			return set[index];
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("index invalid");
			return null;
		}
	}
	
	//returns size
	public int size() {
		return size;
	}
	
	//compares two SortedSets
	public boolean equals(SortedSet<?> object) {
		if (set.equals(object)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//override toString method. similar to hw02
	@Override
	public String toString() {
		String str = "{";
		int x = 0;
		while (x < size-1) {
			str+=set[x]+", ";
			x++;
		}
		str = str + set[x]+ "}";
		//if the set is empty, {} will print out
		if (size==0) {
			str = "{}";
		}
		return str;
	}
	
	//method to resize sortedSet
	private void resize() {
		if (size >= set.length) {
			//new capacity is 2x size
			E[] newSet = (E[])(new Comparable[size * 2]);
			//the values of old set are given to new set, then the capacity of newSet is given to original set
			System.arraycopy(set, 0, newSet, 0, size);
			set = newSet;
		}
	}
}