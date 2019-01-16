package com.cptech.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.system.domain.UserRoleDO;
import com.github.pagehelper.Page;

@Mapper
public interface UserRoleDao {

	UserRoleDO get(String id);

	List<UserRoleDO> findAll(Map<String, Object> map);
	Page<UserRoleDO> findByPage(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserRoleDO userRole);

	int update(UserRoleDO userRole);

	int remove(String id);

	int batchRemove(String[] ids);

	List<String> listRoleId(String userId);

	int removeByUserId(String userId);

	int removeByRoleId(String roleId);

	int batchSaveForMysql(List<UserRoleDO> list);
	int batchSaveForOracle(List<UserRoleDO> list);

	int batchRemoveByUserId(String[] ids);
}
