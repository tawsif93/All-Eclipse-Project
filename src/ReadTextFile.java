import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.deitel.accoundRecord.*;

public class ReadTextFile {

	private Scanner stdin ;

	public void openFile()
	{

		try
		{
			stdin = new Scanner(new File("client.txt"));
		}
		catch(FileNotFoundException fileNotFoundException )
		{
			System.err.println("Error opening file ");
			System.exit(1);
		}
	}

	public void readRecord()
	{
		AccountRecord record = new AccountRecord();
		
		System.out.printf( "%-10s%-12s%-12s%10s\n", "Account",
				"First Name", "Last Name", "Balance" );
		
		try
		{
			while(stdin.hasNext())
			{
				record.setAccont(stdin.nextInt());
				record.setFirstName(stdin.next());
				record.setLastName(stdin.next());
				record.setBalance(stdin.nextDouble());
				
				System.out.printf( "%-10d%-12s%-12s%10.2f\n",
						record.getAccont(), record.getFirstName(),
						record.getLastName(), record.getBalance() );
			}
		}
		
		catch(NoSuchElementException elementException )
		{
			System.err.println("File Improperly Formated");
			System.exit(1);
		}
		
		catch( IllegalStateException stateException )
		{
			System.err.println("Error Reading from file");
			System.exit(1);
		}
	}
	
	public void closeFile()
	{
		if(stdin != null)
		{
			stdin.close();
		}
	}
}
