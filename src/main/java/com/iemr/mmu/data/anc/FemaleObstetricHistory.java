package com.iemr.mmu.data.anc;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_FemaleObstetricHistory")
public class FemaleObstetricHistory {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ObstetricHistoryID")
	private Long obstetricHistoryID;

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
	private Long visitCode;

	@Expose
	@Column(name = "PregOrder")
	private Short pregOrder;

	@Expose
	@Column(name = "totalNoOfPreg")
	private Short totalNoOfPreg;

	@Expose
	@Column(name = "PregComplicationID")
	private Short pregComplicationID;

	@Expose
	@Column(name = "PregComplicationType")
	private String pregComplicationType;

	@Expose
	@Column(name = "OtherPregComplication")
	private String otherPregComplication;

	@Expose
	@Column(name = "PregDurationID")
	private Short pregDurationID;

	@Expose
	@Column(name = "DurationType")
	private String durationType;

	@Expose
	@Column(name = "DeliveryTypeID")
	private Short deliveryTypeID;

	@Expose
	@Column(name = "DeliveryType")
	private String deliveryType;

	@Expose
	@Column(name = "DeliveryPlaceID")
	private Short deliveryPlaceID;

	@Expose
	@Column(name = "DeliveryPlace")
	private String deliveryPlace;

	@Expose
	@Column(name = "OtherDeliveryPlace")
	private String otherDeliveryPlace;

	@Expose
	@Column(name = "DeliveryComplicationID")
	private Short deliveryComplicationID;

	@Expose
	@Column(name = "DeliveryComplicationType")
	private String deliveryComplicationType;

	@Expose
	@Column(name = "OtherDeliveryComplication")
	private String otherDeliveryComplication;

	@Expose
	@Column(name = "PregOutcomeID")
	private Short pregOutcomeID;

	@Expose
	@Column(name = "PregOutcome")
	private String pregOutcome;

	@Expose
	@Column(name = "PostpartumComplicationID")
	private Short postpartumComplicationID;

	@Expose
	@Column(name = "PostpartumComplicationType")
	private String postpartumComplicationType;

	@Expose
	@Column(name = "OtherPostpartumCompType")
	private String otherPostpartumCompType;

	@Expose
	@Column(name = "PostNatalComplicationID")
	private Short postNatalComplicationID;

	@Expose
	@Column(name = "PostNatalComplication")
	private String postNatalComplication;

	@Expose
	@Column(name = "OtherPostNatalComplication")
	private String otherPostNatalComplication;

	@Expose
	@Column(name = "CongenitalAnomalies")
	private String congenitalAnomalies;

	@Expose
	@Column(name = "NewBornComplicationID")
	private Short newBornComplicationID;

	@Expose
	@Column(name = "NewBornComplication")
	private String newBornComplication;

	@Expose
	@Column(name = "OtherNewBornComplication")
	private String otherNewBornComplication;

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
	private Date captureDate;

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

	public Short getPregOrder() {
		return pregOrder;
	}

	public void setPregOrder(Short pregOrder) {
		this.pregOrder = pregOrder;
	}

	public Short getPregComplicationID() {
		return pregComplicationID;
	}

	public void setPregComplicationID(Short pregComplicationID) {
		this.pregComplicationID = pregComplicationID;
	}

	public String getPregComplicationType() {
		return pregComplicationType;
	}

	public void setPregComplicationType(String pregComplicationType) {
		this.pregComplicationType = pregComplicationType;
	}

	public String getOtherPregComplication() {
		return otherPregComplication;
	}

	public void setOtherPregComplication(String otherPregComplication) {
		this.otherPregComplication = otherPregComplication;
	}

	public Short getPregDurationID() {
		return pregDurationID;
	}

	public void setPregDurationID(Short pregDurationID) {
		this.pregDurationID = pregDurationID;
	}

	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	public Short getDeliveryTypeID() {
		return deliveryTypeID;
	}

