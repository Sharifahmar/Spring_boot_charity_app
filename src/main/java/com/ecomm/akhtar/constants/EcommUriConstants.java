/**
 *
 */
package com.ecomm.akhtar.constants;

/**
 * @author Ahmar
 *
 */
public class EcommUriConstants {

	public static final String USER_ME_URI = "/user/me";
	public static final String PHONENUMBER_EXIST_URI = "/user/checkPhoneNumberAvailability";
	public static final String EMAIL_EXIST_URI = "/user/checkEmailAvailability";
	public static final String VALIDATE_KEY_URI = "/validateKey";
	public static final String LOGIN_TOKEN = "/loginToken";
	public static final String REFRESH_TOKEN_URI = "/refreshToken";
	public static final String REGISTER_USER_URI = "/registerUser";
	public static final String UPDATE_USER_URI = "/updateUser";
	public static final String AES = "AES";
	public static final String USERS = "USERS";
	public static final String GENERATE_KEY = "/generateKey";
	public static final String RE_GENERATE_KEYS = "/regenerateKeys";
	public static final String USERS_DETAILS_BY_ID_STATUS = "/userDetails";
	public static final String THANKS_FOR_REG = "Welcome To Akhtar Ecommerce.";
	public static final String DONATION_AMOUNT = "/donationAmount";
	public static final String DONAR_CONTRIBUTION_DETAILS = "/donarContributionDetails";
	public static final String DONAR_CONTRIBUTION_DETAILS_BY_ID = "/donarContributionDetails/{id}";
	public static final String ACCEPTOR_DONATION_DETAILS_BY_ID = "/acceptorDonationDetails/{id}";
	public static final String DELETE_DONAR_CONTRIBUTION_DETAILS = "/deleteDonarContributionDetails";
	public static final String UPDATE_DONAR_CONTRIBUTION_DETAILS = "/updateDonarContributionDetails";
	public static final String DELETE_ACCEPTOR_DONATION_DETAILS = "/deleteAcceptorDonationDetails";
	public static final String UPDATE_ACCEPTOR_DONATION_DETAILS = "/updateAcceptorDonationDetails";
	public static final String DONAR_CONTRIBUTION_DETAILS_REPORT = "/donarContributionDetailsReport";
	public static final String DONAR_SLIP_DETAILS = "/donarSlipDetails";
	public static final String ACCEPTOR_AMOUNT = "/acceptorAmount";
	public static final String ACCEPTOR_TOKEN = "/acceptorToken";
	public static final String STUDENT_STATIONARY = "/studentStationary";
	public static final String AWS_BUCKET_DEFAULT_IMAGE = "https://s3.amazonaws.com/akhtar-ecommerce/ecomm-default.jpg";
	public static final String IMAGE_UPLOAD = "/imageUpload/{component}/{id}";
	public static final String MULTI_FILE_UPLOAD = "/multiplefiles";
	public static final String DONAR_PHONENUMBER_EXIST_URI = "/donar/checkPhoneNumberAvailability";
	public static final String DELETE_DONAR_URI = "/donar/delete";
	public static final String UPDATE_DONAR_URI = "/donar/update";
	public static final String DONAR_SEARCH_CRITERIA_DONAR_URI = "/donar/donarSearchCriteria";
	public static final String DONAR_BULK_RECEIPT_GENERATE_URI = "/donar/donarBulkReceiptGenerate";
	public static final String DONATION_TYPE_EXIST_URI = "/donationType/isDonationTypeExists";
	public static final String DONATION_TYPE_DELETE_URI = "/donationType/delete";
	public static final String DONATION_TYPE_UPDATE_URI = "/donationType/update";
	public static final String DELETE_ACCEPTOR_URI = "/acceptor/delete";
	public static final String ACCEPTOR_PHONENUMBER_EXIST_URI = "/acceptor/checkPhoneNumberAvailability";
	public static final String ACCEPTOR_EMAIL_EXIST_URI = "/acceptor/checkEmailAvailability";
	public static final String UPDATE_ACCEPTOR_URI = "/acceptor/update";
	public static final String ACCEPTOR_SEARCH_CRITERIA_DONAR_URI = "/acceptor/acceptorSearchCriteria";
	public static final String DELETE_STUDENT_URI = "/student/delete";
	public static final String UPDATE_STUDENT_URI = "/student/update";
	public static final String STUDENT_AADHARNUMBER_EXIST_URI = "/student/checkAadharNumberAvailability";
	public static final String STUDENT_SEARCH_CRITERIA_DONAR_URI = "/student/studentSearchCriteria";
	public static final String ACCEPTOR_CONTRIBUTION_DETAILS = "/acceptorContributionDetails";
	public static final String PROFILE_PICTURE_URL = "assets/img/default/default.png";
	public static final String PROFILE_PICTURE_STORE_LOCATION = "file:///C:/Users/Asus/PROJECTS/Java/Spring_boot_charity_app/profile-images/";
	public static final String TEMPLATE_NAME = "receipt";

}
