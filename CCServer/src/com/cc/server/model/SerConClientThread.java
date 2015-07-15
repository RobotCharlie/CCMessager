/**
 * Function: This is a connection thread between server and exact user.
 */

package com.cc.server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.cc.common.Message;
import com.cc.common.MessageType;

public class SerConClientThread extends Thread {

	Socket s;


	public SerConClientThread(Socket s) {
		// TODO Auto-generated constructor stub
		
		//Pass the Socket of Client to Server
		this.s = s;
		
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			// Receive the Info from Client

			try {
				ObjectInputStream ois = new ObjectInputStream(
						s.getInputStream());
				Message m = (Message) ois.readObject();

				
				//Check the Message Type of the Message that sent from Client and classify them by doing different operation..
				
				if(m.getMessageType().equals(MessageType.message_comm_mes)){
					//If the Message is the regular Message..
					System.out.println(m.getSender()+" talk to "+m.getGetter()+ "and say "+ m.getCon());
					SerConClientThread sc = ManageClientThread.getClientThread(m.getGetter());
					ObjectOutputStream oos = new ObjectOutputStream(sc.s.getOutputStream());
					oos.writeObject(m);
				} else if(m.getMessageType().equals(MessageType.message_get_onLineFriends)){
					System.out.println(m.getSender()+" friends ");
					//If the Message is the get_onlineFriends Package, return..
					String res = ManageClientThread.getAllOnlineUserId();
					Message mf = new Message();
					mf.setCon(res);
					mf.setGetter(m.getSender());
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(mf);
					
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
