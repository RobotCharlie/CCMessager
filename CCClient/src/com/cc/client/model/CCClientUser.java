/**
 * This class is the pre-steps for user-checking.
 * A User will be passed into this class by constructor, and then be passed to CCCClientConServer class(the class 
 * that connected with Server) by using sendLoginInfoToServer method.
 */

package com.cc.client.model;

import com.cc.common.*;

public class CCClientUser {


	public boolean checkUser(User u){
		
		return new CCClientConServer().sendLoginInfoToServer(u);
	}


}
