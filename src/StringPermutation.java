import java.util.Scanner;
import java.util.Vector;


public class StringPermutation
{
	
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		
		String inputString = stdin.nextLine();
		System.out.println();
		
		Permutation p = new Permutation(inputString);
		
		stdin.close();
	}
}




class Permutation {

	String s; 
	Vector <Integer> v = new Vector <>();
	
	
	
	public Permutation(String s) {
		this.s = s;
		permute(0, s.length());
	}



	public void swap(int i , int j )
	{
		char temp ;
		char[] charArray = new char[s.length()];
		charArray = s.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		String tep = "";
		
		for(int i1 = 0 ; i1 < charArray.length ; i1++)
		{
			tep += charArray[i1];
		}
		
		s = tep;
	}
	
	public void permute(int i , int n)
	{
		if(i == n ) System.out.println(s);
		else 
		{
			for(int j = i ; j < n ; j++)
			{
				swap(i , j);
				permute(i+1, n);
				swap(i, j);
			}
		}
	}
	
}


