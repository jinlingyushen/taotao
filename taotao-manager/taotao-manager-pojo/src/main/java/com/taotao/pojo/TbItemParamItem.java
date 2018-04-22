package com.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbItemParamItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897768141468292669L;
	
	private Long id;
	
	private Long itemId;
	
	private String paramData;
	
	private Date created;
	
	private Date updated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getParamData() {
		return paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "TbItemParamItem [id=" + id + ", itemId=" + itemId + ", paramData=" + paramData + ", created=" + created
				+ ", updated=" + updated + "]";
	}
	
	

}
