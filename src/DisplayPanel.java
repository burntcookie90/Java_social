import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 * DisplayPanel displays the person
 * @author Vishnu
 * Collaboration Statement: I worked on this alone and with class materials only
 */
public class DisplayPanel extends SocialOrganizerPanel
{
	private JLabel nameLabel;
	private JLabel personImage;
	private JLabel statusLabel;
	private JList friendsList;
	private JLabel friendsListLabel;
	private JPanel listPanel;
	private JList friendList;
	private DefaultListModel friendModel;
	private String defaultName;
	private JList totalList;
	private JLabel totalListLabel;
	private DefaultListModel totalModel;
	
	public DisplayPanel()
	{			
		listPanel = new JPanel();	//Creates a panel for the lists
		
		nameLabel = new JLabel(personList.get(currentPersonIndex).getName());
		nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
		
		personImage = new JLabel(personList.get(currentPersonIndex).getImage());		
		
		statusLabel = new JLabel("Current Status: " + personList.get(currentPersonIndex).getStatus());
		statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
		
		//String[] name = {"circuit","duke"};
		friendModel = new DefaultListModel();
		
		friendList = new JList(friendModel);
		friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		//friendList.setBackground(Color.black);
		friendList.setVisibleRowCount(10);
		friendList.addListSelectionListener(new ListListener());
		friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		friendList.setPreferredSize(new Dimension(200,400));
		friendList.setVisible(true);
		friendsListLabel = new JLabel("List of Friends:                           ");
		
		totalModel = new DefaultListModel();
		totalList = new JList(totalModel);
		totalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		//totalList.setBackground(Color.black);
		totalList.setVisibleRowCount(10);
		totalList.addListSelectionListener(new ListListener());
		totalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		totalList.setPreferredSize(new Dimension(200,400));
		totalList.setVisible(true);
		totalListLabel = new JLabel("List of People in Network:                           ");
		
		setLayout(new BorderLayout());
		add(nameLabel, BorderLayout.NORTH);
		add(personImage, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		friendList.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		listPanel.add(friendsListLabel);
		listPanel.add(Box.createRigidArea(new Dimension(0,10)));
		listPanel.add(new JScrollPane(friendList));
		listPanel.add(Box.createRigidArea(new Dimension(0,10)));
		listPanel.add(totalListLabel);
		listPanel.add(Box.createRigidArea(new Dimension(0,10)));
		listPanel.add(new JScrollPane(totalList));
		listPanel.setBackground(Color.WHITE);
		
		add(listPanel, BorderLayout.EAST);
	}
	
	
	/**
	 * Dislpays the Person Object
	 * @param p Person to display
	 */
	public void displayPerson(Person p)
	{
		nameLabel.setText(p.getName());
		personImage.setIcon((Icon)p.getImage());
		statusLabel.setText("Current status: " + p.getStatus());
		updateFriendList(p.getFriends());
	}
	
	/**
	 * Updates the friendList with inputed list of friends
	 * @param friends list of friends to update with
	 */
	public void updateFriendList(ArrayList friends)
	{
		DefaultListModel listModel = (DefaultListModel)friendList.getModel();
		listModel.clear();
		 for(int i=0; i<friends.size(); i++)
	        {
	            listModel.addElement((String)friends.get(i));
	        }
	}
	
	/**
	 * Updates the total person list with an inputed list of person objects
	 * @param totalPersonList list of person objects
	 */
	public void updateTotalList(ArrayList<Person> totalPersonList)
	{
		DefaultListModel listModel = (DefaultListModel)totalList.getModel();
		listModel.clear();
		 for(int i=0; i<totalPersonList.size(); i++)
	        {
	            listModel.addElement(totalPersonList.get(i).getName());
	        }
		
	}
	
	/**
	 * Sets list selection to index i
	 * @param i index to set list selection
	 */
	public void setListSelection(int i)
	{
		totalList.setSelectedIndex(i);
	}
	
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			if(totalList == e.getSource())
			{
				System.out.println("First index: " + e.getFirstIndex());
		        System.out.println(", Last index: " + e.getLastIndex());
		        boolean adjust = e.getValueIsAdjusting();
		        System.out.println(", Adjusting? " + adjust);
		        if (!adjust)
		        {
		          JList list = (JList) e.getSource();
		          int selections[] = list.getSelectedIndices();
		          Object selectionValues[] = list.getSelectedValues();
		          for (int i = 0, n = selections.length; i < n; i++)
		          {
		            if (i == 0)
		            {
		              System.out.println(" Selections: ");
		            }
		            System.out.println(selections[i] + "/" + selectionValues[i] + " ");
		            displayPerson(personList.get(selections[i]));
		            currentPersonIndex = selections[i];
		          }
		        }
			}
			else if(friendList == e.getSource())
			{
				System.out.println("First index: " + e.getFirstIndex());
		        System.out.println(", Last index: " + e.getLastIndex());
		        boolean adjust = e.getValueIsAdjusting();
		        System.out.println(", Adjusting? " + adjust);
		        if (!adjust)
		        {
		          JList list = (JList) e.getSource();
		          int selections[] = list.getSelectedIndices();
		          Object selectionValues[] = list.getSelectedValues();
		          for (int i = 0, n = selections.length; i < n; i++)
		          {
		            if (i == 0)
		            {
		              System.out.println(" Selections: ");
		            }
		            System.out.println(selections[i] + "/" + selectionValues[i] + " ");
		            for(int j = 0; j<personList.size();j++)
		            {
		            	String selectedName = (String) selectionValues[i];
		            	
		            	if(selectedName.equalsIgnoreCase(personList.get(j).getName()))
		            	{
		            		displayPerson(personList.get(j));
				            currentPersonIndex = j;
		            		dP.setListSelection(currentPersonIndex);
		            	}
		            	
		            }
		            
		          }
		        }
			}
		}
	}

		
	
	
	public String toString()
	{
		return "poop";
	}

}
