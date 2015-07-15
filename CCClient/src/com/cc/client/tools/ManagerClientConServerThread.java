/**
 * This is a class that is used to manage the connection between Client and Server
 */

package com.cc.client.tools;

import java.util.HashMap;

public class ManagerClientConServerThread {

	private static HashMap hm = new HashMap<String, ClientConServerThread>();
	
	//Put the Thread from class ClientConServerThread into hm, each time you Login to a new CC, a Thread will be setup.
	public static void addClientConServerThread(String ccId, ClientConServerThread ccst){
		
		hm.put(ccId, ccst);
	}
	
	//The Thread can be retreated by a given ccId
	public static ClientConServerThread getClientConServerThread(String ccId){
		return (ClientConServerThread)hm.get(ccId);
	}
	
	
	
	
	
}
