package org.iit.algorithm ;

/**
 * Created by hp on 4/5/2015.
 */
public class MaxPriorityQueue extends HeapSort {

	private int[]	Array ;

	public MaxPriorityQueue ( int[] array ) {
		super() ;
		Array = array ;
		setHeapSize(Array.length - 1) ;
		MakeHeap(Array) ;
	}

	public int HeapMaximum() {
		return Array[0] ;
	}

	public int HeapExtractMax() {
		if (getHeapSize() < 0)
		{
			System.err.println("Heap UnderFlow") ;
			return -1 ;
		}
		else
		{
			int max = Array[0] ;
			Array[0] = Array[getHeapSize()] ;
			setHeapSize(getHeapSize() - 1) ;
			MaxHeapify(Array, 0) ;
			return max ;
		}
	}

	public void HeapIncreaseKey( int i, int key ) {
		if (key < Array[i])
			System.err.println("New Key is Less than the Curent key") ;
		else
		{
			Array[i] = key ;
			while ((i > 0) && (Array[getParent(i)] < Array[i]))
			{
				int temp = Array[getParent(i)] ;
				Array[getParent(i)] = Array[i] ;
				Array[i] = temp ;
				i = getParent(i) ;
			}
		}
	}

	public void HeapInsertKey( int key ) {
		int[] newArray = new int[Array.length + 1] ;
		setHeapSize(getHeapSize() + 1) ;
		newArray = Array ;
		newArray[getHeapSize()] = Integer.MIN_VALUE ;
		Array = newArray ;
		HeapIncreaseKey(getHeapSize(), key) ;
	}

}
