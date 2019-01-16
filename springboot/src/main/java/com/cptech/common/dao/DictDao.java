package com.cptech.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cptech.common.domain.DictDO;
import com.github.pagehelper.Page;

/**
 * 字典表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface DictDao {

	DictDO get(String id);

	List<DictDO> findAll(DictDO dict);
	Page<DictDO> findByPage(DictDO dict);

	int count(DictDO dict);

	int save(DictDO dict);

	int update(DictDO dict);

	int remove(String id);

	int batchRemove(String[] ids);

	List<DictDO> listType();
}
