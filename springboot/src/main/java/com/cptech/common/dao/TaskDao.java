package com.cptech.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.common.domain.TaskDO;
import com.github.pagehelper.Page;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface TaskDao {

	TaskDO get(String id);
	
	List<TaskDO> findAll(TaskDO task);
	Page<TaskDO> findByPage(TaskDO task);
	
	int count(TaskDO task);
	
	int save(TaskDO task);
	
	int update(TaskDO task);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
