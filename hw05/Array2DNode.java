/*Derek Guevara
 * CS 2013
 * Section 03
 *This class has the Array2DNode*/
package hw05;

public class Array2DNode<E> {
	private E item;
	protected Array2DNode <E> nextCol;
	protected Array2DNode <E> nextRow;
	Array2DNode(){
		this.item = null;
		this.nextCol = null;
		this.nextRow = null;
	}
	Array2DNode(E item){
		this.item = item;
		this.nextCol = null;
		this.nextRow = null;
	}
	public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
}
