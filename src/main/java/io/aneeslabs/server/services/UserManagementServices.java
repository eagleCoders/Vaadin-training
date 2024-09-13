/**
 * 
 */
package io.aneeslabs.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aneeslabs.server.beans.UserBean;

/**
 * 
 */
@Service
public class UserManagementServices {

	@Autowired
	UserManagementRepository userManagementRepository;
	
	public List<UserBean> getAllUsers(){
		return userManagementRepository.findAll();
	}
	
	
	public UserBean authenticateUser(String userName, String password) {
		return userManagementRepository.findByUserNameAndPassword(userName, password);
	}
}
