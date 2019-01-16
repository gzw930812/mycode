package com.cptech.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cptech.common.domain.LogDO;
import com.github.pagehelper.Page;
@Service
public interface LogService {
	void save(LogDO logDO);
	List<LogDO> findAll(LogDO logDO);
	Page<LogDO> findByPage(LogDO logDO);
	
	int remove(String id);
	int batchRemove(String[] ids);
}
