/**
 * This is the control panel for Server;
 * Function: 1.Turn On/Off the Server; 2.Control and Listen the Client
 */


package com.cc.server.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cc.server.model.CCServerUser;
import com.cc.server.model.MyCCServer;

public class MyServerFrame extends JFrame implements ActionListener{

	JPanel jp1;
	JButton jb1, jb2;
	
	public MyServerFrame(){
		
		jp1 = new JPanel();
		jb1 = new JButton("Turn On the Server");
		jb1.addActionListener(this);
		jb2 = new JButton("Turn Off the Server");
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(700,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //System will be closed when you close the Frame
		this.setVisible(true);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyServerFrame myserver = new MyServerFrame();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			new MyCCServer();
		}
	}

}
