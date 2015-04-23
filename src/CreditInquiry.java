import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.deitel.accoundRecord.AccountRecord;


public class CreditInquiry {

	private MenuOption accountType ;
	private Scanner input ;
	private MenuOption[] choices = { MenuOption.ZERO_BALANCE , MenuOption.CREDIT_BALANCE , 
			MenuOption.DEBIT_BALANCE , MenuOption.END } ;
	
	
	public void readRecords() 
	{
		AccountRecord record = new AccountRecord();
		
		
		try
		{
			input = new Scanner(new File("client.txt"));
			
			while(input.hasNext())
			{
				record.setAccont(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				
				if(shouldDisplay(record.getBalance()))
				{
					System.out.printf("%-10d%-12s%-12s%10.2f\n" , record.getAccont() , record.getFirstName(), record.getLastName() , record.getBalance());
				}
			}
		}
		
		catch(NoSuchElementException noSuchElementException)
		{
			System.err.println("File improperly formed");
			input.close();
			System.exit(1);
		}
		catch (IllegalStateException illegalStateException	) {
			System.err.println("Error reading file");
			System.exit(1);
		}
		catch(FileNotFoundException fileNotFoundException	)
		{
			System.err.println("File cannot be found ");
			System.exit(1);
		}
		
		finally 
		{
			if(input != null)
			{
				input.close();
			}
		}
	}
	
	public boolean shouldDisplay(double balance )
	{
		if((accountType == MenuOption.CREDIT_BALANCE) && (balance < 0 ) ) return true ;
		else if ( (accountType == MenuOption.DEBIT_BALANCE) && (balance > 0 ) ) return true ;
		else if ((accountType == MenuOption.ZERO_BALANCE) && (balance== 0 )) return true ;
		
		return false ;
	}
	
	private MenuOption getrequest()
	{
		Scanner textIn = new Scanner(System.in);
		int request = 1;
		System.out.printf( "\n%s\n%s\n%s\n%s\n%s\n",
				"Enter request", " 1 - List accounts with zero balances",
				" 2 - List accounts with credit balances",
				" 3 - List accounts with debit balances", " 4 - End of run" );
		try
		{
			do
			{
				System.out.println("\n?");
				request = textIn.nextInt();
			}while( request > 4 || request < 1 ) ;
		}
		catch(NoSuchElementException elementException)
		{
			System.err.println("Invalid Input");
			System.exit(1);
		}
		
		return choices[request-1];
	}
	
	public void processRequests()
	{
		accountType = getrequest() ;
		
		while(accountType != MenuOption.END)
		{
			switch(accountType)
			{
				case ZERO_BALANCE : System.out.println("\nAccount with Zero Balance\n");
					break;
				case CREDIT_BALANCE : System.out.println("\nAccount with Credit Balance\n");
					break;
				case DEBIT_BALANCE : System.out.println("\nAccount with Debit balance\n");
					break;
			}
			
			readRecords();
			accountType = getrequest();
		}
	}
}
