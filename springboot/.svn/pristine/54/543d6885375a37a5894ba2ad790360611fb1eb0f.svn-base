package com.cptech.common.service;

import java.util.List;
import java.util.Map;

import com.cptech.common.domain.FileDO;
import com.github.pagehelper.Page;

public interface FileService {
	
	FileDO get(String id);
	
	List<FileDO> findAll(Map<String, Object> map);
	Page<FileDO> findByPage(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FileDO sysFile);
	
	int update(FileDO sysFile);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	/**
	 * 判断一个文件是否存在
	 * @param url FileDO中存的路径
	 * @return
	 */
    Boolean isExist(String url);
}
