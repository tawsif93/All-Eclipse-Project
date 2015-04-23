import java.io.File;
import java.util.Scanner;


public class FileDemonstration {

	public static void main(String[] args) {
		Scanner stdin  = new Scanner(System.in);
		
		
		String name = stdin.nextLine();
		
		analyzePath(name);
	}
	
	public static void analyzePath(String path )
	{
		File name = new File(path);
		
		if(name.exists())
		{
			System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s" , name.getName() , " exists" , (name.isFile() ? "Is a file" : "not a file"),
					(name.isDirectory()? "is a directory " : "not a directory") , (name.isAbsolute() ? "is absolute path" : " not an Absolute path " ) ,
					"Last Modified : " , name.lastModified() , "Length : " , name.length() , "Path : " , name.getPath() , "Absolute Path : " , name.getAbsolutePath() ,
					"Parent : " , name.getParent() 
					);
			
			if(name.isDirectory())
			{
				String[] directories = name.list();
				
				for(String directoryName : directories)
				{
					System.out.println(directoryName);
					
				}
			}
		}
		
		else {
			System.out.println(path + " does not exist ");
			
		}
	}

}
