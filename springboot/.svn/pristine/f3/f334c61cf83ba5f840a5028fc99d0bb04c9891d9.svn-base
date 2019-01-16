package com.cptech.common.domain;

import java.io.Serializable;

/**
 * 文件上传
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-19 16:02:20
 */
public class FileDO extends BaseDo implements Serializable {
    private static final long serialVersionUID = 1L;

    // 文件类型
    private Integer type;
    // URL地址
    private String url;

    public FileDO() {
        super();
    }


    public FileDO(Integer type, String url) {
        super();
        this.type = type;
        this.url = url;
    }


    /**
     * 设置：文件类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：文件类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置：URL地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：URL地址
     */
    public String getUrl() {
        return url;
    }


	@Override
	public String toString() {
		return "FileDO [type=" + type + ", url=" + url + "]";
	}
}
