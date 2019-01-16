package com.cptech.system.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cptech.common.domain.Tree;
import com.cptech.system.domain.MenuDO;
import com.github.pagehelper.Page;

@Service
public interface MenuService {
	Tree<MenuDO> getSysMenuTree(String id);

	List<Tree<MenuDO>> listMenuTree(String id);

	Tree<MenuDO> getTree();

	Tree<MenuDO> getTree(String id);

	List<MenuDO> findAll(MenuDO menuDO);
	
	Page<MenuDO> findByPage(MenuDO menuDO);

	int remove(String id);

	int save(MenuDO menu);

	int update(MenuDO menu);

	MenuDO get(String id);

	Set<String> listPerms(String userId);
	
	List<MenuDO> getTopMenuByUserId(String id);
	
	List<Tree<MenuDO>> getLeftMenuByUserId(String id);
}
