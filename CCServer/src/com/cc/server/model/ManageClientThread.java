package com.cc.server.model;

import java.util.HashMap;
import java.util.Iterator;

public class ManageClientThread {

	//Setup a HashMap to collect <userId, that Thread>
	public static HashMap hm = new HashMap<String , SerConClientThread>();
	
	//Add a Client communication Thread to HashMap
	public static void addClientThread(String uid, SerConClientThread ct){
		hm.put(uid, ct);
	}
	
	public static SerConClientThread getClientThread(String uid) {
		return (SerConClientThread)hm.get(uid);
	}

	//Return the Id of OnlineFriendList(Because if a user online,  he must keep sending socket to Server, 
	//so we are able to know weather the user online by detecting if the user send socket to Server)
	public static String getAllOnlineUserId(){
		//Using Iterator to find all the users that online..
		Iterator it = hm.keySet().iterator();
		String res = " ";
		while(it.hasNext()){
			res += it.next().toString()+" ";
		}
		return res;
	
	}

}
