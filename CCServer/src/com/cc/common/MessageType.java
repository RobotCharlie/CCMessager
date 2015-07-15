/**
 * This is a Interface to define the type of the package
 */

package com.cc.common;

public interface MessageType {

	String message_succeed = "1"; //Successfully Login
	String message_fail = "2"; //Unsuccessfully Login
	String message_comm_mes = "3"; //Regular Info Package
	String message_get_onLineFriends = "4"; //Require Online Friends List
	String message_ret_onLineFriends = "5"; //Retrieve Online Friends List
}
