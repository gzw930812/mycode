package com.cptech.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.system.domain.MenuDO;
import com.github.pagehelper.Page;

@Mapper
public interface MenuDao {

	MenuDO get(String id);
	
	List<MenuDO> findAll(MenuDO menu);
	Page<MenuDO> findByPage(MenuDO menu);
	
	int count(MenuDO menu);
	
	int save(MenuDO menu);
	
	int update(MenuDO menu);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	List<MenuDO> listMenuByUserId(String id);
	
	List<MenuDO> listTopMenuByUserId(String id);
	
	List<MenuDO> listLeftMenuByUserId(String id);
	
	List<String> listUserPerms(String id);
}
