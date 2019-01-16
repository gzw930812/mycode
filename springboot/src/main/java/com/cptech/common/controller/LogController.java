package com.cptech.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cptech.common.domain.LogDO;
import com.cptech.common.service.LogService;
import com.cptech.common.utils.PageUtils;
import com.cptech.common.utils.R;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

@RequestMapping("/common/log")
@Controller
public class LogController {
	@Autowired
	LogService logService;
	String prefix = "common/log";

	@GetMapping()
	String log() {
		return prefix + "/log";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(LogDO logDO) {
		Page<LogDO> findByPage = logService.findByPage(logDO);
		PageInfo<LogDO> pageInfo = new PageInfo<>(findByPage);
		PageUtils pageUtil = new PageUtils(pageInfo.getList(), (int)pageInfo.getTotal());
		return pageUtil;
	}
	
	@ResponseBody
	@PostMapping("/remove")
	R remove(String id) {
		if (logService.remove(id)>0) {
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@PostMapping("/batchRemove")
	R batchRemove(@RequestParam("ids[]") String[] ids) {
		int r = logService.batchRemove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
