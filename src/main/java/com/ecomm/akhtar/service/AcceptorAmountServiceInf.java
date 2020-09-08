package com.ecomm.akhtar.service;

import java.util.List;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.AcceptorAmountModel;
import com.ecomm.akhtar.model.AcceptorContributionDTO;
import com.ecomm.akhtar.model.AcceptorContributionRequestDTO;

public interface AcceptorAmountServiceInf {

	AcceptorAmountModel addAcceptorAmountService(AcceptorAmountModel value) throws CustomException;

	List<AcceptorContributionDTO> getContributionDetails(AcceptorContributionRequestDTO request) throws CustomException;

	AcceptorContributionDTO getDonationDetailsById(Long id);

	AcceptorContributionDTO findById(Long acceptorAmountId);

	AcceptorContributionDTO updateAcceptorDonation(AcceptorContributionDTO acceptorContributionDTO) throws CustomException;

}