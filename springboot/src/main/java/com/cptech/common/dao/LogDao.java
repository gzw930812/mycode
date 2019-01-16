package com.cptech.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.common.domain.LogDO;
import com.github.pagehelper.Page;

/**
 * 系统日志
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface LogDao {

	LogDO get(String id);
	
	List<LogDO> findAll(LogDO logDO);
	Page<LogDO> findByPage(LogDO logDO);
	
	int count(LogDO logDO);
	
	int save(LogDO log);
	
	int update(LogDO log);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
