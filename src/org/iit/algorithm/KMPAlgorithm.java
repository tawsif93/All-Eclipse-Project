package org.iit.algorithm;

public class KMPAlgorithm {

	static String inputString =  "abacaabaccabacabaabb" ;
	static String pattern = "abacab" ;
	
	static int [] failure = new int[pattern.length()+1] ;
	
	
	
	public static void failureFunction()
	{
		int k = 0 ;

		failure[1] = 0 ;
		
		StringBuilder sb = new StringBuilder(pattern);
		
		sb.insert(0, '0');
		System.out.print(failure[0] + " ");
		
		pattern = sb.toString() ;
		
		for (int i = 2; i < pattern.length() ; i++) {
			
			while( k > 0 && pattern.charAt(i) != pattern.charAt(k+1) )
				k = failure[k];
			
			if( pattern.charAt(i) == pattern.charAt(k+1) )
				k++ ;
			
			failure[i] = k ;
			System.out.print( failure[i] + " " ) ;
		}
	}
	
	public static void KMPmatch() {
		failureFunction();
		System.out.println();
		int q = 0 ;
		int m = pattern.length()-1 ;
		
		for(int i = 0 ; i < inputString.length() ; i++)
		{
			while ( q > 0 && inputString.charAt(i) != pattern.charAt(q+1))
				q = failure[q];
			
			if(inputString.charAt(i) == pattern.charAt(q+1))
				q++;
			
			if( q == m )
			{
				System.out.println(q);
				System.out.println("Match : " + (i - m + 1) );
				q = failure[q];
				System.out.println(q);
			}			
		}
	}
	
	public static void main(String[] args) {
		KMPmatch();
	}
}
