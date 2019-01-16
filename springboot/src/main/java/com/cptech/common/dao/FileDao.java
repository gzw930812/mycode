package com.cptech.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cptech.common.domain.FileDO;
import com.github.pagehelper.Page;

/**
 * 文件上传
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface FileDao {

	FileDO get(@Param("id")String id);
	
	List<FileDO> findAll(Map<String,Object> map);
	Page<FileDO> findByPage(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FileDO file);
	
	int update(FileDO file);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
