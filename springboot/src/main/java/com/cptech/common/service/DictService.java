package com.cptech.common.service;

import java.util.List;

import com.cptech.common.domain.DictDO;
import com.cptech.system.domain.UserDO;
import com.github.pagehelper.Page;

public interface DictService {
	
	DictDO get(String id);
	
	List<DictDO> findAll(DictDO dict);
	Page<DictDO> findByPage(DictDO dict);
	
	int count(DictDO dict);
	
	int save(DictDO dict);
	
	int update(DictDO dict);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<DictDO> listType();
	
	String getName(String type,String value);

	/**
	 * 获取爱好列表
	 * @return
     * @param userDO
	 */
	List<DictDO> getHobbyList(UserDO userDO);

	/**
	 * 获取性别列表
 	 * @return
	 */
	List<DictDO> getSexList();

	/**
	 * 根据type获取数据
	 * @param map
	 * @return
	 */
	List<DictDO> listByType(String type);

}
