/**
 * Function:CCclient Login UI
 * 
 */
package com.cc.client.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.cc.client.model.CCClientUser;
import com.cc.client.tools.ManageCCFriendList;
import com.cc.client.tools.ManagerClientConServerThread;
import com.cc.common.Message;
import com.cc.common.MessageType;
import com.cc.common.User;



public class CCClientLogin extends JFrame implements ActionListener{

	//Upper components
	JLabel label1;
	
	//Middle components
	//There are three JPanel here, and a Option Card
	JTabbedPane jtp;
	JPanel panel2,panel3,panel4;
	JLabel panel2_l1,panel2_l2,panel2_l3,panel2_l4;
	JButton panel2_b1;
	JTextField panel2_jtf;
	JPasswordField panel2_jpf;
	JCheckBox panel2_jcb1,panel2_jcb2;
	
	
	//Lower components
	JPanel panel1;
	JButton panel1_b1, panel1_b2, panel1_b3;
	
	//Constructor of class CCClientLogin
	public CCClientLogin(){
		
		//Initialization of Upper components
		label1 = new JLabel(new ImageIcon("Image/label1.png"));
		
		//Initialization of Middle components
		panel2 = new JPanel(new GridLayout(3,3));
		panel2.setBackground(Color.WHITE);
		panel2_l1 = new JLabel("Username",JLabel.CENTER);
		panel2_l2 = new JLabel("Password",JLabel.CENTER);
		panel2_l3 = new JLabel("Forget Password?",JLabel.CENTER);
		panel2_l3.setForeground(Color.BLUE);
		panel2_l4 = new JLabel("Password Protection",JLabel.CENTER);
		panel2_b1 = new JButton(new ImageIcon("Image/clear_password.png"));
		panel2_jtf = new JTextField();
		panel2_jpf = new JPasswordField();
		panel2_jcb1 = new JCheckBox("Invisable");
		panel2_jcb2 = new JCheckBox("Remember Pwd");
		
		panel3 = new JPanel(new GridLayout(3,3));

		panel4 = new JPanel(new GridLayout(3,3));

		//Put all the components into the panel2 (From left to right, from up to down)
		panel2.add(panel2_l1);
		panel2.add(panel2_jtf);
		panel2.add(panel2_b1);
		panel2.add(panel2_l2);
		panel2.add(panel2_jpf);
		panel2.add(panel2_l3);
		panel2.add(panel2_jcb1);
		panel2.add(panel2_jcb2);
		panel2.add(panel2_l4);
		
		
		jtp = new JTabbedPane();
		jtp.add("CC Number", panel2);
		jtp.add("Cell Phone Number", panel3);
		jtp.add("Email", panel4);
		
		
		//Initialization of Lower components
		panel1 = new JPanel();
		//When click login button
		panel1_b1 = new JButton(new ImageIcon("Image/pb1_login.png"));
		panel1_b1.addActionListener(this);
		panel1_b2 = new JButton(new ImageIcon("Image/pb2_cancel.png"));
		panel1_b3 = new JButton(new ImageIcon("Image/pb3_help.png"));
		

		//Put three button into the panel
		panel1.add(panel1_b1);
		panel1.add(panel1_b2);
		panel1.add(panel1_b3);
		
		
		this.add(label1,"North");
		//Put panel1 into South side
		this.add(panel1,"South");
		this.add(jtp, "Center");
		this.setSize(422,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CCClientLogin ccClientLogin = new CCClientLogin();
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		//If click login button
		if(e.getSource()==panel1_b1){
			
			CCClientUser ccclientuser = new CCClientUser();
			User u =new User();
			u.setUserId(panel2_jtf.getText().trim());
			u.setPwd(new String(panel2_jpf.getPassword()));
			
			if(ccclientuser.checkUser(u)){
				
//				//Send the Server a Online Friends List Request Package
//				try {
//				
//
//					
//					ObjectOutputStream oos = new ObjectOutputStream
//							(ManagerClientConServerThread.getClientConServerThread(u.getUserId()).getSocket().getOutputStream());
//					
//					//Build a Message to have two features(MessageType and Sender)
//					Message m = new Message();
//					m.setMessageType(MessageType.message_get_onLineFriends);
//					//Referring that I need the FriendsList of exact CCUser
//					m.setSender(u.getUserId());
//					oos.writeObject(m);
//					
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				//Put the FriendList_Setup here
				CCFriendList ccFriendList = new CCFriendList(u.getUserId());
				ManageCCFriendList.addCCFreindList(u.getUserId(), ccFriendList);
				
				this.dispose(); //Close this window
				
			} else{
				JOptionPane.showMessageDialog(this, "UserId and Password mismatch");
			}
			

		}
	}

}
