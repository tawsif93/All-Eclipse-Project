import java.awt.Graphics;

import javax.swing.JApplet;


public class WelcomeApplet extends JApplet{

	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawString("Welcome My Dear ", 25, 25);
	}
}