	public void setDeliveryTypeID(Short deliveryTypeID) {
		this.deliveryTypeID = deliveryTypeID;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Short getDeliveryPlaceID() {
		return deliveryPlaceID;
	}

	public void setDeliveryPlaceID(Short deliveryPlaceID) {
		this.deliveryPlaceID = deliveryPlaceID;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public String getOtherDeliveryPlace() {
		return otherDeliveryPlace;
	}

	public void setOtherDeliveryPlace(String otherDeliveryPlace) {
		this.otherDeliveryPlace = otherDeliveryPlace;
	}

	public Short getDeliveryComplicationID() {
		return deliveryComplicationID;
	}

	public void setDeliveryComplicationID(Short deliveryComplicationID) {
		this.deliveryComplicationID = deliveryComplicationID;
	}

	public String getDeliveryComplicationType() {
		return deliveryComplicationType;
	}

	public void setDeliveryComplicationType(String deliveryComplicationType) {
		this.deliveryComplicationType = deliveryComplicationType;
	}

	public String getOtherDeliveryComplication() {
		return otherDeliveryComplication;
	}

	public void setOtherDeliveryComplication(String otherDeliveryComplication) {
		this.otherDeliveryComplication = otherDeliveryComplication;
	}

	public Short getPregOutcomeID() {
		return pregOutcomeID;
	}

	public void setPregOutcomeID(Short pregOutcomeID) {
		this.pregOutcomeID = pregOutcomeID;
	}

	public String getPregOutcome() {
		return pregOutcome;
	}

	public void setPregOutcome(String pregOutcome) {
		this.pregOutcome = pregOutcome;
	}

	public Short getPostpartumComplicationID() {
		return postpartumComplicationID;
	}

	public void setPostpartumComplicationID(Short postpartumComplicationID) {
		this.postpartumComplicationID = postpartumComplicationID;
	}

	public String getPostpartumComplicationType() {
		return postpartumComplicationType;
	}

	public void setPostpartumComplicationType(String postpartumComplicationType) {
		this.postpartumComplicationType = postpartumComplicationType;
	}

	public String getOtherPostpartumCompType() {
		return otherPostpartumCompType;
	}

	public void setOtherPostpartumCompType(String otherPostpartumCompType) {
		this.otherPostpartumCompType = otherPostpartumCompType;
	}

	public Short getPostNatalComplicationID() {
		return postNatalComplicationID;
	}

	public void setPostNatalComplicationID(Short postNatalComplicationID) {
		this.postNatalComplicationID = postNatalComplicationID;
	}

	public String getPostNatalComplication() {
		return postNatalComplication;
	}

	public void setPostNatalComplication(String postNatalComplication) {
		this.postNatalComplication = postNatalComplication;
	}

	public String getOtherPostNatalComplication() {
		return otherPostNatalComplication;
	}

	public void setOtherPostNatalComplication(String otherPostNatalComplication) {
		this.otherPostNatalComplication = otherPostNatalComplication;
	}

	public String getCongenitalAnomalies() {
		return congenitalAnomalies;
	}

	public void setCongenitalAnomalies(String congenitalAnomalies) {
		this.congenitalAnomalies = congenitalAnomalies;
	}

	public Short getNewBornComplicationID() {
		return newBornComplicationID;
	}

	public void setNewBornComplicationID(Short newBornComplicationID) {
		this.newBornComplicationID = newBornComplicationID;
	}

	public String getNewBornComplication() {
		return newBornComplication;
	}

	public void setNewBornComplication(String newBornComplication) {
		this.newBornComplication = newBornComplication;
	}

	public String getOtherNewBornComplication() {
		return otherNewBornComplication;
	}

	public void setOtherNewBornComplication(String otherNewBornComplication) {
		this.otherNewBornComplication = otherNewBornComplication;
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

	public Long getObstetricHistoryID() {
		return obstetricHistoryID;
	}

	public Short getTotalNoOfPreg() {
		return totalNoOfPreg;
	}

	public void setTotalNoOfPreg(Short totalNoOfPreg) {
		this.totalNoOfPreg = totalNoOfPreg;
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

	public FemaleObstetricHistory() {
	}

	public FemaleObstetricHistory(Date createdDate, Short pregOrder, String pregComplicationType,
			String otherPregComplication, String durationType, String deliveryType, String deliveryPlace,
			String otherDeliveryPlace, String deliveryComplicationType, String otherDeliveryComplication,
			String pregOutcome, String postpartumComplicationType, String otherPostpartumCompType,
			String postNatalComplication, String otherPostNatalComplication, String congenitalAnomalies,
			String newBornComplication, String otherNewBornComplication) {
		super();
		this.captureDate = createdDate;
		this.pregOrder = pregOrder;
		this.pregComplicationType = pregComplicationType;
		this.otherPregComplication = otherPregComplication;
		this.durationType = durationType;
		this.deliveryType = deliveryType;
		this.deliveryPlace = deliveryPlace;
		this.otherDeliveryPlace = otherDeliveryPlace;
		this.deliveryComplicationType = deliveryComplicationType;
		this.otherDeliveryComplication = otherDeliveryComplication;
		this.pregOutcome = pregOutcome;
		this.postpartumComplicationType = postpartumComplicationType;
		this.otherPostpartumCompType = otherPostpartumCompType;
		this.postNatalComplication = postNatalComplication;
		this.otherPostNatalComplication = otherPostNatalComplication;
		this.congenitalAnomalies = congenitalAnomalies;
		this.newBornComplication = newBornComplication;
		this.otherNewBornComplication = otherNewBornComplication;
	}

	public FemaleObstetricHistory(Short pregOrder, Short pregComplicationID, String pregComplicationType,
			String otherPregComplication, Short pregDurationID, String durationType, Short deliveryTypeID,
			String deliveryType, Short deliveryPlaceID, String deliveryPlace, String otherDeliveryPlace,
			Short deliveryComplicationID, String deliveryComplicationType, String otherDeliveryComplication,
			Short pregOutcomeID, String pregOutcome, Short postpartumComplicationID, String postpartumComplicationType,
			String otherPostpartumCompType, Short postNatalComplicationID, String postNatalComplication,
			String otherPostNatalComplication, String congenitalAnomalies, Short newBornComplicationID,
			String newBornComplication, String otherNewBornComplication) {
		super();
		this.pregOrder = pregOrder;
		this.pregComplicationID = pregComplicationID;
		this.pregComplicationType = pregComplicationType;
		this.otherPregComplication = otherPregComplication;
		this.pregDurationID = pregDurationID;
		this.durationType = durationType;
		this.deliveryTypeID = deliveryTypeID;
		this.deliveryType = deliveryType;
		this.deliveryPlaceID = deliveryPlaceID;
		this.deliveryPlace = deliveryPlace;
		this.otherDeliveryPlace = otherDeliveryPlace;
		this.deliveryComplicationID = deliveryComplicationID;
		this.deliveryComplicationType = deliveryComplicationType;
		this.otherDeliveryComplication = otherDeliveryComplication;
		this.pregOutcomeID = pregOutcomeID;
		this.pregOutcome = pregOutcome;
		this.postpartumComplicationID = postpartumComplicationID;
		this.postpartumComplicationType = postpartumComplicationType;
		this.otherPostpartumCompType = otherPostpartumCompType;
		this.postNatalComplicationID = postNatalComplicationID;
		this.postNatalComplication = postNatalComplication;
		this.otherPostNatalComplication = otherPostNatalComplication;
		this.congenitalAnomalies = congenitalAnomalies;
		this.newBornComplicationID = newBornComplicationID;
		this.newBornComplication = newBornComplication;
		this.otherNewBornComplication = otherNewBornComplication;
	}

	public void setObstetricHistoryID(Long obstetricHistoryID) {
		this.obstetricHistoryID = obstetricHistoryID;
	}

	public Long getVisitCode() {
		return visitCode;
	}

	public void setVisitCode(Long visitCode) {
		this.visitCode = visitCode;
	}

}
