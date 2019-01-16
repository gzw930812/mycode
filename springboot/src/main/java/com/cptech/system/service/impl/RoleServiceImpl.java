package com.cptech.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cptech.system.dao.RoleDao;
import com.cptech.system.dao.RoleMenuDao;
import com.cptech.system.dao.UserDao;
import com.cptech.system.dao.UserRoleDao;
import com.cptech.system.domain.RoleDO;
import com.cptech.system.domain.RoleMenuDO;
import com.cptech.system.service.RoleService;
import com.github.pagehelper.Page;


@Service
public class RoleServiceImpl implements RoleService {

    public static final String ROLE_ALL_KEY = "\"role_all\"";

    public static final String DEMO_CACHE_NAME = "role";

    @Autowired
    RoleDao roleMapper;
    @Autowired
    RoleMenuDao roleMenuMapper;
    @Autowired
    UserDao userMapper;
    @Autowired
    UserRoleDao userRoleMapper;

    @Override
    public List<RoleDO> findAll() {
        List<RoleDO> roles = roleMapper.findAll(new HashMap<>(16));
        return roles;
    }
    @Override
    public Page<RoleDO> findByPage() {
    	return roleMapper.findByPage(new HashMap<>(16));
    }


    @Override
    public List<RoleDO> list(String userId) {
        List<String> rolesIds = userRoleMapper.listRoleId(userId);
        List<RoleDO> roles = roleMapper.findAll(new HashMap<>(16));
        for (RoleDO roleDO : roles) {
            roleDO.setRoleSign("false");
            for (String roleId : rolesIds) {
                if (Objects.equals(roleDO.getId(), roleId)) {
                    roleDO.setRoleSign("true");
                    break;
                }
            }
        }
        return roles;
    }
    @Transactional
    @Override
    public int save(RoleDO role) {
    	role.preInsert();
    	String roleId = role.getId();
        int count = roleMapper.save(role);
        List<String> menuIds = role.getMenuIds();
        List<RoleMenuDO> rms = new ArrayList<>();
        for (String menuId : menuIds) {
            RoleMenuDO rmDo = new RoleMenuDO();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            rmDo.preInsert();
            rms.add(rmDo);
        }
        roleMenuMapper.removeByRoleId(roleId);
        if (rms.size() > 0) {
        	if("mysql".equals(role.getDatabaseType()))
        		roleMenuMapper.batchSaveForMysql(rms);
        	else
        		roleMenuMapper.batchSaveForOracle(rms);
        }
        return count;
    }

    @Transactional
    @Override
    public int remove(String id) {
        int count = roleMapper.remove(id);
        userRoleMapper.removeByRoleId(id);
        roleMenuMapper.removeByRoleId(id);
        return count;
    }

    @Override
    public RoleDO get(String id) {
        RoleDO roleDO = roleMapper.get(id);
        return roleDO;
    }

    @Override
    public int update(RoleDO role) {
    	role.preUpdate();
        int r = roleMapper.update(role);
        List<String> menuIds = role.getMenuIds();
        String roleId = role.getId();
        roleMenuMapper.removeByRoleId(roleId);
        List<RoleMenuDO> rms = new ArrayList<>();
        for (String menuId : menuIds) {
            RoleMenuDO rmDo = new RoleMenuDO();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            rmDo.preInsert();
            rms.add(rmDo);
        }
        if (rms.size() > 0) {
        	if("mysql".equals(role.getDatabaseType()))
        		roleMenuMapper.batchSaveForMysql(rms);
        	else
        		roleMenuMapper.batchSaveForOracle(rms);
        }
        return r;
    }

    @Override
    public int batchremove(String[] ids) {
        int r = roleMapper.batchRemove(ids);
        return r;
    }

}
