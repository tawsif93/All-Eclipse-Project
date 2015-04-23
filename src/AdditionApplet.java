import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JOptionPane;



public class AdditionApplet extends JApplet{

	private double sum ;
	
	public void init()
	{
		String firstDigit = JOptionPane.showInputDialog(this ,"Enter First Floating Point " );
		String secondDigit = JOptionPane.showInputDialog(this ,"Enter Second Floating Point");
		
		sum = Double.parseDouble(firstDigit) + Double.parseDouble(secondDigit);
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawRect(15, 10, 270, 20);
		
		g.drawString("The Sum is : " + sum 	, 25 , 25 );
	}
}
