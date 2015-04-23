package deitel.exercise.chapter20 ;

import java.util.Comparator ;
import java.util.PriorityQueue ;

public class PriorityQueueTest {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		PriorityQueue< Double> priorityQueue = new PriorityQueue<>(
				new PriorityQueueComparator()) ;

		priorityQueue.add(1.3) ;
		priorityQueue.add(3.9) ;
		priorityQueue.add(0.1) ;
		priorityQueue.add(9.0) ;

		while (priorityQueue.size() > 0) {
			System.out.println("Top : " + priorityQueue.peek()) ;
			priorityQueue.poll() ;
		}
	}
}

class PriorityQueueComparator implements Comparator< Double> {

	@Override
	public int compare( Double o1, Double o2 ) {
		// TODO Auto-generated method stub

		if ((o1 - o2) < 0)
			return 1 ;
		else if ((o1 - o2) > 0)
			return -1 ;

		return 0 ;
	}

}
