package com.murari.dao;

import java.util.List;

import com.murari.beans.CartBean;
import com.murari.beans.UserBean;

public interface UserDao {
	
	/*private String userName;
	private Long mobileNo;
	private String emailId;
	private String address;
	private int pinCode;
	private String password;
	*/
	
	public String registerUser(String userName,Long mobileNo,String emailId,String address,int pinCode,String password);
	
	public String registerUser(UserBean user);
	
	public boolean isRegistered(String emailId);
		
	public String isValidCredential(String emailId, String password);
	
	public UserBean getUserDetails(String emailId,String password);
	
	public String getFName(String emailId);
	
	public String getUserAddr(String userId);
	
	
}
