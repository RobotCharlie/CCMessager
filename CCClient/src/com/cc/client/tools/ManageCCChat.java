/**
 * This is a Class that manage the Chat window
 */

package com.cc.client.tools;

import java.util.HashMap;

import com.cc.client.view.CCChat;

public class ManageCCChat {

	private static HashMap hm = new HashMap<String, CCChat>();
	
	//Put in
	public static void addCCChat(String loginIdAndFriendId, CCChat ccchat){
		hm.put(loginIdAndFriendId, ccchat);
	}
	//Retrieve 
	public static CCChat getCCChat(String loginIdAndFriendId){
		return (CCChat)hm.get(loginIdAndFriendId);
	}
	
	
}
