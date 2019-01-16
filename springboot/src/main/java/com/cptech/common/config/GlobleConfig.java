package com.cptech.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="cptech")
public class GlobleConfig {
	//上传路径
	private String uploadPath;
	private String systemName;//系统名称
	private String fileServerAddress;//文件服务器地址

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getFileServerAddress() {
		return fileServerAddress;
	}

	public void setFileServerAddress(String fileServerAddress) {
		this.fileServerAddress = fileServerAddress;
	}
	
}
