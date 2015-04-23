import java.util.InputMismatchException;
import java.util.Scanner;


public class DivideByZeroWithExceptionHandling {

	public static int quotient(int nominator , int deNominator) throws ArithmeticException // Manually throw Arithmetic Exception
	{
		return nominator/deNominator;
	}
	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in); //Creating Scanner 
		Boolean continueLoop = true ;

		do
		{
			try {


				System.out.println("Enter Nominator : ");
				int nominator = stdin.nextInt();
				System.out.println("Enter Denominator : ");
				int denominator = stdin.nextInt();

				int result = quotient(nominator, denominator);

				System.out.println("Result : " + result);
				continueLoop = false ;
			}
			
			catch( ArithmeticException arithmeticException  )
			{
				System.err.println("Exception : " + arithmeticException); // Divide by Zero Exception
				System.out.println("Can not divide by Zero ");
			}
			
			catch ( InputMismatchException inputMismatchException) {
				System.err.println("Exception :  " + inputMismatchException); // Non Integer Value Enter Exception
				stdin.nextLine();
				System.out.println("Enter integer .!!!");
			}
			
			finally 
			{
				if(!continueLoop)stdin.close();
			}

		}while(continueLoop);
	}

}
