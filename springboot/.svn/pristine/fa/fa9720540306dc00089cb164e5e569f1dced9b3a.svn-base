package com.cptech.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.system.domain.UserDO;
import com.github.pagehelper.Page;

@Mapper
public interface UserDao {

	UserDO get(String id);
	
	List<UserDO> findAll(UserDO user);
	
	Page<UserDO> findByPage(UserDO user);
	
	int count(UserDO user);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	String[] listAllDept();

}
