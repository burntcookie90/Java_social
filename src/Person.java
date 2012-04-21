import java.util.ArrayList;

import javax.swing.ImageIcon;


/**
 * Person class: houses the information for a Person.
 * @author Vishnu
 * Collaboration Statement: I worked on this alone and with class materials only
 */
public class Person
{
	private String name, status;
	ArrayList<String> friendNames;
	ImageIcon personImage;
	
	public Person(String name)
	{
		this.name = name;
		status = "No Status";
		friendNames = new ArrayList<String>();
		//friendNames.add(" ");
		
		personImage = new ImageIcon("facebook-no-image1.gif");
	}
	
	/**
	 * Set's person's image
	 * @param image image to set for person
	 */
	public void setImage(ImageIcon image)
	{
		this.personImage = image;
	}
	
	/**
	 * returns Image for person
	 * @return Image for Person
	 */
	public ImageIcon getImage()
	{
		return personImage;
	}
	
	/**
	 * Sets the name for the Person
	 * @param name name to set for Person
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Returns name of current Person
	 * @return name of current Person
	 */
	public String getName()
	{
		return name;
	}	

	/**
	 * Sets status of current Person
	 * @param status status of current Person
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	/**
	 * returns current status of current person
	 * @return status of current person
	 */
	public String getStatus()
	{
		return status;
	}
	
	/**
	 * Add's friend to current person's friend list
	 * @param friendName name of friend to add
	 */
	public void addFriend(String friendName)
	{
		friendNames.add(friendName);
	}
	
	/**
	 * Returns list of friend names
	 * @return ArrayList with friend's names
	 */
	public ArrayList getFriends()
	{
		return friendNames;
	}
	
	public String toString()
	{
		String personString = name + "_" +status + "_" + friendNames;
		return personString;
		
	}
}
