import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class FileDemonstrationGui extends JFrame{

	private JTextArea output ;
	private JScrollPane scrollPane ;
	
	public FileDemonstrationGui()
	{
		super("Testing Class File");
		
		output = new JTextArea();
		
		scrollPane = new JScrollPane(output);
		output.setEditable(false);
		add(scrollPane , BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
		
		analyzePath();
	}
	
	private File getFileOrDirectory()
	{
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int result = fileChooser.showOpenDialog(this);
		
		if(result == JFileChooser.CANCEL_OPTION)
		{
			System.exit(1);
		}
		
		File fileName = fileChooser.getSelectedFile() ;
		
		if( (fileName == null) || (fileName.getName().equals("")))
		{
			JOptionPane.showMessageDialog(this, "Invalid Name" , "Invalid Name" , JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		return fileName ;
	}
	
	public void analyzePath()
	{
		File name = getFileOrDirectory();
		
		if(name.exists())
		{
			output.setText(String.format("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s" , name.getName() , " exists" , (name.isFile() ? "is a file" : " is not a file" ) ,
					(name.isDirectory() ? "is a Directory " : "is not a Directory") , 
					(name.isAbsolute() ? "is a Absolute Path" : "is not a Absolute path") , "Last Modified: " ,
					name.lastModified() , "Length: " , name.length() , 
					"Path : " , name.getPath() , "Absolute Path : " , name.getAbsolutePath() , 
					"Parent : " , name.getParent()));
			
			if( name.isDirectory())
			{
				String[] directory = name.list();
				output.append("\n\nDirectory List: \n\n");
				
				for (String directoryName : directory) {
					output.append(directoryName + "\n");
				}
			}
		}
		
		else 
		{
			JOptionPane.showMessageDialog(this, name + " does not exist" , "Error" ,  JOptionPane.ERROR_MESSAGE);
		}
	}
}
