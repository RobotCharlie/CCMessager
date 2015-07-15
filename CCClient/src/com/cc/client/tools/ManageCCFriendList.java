/**
 * This is a Class that manage the FriendList, StrangerList, BlockList
 */

package com.cc.client.tools;

import java.util.HashMap;

import com.cc.client.view.CCFriendList;

public class ManageCCFriendList {
	
	private static HashMap hm = new HashMap<String, CCFriendList>();
	
	public static void addCCFreindList(String ccId, CCFriendList ccFriendList){
		hm.put(ccId, ccFriendList);
	}

	public static CCFriendList getCCFriendList(String ccId){
		return (CCFriendList)hm.get(ccId);
	}
	
}
