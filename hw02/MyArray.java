/*Derek Guevara
 * CS 2013
 * Section 3
 *This class has the methods for the generics hw*/
package hw02;
import java.util.Random;
public class MyArray<E extends Comparable<E>> {
    //No other data fields necessary.
    private E[] data;
    public MyArray(int size) {
        this.data = (E[])(new Comparable[size]);
    }
    
    public E[] getData() {
		return data;
	}
    
	public void setData(E[] data) {
		this.data = data;
	}
	
	//This constructor can accept an array or a comma-separated list of values.
    public MyArray(E ... elements) {
        this.data = (E[])(new Comparable[elements.length]);
        //Make a deep copy to prevent shared references.
        System.arraycopy(elements, 0, this.data, 0, elements.length);
    }
    
    //gets data at a given index
    public E get (int index) {
		return data[index];
    }
    
    //returns data from start to end
    public E[] get (int start, int end) {
    	E[] myArrayCopy = (E[])(new Comparable[(this.size())]);
    	int x = start;
    	E last = this.get(end);
    	myArrayCopy[end] = last;
    	//print myArrayCopy
    	String str = "";
    	while (x < end) {
    		myArrayCopy[x] = this.get(x);
    		str+= (myArrayCopy[x] + ", ");
    		x++;
    	}
    	str+= last;
    	System.out.println(str);
    	return myArrayCopy;
    }
    
    //puts E value at the given index
    public void put (int index, E value) {
    	data[index] = value;
    }
    
    //inserts values from start to end.
    public  void put (int start, int end, E... elementList ) {
        	for (E element: elementList) {
        		if (start < data.length) {
        			data[start] = element;
            		start++;
        		}	
        	}
    }
    
    //method to make check if two MyArrays are equal
    @Override
    public boolean equals(Object o) {
    	//checks if o is instance of myArray. then compares values (to String)
    	if (o instanceof MyArray && this.toString().equals(o.toString())){
    		System.out.println("TRUE");
    		return true;
    	}
    	else {
    		System.out.println("FALSE");
    		return false;
    	}
    }
    
    //method to get max value from array
    public E max() {
    	//max is set at index 0
    	E max = (E) data[0];
    	int x = 1;
    	//max is compared with all values from array
    	while (x < data.length) {
    		if ((data[x].compareTo(max) > 0))  {
    			max = (E) data[x];
    		}
    		x++;
    	}
    	return max;
    }
    
    //method to get min value from array
    public E min() {
    	//min is set at index zero
    	E min = (E) data[0];
    	int x = 1;
    	//min is compared with all values from array
    	while (x < data.length) {
    		if ((data[x].compareTo(min) < 0))  {
    			min = (E) data[x];
    		}
    		x++;
    	}
    	return min;
    }
    
    //method to reverse values from array
    public void reverse() {
    	E[] copyData = (E[])(new Comparable[data.length]);
    	int count = 0;
    	//new Array is created with the same values as original array
    	while (count < data.length) {
    		copyData[count] = data[count];
    		count++;
    	}
    	//this variable holds data from index zero
    	E zero = copyData[0];
    	int i = 0;
    	int j = data.length-1;
    	while (i < data.length-1) {
    		//data gets copied to new array in reverse order
    		data[i]=copyData[j];
    		i++;
    		j--;
    	}
    	//data from variable zero gets put at the end of the array
    	data[data.length-1] = zero;
    	System.out.println(this.toString());
    }
    
    //method to shuffle contents inside array
    public void shuffle() {
        Random random = new Random();
        for (int count = this.size() - 1; count > 0; count--){
        	//random int is created
            int randomInt = random.nextInt(count + 1);
            //temp holds the value from the random int
            E temp = this.get(randomInt);
            //value from count gets inserted into randomInt
            this.put(randomInt, this.get(count));
            this.put(count, temp);
        }
        System.out.println(this.toString());
    }
    
    public void leftShift(int shiftDistance) {
    	int count = 0;
    	while (count < shiftDistance) {
    		//temp holds value at index 0.
    		//temp 2 holds value at index 1.
    		E temp = this.get(0);
    		E temp2 = this.get(1);
    		for (int i = 1; i < this.size()-1; i++) {
    			this.put(i, this.get(i+1));
    		}
    		//temp gets placed at the END (last index) of the array 
    		this.put(this.size()-1, temp);
    		//temp 2 gets placed at the first index of the array
    		this.put(0, temp2);
    		count++;
    	}
    }

    //shitfs all values by shiftDistance value.
    public void rightShift(int shiftDistance) {
    	int count = 0;
    	
    	
    	while (count < shiftDistance) {
        	int x = this.size();
        	//temp holds value from last index
            E temp = this.get(x-1);
            //values shift
            for(int i =x-1; i>0; i--) {
              this.put(i, this.get(i-1));
            }
            //temp gets placed at index zero
            this.put(0, temp);
            count++;
            
            
    	}
    }
    
    //returns the size of the array
    public int size() {
    	return data.length;
    }
    
    //to string method
    @Override
    public String toString() {
    	String toStr = "";
    	int x = 0;
    	//this creates a string with all values EXCEPT the last value
    	while (x < (data.length-1)) {
    		toStr+= data[x] + ", ";
    		x++;
    	}
    	//data[x] is the LAST value. this is done to not have a trailing comma/space
    	toStr = toStr + data[x];
    	return toStr;
    }
    
    //method that sorts values from lowest to greatest
    public void sort() {
    	int x = 0;
    	while (x < this.size()-1) {
    		int first = x;
    		int second = first + 1;
    		//compares value at x with the value in front of it
    		if (this.get(first).compareTo(this.get(second)) > 0) {
    			E temp = this.get(second);
    			this.put(second, this.get(first));
    			this.put(first, temp);
    			x++;
    			//recursion to test all values
    			this.sort();
    		}
    		else {
    			x++;
    		}
    	}
    }
}