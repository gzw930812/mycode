package com.cptech.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.cptech.common.dao.LogDao;
import com.cptech.common.domain.LogDO;
import com.cptech.common.service.LogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogDao logMapper;

	@Async
	@Override
	public void save(LogDO logDO) {
		logDO.preInsert();
		logMapper.save(logDO);
	}

	@Override
	public int remove(String id) {
		int count = logMapper.remove(id);
		return count;
	}

	@Override
	public int batchRemove(String[] ids){
		return logMapper.batchRemove(ids);
	}

	@Override
	public List<LogDO> findAll(LogDO logDO) {
		return logMapper.findAll(logDO);
	}

	@Override
	public Page<LogDO> findByPage(LogDO logDO) {
		PageHelper.startPage(logDO.getOffset(), logDO.getLimit());
		return logMapper.findByPage(logDO);
	}
}
