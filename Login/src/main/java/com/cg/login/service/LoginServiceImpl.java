package com.cg.login.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.login.dao.ILoginDao;
import com.cg.login.entity.User;
import com.cg.login.exception.LoginException;

@Service
public class LoginServiceImpl  implements  ILoginService{
	
	
	@Autowired
	private ILoginDao dao;
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	public User doLogin(String userID, String password) throws LoginException {
		User user = null;
		logger.debug("doing login process");
		Optional<User> optUser = dao.findById(userID);
		
		if(optUser.isPresent()) {
			user = optUser.get();
			if(!user.getPassword().contentEquals(password))
					throw new LoginException("password is Wrong, Check your Password");
			logger.info("User Authenticated for " + userID);
			return user;
		}
		throw new LoginException("Check your Credentials");
		
	
	}

	public String encryptUser(User user) {
		
		return encryptString(user.getUserID())+ "-" +encryptString(user.getUserName())+"-" 
		+encryptString(user.getRole());
	}
	
	public String encryptString(String str) {
		
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]+3;
			sb.append((char)ch);
		}
		
		return sb.toString();
	}
	
	public String decryptString(String str) {
		
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch;
		for(int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]-3;
			sb.append((char)ch);
		}
		
		return sb.toString();
		
		
	}

}

