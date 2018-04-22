package com.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1218612003047243421L;
	
	private Long id;
	
	private Long categoryId;
	
	private String title;
	
	private String subTitle;
	
	private String titleDesc;
	
	private String url;
	
	private String pic;
	
	private String pic2;
	
	private String content;
	
	private Date created;
	
	private Date updated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "ItemContent [id=" + id + ", categoryId=" + categoryId + ", title=" + title + ", subTitle=" + subTitle
				+ ", titleDesc=" + titleDesc + ", url=" + url + ", pic=" + pic + ", pic2=" + pic2 + ", content="
				+ content + ", created=" + created + ", updated=" + updated + "]";
	}
	
	

}
