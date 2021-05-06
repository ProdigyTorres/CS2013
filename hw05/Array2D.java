/*Derek Guevara
 * CS 2013
 * Section 03
 *This class has the methods for Array2D*/
package hw05;
import java.util.ArrayList;

public class Array2D<E> {
	private int rows;
	private int cols;
	private Array2DNode<E> head;
	private Array2DNode<E> rowTail;
	private Array2DNode<E> colTail;
	Array2D(){
		rows = 0;
		cols = 0;
		head = null;
		rowTail = null;
		colTail = null;
	}
	
	//this method takes two ints as parameters and creates a 2d linked list with those parameters
	Array2D(int rows, int cols){
		int colIndex = 0;
		int rowIndex = 0;
		while (rowIndex < rows) {
			addFirstRow();
			rowIndex++;
		}
		while (colIndex < cols-1) {
			addFirstCol();
			colIndex++;
		}
	}
	
	//similar to Array2D(int rows, int cols)
	Array2D(E[][] arr) {
		int colIndex = 0;
		int rowIndex = 0;
		while (rowIndex < arr[0].length) {
			addFirstRow();
			rowIndex++;
		}
		while (colIndex < arr.length - 1) {
			addFirstCol();
			colIndex++;
		}
	}
	
	//adds a column at the beginning of the list
	public void addFirstCol() {
		Array2DNode<E> temp = new Array2DNode<E>();
		//if the linkedList is empty, a row and column are created
		if (this.isEmpty()) {
			this.head = temp;
			this.colTail = temp;
			this.rowTail = temp;
			this.rows++;
			this.cols++;
		}
		else {
			temp.nextCol = this.head;
			this.head = temp;
			this.cols++;
		}	
	}
	
	//same as addFirstCol
	public void addFirstRow() {
		Array2DNode<E> temp = new Array2DNode<E>();
		if (this.isEmpty()) {
			this.head = temp;
			this.rowTail = temp;
			this.colTail = temp;
			this.rows++;
			this.cols++;
		}
		else {
			temp.nextRow = this.head;
			this.head = temp;
			this.rows++;
		}
	}
	
	public void addLastCol() {
		Array2DNode<E> temp = new Array2DNode<E>();
		if (this.isEmpty()) {
			this.head = temp;
			this.colTail = temp;
			this.rows++;
			this.cols++;
		}
		else {
			this.colTail.nextCol = temp;
			this.colTail = temp;
			this.cols++;
		}
	}
	
	public void addLastRow() {
		Array2DNode<E> temp = new Array2DNode<E>();
		if (this.isEmpty()) {
			this.head = temp;
			this.rowTail = temp;
			this.rows++;
			this.cols++;
		}
		else {
			this.rowTail.nextRow = temp;
			this.rowTail = temp;
			this.rows++;
		}
	}
	
	public void insertCol(int index) {
		if (index < 0 || index > this.cols) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value: " + index);
		}
		
