package com.cptech.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.system.domain.RoleDO;
import com.github.pagehelper.Page;

@Mapper
public interface RoleDao {

	RoleDO get(String id);
	
	List<RoleDO> findAll(Map<String,Object> map);
	Page<RoleDO> findByPage(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
