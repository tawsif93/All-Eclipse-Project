package deitel.exercise.chapter20 ;

import java.io.FileInputStream ;
import java.io.FileOutputStream ;
import java.io.IOException ;
import java.util.Properties ;
import java.util.Set ;

public class PropertiesTest {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		Properties table = new Properties() ;

		table.setProperty("color", "red") ;
		table.setProperty("width", "200") ;

		System.out.println("After Setting Properties : ") ;
		listProperties(table) ;

		table.setProperty("color", "blue") ;
		System.out.println("After Changing Properties : ") ;
		listProperties(table) ;

		table.setProperty("color", "black") ;
		System.out.println("After Changing Properties : ") ;
		listProperties(table) ;

		saveProperties(table) ;

		table.clear() ;

		System.out.println("After Clearing Properties : ") ;
		listProperties(table) ;

		laodProperties(table) ;
		Object value = table.getProperty("color") ;

		if (value != null)
			System.out.println("Property Color's Value is : " + (String) value) ;
		else
			System.out.println("Property color is not in the Table . ") ;
	}

	private static void laodProperties( Properties properties ) {
		// TODO Auto-generated method stub
		try {

			FileInputStream input = new FileInputStream("props.dat") ;
			properties.load(input) ;
			input.close() ;
			System.out.println("After Loading Properties : ") ;
			listProperties(properties) ;

		} catch ( IOException ioException ) {
			// TODO: handle exception
			ioException.printStackTrace() ;
		}
	}

	private static void saveProperties( Properties table ) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream output = new FileOutputStream("props.dat") ;
			table.store(output, "Sample Properties") ;
			output.close() ;
			System.out.println("After Saving Properties : ") ;
			listProperties(table) ;

		} catch ( IOException e ) {
			// TODO: handle exception
			e.printStackTrace() ;
		}
	}

	private static void listProperties( Properties table ) {
		// TODO Auto-generated method stub

		Set< Object> set = table.keySet() ;

		for (Object object : set)
			System.out.printf("%s\t%s\n", object,
					table.getProperty((String) object)) ;
		System.out.println() ;
	}
}
