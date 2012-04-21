import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * SocialOrganizerPanel brings all of the GUI compnents together and allows communication between all of them and stores data for all of the children 
 * panels to use
 * @author Vishnu
 * Collaboration Statement: I worked on this alone and with class materials only
 */
public abstract class SocialOrganizerPanel extends JPanel
{
	protected static DisplayPanel dP;
	protected static InputPanel iP;
	protected static SearchPanel sP;
	protected static ArrayList<Person> personList = new ArrayList<Person>();
	protected static int currentPersonIndex;
	
	public SocialOrganizerPanel()
	{
		personList.add(new Person("John Doe"));
		personList.get(0).setImage(new ImageIcon("facebook-no-image1.gif"));
		currentPersonIndex = 0;
	}
	public SocialOrganizerPanel(InputPanel ip, SearchPanel sp, DisplayPanel dp)
	{
		this.dP = dp;
		this.iP = ip;
		this.sP = sp;
		
		dP.setBackground(new Color(255,255,255));
		iP.setBackground(new Color(196,153,74));
		//sP.setBackground(Color.BLUE);
		
		dP.updateTotalList(personList);
		
		System.out.println(personList + "    " + personList.indexOf(personList.get(0)));
		

		setLayout(new BorderLayout());		
		add(sP, BorderLayout.NORTH);
		add(iP, BorderLayout.WEST);
		add(dP, BorderLayout.CENTER);
	}

}