		Array2DNode<E> temp = new Array2DNode<E>();
		if (index == 0) {
			this.addFirstCol();
		}
		else if (index == this.cols) {
			this.addLastCol();
		}
		else {
			Array2DNode<E> current = this.head;
			int count = 0;
			while (count < index-1) {
				current = current.nextCol;
				count++;
			}
			temp.nextCol=current.nextCol;
			current.nextCol=temp;
			this.cols++;
		}
	}
	
	public void insertRow(int index) {
		if (index < 0 || index > this.rows) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value: " + index);
		}
		
		Array2DNode<E> temp = new Array2DNode<E>();
		if (index == 0) {
			this.addFirstRow();
		}
		else if (index == this.rows) {
			this.addLastRow();
		}
		else {
			Array2DNode<E> current = this.head;
			int count = 0;
			while (count < index-1) {
				current = current.nextRow;
				count++;
			}
			temp.nextRow=current.nextRow;
			current.nextRow=temp;
			this.rows++;
		}
	}
	
	public void deleteFirstCol() {
		if (this.isEmpty()) {
			throw new RuntimeException("Linked list is empty, nothing to delete!");
		}
		if (this.colSize() == 0) {
			this.head = this.colTail = null;
		}
		else {
			this.head = this.head.nextCol;
		}
		this.cols--;
	}
	
	public void deleteFirstRow() {
		if (this.isEmpty()) {
			throw new RuntimeException("Linked list is empty, nothing to delete!");
		}
		if (this.rowSize() == 0) {
			this.head = this.rowTail = null;
		}
		else {
			this.head = this.head.nextRow;
		}
		this.rows--;
	}
	
	public void deleteLastRow() {
		if (this.isEmpty()) {
			throw new RuntimeException("Linked list is empty, nothing to delete!");
		}
		//E temp = this.rowTail.getItem();
		if (this.rowSize() == 1) {
			this.head = this.rowTail = null;
		}
		else {
			Array2DNode<E> current = this.head;
			Array2DNode<E> previous = this.head;
			int x = 0;
			while (current != this.rowTail) {
	//			System.out.println(current.getItem() + " test " + previous.getItem());
				previous = current;
				current = current.nextRow;
			}
			previous.nextRow = null;
			this.rowTail = previous;
		}
		this.rows--;
	}
	
	public void deleteLastCol() {
		if (this.isEmpty()) {
			throw new RuntimeException("Linked list is empty, nothing to delete!");
		}
		if (this.cols == 0) {
			deleteFirstCol();
		}
		else {
			Array2DNode<E> current = this.head;
			Array2DNode<E> previous = this.head;
			while (current!= this.colTail) {
				previous = current;
				current = current.nextCol;
			}
			previous.nextCol = null;
			this.colTail = previous;
		}
		this.cols--;
	}
	
	public void deleteCol(int index) {
		if (this.isEmpty()) {
			throw new RuntimeException("Linked list is empty, nothing to delete!");
		}
		
		if (index < 0 || index >= this.cols) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value: " + index);
		}
		
		if (index == 0) {
			this.deleteFirstCol();
		}
		else if (index == this.cols - 1) {
			this.deleteLastCol();
		}
		else {
			int count = 0;
			Array2DNode<E> previous = this.head;
			if (previous == null) {
				System.out.println("this is null");
			}
			while (count < index - 1) {
				previous = previous.nextCol;
				count++;
			}
			previous.nextCol = previous.nextCol.nextCol;
			this.cols--;
		}
	}
	
	public void deleteRow(int index) {
		if (this.isEmpty()) {
			throw new RuntimeException("Linked list is empty, nothing to delete!");
		}
		
		if (index < 0 || index >= this.rows) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value: " + index);
		}
		
		if (index == 0) {
			this.deleteFirstRow();
		}
		else if (index == this.rows - 1) {
			this.deleteLastCol();
		}
		else {
			int count = 0;
			Array2DNode<E> previous = this.head;
			
			while (count < index - 1) {
				previous = previous.nextRow;
				count++;
			}
			
			E temp = previous.nextRow.getItem();
			previous.nextRow = previous.nextRow.nextRow;
		
			this.rows--;
		}
	}

	public E get (int row, int col) {
		if (row < 0 || col < 0 || col > this.colSize() || row > this.rowSize()) {
			throw new IndexOutOfBoundsException("index is out of bounds");	
		}
		Array2DNode <E> current = this.head;
		int currRow = 0;
		int currCol = 0;
		while (currRow < row) {
			current = current.nextRow;
			currRow++;
		}
		while (currCol < col) {
			current = current.nextCol;
			currCol++;
		}
		return current.getItem();
	}
	
	public ArrayList<E> getCol(int col) {
		ArrayList<E> list = new ArrayList<E>();
		System.out.println("Col index " + col);
		if (col < 0 || col > this.cols) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		
		Array2DNode<E> current = this.head;
		int index = 0;
		while (index < col) {
			current = current.nextRow;
			index++;
			System.out.println(index);
		}
		while (current != null) {
			System.out.println("test " + current.getItem());
			list.add(current.getItem());
			current = current.nextCol;
		}
		return list;
	}
	
	public ArrayList<E> getRow(int row) {
		ArrayList<E> list = new ArrayList<E>();
		if (row < 0 || row > this.rows) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		Array2DNode<E> current = this.head;
		int index = 0;
		while (index < row) {
			current = current.nextCol;
			index++;
		}
		while (current != null) {
			System.out.println("test " + current.getItem());
			list.add(current.getItem());
			current = current.nextRow;
		}
		return list;
	}
	
	//
	public void set(int row, int col, E item) {
		Array2DNode<E> temp = new Array2DNode<E>(item);
		Array2DNode<E> currRow = new Array2DNode<E>();
		Array2DNode<E> currCol = new Array2DNode<E>();
		if (row > this.rows || row < 0 || col < 0 || col > this.cols) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value");
		}
		if (row == 0 & col == 0) {
			this.head = temp;
			this.rowTail = temp;
			this.colTail = temp;
		}
		int colCount = 0;
		int rowCount=0;
		while (rowCount < row) {	
			
		}
	}
	
	//returns col size
	public int colSize() {
		return cols;
	}
	
	//returns row size
	public int rowSize() {
		return rows;
	}
	
	//returns true if 2dLinkedList is empty
	public boolean isEmpty() {
		return (this.head == null && this.rowTail==null && this.colTail==null && this.cols==0 && this.rows==0);
	}
	
	public String toString() {
		String result = "";
		if (this.isEmpty()) {
			result = "list is empty";
		}
		Array2DNode<E> currentRow = this.head;
		Array2DNode<E> currentCol = this.head;
		while (currentCol != null) {
			while ( currentRow != null) {
				result += currentRow.getItem() + " ";
				currentRow = currentRow.nextRow;
			}
			System.out.print("\n");
			currentCol = currentCol.nextCol;
		} 
		return result;
	}
	
}