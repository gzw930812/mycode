package com.cptech.common.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cptech.common.annotation.Log;
import com.cptech.common.domain.TaskLogDO;
import com.cptech.common.service.TaskLogService;
import com.cptech.common.utils.PageUtils;
import com.cptech.common.utils.R;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * 任务调度日志表
 * 
 * @author fb
 * @email 1595418464@qq.com
 * @date 2018-05-23 17:09:14
 */
 
@Controller
@RequestMapping("/common/jobLog")
public class JobLogController {
	@Autowired
	private TaskLogService taskLogService;
	
	@GetMapping()
	@RequiresPermissions("common:jobLog:jobLog")
	String jobog(){
	    return "common/jobLog/jobLog";
	}
	
	@Log("任务调度日志表-查询列表")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:jobLog:jobLog")
	public PageUtils list(TaskLogDO taskLog){
		//查询列表数据
		Page<TaskLogDO> findByPage = taskLogService.findByPage(taskLog);
		PageInfo<TaskLogDO> pageInfo = new PageInfo<>(findByPage);
		PageUtils pageUtil = new PageUtils(pageInfo.getList(), (int)pageInfo.getTotal());
		return pageUtil;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:jobLog:add")
	String add(){
	    return "common/jobLog/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:jobLog:edit")
	String edit(@PathVariable("id") String id,Model model){
		TaskLogDO taskLog = taskLogService.get(id);
		model.addAttribute("taskLog", taskLog);
	    return "common/jobLog/edit";
	}
	
	/**
	 * 保存
	 */
	@Log("任务调度日志表-保存")
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:jobLog:add")
	public R save(TaskLogDO taskLog){
		if(taskLogService.save(taskLog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@Log("任务调度日志表-修改")
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:jobLog:edit")
	public R update( TaskLogDO taskLog){
		taskLogService.update(taskLog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@Log("任务调度日志表-删除")
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:jobLog:remove")
	public R remove( String id){
		if(taskLogService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@Log("任务调度日志表-批量删除")
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:jobLog:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		taskLogService.batchRemove(ids);
		return R.ok();
	}
	
}
