package com.iemr.mmu.service.cancerScreening;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iemr.mmu.data.nurse.BenCancerVitalDetail;
import com.iemr.mmu.data.nurse.BenFamilyCancerHistory;
import com.iemr.mmu.data.nurse.BenObstetricCancerHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerDietHistory;
import com.iemr.mmu.data.nurse.BenPersonalCancerHistory;
import com.iemr.mmu.data.nurse.BeneficiaryVisitDetail;
import com.iemr.mmu.repo.nurse.BenCancerVitalDetailRepo;
import com.iemr.mmu.repo.nurse.BenFamilyCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenObstetricCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerDietHistoryRepo;
import com.iemr.mmu.repo.nurse.BenPersonalCancerHistoryRepo;
import com.iemr.mmu.repo.nurse.BenVisitDetailRepo;

@Service
public class CSNurseServiceImpl implements CSNurseService {
	private BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepo;
	private BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepo;
	private BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepo;
	private BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepo;
	private BenCancerVitalDetailRepo benCancerVitalDetailRepo;
	private BenVisitDetailRepo benVisitDetailRepo;

	@Autowired
	public void setBenPersonalCancerHistoryRepo(BenPersonalCancerHistoryRepo benPersonalCancerHistoryRepo) {
		this.benPersonalCancerHistoryRepo = benPersonalCancerHistoryRepo;
	}

	@Autowired
	public void setBenFamilyCancerHistoryRepo(BenFamilyCancerHistoryRepo benFamilyCancerHistoryRepo) {
		this.benFamilyCancerHistoryRepo = benFamilyCancerHistoryRepo;
	}

	@Autowired
	public void setBenPersonalCancerDietHistoryRepo(BenPersonalCancerDietHistoryRepo benPersonalCancerDietHistoryRepo) {
		this.benPersonalCancerDietHistoryRepo = benPersonalCancerDietHistoryRepo;
	}

	@Autowired
	public void setBenObstetricCancerHistoryRepo(BenObstetricCancerHistoryRepo benObstetricCancerHistoryRepo) {
		this.benObstetricCancerHistoryRepo = benObstetricCancerHistoryRepo;
	}

	@Autowired
	public void setBenCancerVitalDetailRepo(BenCancerVitalDetailRepo benCancerVitalDetailRepo) {
		this.benCancerVitalDetailRepo = benCancerVitalDetailRepo;
	}

	@Autowired
	public void setBenVisitDetailRepo(BenVisitDetailRepo benVisitDetailRepo) {
		this.benVisitDetailRepo = benVisitDetailRepo;
	}

