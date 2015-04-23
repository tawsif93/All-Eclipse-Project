import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.deitel.accoundRecord.*;



public class CreateTextFile {

	private Formatter output ;

	public void openFile()
	{
		try
		{
			output = new Formatter("client.txt");
		}
		catch(SecurityException securityException )
		{
			System.err.println("You do not have write access to this file");
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file or Creating it");
			System.exit(1);
		}
	}

	public void addRecord()
	{
		AccountRecord record = new AccountRecord();

		Scanner stdin = new Scanner(System.in);

		System.out.printf( "%s\n%s\n%s\n%s\n\n",
				"To terminate input, type the end-of-file indicator ",
				"when you are prompted to enter input.",
				"On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
				"On Windows type <ctrl> z then press Enter" );
		System.out.printf( "%s\n%s",
				"Enter account number (> 0), first name, last name and balance.",
				"? " );

		while(stdin.hasNext())
		{
			try
			{
				record.setAccont(stdin.nextInt());
				record.setFirstName(stdin.next());
				record.setLastName(stdin.next());
				record.setBalance(stdin.nextDouble());


				if(record.getAccont() > 0 ) 
				{
					output.format( "%d %s %s %.2f\n", record.getAccont(),
							record.getFirstName(), record.getLastName(),
							record.getBalance() );
				}

				else 
				{
					System.out.println("Account number must be greater than 0");
				}
			}

			catch(FormatterClosedException formatterCloseException)
			{
				System.err.println("Error writting to file"	);
				return ;
			}

			catch(NoSuchElementException noSuchElementException)
			{
				System.err.println("Invalid input , Please try again ");
				stdin.nextLine();
			}
			
			System.out.printf( "%s %s\n%s", "Enter account number (>0),",
					"first name, last name and balance.", "? " );

		}
	}
	
	public void closeFile()
	{
		if( output != null	)
		{
			output.close();
		}
	}
}