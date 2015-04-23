
public class ReadTextFileTest {

	public static void main(String[] args) {
		
		ReadTextFile record = new ReadTextFile();
		
		record.openFile();
		record.readRecord();
		record.closeFile();
		
	}

}
