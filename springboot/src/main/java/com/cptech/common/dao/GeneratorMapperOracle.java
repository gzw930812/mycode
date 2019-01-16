package com.cptech.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface GeneratorMapperOracle {
	@Select("select  a.table_name \"tableName\",a.table_type \"engine\",a.comments \"tableComment\",b.last_analyzed \"create_time\" from user_tab_comments a inner join USER_TABLES b on a.table_name=b.table_name")
	List<Map<String, Object>> list();

	@Select("select count(*) from USER_TABLES")
	int count(Map<String, Object> map);

	@Select("select  a.table_name \"tableName\",a.table_type \"engine\",a.comments \"tableComment\",b.last_analyzed \"create_time\" from user_tab_comments a inner join USER_TABLES b on a.table_name=b.table_name and a.table_name=#{tableName} and b.table_name=#{tableName}")
	Map<String, String> get(String tableName);

	@Select("SELECT a.column_name \"columnName\",a.data_type \"dataType\",b.comments \"columnComment\",'' \"columnKey\",'' \"extra\"  FROM all_tab_columns   a  inner join user_col_comments b on a.table_name=b.table_name and a.column_name=b.column_name and a.table_name=#{tableName}  and b.table_name=#{tableName}")
	List<Map<String, String>> listColumns(String tableName);
}
