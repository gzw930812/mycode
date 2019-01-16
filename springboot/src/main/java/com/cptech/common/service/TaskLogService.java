package com.cptech.common.service;

import java.util.List;

import com.cptech.common.domain.TaskLogDO;
import com.github.pagehelper.Page;

/**
 * 任务调度日志表
 * 
 * @author fb
 * @email 1595418464@qq.com
 * @date 2018-05-23 17:09:14
 */
public interface TaskLogService {
	
	TaskLogDO get(String id);
	
	List<TaskLogDO> findAll(TaskLogDO taskLog);
	Page<TaskLogDO> findByPage(TaskLogDO taskLog);
	
	int save(TaskLogDO taskLog);
	
	int update(TaskLogDO taskLog);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
