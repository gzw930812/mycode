package com.cptech.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cptech.common.config.Constant;
import com.cptech.common.domain.Tree;
import com.cptech.common.utils.BuildTree;
import com.cptech.system.dao.DeptDao;
import com.cptech.system.domain.DeptDO;
import com.cptech.system.service.DeptService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao sysDeptMapper;

	@Override
	public DeptDO get(String deptId){
		return sysDeptMapper.get(deptId);
	}

	@Override
	public int save(DeptDO sysDept){
		sysDept.preInsert();
		return sysDeptMapper.save(sysDept);
	}

	@Override
	public int update(DeptDO sysDept){
		sysDept.preUpdate();
		return sysDeptMapper.update(sysDept);
	}

	@Override
	public int remove(String deptId){
		return sysDeptMapper.remove(deptId);
	}

	@Override
	public int batchRemove(String[] deptIds){
		return sysDeptMapper.batchRemove(deptIds);
	}

	@Override
	public Tree<DeptDO> getTree(DeptDO deptDO) {
		List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
		List<DeptDO> sysDepts = sysDeptMapper.findAll(deptDO);
		for (DeptDO sysDept : sysDepts) {
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(sysDept.getId());
			if(sysDept.getId().equals(deptDO.getParentId())) {
				tree.setParentId(Constant.DEPT_ROOT_ID);
			} else {
				tree.setParentId(sysDept.getParentId().toString());
			}
			tree.setText(sysDept.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptDO> t = BuildTree.build(trees,"总机构");
		return t;
	}

	@Override
	public boolean checkDeptHasUser(String deptId) {
		//查询机构以及此机构的下级机构
		int result = sysDeptMapper.getDeptUserNumber(deptId);
		return result==0?true:false;
	}

	@Override
	public List<DeptDO> findAll(DeptDO sysDept) {
		List<DeptDO> findAll = sysDeptMapper.findAll(sysDept);
		//获取机构所属区域
		for (DeptDO deptDO : findAll) {
			if(Constant.AREA_ROOT_ID.equals(deptDO.getAreaId())){
				deptDO.setAreaName("全国");
			}else{
				deptDO.setAreaName(getParentAreaName(deptDO.getAreaId()));
			}
			if(!Constant.DEPT_ROOT_ID.equals(deptDO.getParentId())){
				if(deptDO.getId().equals(sysDept.getParentId())){
					deptDO.setParentId(Constant.DEPT_ROOT_ID);
				}
			}
		}
		return findAll;
	}

	@Override
	public Page<DeptDO> findByPage(DeptDO sysDept) {
		PageHelper.startPage(sysDept.getOffset(), sysDept.getLimit());
		return sysDeptMapper.findByPage(sysDept);
	}

	@Override
	public int count(DeptDO sysDept) {
		return sysDeptMapper.count(sysDept);
	}

	@Override
	public String getParentAreaName(String areaId) {
		return sysDeptMapper.getParentAreaName(areaId);
	}

	@Override
	public DeptDO findAllByTree(DeptDO sysDept) {
		List<DeptDO> findAll = sysDeptMapper.findAll(sysDept);
		//获取机构所属区域
		DeptDO root = findAll.get(0);
		if("1".equals(root.getAreaId())){
			root.setAreaName("中华人民共和国");
		}else{
			root.setAreaName(getParentAreaName(root.getAreaId()));
		}
		for (DeptDO parent : findAll) {
			if("1".equals(parent.getAreaId())){
				parent.setAreaName("中华人民共和国");
			}else{
				parent.setAreaName(getParentAreaName(parent.getAreaId()));
			}
			for (DeptDO child : findAll) {
				if(parent.getId().equals(child.getParentId())) {
					parent.getChildren().add(child);
				}
			}
		}
		return root;
	}

	@Override
	public String getUserDeptIds(String parentId) {
		return sysDeptMapper.getUserDeptIds(parentId);
	}

}
