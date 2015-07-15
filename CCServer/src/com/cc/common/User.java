/**
 * This is User Info class
 */

package com.cc.common;


// java.io.Serializable is to transfer a file by regarding it as a object.
public class User implements java.io.Serializable {

	private String userId;
	private String pwd;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
