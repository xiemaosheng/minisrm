package com.minisrm.admin.common.bean.sso;

import java.util.List;

public class UserMenus {
	/**
	 *  {
    "groupId": "GIVEU_RQC_QUALITY_SUPERVISE",
    "groupDesc": "质检管理",
    "seq": 1,
    "icon": "QUALITY_SUPERVISE",
    "data": null,
    "items": [
      {
        "taskCode": "RECORD_QUALITY",
        "taskName": "审核质检",
        "webUrl": "/qualityDistribution",
        "seq": 999,
        "data": null,
        "icon": "cog.png"
      },
      {
        "taskCode": "RECORD_LISTEN",
        "taskName": "审核录音查听",
        "webUrl": "/soundRecordInfo",
        "seq": 999,
        "data": null,
        "icon": "cog.png"
      }
    ]
  },
	 */
	
	private String groupId;
	
	private String groupDesc;
	
	private Integer seq;
	
	private String icon;
	
	private String data;
	
	private String url;
	
	private List<UserGrants> items;
	
	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<UserGrants> getItems() {
		return items;
	}

	public void setItems(List<UserGrants> items) {
		this.items = items;
	}
	
}
