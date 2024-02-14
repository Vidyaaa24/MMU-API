/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.controller.ncdCare;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.service.ncdCare.NCDCareServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;


/**
 * @Objective Saving NCD Care data for Nurse and Doctor.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/NCDCare", headers = "Authorization", consumes = "application/json", produces = "application/json")
public class NCDCareController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	private NCDCareServiceImpl ncdCareServiceImpl;

	@Autowired
	public void setNcdCareServiceImpl(NCDCareServiceImpl ncdCareServiceImpl) {
		this.ncdCareServiceImpl = ncdCareServiceImpl;
	}

	/**
	 * @Objective Save NCD Care data for nurse.
	 * @ApiParam JSON requestObj
	 * @return success or failure response
	 */
	@CrossOrigin
	@Operation(summary = "Save NCD care data collected by nurse")
	@PostMapping(value = { "/save/nurseData" })
	public String saveBenNCDCareNurseData(@RequestBody String requestObj) {
		OutputResponse response = new OutputResponse();
		try {
			JsonObject jsnOBJ = parseJsonRequest(requestObj);

			if (jsnOBJ != null) {
				Long ncdCareRes = ncdCareServiceImpl.saveNCDCareNurseData(jsnOBJ);
				if (null != ncdCareRes && ncdCareRes > 0) {
					response.setResponse("Data saved successfully");
				} else if (null != ncdCareRes && ncdCareRes == 0) {
					response.setResponse("Data already saved");
				} else {
					response.setResponse("Unable to save data");
				}

			} else {
				response.setError(5000, "Invalid Request !!!");
			}

		} catch (Exception e) {
			logger.error("Error while saving NCD Care nurse data :" + e);
			response.setError(5000, "Unable to save data");
		}
		return response.toString();
	}

	/**
	 * @Objective Save NCD Care data for doctor.
	 * @ApiParam JSON requestObj
	 * @return success or failure response
	 */
	@CrossOrigin
	@Operation(summary = "Save NCD care beneficiary case record and referral")
	@PostMapping(value = { "/save/doctorData" })
	public String saveBenNCDCareDoctorData(@RequestBody String requestObj,
			@RequestHeader(value = "Authorization") String authorization) {
		OutputResponse response = new OutputResponse();
		try {
			JsonObject jsnOBJ = parseJsonRequest(requestObj);

			if (jsnOBJ != null) {
				Long ncdCareRes = ncdCareServiceImpl.saveDoctorData(jsnOBJ, authorization);
				if (null != ncdCareRes && ncdCareRes > 0) {
					response.setResponse("Data saved successfully");
				} else {
					response.setResponse("Unable to save data");
				}

			} else {
				response.setResponse("Invalid request");
			}
		} catch (Exception e) {
			logger.error("Error while saving NCD Care doctor data :" + e);
			response.setError(5000, "Unable to save data. " + e.getMessage());
		}
		return response.toString();
	}

	@CrossOrigin()
	@Operation(summary = "Get NCD care beneficiary visit details")
	@PostMapping(value = { "/getBenVisitDetailsFrmNurseNCDCare" })
	@Transactional(rollbackFor = Exception.class)
	public String getBenVisitDetailsFrmNurseNCDCare(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"visitCode\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1) {
				Long benRegID = obj.getLong("benRegID");
				Long visitCode = obj.getLong("visitCode");

				String res = ncdCareServiceImpl.getBenVisitDetailsFrmNurseNCDCare(benRegID, visitCode);
				response.setResponse(res);
			} else {
				logger.info("Invalid request");
				response.setError(5000, "Invalid request");
			}
			logger.info("NCD Care visit data fetching Response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while getting beneficiary visit data");
			logger.error("Error while getting beneficiary visit data :" + e);
		}
		return response.toString();
	}

	/**
	 * @Objective Fetching beneficiary history details enterted by nurse.
	 * @ApiParam comingRequest
	 * @return visit details in JSON format
	 */
	@CrossOrigin()
	@Operation(summary = "Get NCD care beneficiary history")
	@PostMapping(value = { "/getBenNCDCareHistoryDetails" })

	public String getBenNCDCareHistoryDetails(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"visitCode\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("visitCode")) {
				Long benRegID = obj.getLong("benRegID");
				Long visitCode = obj.getLong("visitCode");

				String s = ncdCareServiceImpl.getBenNCDCareHistoryDetails(benRegID, visitCode);
				response.setResponse(s);
			} else {
				response.setError(5000, "Invalid request");
			}
			logger.info("NCD Care history data fetching Response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while getting beneficiary history data");
			logger.error("Error while getting beneficiary history data :" + e);
		}
		return response.toString();
	}

	/**
	 * @Objective Fetching beneficiary vital details enterted by nurse.
	 * @ApiParam comingRequest
	 * @return visit details in JSON format
	 */

	@CrossOrigin()
	@Operation(summary = "Get NCD care beneficiary vitals")
	@PostMapping(value = { "/getBenVitalDetailsFrmNurseNCDCare" })
	public String getBenVitalDetailsFrmNurseNCDCare(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"visitCode\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.has("benRegID") && obj.has("visitCode")) {
				Long benRegID = obj.getLong("benRegID");
				Long visitCode = obj.getLong("visitCode");

				String res = ncdCareServiceImpl.getBeneficiaryVitalDetails(benRegID, visitCode);
				response.setResponse(res);
			} else {
				logger.info("Invalid request");
				response.setError(5000, "Invalid request");
			}
			logger.info("NCD Care vital data fetching Response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while getting beneficiary vital data");
			logger.error("Error while getting beneficiary vital data :" + e);
		}
		return response.toString();
	}

	/**
	 * @Objective Fetching beneficiary doctor details.
	 * @ApiParam comingRequest
	 * @return visit details in JSON format
	 */
	@CrossOrigin()
	@Operation(summary = "Get NCD care beneficiary case record and referral")
	@PostMapping(value = { "/getBenCaseRecordFromDoctorNCDCare" })
	@Transactional(rollbackFor = Exception.class)
	public String getBenCaseRecordFromDoctorNCDCare(
			@ApiParam(value = "{\"benRegID\":\"Long\",\"visitCode\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 1 && obj.has("benRegID") && obj.has("visitCode")) {
				Long benRegID = obj.getLong("benRegID");
				Long visitCode = obj.getLong("visitCode");

				String res = ncdCareServiceImpl.getBenCaseRecordFromDoctorNCDCare(benRegID, visitCode);
				response.setResponse(res);
			} else {
				logger.info("Invalid request");
				response.setError(5000, "Invalid request");
			}
			logger.info("NCD Care doctor data fetching Response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Error while getting beneficiary doctor data");
			logger.error("Error while getting beneficiary doctor data :" + e);
		}
		return response.toString();
	}

	@CrossOrigin
	@Operation(summary = "Update NCD care beneficiary history")
	@PostMapping(value = { "/update/historyScreen" })
	public String updateHistoryNurse(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		try {
			int result = ncdCareServiceImpl.updateBenHistoryDetails(jsnOBJ);
			if (result > 0) {
				Map<String, Integer> resMap = new HashMap<>();
				resMap.put("result", result);
				response.setResponse("Data updated successfully");
			} else {
				response.setError(500, "Unable to modify data");
			}
			logger.info("History data update Response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Unable to modify data");
			logger.error("Error while updating history data :" + e);
		}

		return response.toString();
	}

	/**
	 * 
	 * @ApiParam requestObj
	 * @return success or failure response
	 * @objective Replace NCD Care Vital Data entered by Nurse with the details
	 *            entered by Doctor
	 */

	@CrossOrigin
	@Operation(summary = "Update NCD care beneficiary vitals")
	@PostMapping(value = { "/update/vitalScreen" })
	public String updateVitalNurse(@RequestBody String requestObj) {

		OutputResponse response = new OutputResponse();
		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		try {
			int result = ncdCareServiceImpl.updateBenVitalDetails(jsnOBJ);
			if (result > 0) {
				response.setResponse("Data updated successfully");
			} else {
				response.setError(500, "Unable to modify data");
			}
			logger.info("Vital data update Response:" + response);
		} catch (Exception e) {
			response.setError(5000, "Unable to modify data");
			logger.error("Error while updating vital data :" + e);
		}

		return response.toString();
	}

	/**
	 * 
	 * @ApiParam requestObj
	 * @return success or failure response
	 * @objective Replace NCD Care doctor data for the doctor next visit
	 */
	@CrossOrigin
	@Operation(summary = "Update NCD care beneficiary case record and referral")
	@PostMapping(value = { "/update/doctorData" })
	public String updateNCDCareDoctorData(@RequestBody String requestObj,
			@RequestHeader(value = "Authorization") String authorization) {

		OutputResponse response = new OutputResponse();
		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		try {
			Long result = ncdCareServiceImpl.updateNCDCareDoctorData(jsnOBJ, authorization);
			if (null != result && result > 0) {
				response.setResponse("Data updated successfully");
			} else {
				response.setError(500, "Unable to modify data");
			}
			logger.info("Doctor data update Response:" + response);
		} catch (Exception e) {
			response.setError(500, "Unable to modify data. " + e.getMessage());
			logger.error("Error while updating doctor data :" + e);
		}

		return response.toString();
	}
	private JsonObject parseJsonRequest(String requestObj) {
        JsonElement jsonElement = JsonParser.parseString(requestObj);
        return jsonElement.getAsJsonObject();
    }
}
