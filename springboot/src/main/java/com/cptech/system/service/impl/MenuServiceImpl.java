package com.cptech.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cptech.common.domain.Tree;
import com.cptech.common.utils.BuildTree;
import com.cptech.system.dao.MenuDao;
import com.cptech.system.dao.RoleMenuDao;
import com.cptech.system.domain.MenuDO;
import com.cptech.system.service.MenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuDao menuMapper;
	@Autowired
	RoleMenuDao roleMenuMapper;
	@Value("${server.context-path}")
	private String contexPath;//系统上下文路径

	/**
	 * @param
	 * @return 树形菜单
	 */
	@Cacheable
	@Override
	public Tree<MenuDO> getSysMenuTree(String id) {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.listMenuByUserId(id);
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getId());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", this.contexPath+"/"+sysMenuDO.getUrl());
			attributes.put("icon", sysMenuDO.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = BuildTree.build(trees,"根菜单");
		return t;
	}


	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int remove(String id) {
		int result = menuMapper.remove(id);
		return result;
	}
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int save(MenuDO menu) {
		menu.preInsert();
		int r = menuMapper.save(menu);
		return r;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int update(MenuDO menu) {
		menu.preUpdate();
		int r = menuMapper.update(menu);
		return r;
	}

	@Override
	public MenuDO get(String id) {
		MenuDO menuDO = menuMapper.get(id);
		return menuDO;
	}

	@Override
	public Tree<MenuDO> getTree() {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.findAll(new MenuDO());
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = BuildTree.build(trees,"根菜单");
		return t;
	}

	@Override
	public Tree<MenuDO> getTree(String id) {
		// 根据roleId查询权限
		List<MenuDO> menus = menuMapper.findAll(new MenuDO());
		List<String> menuIds = roleMenuMapper.listMenuIdByRoleId(id);
		List<String> temp = menuIds;
		for (MenuDO menu : menus) {
			if (temp.contains(menu.getParentId())) {
				menuIds.remove(menu.getParentId());
			}
		}
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.findAll(new MenuDO());
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> state = new HashMap<>(16);
			String menuId = sysMenuDO.getId();
			if (menuIds.contains(menuId)) {
				state.put("selected", true);
			} else {
				state.put("selected", false);
			}
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = BuildTree.build(trees,"根菜单");
		return t;
	}

	@Override
	public Set<String> listPerms(String userId) {
		List<String> perms = menuMapper.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			if (StringUtils.isNotBlank(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}

	@Override
	public List<Tree<MenuDO>> listMenuTree(String id) {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.listMenuByUserId(id);
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getId());
			tree.setParentId(sysMenuDO.getParentId());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			String url = sysMenuDO.getUrl();
			if(StringUtils.isNotEmpty(url)) {
				url=url.contains("http")?url:this.contexPath+"/"+url;
			}
			attributes.put("url", url);
			attributes.put("icon", sysMenuDO.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<MenuDO>> list = BuildTree.buildList(trees, "0");
		return list;
	}


	@Override
	public List<MenuDO> findAll(MenuDO menuDO) {
		return menuMapper.findAll(menuDO);
	}


	@Override
	public Page<MenuDO> findByPage(MenuDO menuDO) {
		PageHelper.startPage(menuDO.getOffset(), menuDO.getLimit());
		return menuMapper.findByPage(menuDO);
	}


	@Override
	public List<MenuDO> getTopMenuByUserId(String id) {
		return menuMapper.listTopMenuByUserId(id);
	}


	@Override
	public List<Tree<MenuDO>> getLeftMenuByUserId(String id) {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> leftMenus = menuMapper.listLeftMenuByUserId(id);
		for (MenuDO sysMenuDO : leftMenus) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getId());
			String type = sysMenuDO.getType();
			if("0".equals(type)){//目录
				tree.setParentId("0");
			}else{
				tree.setParentId(sysMenuDO.getParentId());
			}
			tree.setText(sysMenuDO.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			String url = sysMenuDO.getUrl();
			if(StringUtils.isNotEmpty(url)) {
				url=url.contains("http")?url:this.contexPath+"/"+url;
			}
			attributes.put("url", url);
			attributes.put("icon", sysMenuDO.getIcon());
			attributes.put("real_parent_id", sysMenuDO.getParentId());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<MenuDO>> list = BuildTree.buildList(trees, "0");
		return list;
	}
}
