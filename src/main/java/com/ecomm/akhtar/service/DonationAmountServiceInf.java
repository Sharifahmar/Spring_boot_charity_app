package com.ecomm.akhtar.service;

import java.util.List;

import com.ecomm.akhtar.entity.DonationAmountEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.DonarContributionDTO;
import com.ecomm.akhtar.model.DonarContributionRequestDTO;
import com.ecomm.akhtar.model.DonationAmountModel;

public interface DonationAmountServiceInf {

	public DonationAmountModel addDonationAmountService(DonationAmountModel value) throws CustomException;

	public List<DonarContributionDTO> getContributionDetails(DonarContributionRequestDTO request) throws CustomException;

	public DonarContributionDTO getContributionDetailsById(Long id);

	public DonarContributionDTO findById(Long donationAmountId);

}