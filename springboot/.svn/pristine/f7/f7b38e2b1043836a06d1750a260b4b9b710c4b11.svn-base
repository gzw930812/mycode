package com.cptech.common.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cptech.common.dao.GeneratorMapperMysql;
import com.cptech.common.dao.GeneratorMapperOracle;
import com.cptech.common.service.GeneratorService;
import com.cptech.common.utils.GenUtils;
import com.cptech.system.domain.UserDO;


@Service
public class GeneratorServiceImpl implements GeneratorService {
	@Autowired
	GeneratorMapperMysql generatorMapperMysql;
	@Autowired
	GeneratorMapperOracle generatorMapperOracle;

	@Override
	public List<Map<String, Object>> list() {
		UserDO user=new UserDO();
		List<Map<String, Object>> list=null;
		if("mysql".equals(user.getDatabaseType()))
			list = generatorMapperMysql.list();
		else
			list =generatorMapperOracle.list();
		return list;
	}

	@Override
	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		for(String tableName : tableNames){
			UserDO user=new UserDO();
			//查询表信息
			Map<String, String> table = null;
			//查询列信息
			List<Map<String, String>> columns = null;
			if("mysql".equals(user.getDatabaseType())){
				table = generatorMapperMysql.get(tableName);
				columns=generatorMapperMysql.listColumns(tableName);
			}else{
				table = generatorMapperOracle.get(tableName);
				columns=generatorMapperOracle.listColumns(tableName);
			}
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

}
