import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * SearchPanel class contains buttons to add, remove and find people
 * @author Vishnu
 * Collaboration Statement: I worked on this alone and with class materials only
 */
public class SearchPanel extends SocialOrganizerPanel
{
	JButton addPerson, removePerson, findPerson, save, load, quit;
	JTextField nameInputField;
	//static ArrayList<Person> personList;
	private int length;
	//DisplayPanel displayPanel;
	
	public SearchPanel()
	{
		super();
		
		//displayPanel = new DisplayPanel();
		JPanel searchButtons = new JPanel();
		
		personList = new ArrayList<Person>();
		addPerson = new JButton("Add Person");
		removePerson = new JButton("Remove Person");
		findPerson = new JButton("Find Person");
		save = new JButton("Save");
		load = new JButton("Load");
		quit = new JButton("Quit");
		
		nameInputField = new JTextField(25);
		
		ButtonListener b1 = new ButtonListener();
		
		addPerson.addActionListener(b1);
		removePerson.addActionListener(b1);
		findPerson.addActionListener(b1);
		save.addActionListener(b1);
		load.addActionListener(b1);
		quit.addActionListener(b1);
		
		KeyListener1 t1 = new KeyListener1();
		
		nameInputField.addKeyListener(t1);
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		
		searchButtons.add(addPerson);
		searchButtons.add(removePerson);
		searchButtons.add(findPerson);
		searchButtons.add(nameInputField);
		searchButtons.add(Box.createRigidArea(new Dimension(99,0)));
//		searchButtons.add(save);
//		searchButtons.add(load);
		searchButtons.add(Box.createRigidArea(new Dimension(99,0)));
		searchButtons.add(quit);
		searchButtons.setBackground(new Color(0,0,153));
		
		add(Box.createRigidArea(new Dimension(54,0)));
		add(searchButtons);
		//add(displayPanel);
		
		length = 1;
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(addPerson == e.getSource())
			{
				for(int i=0; i<length;i++)
				{
					if(personList.get(i).getName().equalsIgnoreCase(nameInputField.getText()))
					{
						JOptionPane.showMessageDialog(null, "Person Already Exists!", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						personList.add(new Person(nameInputField.getText()));
						System.out.println(personList + "    " + personList.indexOf(personList.get(length)));
	//					System.out.println(dP.toStrinlg());
						dP.displayPerson(personList.get(length));
						dP.setListSelection(length);
						dP.updateTotalList(personList);
						currentPersonIndex = length;
						length++;
						break;
					}
				}
				
			}
			else if(removePerson == e.getSource())
			{
				for(int i=0; i<length;i++)
				{
					if(personList.get(i).getName().equalsIgnoreCase(nameInputField.getText()))
					{
						personList.remove(i);
						currentPersonIndex = i-1;
						dP.displayPerson(personList.get(currentPersonIndex));
						dP.setListSelection(currentPersonIndex);
						dP.updateTotalList(personList);
						length--;
					}
				}
			}
			else if(findPerson == e.getSource())
			{
				for(int i=0; i<length;i++)
				{
					if(personList.get(i).getName().equalsIgnoreCase(nameInputField.getText()))
					{
						currentPersonIndex = i;
						dP.displayPerson(personList.get(currentPersonIndex));
						dP.setListSelection(currentPersonIndex);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Person Does Not Exist!", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
//			else if(save == e.getSource())
//			{
////				File saveFile = new File();
////				saveFile.setWritable(true);
//				try
//				{
//				  FileWriter writer = new FileWriter("C:\\mycsv.csv");
//				  writer.append((CharSequence)personList.toString());
//				  writer.close();				  
//				}
//				catch(Exception ex)
//				{
//				  ex.printStackTrace();
//				}
//			}
//			else if(load ==e.getSource())
//			{
//				try {
//					FileReader reader = new FileReader("C:\\mycsv.csv");
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
			else if(quit == e.getSource())
			{
				int value = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				
				if (value == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
				
			}
		
		}
	}
	
	private class KeyListener1 implements KeyListener
	{
		

		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				for(int i=0; i<length;i++)
				{
					if(personList.get(i).getName().equalsIgnoreCase(nameInputField.getText()))
					{
						JOptionPane.showMessageDialog(null, "Person Already Exists!", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						personList.add(new Person(nameInputField.getText()));
						System.out.println(personList + "    " + personList.indexOf(personList.get(length)));
//						System.out.println(dP.toStrinlg());
						dP.displayPerson(personList.get(length));
						dP.setListSelection(length);
						dP.updateTotalList(personList);
						currentPersonIndex = length;
						length++;
						break;
					}
				}
			}
			
		}

		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
				
	}
}
