/**
 *
 */
package com.ecomm.akhtar.service;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;

/**
 * @author Ahmar
 *
 */

public interface UserServiceInf {

	Boolean existsByPhoneNumber(String userName);

	Boolean existsByEmailId(String emailId);

	Users getUserDetailsByIdStatus(Long id ,Boolean status) throws CustomException;

	Users updateUserCurrentContext(Users users) throws Exception;



}
