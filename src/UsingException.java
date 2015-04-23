
public class UsingException {

	public static void main(String[] args) {
		try {
			throwException();
			
		} catch (Exception exception) {
			System.err.println("Exception Handled in Main");
		}
		
		doesNotThrowException();
	}
	
	private static void throwException() throws Exception{
		try {
			System.out.println("Method throw Exception");
			throw new Exception();
		} 
		catch (Exception exception) {
			System.err.println("Exception Handled in method throw Execption");
			throw exception ;
		}
		
		finally 		
		{
			System.err.println("Finally Executed in throwException Method");
		}

	}
	
	private static void doesNotThrowException() {
		try {
			System.out.println("Method does not throwException");
		} 
		catch (Exception exception) {
			System.err.println(exception);
		}
		
		finally {
			System.err.println("Finally Executed in doesNotThrowException");
		}
		
		System.out.println("End of does not throw exception Method");
	}
	
}
