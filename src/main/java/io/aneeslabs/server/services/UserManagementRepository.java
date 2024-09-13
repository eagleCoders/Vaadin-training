/**
 * 
 */
package io.aneeslabs.server.services;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aneeslabs.server.beans.UserBean;

/**
 * 
 */
public interface UserManagementRepository extends JpaRepository<UserBean, Integer> {

	public UserBean findByUserNameAndPassword(String userName, String password);
}
