package com.minisrm.admin.common.bean.sso;

public class UserGrants {
	/**
	 * "taskCode": "RECORD_LISTEN",
    "taskName": "审核录音查听",
    "status": 1,
    "groupId": "GIVEU_RQC_QUALITY_SUPERVISE",
    "formName": null,
    "url": null,
    "webUrl": "/soundRecordInfo",
    "remark": "审核录音查听",
    "updateUser": "100000",
    "updateTime": "2017-07-06T13:55:08",
    "seq": 999,
    "subsysName": "GIVEU_RQC",
    "data": null,
    "icon": "RECORD_LISTEN",
    "updateIp": "10.10.11.25"
  },
	 */
	
	private String taskCode;
	
	private String taskName;
	
	private Integer status;
	
	private String groupId;
	
	private String formName;
	
	private String url;
	
	private String webUrl;
	
	private String remark;
	
	private String updateUser;
	
	private String updateTime;
	
	private Integer seq;
	
	private String subsysName;
	
	private String data;
	
	private String icon;
	
	private String updateIp;

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getSubsysName() {
		return subsysName;
	}

	public void setSubsysName(String subsysName) {
		this.subsysName = subsysName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUpdateIp() {
		return updateIp;
	}

	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}
	
	
}
