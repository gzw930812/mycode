package com.cptech.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cptech.common.dao.TaskLogDao;
import com.cptech.common.domain.TaskLogDO;
import com.cptech.common.service.TaskLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;



@Service
public class TaskLogServiceImpl implements TaskLogService {
	@Autowired
	private TaskLogDao taskLogDao;
	
	@Override
	public TaskLogDO get(String id){
		return taskLogDao.get(id);
	}
	
	@Override
	public List<TaskLogDO> findAll(TaskLogDO taskLog){
		return taskLogDao.findAll(taskLog);
	}
	@Override
	public Page<TaskLogDO> findByPage(TaskLogDO taskLog){
		PageHelper.startPage(taskLog.getOffset(), taskLog.getLimit());
		return taskLogDao.findByPage(taskLog);
	}
	
	@Override
	public int save(TaskLogDO taskLog){
		taskLog.preInsert();
		return taskLogDao.save(taskLog);
	}
	
	@Override
	public int update(TaskLogDO taskLog){
		taskLog.preUpdate();
		return taskLogDao.update(taskLog);
	}
	
	@Override
	public int remove(String id){
		return taskLogDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return taskLogDao.batchRemove(ids);
	}
	
}
