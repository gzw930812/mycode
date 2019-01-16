package com.cptech.system.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cptech.common.domain.BaseDo;

public class DeptDO extends BaseDo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//上级机构ID，一级机构为0
	private String parentId;
	private String areaId;//区域id
	private String areaName;//区域名称
	//机构名称
	private String name;
	//排序
	private Integer orderNum;
	
	private List<DeptDO> children;

	/**
	 * 设置：上级机构ID，一级机构为0
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级机构ID，一级机构为0
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：机构名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：机构名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public List<DeptDO> getChildren() {
		if(children == null) children = new ArrayList<DeptDO>();
		return children;
	}
	public void setChildren(List<DeptDO> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "DeptDO [parentId=" + parentId + ", areaId=" + areaId
				+ ", areaName=" + areaName + ", name=" + name + ", orderNum="
				+ orderNum + "]";
	}
}
