package com.iemr.mmu.data.doctor;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.data.masterdata.anc.ServiceMaster;
import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;

@Entity
@Table(name = "t_benreferdetails")
public class BenReferDetails {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "benReferID")
	private Long benReferID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "VisitCode")
	private Long VisitCode;

	@Expose
	@Column(name = "referredToInstituteID")
	private Integer referredToInstituteID;

	@Expose
	@Column(name = "referredToInstituteName")
	private String referredToInstituteName;

	@Expose
	@Column(name = "serviceID")
	private Short serviceID;

	@Expose
	@Column(name = "serviceName")
	private String serviceName;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Expose
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;

	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;

	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;

	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;

	@Expose
	@Column(name = "ReservedForChange")
	private String reservedForChange;

	@Transient
	private ArrayList<ServiceMaster> refrredToAdditionalServiceList;

	public Long getBenReferID() {
		return benReferID;
	}

	public void setBenReferID(Long benReferID) {
		this.benReferID = benReferID;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Long getVisitCode() {
		return VisitCode;
	}

	public void setVisitCode(Long visitCode) {
		VisitCode = visitCode;
	}

	public Integer getReferredToInstituteID() {
		return referredToInstituteID;
	}

	public void setReferredToInstituteID(Integer referredToInstituteID) {
		this.referredToInstituteID = referredToInstituteID;
	}

	public String getReferredToInstituteName() {
		return referredToInstituteName;
	}

	public void setReferredToInstituteName(String referredToInstituteName) {
		this.referredToInstituteName = referredToInstituteName;
	}

	public Short getServiceID() {
		return serviceID;
	}

	public void setServiceID(Short serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Long getVanSerialNo() {
		return vanSerialNo;
	}

	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public String getSyncedBy() {
		return syncedBy;
	}

	public void setSyncedBy(String syncedBy) {
		this.syncedBy = syncedBy;
	}

	public Timestamp getSyncedDate() {
		return syncedDate;
	}

	public void setSyncedDate(Timestamp syncedDate) {
		this.syncedDate = syncedDate;
	}

	public String getReservedForChange() {
		return reservedForChange;
	}

	public void setReservedForChange(String reservedForChange) {
		this.reservedForChange = reservedForChange;
	}

	public ArrayList<ServiceMaster> getRefrredToAdditionalServiceList() {
		return refrredToAdditionalServiceList;
	}

	public void setRefrredToAdditionalServiceList(ArrayList<ServiceMaster> refrredToAdditionalServiceList) {
		this.refrredToAdditionalServiceList = refrredToAdditionalServiceList;
	}
	
	public BenReferDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BenReferDetails(Long benReferID, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			Integer referredToInstituteID, String referredToInstituteName, Short serviceID,
			String serviceName) {
		super();
		this.benReferID = benReferID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.referredToInstituteID = referredToInstituteID;
		this.referredToInstituteName = referredToInstituteName;
		this.serviceID = serviceID;
		this.serviceName = serviceName;
	}

	public static BenReferDetails getBenReferDetails(ArrayList<Object[]> resList) {
		ArrayList<BenReferDetails> resArray = new ArrayList<BenReferDetails>();
		BenReferDetails cOBJ=null;
		if (resList != null && resList.size() > 0) {
			
			Object[] obj1 = resList.get(0);
			cOBJ = new BenReferDetails((Long)obj1[0], (Long)obj1[1], (Long)obj1[2], (Integer)obj1[3], (Integer)obj1[4], (String)obj1[5], 
					(Short)obj1[6], (String)obj1[7]);
			ArrayList<ServiceMaster> servicesList = new ArrayList<ServiceMaster>();
			for (Object[] obj : resList) {
				if(null != obj[6]){
					ServiceMaster sm = new ServiceMaster((Short)obj[6], (String)obj[7]);
					servicesList.add(sm);
				}
			}
			
			cOBJ.setRefrredToAdditionalServiceList(servicesList);
		}
		return cOBJ;
	}
	
}
