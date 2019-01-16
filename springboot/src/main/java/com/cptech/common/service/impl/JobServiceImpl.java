package com.cptech.common.service.impl;

import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cptech.common.config.Constant;
import com.cptech.common.dao.TaskDao;
import com.cptech.common.domain.ScheduleJob;
import com.cptech.common.domain.TaskDO;
import com.cptech.common.quartz.utils.QuartzManager;
import com.cptech.common.service.JobService;
import com.cptech.common.utils.ScheduleJobUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private TaskDao taskScheduleJobMapper;

	@Autowired
	QuartzManager quartzManager;

	@Override
	public TaskDO get(String id) {
		return taskScheduleJobMapper.get(id);
	}

	@Override
	public int count(TaskDO taskDO) {
		return taskScheduleJobMapper.count(taskDO);
	}

	@Override
	public int save(TaskDO taskScheduleJob) {
		taskScheduleJob.preInsert();
		return taskScheduleJobMapper.save(taskScheduleJob);
	}

	@Override
	public int update(TaskDO taskScheduleJob) {
		taskScheduleJob.preUpdate();
		return taskScheduleJobMapper.update(taskScheduleJob);
	}

	@Override
	public int remove(String id) {
		try {
			TaskDO scheduleJob = get(id);
			quartzManager.deleteJob(ScheduleJobUtils.entityToData(scheduleJob));
			return taskScheduleJobMapper.remove(id);
		} catch (SchedulerException e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int batchRemove(String[] ids) {
		for (String id : ids) {
			try {
				TaskDO scheduleJob = get(id);
				quartzManager.deleteJob(ScheduleJobUtils.entityToData(scheduleJob));
			} catch (SchedulerException e) {
				e.printStackTrace();
				return 0;
			}
		}
		return taskScheduleJobMapper.batchRemove(ids);
	}

	@Override
	public void initSchedule() throws SchedulerException {
		// 这里获取任务信息数据
		List<TaskDO> jobList = taskScheduleJobMapper.findAll(new TaskDO());
		for (TaskDO scheduleJob : jobList) {
			if ("1".equals(scheduleJob.getJobStatus())) {
				ScheduleJob job = ScheduleJobUtils.entityToData(scheduleJob);
				quartzManager.addJob(job);
			}

		}
	}

	@Override
	public void updateStatus(String jobId, String cmd) throws SchedulerException {
		TaskDO scheduleJob = get(jobId);
		if (scheduleJob == null) {
			return;
		}
		if (Constant.STATUS_RUNNING_STOP.equals(cmd)) {
			quartzManager.deleteJob(ScheduleJobUtils.entityToData(scheduleJob));
			scheduleJob.setJobStatus(ScheduleJob.STATUS_NOT_RUNNING);
		} else {
			if (!Constant.STATUS_RUNNING_START.equals(cmd)) {
			} else {
                scheduleJob.setJobStatus(ScheduleJob.STATUS_RUNNING);
                quartzManager.addJob(ScheduleJobUtils.entityToData(scheduleJob));
            }
		}
		update(scheduleJob);
	}

	@Override
	public void updateCron(String jobId) throws SchedulerException {
		TaskDO scheduleJob = get(jobId);
		if (scheduleJob == null) {
			return;
		}
		if (ScheduleJob.STATUS_RUNNING.equals(scheduleJob.getJobStatus())) {
			quartzManager.updateJobCron(ScheduleJobUtils.entityToData(scheduleJob));
		}
		update(scheduleJob);
	}

	@Override
	public List<TaskDO> findAll(TaskDO taskDO) {
		return taskScheduleJobMapper.findAll(taskDO);
	}

	@Override
	public Page<TaskDO> findByPage(TaskDO taskDO) {
		PageHelper.startPage(taskDO.getOffset(), taskDO.getLimit());
		return taskScheduleJobMapper.findByPage(taskDO);
	}

}
