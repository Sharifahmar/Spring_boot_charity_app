/**
 *
 */
package com.ecomm.akhtar.service;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.model.UsersUpdateModel;

/**
 * @author Ahmar
 *
 */

public interface UserServiceInf {

	Boolean existsByPhoneNumber(String userName);

	Boolean existsByEmailId(String emailId);

	Users getUserDetailsByIdStatus(Long id ,Boolean status) throws CustomException;

	UsersUpdateModel updateUserCurrentContext(UsersUpdateModel users) throws Exception;



}
