import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Main method for The Social Organizer Program.
 * @author Vishnu
 * Collaboration Statement: I worked on this alone and with class materials only
 */
public class SocialOrganizerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Social Organizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setBackground(Color.yellow);
		SocialOrganizerFront sof = new SocialOrganizerFront();
		frame.add(sof);
		
		frame.setResizable(false);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
