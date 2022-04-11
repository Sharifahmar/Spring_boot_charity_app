package com.ecomm.akhtar.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.ApiResponseGenericModel;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.model.DonarContributionDTO;
import com.ecomm.akhtar.model.DonarContributionRequestDTO;
import com.ecomm.akhtar.model.DonationAmountModel;
import com.ecomm.akhtar.service.DonationAmountServiceInf;
import com.ecomm.akhtar.utils.PdfGenerateUtils;
import com.lowagie.text.DocumentException;

/**
 * @author Ahmar
 *
 */
@RestController
public class DonationAmountController {

	@Autowired
	private DonationAmountServiceInf donationAmountServiceInf;

	@Autowired
	private PdfGenerateUtils pdfGenerateUtils;

	@PostMapping(EcommUriConstants.DONATION_AMOUNT)
	public ResponseEntity<ApiResponseModel> addDonationAmount(@RequestBody DonationAmountModel donationAmountModel) {
		try {
			DonationAmountModel donationTypeModelRetrn = donationAmountServiceInf
					.addDonationAmountService(donationAmountModel);
			if (!ObjectUtils.isEmpty(donationTypeModelRetrn)) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseModel("Donation Amount Insert Successfully..!!", true));
			}
		} catch (CustomException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseModel(e.getMessage(), e.getSuccess()));

		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseModel("Something went wrong.!!", false));
	}

	@PostMapping(EcommUriConstants.DONAR_CONTRIBUTION_DETAILS)
	public ResponseEntity<ApiResponseGenericModel<List<DonarContributionDTO>>> getContributionDetails(
			@RequestBody DonarContributionRequestDTO request) {

		try {
			List<DonarContributionDTO> donarContributionDTO = donationAmountServiceInf.getContributionDetails(request);
			if (!CollectionUtils.isEmpty(donarContributionDTO)) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseGenericModel<List<DonarContributionDTO>>(donarContributionDTO, true));
			}
		} catch (CustomException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseGenericModel<>(e.getMessage(), e.getSuccess()));
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseGenericModel<>("No Data present for related Search..!!", false));
	}

	@PostMapping(EcommUriConstants.DONAR_CONTRIBUTION_DETAILS_BY_ID)
	public ResponseEntity<ApiResponseGenericModel<DonarContributionDTO>> getContributionDetailsById(
			@PathVariable Long id) {

		DonarContributionDTO donarContributionDTO = donationAmountServiceInf.getContributionDetailsById(id);
		if (!ObjectUtils.isEmpty(donarContributionDTO)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseGenericModel<DonarContributionDTO>(donarContributionDTO, true));
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseGenericModel<>("No Data present for related Search..!!", false));
	}

	@PostMapping(EcommUriConstants.DELETE_DONAR_CONTRIBUTION_DETAILS)
	public ResponseEntity<ApiResponseModel> deleteDonationContribution(
			@RequestBody DonarContributionDTO donarContributionDTO) {

		DonarContributionDTO donationAmtDto = donationAmountServiceInf
				.findById(donarContributionDTO.getDonationAmountId());

		if (!ObjectUtils.isEmpty(donationAmtDto)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel("Donation Amount Deleted Successfully..!!", true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));
		}
	}

	@PostMapping(EcommUriConstants.UPDATE_DONAR_CONTRIBUTION_DETAILS)
	public ResponseEntity<ApiResponseModel> updateDonationContribution(
			@RequestBody DonarContributionDTO donarContributionDTO) {

		try {
			DonarContributionDTO donationAmtDto = donationAmountServiceInf
					.updateDonarContribution(donarContributionDTO);
			if (!ObjectUtils.isEmpty(donationAmtDto)) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseModel("Donation Record Update Successfully..!!", true));
			}

		} catch (CustomException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseModel(e.getMessage(), e.getSuccess()));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));

	}

	@PostMapping(EcommUriConstants.DONAR_CONTRIBUTION_DETAILS_REPORT)
	public ResponseEntity<ApiResponseModel> generateDonationContributionReport(
			@RequestBody DonarContributionRequestDTO request) {

		try {
			List<DonarContributionDTO> donarContributionDTO = donationAmountServiceInf.getContributionDetails(request);
			if (!ObjectUtils.isEmpty(donarContributionDTO)) {
				Map<String, Object> mapData =  new HashMap<String,Object>();
				mapData.put("data", donarContributionDTO);
				pdfGenerateUtils.createPdf(EcommUriConstants.TEMPLATE_NAME,
						mapData);
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseModel("Report generated Successfully..!!", true));
			}

		} catch (CustomException | IOException | DocumentException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseModel(e.getMessage(), false));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));

	}

}
