package com.jskj.springboot.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


public class QualificationsInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String accountId;

	private String businessTypeCode;

	private String certificateNumber;

	private Timestamp creationTime;

	private String creatorId;

	private String enableCode;

	private String enclosureUrl;

	private String isCq;

	private String pushState;

	private String qualificationsInfoTypeCode;

	private String remarks;

	private Timestamp remarksTime;

	private String shr;

	private String shrId;

	private Timestamp shsj;

	private String shyj;

	private String shzt;

	private String superiorId;

	private String tbState;

	private String userName;

	private Date validityEndDate;

	private Date validityStartDate;

	private BigDecimal xh;
	
	private BigDecimal ssdljb;
	
	private String gjdlId;
	
	private String gysdm;
	
	private String gysmc;
	
	private String scsdm;
	
	private String wzdm;

	public QualificationsInfo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getBusinessTypeCode() {
		return this.businessTypeCode;
	}

	public void setBusinessTypeCode(String businessTypeCode) {
		this.businessTypeCode = businessTypeCode;
	}

	public String getCertificateNumber() {
		return this.certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getEnableCode() {
		return this.enableCode;
	}

	public void setEnableCode(String enableCode) {
		this.enableCode = enableCode;
	}

	public String getEnclosureUrl() {
		return this.enclosureUrl;
	}

	public void setEnclosureUrl(String enclosureUrl) {
		this.enclosureUrl = enclosureUrl;
	}

	public String getIsCq() {
		return this.isCq;
	}

	public void setIsCq(String isCq) {
		this.isCq = isCq;
	}

	public String getPushState() {
		return this.pushState;
	}

	public void setPushState(String pushState) {
		this.pushState = pushState;
	}

	public String getQualificationsInfoTypeCode() {
		return this.qualificationsInfoTypeCode;
	}

	public void setQualificationsInfoTypeCode(String qualificationsInfoTypeCode) {
		this.qualificationsInfoTypeCode = qualificationsInfoTypeCode;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Timestamp getRemarksTime() {
		return this.remarksTime;
	}

	public void setRemarksTime(Timestamp remarksTime) {
		this.remarksTime = remarksTime;
	}

	public String getShr() {
		return this.shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	public String getShrId() {
		return this.shrId;
	}

	public void setShrId(String shrId) {
		this.shrId = shrId;
	}

	public Timestamp getShsj() {
		return this.shsj;
	}

	public void setShsj(Timestamp shsj) {
		this.shsj = shsj;
	}

	public String getShyj() {
		return this.shyj;
	}

	public void setShyj(String shyj) {
		this.shyj = shyj;
	}

	public String getShzt() {
		return this.shzt;
	}

	public void setShzt(String shzt) {
		this.shzt = shzt;
	}

	public String getSuperiorId() {
		return this.superiorId;
	}

	public void setSuperiorId(String superiorId) {
		this.superiorId = superiorId;
	}

	public String getTbState() {
		return this.tbState;
	}

	public void setTbState(String tbState) {
		this.tbState = tbState;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getValidityEndDate() {
		return this.validityEndDate;
	}

	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
	}

	public Date getValidityStartDate() {
		return this.validityStartDate;
	}

	public void setValidityStartDate(Date validityStartDate) {
		this.validityStartDate = validityStartDate;
	}

	
    public BigDecimal getXh() {
		return xh;
	}

	public void setXh(BigDecimal xh) {
		this.xh = xh;
	}

	public BigDecimal getSsdljb() {
		return ssdljb;
	}

	public void setSsdljb(BigDecimal ssdljb) {
		this.ssdljb = ssdljb;
	}

	public String getGjdlId() {
		return gjdlId;
	}

	public void setGjdlId(String gjdlId) {
		this.gjdlId = gjdlId;
	}

	public String getGysdm() {
		return gysdm;
	}

	public void setGysdm(String gysdm) {
		this.gysdm = gysdm;
	}

	public String getGysmc() {
		return gysmc;
	}

	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}

	public String getScsdm() {
		return scsdm;
	}

	public void setScsdm(String scsdm) {
		this.scsdm = scsdm;
	}

	public String getWzdm() {
		return wzdm;
	}

	public void setWzdm(String wzdm) {
		this.wzdm = wzdm;
	}

}