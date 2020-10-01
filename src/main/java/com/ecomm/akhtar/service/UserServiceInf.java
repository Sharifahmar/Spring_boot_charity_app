/**
 *
 */
package com.ecomm.akhtar.service;

import java.io.IOException;
import java.net.URISyntaxException;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.model.UsersUpdateModel;
import com.ecomm.akhtar.securityconfig.UserPrincipal;

/**
 * @author Ahmar
 *
 */

public interface UserServiceInf {

	Boolean existsByPhoneNumber(String userName);

	Boolean existsByEmailId(String emailId);

	Users getUserDetailsByIdStatus(UserPrincipal user ,Boolean status) throws CustomException, IOException, URISyntaxException;

	UsersUpdateModel updateUserCurrentContext(UsersUpdateModel users) throws Exception;



}
