/*Derek Guevara
 * CS 2013
 * Section 3
 * this class has the 7 different sorting algorithms*/
package hw06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {
	
	private Sorting() {
	}
	
	static <E extends Comparable <E>> void insertionSort(ArrayList<E> list) {
		for (int i = 1; i < list.size(); i++) {
			E temp = list.get(i);
			int j = i;
			while (j > 0 && temp.compareTo(list.get(j-1)) < 0) {
				list.set(j, list.get(j-1));
				j--;
			}
			list.set(j, temp);
		}
	}
	
	static <E extends Comparable <E>> void bubbleSort(ArrayList<E> list) {
		for (int i = 1; i < list.size() ; i++) {
			boolean swapped = false;
			for (int j = 0; j < list.size() - 1; j ++) {
				if (list.get(j).compareTo(list.get(j+1)) <0){
					Collections.swap(list, j, j+1);
					swapped = true;
				}
			}
			if (!swapped){
				break;
			}
		}
	}
	
	static <E extends Comparable <E>> void selectionSort(ArrayList<E> list) {
		for (int i = 0; i < list.size()-1; i++) {
			int min = i;
			for (int j = i+1; j < list.size(); j++) {
				if (list.get(j).compareTo(list.get(min)) < 0) {
					min = j;
				}
			}
			Collections.swap(list, i, min);
		}
	}
	
	static <E extends Comparable <E>> void mergeSort(ArrayList<E> list) {
		if (list.size() > 1) {
			int mid = (list.size()-1)/2;
			ArrayList<E> left = new ArrayList<E>();
			ArrayList<E> right = new ArrayList<E>();
			for (int i = 0; i <= mid; i++) {
				left.add(list.get(i));
			}
			mergeSort(left);
			for (int j = mid+1; j < list.size(); j++) {
				right.add(list.get(j));
			}
			mergeSort(right);
			merge(left, right, list);
		}
	}
	
	private static <E extends Comparable <E>> void merge(ArrayList <E> list1, ArrayList <E> list2, ArrayList <E> result) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i).compareTo(list2.get(j)) < 0) {
				result.set(k, list1.get(i));
				i++;
			}
			else {
				result.set(k, list2.get(j));
				j++;
			}
			k++;
		}
		while (i < list1.size()) {
			result.set(k, list1.get(i));
			i++;
			k++;
		}
		while (j < list2.size()) {
			result.set(k, list2.get(j));
			j++;
			k++;
		}
	}
	
	static <E extends Comparable <E>> void quickSort(ArrayList<E> list) {
		quickSort (list, 0, list.size()-1);
	}
	
	private static <E extends Comparable <E>> void quickSort(ArrayList<E> list, int low, int high) {
		if (low < high) {
			int p = partition(list, low, high);
			quickSort(list, low, p-1);
			quickSort(list, p+1, high);
		}
	}

	private static <E extends Comparable <E>> int partition (ArrayList <E> list, int low, int high) {
		E pivot = list.get(high);
		int i = low -1;
		for (int j = low; j < high; j++) {
			if (list.get(j).compareTo(pivot) < 0) {
				i = i + 1;
				Collections.swap(list, i, j);
			}
		}
		Collections.swap(list, i+1, high);
		return i + 1;
	}
	
	static void countingSort(ArrayList<Integer> list, int k){
		Integer[] results = new Integer[list.size()];
		int[] counts = new int[k];
		for (int i = 0; i < k-1; i++) {
			counts[i]=0;
		}
		for (int i = 0; i <= list.size()-1; i++) {
			counts[list.get(i)]++;
		}
		for (int i = 1; i <= k-1; i++) {
			counts[i]+= counts[i-1];
		}
		for (int i = list.size()-1; i >= 0; i--) {
			results[counts[list.get(i)] -1] = list.get(i);
			counts[list.get(i)]--;
		}
		//the list is currently unsorted. we empty out the list,
		//and add the sorted values. (since method is void)
		list.clear();
		for (int x = 0; x < results.length; x++) {
			list.add(results[x]);
		}
	}
	
	static void radixSort(ArrayList<Integer> list) {
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();	
		}
		//we need to find the max
		int max = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}		
		}
		//in order to find the digits of maximum value, we must turn it into a string
		String maxString = String.valueOf(max);
		for (int i = 0; i < maxString.length(); i++) {
			for (int j = 0; j <= list.size()-1; j++) {
				/*key starts with the value of list at index j
				 * It gets turned to a String. Then, necessary zeros get added depending on how many digits key has.
				 * Then, depending on the value of i, 
				 */	
				String keyString  = String.valueOf(list.get(j));
				if (keyString.length() == 1) {
					keyString = "00" + keyString;
				}
				if (keyString.length() == 2) {
					keyString = "0" + keyString;
				}
				int key = Character.getNumericValue(keyString.charAt(0));
				if (i == 0) {
					key = Character.getNumericValue(keyString.charAt(2));
				}
				if (i == 1) {
					key = Character.getNumericValue(keyString.charAt(1));
				}
				buckets[key].add(list.get(j));
			}
			//list gets emptied out. then values from buckets get added to list
			list.clear();
			for (int j = 0; j <= buckets.length-1; j++) {
				for (Integer x : buckets[j]) {		
					list.add(x);
				}
				buckets[j].clear();
			}
		}
		
	}
}


