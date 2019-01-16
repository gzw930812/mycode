package com.cptech.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cptech.system.domain.RoleDO;
import com.github.pagehelper.Page;

@Service
public interface RoleService {

	RoleDO get(String id);

	List<RoleDO> findAll();
	
	Page<RoleDO> findByPage();

	int save(RoleDO role);

	int update(RoleDO role);

	int remove(String id);

	List<RoleDO> list(String userId);

	int batchremove(String[] ids);
}
