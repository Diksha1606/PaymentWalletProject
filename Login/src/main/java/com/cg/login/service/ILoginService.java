
package com.cg.login.service;

import com.cg.login.entity.User;
import com.cg.login.exception.LoginException;

public interface ILoginService {
	
	public User doLogin(String userID, String password) throws LoginException;
	public String encryptUser(User user);
	

}
