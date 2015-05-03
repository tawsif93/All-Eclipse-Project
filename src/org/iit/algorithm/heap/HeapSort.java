package org.iit.algorithm.heap;

/**
 * Created by hp on 4/2/2015.
 */

public class HeapSort {

	private int HeapSize ;

	public HeapSort ( ) {
	}

	public HeapSort ( int[] array )
	{

		MakeHeap(array);
		for (int i = array.length-1 ; i > 0 ; i--)
		{
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp ;

			System.out.println(array[i]);
			setHeapSize(getHeapSize()-1);
			MaxHeapify(array , 0 );
		}

		System.out.println(array[0]);
	}

	int getHeapSize() {
		return HeapSize;
	}

	void setHeapSize(int size)
	{
		HeapSize = size ;
	}

	int getParent(int i )
	{
		return i/2;
	}

	int getLeft(int i)
	{
		return 2 * i + 1 ;
	}

	int getRight(int i)
	{
		return 2 * i + 2 ;
	}

	void MaxHeapify(int[] array, int i)
	{
		int left = getLeft(i);
		int right = getRight(i);
		int longest ;

		if(HeapSize >= left && array[left] > array[i])
		{
			longest = left ;
		}
		else longest = i ;


		if(HeapSize >= right && array[right] > array[longest])
			longest = right ;

		if( longest != i)
		{
			int temp = array[i];
			array[i] = array[longest];
			array[longest] = temp ;
			MaxHeapify(array , longest);
		}
	}


	void MakeHeap(int[] array)
	{
		setHeapSize(array.length-1);

		for (int i = (array.length-1)/2 ; i >= 0 ; i--)
			MaxHeapify(array , i );
	}


}
