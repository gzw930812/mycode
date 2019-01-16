package com.cptech.system.domain;

import com.cptech.common.domain.BaseDo;

public class RoleMenuDO extends BaseDo {
	private String  roleId;
	private String menuId;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		return "RoleMenuDO [roleId=" + roleId + ", menuId=" + menuId + "]";
	}

}
