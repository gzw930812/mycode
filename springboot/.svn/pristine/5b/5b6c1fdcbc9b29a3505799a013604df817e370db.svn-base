package com.cptech.common.controller;

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
import com.cptech.common.domain.TaskDO;
import com.cptech.common.service.JobService;
import com.cptech.common.utils.PageUtils;
import com.cptech.common.utils.R;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-26 20:53:48
 */
@Controller
@RequestMapping("/common/job")
public class JobController extends BaseController{
	@Autowired
	private JobService taskScheduleJobService;

	@GetMapping()
	String taskScheduleJob(Model model) {
		model.addAttribute("toJobLogUrl", getContexPath()+"/common/jobLog/list");
		return "common/job/job";
	}
	@Log("查询任务列表")
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(TaskDO taskDO) {
		// 查询列表数据
		Page<TaskDO> findByPage = taskScheduleJobService.findByPage(taskDO);
		PageInfo<TaskDO> pageInfo = new PageInfo<>(findByPage);
		PageUtils pageUtil = new PageUtils(pageInfo.getList(), (int)pageInfo.getTotal());
		return pageUtil;
	}

	@GetMapping("/add")
	String add() {
		return "common/job/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") String id, Model model) {
		TaskDO job = taskScheduleJobService.get(id);
		model.addAttribute("job", job);
		return "common/job/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") String id) {
		TaskDO taskScheduleJob = taskScheduleJobService.get(id);
		return R.ok().put("taskScheduleJob", taskScheduleJob);
	}

	/**
	 * 保存
	 */
	@Log("保存任务")
	@ResponseBody
	@PostMapping("/save")
	public R save(TaskDO taskScheduleJob) {
		if (taskScheduleJobService.save(taskScheduleJob) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@Log("修改任务")
	@ResponseBody
	@PostMapping("/update")
	public R update(TaskDO taskScheduleJob) {
		taskScheduleJobService.update(taskScheduleJob);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@Log("删除任务")
	@PostMapping("/remove")
	@ResponseBody
	public R remove(String id) {
		if (taskScheduleJobService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@Log("批量删除任务")
	@PostMapping("/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") String[] ids) {
		taskScheduleJobService.batchRemove(ids);

		return R.ok();
	}

	@Log("启动/停止任务")
	@PostMapping(value = "/changeJobStatus")
	@ResponseBody
	public R changeJobStatus(String id,String cmd ) {
		String label = "停止";
		if ("start".equals(cmd)) {
			label = "启动";
		} else {
			label = "停止";
		}
		try {
			taskScheduleJobService.updateStatus(id, cmd);
			return R.ok("任务" + label + "成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.ok("任务" + label + "失败");
	}

}
