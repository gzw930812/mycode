package com.cptech.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.system.domain.DeptDO;
import com.github.pagehelper.Page;

@Mapper
public interface DeptDao {

	DeptDO get(String id);
	
	List<DeptDO> findAll(DeptDO sysDept);
	
	Page<DeptDO> findByPage(DeptDO sysDept);
	
	int count(DeptDO sysDept);
	
	int save(DeptDO dept);
	
	int update(DeptDO dept);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	String[] listParentDept();
	
	int getDeptUserNumber(String id);
	
	String getParentAreaName(String areaId);

	String getUserDeptIds(String parentId);
}
