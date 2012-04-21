import java.awt.BorderLayout;
import java.awt.Dimension;


/**
 * Social Organizer Front class sends args to Super Class SocialOrganizerPanel
 * @author Vishnu
 * Collaboration Statement: I worked on this alone and with class materials only
 */
public class SocialOrganizerFront extends SocialOrganizerPanel
{
	
	public SocialOrganizerFront()
	{
		super(new InputPanel(),new SearchPanel(),new DisplayPanel());		
		
		setPreferredSize(new Dimension(1350,600));
	}
}
