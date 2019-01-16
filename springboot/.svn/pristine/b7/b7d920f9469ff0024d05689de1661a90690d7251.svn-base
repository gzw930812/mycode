package com.cptech.common.service;

import java.util.List;

import org.quartz.SchedulerException;

import com.cptech.common.domain.TaskDO;
import com.github.pagehelper.Page;

public interface JobService {
	
	TaskDO get(String id);
	
	List<TaskDO> findAll(TaskDO taskDO);
	Page<TaskDO> findByPage(TaskDO taskDO);
	
	int count(TaskDO taskDO);
	
	int save(TaskDO taskScheduleJob);
	
	int update(TaskDO taskScheduleJob);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	void initSchedule() throws SchedulerException;

	void updateStatus(String jobId, String cmd) throws SchedulerException;

	void updateCron(String jobId) throws SchedulerException;
}
