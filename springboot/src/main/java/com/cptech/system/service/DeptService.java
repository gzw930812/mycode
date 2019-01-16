package com.cptech.system.service;

import java.util.List;

import com.cptech.common.domain.Tree;
import com.cptech.system.domain.DeptDO;
import com.github.pagehelper.Page;

public interface DeptService {
	
	DeptDO get(String deptId);
	
	List<DeptDO> findAll(DeptDO sysDept);
	DeptDO findAllByTree(DeptDO sysDept);
	Page<DeptDO> findByPage(DeptDO sysDept);
	
	int count(DeptDO sysDept);
	
	int save(DeptDO sysDept);
	
	int update(DeptDO sysDept);
	
	int remove(String deptId);
	
	int batchRemove(String[] deptIds);

	Tree<DeptDO> getTree(DeptDO deptDO);
	
	boolean checkDeptHasUser(String deptId);
	
	String getParentAreaName(String areaId);

	String getUserDeptIds(String parentId);
}
