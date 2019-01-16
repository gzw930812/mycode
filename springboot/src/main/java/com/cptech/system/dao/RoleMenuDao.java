package com.cptech.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.system.domain.RoleMenuDO;
import com.github.pagehelper.Page;

@Mapper
public interface RoleMenuDao {

	RoleMenuDO get(String id);
	
	List<RoleMenuDO> findAll(Map<String,Object> map);
	Page<RoleMenuDO> findByPage(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RoleMenuDO roleMenu);
	
	int update(RoleMenuDO roleMenu);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	List<String> listMenuIdByRoleId(String roleId);
	
	int removeByRoleId(String roleId);

	int removeByMenuId(String menuId);
	
	int batchSaveForMysql(List<RoleMenuDO> list);
	int batchSaveForOracle(List<RoleMenuDO> list);
}
