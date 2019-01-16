package com.cptech.common.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cptech.common.config.GlobleConfig;
import com.cptech.common.dao.FileDao;
import com.cptech.common.domain.FileDO;
import com.cptech.common.service.FileService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileDao sysFileMapper;

	@Autowired
	private GlobleConfig globleConfig;
	@Override
	public FileDO get(String id){
		return sysFileMapper.get(id);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysFileMapper.count(map);
	}
	
	@Override
	public int save(FileDO sysFile){
		sysFile.preInsert();
		return sysFileMapper.save(sysFile);
	}
	
	@Override
	public int update(FileDO sysFile){
		sysFile.preUpdate();
		return sysFileMapper.update(sysFile);
	}
	
	@Override
	public int remove(String id){
		return sysFileMapper.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return sysFileMapper.batchRemove(ids);
	}

    @Override
    public Boolean isExist(String url) {
		Boolean isExist = false;
		if (!StringUtils.isEmpty(url)) {
			String filePath = url.replace("/files/", "");
			filePath = globleConfig.getUploadPath() + filePath;
			File file = new File(filePath);
			if (file.exists()) {
				isExist = true;
			}
		}
		return isExist;
	}

	@Override
	public List<FileDO> findAll(Map<String, Object> map) {
		return sysFileMapper.findAll(map);
	}

	@Override
	public Page<FileDO> findByPage(Map<String, Object> map) {
		PageHelper.startPage(Integer.parseInt(map.get("offset")+""), Integer.parseInt(map.get("limit")+""));
		return sysFileMapper.findByPage(map);
	}
	}
