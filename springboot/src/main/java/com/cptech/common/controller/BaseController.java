package com.cptech.common.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.cptech.common.utils.ShiroUtils;
import com.cptech.system.domain.UserDO;

@Controller
public class BaseController {
	
	@Value("${server.context-path}")
	private String contexPath;//系统上下文路径
	
	/**
	 * 获取系统上下文路径（即项目名称）
	 * @return
	 */
	public String getContexPath() {
		return contexPath;
	}
	
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public String getUserId() {
		return getUser().getId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
	
}