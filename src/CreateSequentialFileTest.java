
public class CreateSequentialFileTest {

	public static void main(String[] args) {
		CreateSequentialFile application = new CreateSequentialFile();
		
		application.openFile();
		application.addRecord();
		application.closeFile();
	}

}
