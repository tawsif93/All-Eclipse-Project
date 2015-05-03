package org.iit.algorithm ;

public class HeapSortMain {

	public static void main( String[] args ) {
		int[] a = { 3, 2, 19, 16, 17, 55 } ;
		// HeapSort hs = new HeapSort (a);

		MaxPriorityQueue mpq = new MaxPriorityQueue(a) ;
		// System.out.println ( mpq.HeapMaximum () );
		System.out.println(mpq.HeapExtractMax()) ;
		System.out.println(mpq.HeapExtractMax()) ;
		System.out.println(mpq.HeapExtractMax()) ;
		System.out.println(mpq.HeapExtractMax()) ;
		System.out.println(mpq.HeapExtractMax()) ;
		System.out.println(mpq.HeapExtractMax()) ;
		mpq.HeapInsertKey(56) ;
		System.out.println("Heap Extract : " + mpq.HeapExtractMax()) ;
		// System.out.println (mpq.HeapExtractMax ());
		mpq.HeapIncreaseKey(0, 57) ;
		// System.out.println (mpq.HeapExtractMax ());

	}
}