	@Override
	public int saveBenFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistoryList) {
		for (BenFamilyCancerHistory benFamilyCancerHistoryOBJ : benFamilyCancerHistoryList) {
			List<String> familyMenberList = benFamilyCancerHistoryOBJ.getFamilyMemberList();
			String familyMemberData = "";
			if (familyMenberList != null && familyMenberList.size() > 0) {
				int i = 1;
				for (String familyMember : familyMenberList) {
					if (i == familyMenberList.size()) {
						familyMemberData += familyMember;
					} else {
						familyMemberData += familyMember + ",";
					}

					i++;
				}
			}
			benFamilyCancerHistoryOBJ.setFamilyMember(familyMemberData);
			// System.out.println("hello...");
		}
		int responseData = 0;
		List<BenFamilyCancerHistory> response = (List<BenFamilyCancerHistory>) benFamilyCancerHistoryRepo
				.save(benFamilyCancerHistoryList);
		if (benFamilyCancerHistoryList.size() == response.size())
			responseData = 1;
		return responseData;
	}

	@Override
	public Long saveBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory) {
		List<String> typeOfTobaccoProductUseList = benPersonalCancerHistory.getTypeOfTobaccoProductList();
		String typeOfTobaccoProductUseConcat = "";
		if (typeOfTobaccoProductUseList != null && typeOfTobaccoProductUseList.size() > 0) {
			for (String s : typeOfTobaccoProductUseList) {
				typeOfTobaccoProductUseConcat += s + ",";
			}
		}
		benPersonalCancerHistory.setTypeOfTobaccoProduct(typeOfTobaccoProductUseConcat);
		BenPersonalCancerHistory response = benPersonalCancerHistoryRepo.save(benPersonalCancerHistory);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory) {
		List<String> personalOilConsumedList = benPersonalCancerDietHistory.getTypeOfOilConsumedList();
		String oilConsumedData = "";
		if (personalOilConsumedList != null && personalOilConsumedList.size() > 0) {
			for (String s : personalOilConsumedList) {
				oilConsumedData += s + ",";
			}
		}
		benPersonalCancerDietHistory.setTypeOfOilConsumed(oilConsumedData);
		BenPersonalCancerDietHistory response = benPersonalCancerDietHistoryRepo.save(benPersonalCancerDietHistory);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory) {
		BenObstetricCancerHistory response = benObstetricCancerHistoryRepo.save(benObstetricCancerHistory);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public Long saveBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail) {
		BenCancerVitalDetail response = benCancerVitalDetailRepo.save(benCancerVitalDetail);
		if (response != null)
			return response.getID();
		else
			return null;
	}

	@Override
	public int updateBeneficiaryFamilyCancerHistory(List<BenFamilyCancerHistory> benFamilyCancerHistoryList) {
		int response = 0;
		int delRes = 0;
		try {
			if (benFamilyCancerHistoryList.size() > 0) {

				ArrayList<Object[]> benFamilyCancerHistoryStatuses = benFamilyCancerHistoryRepo
						.getFamilyCancerHistoryStatus(benFamilyCancerHistoryList.get(0).getBeneficiaryRegID(),
								benFamilyCancerHistoryList.get(0).getBenVisitID());

				for (Object[] obj : benFamilyCancerHistoryStatuses) {
					Character processed = (Character) obj[1];
					if (null != processed && processed != 'N') {
						processed = 'U';
					}
					delRes = benFamilyCancerHistoryRepo.deleteExistingFamilyRecord((Long) obj[0], processed);
				}

			}
			ArrayList<BenFamilyCancerHistory> newbenFamilyCancerHistoryList = new ArrayList<BenFamilyCancerHistory>();
			if (delRes > 0) {
				for (BenFamilyCancerHistory benFamilyCancerHistory : benFamilyCancerHistoryList) {
					List<String> familyMenberList = benFamilyCancerHistory.getFamilyMemberList();
					if (null != familyMenberList && !familyMenberList.isEmpty()) {
						String familyMemberData = "";
						for (String familyMember : familyMenberList) {
							familyMemberData += familyMember + ",";
						}
						benFamilyCancerHistory.setFamilyMember(familyMemberData);
						newbenFamilyCancerHistoryList.add(benFamilyCancerHistory);
					}

				}
				if (newbenFamilyCancerHistoryList.size() > 0) {
					ArrayList<BenFamilyCancerHistory> benFamilyCancerHistories = (ArrayList<BenFamilyCancerHistory>) benFamilyCancerHistoryRepo
							.save(newbenFamilyCancerHistoryList);
					if (benFamilyCancerHistories.size() > 0) {
						response = benFamilyCancerHistories.size();
					}
				} else {
					response = 0;
				}
			} else {
				response = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenObstetricCancerHistory(BenObstetricCancerHistory benObstetricCancerHistory) {
		int response = 0;

		Character processed = benObstetricCancerHistoryRepo.getObstetricCancerHistoryStatus(
				benObstetricCancerHistory.getBeneficiaryRegID(), benObstetricCancerHistory.getBenVisitID());
		if (null != processed && processed != 'N') {
			processed = 'U';
		}
		try {

			response = benObstetricCancerHistoryRepo.updateBenObstetricCancerHistory(
					benObstetricCancerHistory.getProviderServiceMapID(), benObstetricCancerHistory.getPregnancyStatus(),
					benObstetricCancerHistory.getIsUrinePregTest(), benObstetricCancerHistory.getPregnant_No(),
					benObstetricCancerHistory.getNoOfLivingChild(), benObstetricCancerHistory.getIsAbortion(),
					benObstetricCancerHistory.getIsOralContraceptiveUsed(),
					benObstetricCancerHistory.getIsHormoneReplacementTherapy(),
					benObstetricCancerHistory.getMenarche_Age(), benObstetricCancerHistory.getIsMenstrualCycleRegular(),
					benObstetricCancerHistory.getMenstrualCycleLength(),
					benObstetricCancerHistory.getMenstrualFlowDuration(),
					benObstetricCancerHistory.getMenstrualFlowType(), benObstetricCancerHistory.getIsDysmenorrhea(),
					benObstetricCancerHistory.getIsInterMenstrualBleeding(),
					benObstetricCancerHistory.getMenopauseAge(), benObstetricCancerHistory.getIsPostMenopauseBleeding(),
					benObstetricCancerHistory.getIsFoulSmellingDischarge(), benObstetricCancerHistory.getModifiedBy(),
					benObstetricCancerHistory.getBeneficiaryRegID(), benObstetricCancerHistory.getBenVisitID(),
					processed);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenPersonalCancerHistory(BenPersonalCancerHistory benPersonalCancerHistory) {
		int response = 0;

		Character processed = benPersonalCancerHistoryRepo.getPersonalCancerHistoryStatus(
				benPersonalCancerHistory.getBeneficiaryRegID(), benPersonalCancerHistory.getBenVisitID());
		if (null != processed && processed != 'N') {
			processed = 'U';
		}

		try {

			List<String> typeOfTobaccoProductList = benPersonalCancerHistory.getTypeOfTobaccoProductList();
			if (null != typeOfTobaccoProductList && !typeOfTobaccoProductList.isEmpty()) {
				String typeOfTobaccoProductData = "";
				for (String typeOfTobaccoProduct : typeOfTobaccoProductList) {
					typeOfTobaccoProductData += typeOfTobaccoProduct + ",";
				}
				benPersonalCancerHistory.setTypeOfTobaccoProduct(typeOfTobaccoProductData);
			}
			response = benPersonalCancerHistoryRepo.updateBenPersonalCancerHistory(
					benPersonalCancerHistory.getProviderServiceMapID(), benPersonalCancerHistory.getTobaccoUse(),
					benPersonalCancerHistory.getStartAge_year(), benPersonalCancerHistory.getEndAge_year(),
					benPersonalCancerHistory.getTypeOfTobaccoProduct(), benPersonalCancerHistory.getQuantityPerDay(),
					benPersonalCancerHistory.getIsFilteredCigaerette(),
					benPersonalCancerHistory.getIsCigaretteExposure(), benPersonalCancerHistory.getIsBetelNutChewing(),
					benPersonalCancerHistory.getDurationOfBetelQuid(), benPersonalCancerHistory.getAlcoholUse(),
					benPersonalCancerHistory.getSsAlcoholUsed(), benPersonalCancerHistory.getFrequencyOfAlcoholUsed(),
					benPersonalCancerHistory.getModifiedBy(), benPersonalCancerHistory.getBeneficiaryRegID(),
					benPersonalCancerHistory.getBenVisitID(), processed);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenPersonalCancerDietHistory(BenPersonalCancerDietHistory benPersonalCancerDietHistory) {
		int response = 0;

		Character processed = benPersonalCancerDietHistoryRepo.getPersonalCancerDietHistoryStatus(
				benPersonalCancerDietHistory.getBeneficiaryRegID(), benPersonalCancerDietHistory.getBenVisitID());
		if (null != processed && processed != 'N') {
			processed = 'U';
		}

		try {
			List<String> typeOfOilConsumedList = benPersonalCancerDietHistory.getTypeOfOilConsumedList();
			if (null != typeOfOilConsumedList && !typeOfOilConsumedList.isEmpty()) {
				String typeOfOilConsumedData = "";
				for (String typeOfOilConsumed : typeOfOilConsumedList) {
					typeOfOilConsumedData += typeOfOilConsumed + ",";
				}
				benPersonalCancerDietHistory.setTypeOfOilConsumed(typeOfOilConsumedData);
			}

			response = benPersonalCancerDietHistoryRepo.updateBenPersonalCancerDietHistory(
					benPersonalCancerDietHistory.getProviderServiceMapID(), benPersonalCancerDietHistory.getDietType(),
					benPersonalCancerDietHistory.getFruitConsumptionDays(),
					benPersonalCancerDietHistory.getFruitQuantityPerDay(),
					benPersonalCancerDietHistory.getVegetableConsumptionDays(),
					benPersonalCancerDietHistory.getVegetableQuantityPerDay(),
					benPersonalCancerDietHistory.getIntakeOfOutsidePreparedMeal(),
					benPersonalCancerDietHistory.getTypeOfOilConsumed(),
					benPersonalCancerDietHistory.getPhysicalActivityType(),
					benPersonalCancerDietHistory.getSsRadiationExposure(),
					benPersonalCancerDietHistory.getIsThyroidDisorder(), benPersonalCancerDietHistory.getModifiedBy(),
					benPersonalCancerDietHistory.getBeneficiaryRegID(), benPersonalCancerDietHistory.getBenVisitID(),
					processed);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return response;

	}

	@Override
	public int updateBenVitalDetail(BenCancerVitalDetail benCancerVitalDetail) {
		Character processed = benCancerVitalDetailRepo.getCancerVitalStatus(benCancerVitalDetail.getBeneficiaryRegID(),
				benCancerVitalDetail.getBenVisitID());
		if (null != processed && processed != 'N') {
			processed = 'U';
		}
		int response = benCancerVitalDetailRepo.updateBenCancerVitalDetail(
				benCancerVitalDetail.getProviderServiceMapID(), benCancerVitalDetail.getWeight_Kg(),
				benCancerVitalDetail.getHeight_cm(), benCancerVitalDetail.getWaistCircumference_cm(),
				benCancerVitalDetail.getBloodGlucose_Fasting(), benCancerVitalDetail.getBloodGlucose_Random(),
				benCancerVitalDetail.getBloodGlucose_2HrPostPrandial(), benCancerVitalDetail.getSystolicBP_1stReading(),
				benCancerVitalDetail.getDiastolicBP_1stReading(), benCancerVitalDetail.getSystolicBP_2ndReading(),
				benCancerVitalDetail.getDiastolicBP_2ndReading(), benCancerVitalDetail.getSystolicBP_3rdReading(),
				benCancerVitalDetail.getDiastolicBP_3rdReading(), benCancerVitalDetail.getHbA1C(),
				benCancerVitalDetail.getHemoglobin(), benCancerVitalDetail.getModifiedBy(),
				benCancerVitalDetail.getBeneficiaryRegID(), benCancerVitalDetail.getBenVisitID(), processed);
		return response;
	}

	@Override
	public List<BenFamilyCancerHistory> getBenFamilyHisData(Long benRegID, Long benVisitID) {
		List<BenFamilyCancerHistory> benFamilyCancerHistoryList = benFamilyCancerHistoryRepo
				.getBenFamilyHistory(benRegID, benVisitID);
		if (benFamilyCancerHistoryList.size() > 0) {
			for (BenFamilyCancerHistory obj : benFamilyCancerHistoryList) {
				String s = obj.getFamilyMember();
				List<String> famMemlist = new ArrayList<>();
				if (s != null) {
					String[] arr = s.split(",");
					for (int i = 0; i < arr.length; i++) {
						famMemlist.add(arr[i]);
					}
				}
				obj.setFamilyMemberList(famMemlist);
				// System.out.println("hello");
			}
		}

		return benFamilyCancerHistoryList;
	}

	@Override
	public BenObstetricCancerHistory getBenObstetricDetailsData(Long benRegID, Long benVisitID) {
		BenObstetricCancerHistory benObstetricCancerHistoryData = benObstetricCancerHistoryRepo
				.getBenObstetricCancerHistory(benRegID, benVisitID);
		return benObstetricCancerHistoryData;
	}

	@Override
	public BenPersonalCancerHistory getBenPersonalCancerHistoryData(Long benRegID, Long benVisitID) {
		BenPersonalCancerHistory benPersonalCancerHistory = benPersonalCancerHistoryRepo.getBenPersonalHistory(benRegID,
				benVisitID);
		List<String> typeOfTobaccoProductList = new ArrayList<>();
		String s = benPersonalCancerHistory.getTypeOfTobaccoProduct();
		if (s != null) {
			String[] arr = s.split(",");
			for (int i = 0; i < arr.length; i++) {
				typeOfTobaccoProductList.add(arr[i]);
			}
			benPersonalCancerHistory.setTypeOfTobaccoProductList(typeOfTobaccoProductList);

		}
		return benPersonalCancerHistory;
	}

	@Override
	public BenPersonalCancerDietHistory getBenPersonalCancerDietHistoryData(Long benRegID, Long benVisitID) {
		BenPersonalCancerDietHistory benPersonalCancerDietHistory = benPersonalCancerDietHistoryRepo
				.getBenPersonaDietHistory(benRegID, benVisitID);

		String s = benPersonalCancerDietHistory.getTypeOfOilConsumed();
		List<String> oilConsumedList = new ArrayList<>();
		if (s != null) {
			String[] arr = s.split(",");
			for (int i = 0; i < arr.length; i++) {
				oilConsumedList.add(arr[i]);
			}
			benPersonalCancerDietHistory.setTypeOfOilConsumedList(oilConsumedList);

		} else {
			benPersonalCancerDietHistory.setTypeOfOilConsumedList(oilConsumedList);
		}
		return benPersonalCancerDietHistory;
	}

	@Override
	public BenCancerVitalDetail getBenCancerVitalDetailData(Long benRegID, Long benVisitID) {
		BenCancerVitalDetail benCancerVitalDetail = benCancerVitalDetailRepo.getBenCancerVitalDetail(benRegID,
				benVisitID);
		return benCancerVitalDetail;
	}

	public Map<String, Object> getBenNurseDataForCaseSheet(Long benRegID, Long benVisitID) {
		Map<String, Object> resMap = new HashMap<>();

		resMap.put("benVisitDetail", getBeneficiaryVisitDetails(benRegID, benVisitID));

		resMap.put("familyDiseaseHistory", getBenFamilyHisData(benRegID, benVisitID));

		resMap.put("patientObstetricHistory", getBenObstetricDetailsData(benRegID, benVisitID));

		resMap.put("patientPersonalHistory", getBenPersonalCancerHistoryData(benRegID, benVisitID));

		resMap.put("benPersonalDietHistory", getBenPersonalCancerDietHistoryData(benRegID, benVisitID));

		resMap.put("currentVitals", getBenCancerVitalDetailData(benRegID, benVisitID));

		return resMap;
	}

	private BeneficiaryVisitDetail getBeneficiaryVisitDetails(Long benRegID, Long benVisitID) {
		List<Objects[]> beneficiaryVisitDetail = benVisitDetailRepo.getBeneficiaryVisitDetails(benRegID, benVisitID);
		BeneficiaryVisitDetail beneficiaryVisit = null;
		if (null != beneficiaryVisitDetail) {
			for (Object[] obj : beneficiaryVisitDetail) {
				beneficiaryVisit = new BeneficiaryVisitDetail((Long) obj[0], (Long) obj[1], (Integer) obj[2],
						(Timestamp) obj[3], (Short) obj[4], (Short) obj[5], (String) obj[6], (Integer) obj[7],
						(String) obj[8], (String) obj[9], (String) obj[10], (String) obj[11], (String) obj[12],
						(String) obj[13], (String) obj[14]);
			}
		}

		return beneficiaryVisit;
	}

	/***
	 * Fetch beneficiary past all visit family history.
	 * 
	 * @param beneficiaryRegID
	 * @return
	 */

	public String getBenCancerFamilyHistory(Long beneficiaryRegID) {
		Map<String, Object> resMap = new HashMap<>();
		Map<String, String> columnMap = new HashMap<>();
		List<Map<String, String>> columns = new ArrayList<Map<String, String>>();
		ArrayList<BenFamilyCancerHistory> benMedHistoryArrayList = new ArrayList<>();

		ArrayList<Object[]> benCancerFamilyHistoryDataArray = benFamilyCancerHistoryRepo
				.getBenCancerFamilyHistory(beneficiaryRegID);

		if (benCancerFamilyHistoryDataArray != null && benCancerFamilyHistoryDataArray.size() > 0) {
			BenFamilyCancerHistory benFamilyCancerHistory;
			for (Object[] obj : benCancerFamilyHistoryDataArray) {
				benFamilyCancerHistory = new BenFamilyCancerHistory((String) obj[0], (String) obj[1], (Date) obj[2]);
				benMedHistoryArrayList.add(benFamilyCancerHistory);
			}
		}

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Date of Capture");
		columnMap.put("keyName", "captureDate");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Cancer Disease Type");
		columnMap.put("keyName", "cancerDiseaseType");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Family Members");
		columnMap.put("keyName", "familyMember");
		columns.add(columnMap);

		resMap.put("columns", columns);
		resMap.put("data", benMedHistoryArrayList);

		return new Gson().toJson(resMap);
	}

	/***
	 * Fetch beneficiary past all visit personal history.
	 * 
	 * @param beneficiaryRegID
	 * @return
	 */

	public String getBenCancerPersonalHistory(Long beneficiaryRegID) {
		Map<String, Object> resMap = new HashMap<>();
		Map<String, String> columnMap = new HashMap<>();
		List<Map<String, String>> columns = new ArrayList<Map<String, String>>();
		ArrayList<BenPersonalCancerHistory> benPersonalHistoryArrayList = new ArrayList<>();

		ArrayList<Object[]> benPersonalHistory = benPersonalCancerHistoryRepo.getBenPersonalHistory(beneficiaryRegID);

		if (benPersonalHistory != null && benPersonalHistory.size() > 0) {
			for (Object[] obj : benPersonalHistory) {
				BenPersonalCancerHistory personalCancerHistory = new BenPersonalCancerHistory((String) obj[0],
						(Integer) obj[1], (Integer) obj[2], (String) obj[3], (Integer) obj[4], (Boolean) obj[5],
						(Boolean) obj[6], (Boolean) obj[7], (Integer) obj[8], (String) obj[9], (Boolean) obj[10],
						(String) obj[11], (Date) obj[12]);
				benPersonalHistoryArrayList.add(personalCancerHistory);
			}
		}

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Date of Capture");
		columnMap.put("keyName", "captureDate");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Tobacco Use Status");
		columnMap.put("keyName", "tobaccoUse");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Start Age(Years)");
		columnMap.put("keyName", "startAge_year");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Stop Age(Years)");
		columnMap.put("keyName", "endAge_year");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Type Of Tobacco Product");
		columnMap.put("keyName", "typeOfTobaccoProduct");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Quantity(Per Day)");
		columnMap.put("keyName", "quantityPerDay");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Filtered Cigarette");
		columnMap.put("keyName", "isFilteredCigaerette");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Exposure to Cigarette");
		columnMap.put("keyName", "isCigaretteExposure");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Betel Nut Chewing");
		columnMap.put("keyName", "isBetelNutChewing");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Duration Of Betel Quid in Mouth(Mins)");
		columnMap.put("keyName", "durationOfBetelQuid");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Alcohol use Status");
		columnMap.put("keyName", "alcoholUse");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Alcohol Consumed(within 12 months)");
		columnMap.put("keyName", "ssAlcoholUsed");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Frequency Of Alcohol Use(within 12 months)");
		columnMap.put("keyName", "frequencyOfAlcoholUsed");
		columns.add(columnMap);

		resMap.put("columns", columns);
		resMap.put("data", benPersonalHistoryArrayList);

		return new Gson().toJson(resMap);
	}

	/***
	 * Fetch beneficiary All past visit personal diet history.
	 * 
	 * @param beneficiaryRegID
	 * @return
	 */
	public String getBenCancerPersonalDietHistory(Long beneficiaryRegID) {

		Map<String, Object> resMap = new HashMap<>();
		Map<String, String> columnMap = new HashMap<>();
		List<Map<String, String>> columns = new ArrayList<Map<String, String>>();
		ArrayList<BenPersonalCancerDietHistory> benPersonalDietArrayList = new ArrayList<>();

		ArrayList<Object[]> benPersonalCancerDietHistory = benPersonalCancerDietHistoryRepo
				.getBenPersonaDietHistory(beneficiaryRegID);

		if (benPersonalCancerDietHistory != null && benPersonalCancerDietHistory.size() > 0) {
			for (Object[] obj : benPersonalCancerDietHistory) {
				BenPersonalCancerDietHistory personalCancerDietHistory = new BenPersonalCancerDietHistory(
						(String) obj[0], (Integer) obj[1], (Integer) obj[2], (Integer) obj[3], (Integer) obj[4],
						(Integer) obj[5], (String) obj[6], (String) obj[7], (Boolean) obj[8], (Boolean) obj[9],
						(Date) obj[10]);
				benPersonalDietArrayList.add(personalCancerDietHistory);
			}
		}

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Date of Capture");
		columnMap.put("keyName", "captureDate");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Diet Type");
		columnMap.put("keyName", "dietType");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Fruit Consumption(Days/week)");
		columnMap.put("keyName", "fruitConsumptionDays");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Fruit Quantity(Cups/day)");
		columnMap.put("keyName", "fruitQuantityPerDay");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Vegetable Consumption(Days/week)");
		columnMap.put("keyName", "vegetableConsumptionDays");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Vegetable Quantity(Cups/day)");
		columnMap.put("keyName", "vegetableQuantityPerDay");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Weekly Intake Of Outside Prepared Meal");
		columnMap.put("keyName", "intakeOfOutsidePreparedMeal");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Type Of Oil Consumed");
		columnMap.put("keyName", "typeOfOilConsumed");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Physical Activity Type");
		columnMap.put("keyName", "physicalActivityType");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "History of exposure to radiation");
		columnMap.put("keyName", "ssRadiationExposure");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "History of any thyroid disorder");
		columnMap.put("keyName", "isThyroidDisorder");
		columns.add(columnMap);

		resMap.put("columns", columns);
		resMap.put("data", benPersonalDietArrayList);

		return new Gson().toJson(resMap);
	}

	/***
	 * Fetch beneficiary past all visit obstetric history.
	 * 
	 * @param beneficiaryRegID
	 * @return
	 */

	public String getBenCancerObstetricHistory(Long beneficiaryRegID) {
		Map<String, Object> resMap = new HashMap<>();
		Map<String, String> columnMap = new HashMap<>();
		List<Map<String, String>> columns = new ArrayList<Map<String, String>>();
		ArrayList<BenObstetricCancerHistory> benObstetricCancerHistoryArrayList = new ArrayList<>();

		ArrayList<Object[]> benObstetricCancerHistoryList = benObstetricCancerHistoryRepo
				.getBenObstetricCancerHistoryData(beneficiaryRegID);

		if (benObstetricCancerHistoryList != null && benObstetricCancerHistoryList.size() > 0) {
			BenObstetricCancerHistory benObstetricCancerHistory;
			for (Object[] obj : benObstetricCancerHistoryList) {
				benObstetricCancerHistory = new BenObstetricCancerHistory((String) obj[0], (Boolean) obj[1],
						(String) obj[2], (Integer) obj[3], (Boolean) obj[4], (Boolean) obj[5], (Boolean) obj[6],
						(Integer) obj[7], (Boolean) obj[8], (Integer) obj[9], (Integer) obj[10], (String) obj[11],
						(Boolean) obj[12], (Boolean) obj[13], (Integer) obj[14], (Boolean) obj[15], (Boolean) obj[16],
						(Date) obj[17]);
				benObstetricCancerHistoryArrayList.add(benObstetricCancerHistory);
			}
		}

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Date of Capture");
		columnMap.put("keyName", "captureDate");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Pregnancy Status");
		columnMap.put("keyName", "pregnancyStatus");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Urine pregnancy test");
		columnMap.put("keyName", "isUrinePregTest");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "No of times Pregnant");
		columnMap.put("keyName", "pregnant_No");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "No of Living Children");
		columnMap.put("keyName", "noOfLivingChild");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Abortions");
		columnMap.put("keyName", "isAbortion");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Oral Contraceptives used in 5 years");
		columnMap.put("keyName", "isOralContraceptiveUsed");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Hormone replacement Therapy in 5yrs");
		columnMap.put("keyName", "isHormoneReplacementTherapy");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Age at menarche(Years)");
		columnMap.put("keyName", "menarche_Age");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Regularity of Menstrual Cycle");
		columnMap.put("keyName", "isMenstrualCycleRegular");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Length of Menstrual Cycle(in days)");
		columnMap.put("keyName", "menstrualCycleLength");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Menstrual Flow Duration(Days)");
		columnMap.put("keyName", "menstrualFlowDuration");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Type of Flow");
		columnMap.put("keyName", "menstrualFlowType");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Dysmenorrhea");
		columnMap.put("keyName", "isDysmenorrhea");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Inter menstrual bleeding");
		columnMap.put("keyName", "isInterMenstrualBleeding");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Age at Menopause(Years)");
		columnMap.put("keyName", "menopauseAge");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Post-menopausal Bleeding");
		columnMap.put("keyName", "isPostMenopauseBleeding");
		columns.add(columnMap);

		columnMap = new HashMap<>();
		columnMap.put("columnName", "Foul Smelling Discharge");
		columnMap.put("keyName", "isFoulSmellingDischarge");
		columns.add(columnMap);

		resMap.put("columns", columns);
		resMap.put("data", benObstetricCancerHistoryArrayList);

		return new Gson().toJson(resMap);
	}

}