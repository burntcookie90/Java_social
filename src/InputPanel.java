import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * InputPanel contains buttons to load images, update the status, and add friends
 * @author Vishnu
 * Collaboration Statement: I worked on this alone and with class materials only
 */
public class InputPanel extends SocialOrganizerPanel
{
	JButton addImage, submitStatus, addFriend;
	JTextField statusField, friendField;
	JFileChooser chooser;
	JLabel socialLabel;
	JLabel organizerLabel;
	
	public InputPanel()
	{
		chooser = new JFileChooser();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addImage = new JButton("Add an Image");
		submitStatus = new JButton("Submit status");
		addFriend = new JButton("Add a friend");
		
		statusField = new JTextField(15);
		friendField= new JTextField(15);
		
		ButtonListener b1 = new ButtonListener();
		addImage.addActionListener(b1);
		submitStatus.addActionListener(b1);
		addFriend.addActionListener(b1);
		
		TextListener t1 = new TextListener();
		statusField.addActionListener(t1);
		friendField.addActionListener(t1);
		
		socialLabel = new JLabel("S o c i a l");
		socialLabel.setForeground(Color.white);
		socialLabel.setFont(new Font("Helvetica", Font.BOLD, 35));
		organizerLabel = new JLabel("Organizer");
		organizerLabel.setForeground(new Color(0,0,153));
		organizerLabel.setFont(new Font("Arial", Font.BOLD, 35));
		
		add(socialLabel);
		add(organizerLabel);
		add(Box.createRigidArea(new Dimension(0,80)));
		add(addImage);
		add(Box.createRigidArea(new Dimension(0,80)));
		add(statusField);
		add(submitStatus);
		add(Box.createRigidArea(new Dimension(0,80)));
		add(friendField);
		add(addFriend);
		add(Box.createRigidArea(new Dimension(0,120)));
		
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(addImage == e.getSource())
			{
				int status = chooser.showOpenDialog(null);
				
				if(status==JFileChooser.APPROVE_OPTION)
				{
					File file = chooser.getSelectedFile();
					String name = file.getAbsolutePath();
					ImageIcon icon = new ImageIcon(name);
					Image image = icon.getImage();
					image = image.getScaledInstance(200,200,Image.SCALE_DEFAULT);
					icon.setImage(image);
					personList.get(currentPersonIndex).setImage(icon);
					dP.displayPerson(personList.get(currentPersonIndex));
				}
			}
			else if(submitStatus == e.getSource())
			{
				String status = statusField.getText();
				personList.get(currentPersonIndex).setStatus(status);
				dP.displayPerson(personList.get(currentPersonIndex));
				System.out.println(personList.get(currentPersonIndex));	
				statusField.setText("");
			}
			else if(addFriend == e.getSource())
			{
				personList.get(currentPersonIndex).addFriend(friendField.getText());
				dP.displayPerson(personList.get(currentPersonIndex));
				
				for(int i = 0; i<personList.size();i++)
				{
					if(personList.get(i).getName().equals(friendField.getText()))
					{
						personList.get(i).addFriend(personList.get(currentPersonIndex).getName());
						break;
					}
					else
					{
						personList.add(new Person(friendField.getText()));
						dP.updateTotalList(personList);
						break;
					}
						
				}
				
			}
		}
		
	}
	
	private class TextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			
		}
		
	}

}
