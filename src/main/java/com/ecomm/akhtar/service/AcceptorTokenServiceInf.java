package com.ecomm.akhtar.service;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Acceptor;

public interface AcceptorTokenServiceInf {

	String addAcceptorTokenService(Acceptor acceptor) throws CustomException;

}