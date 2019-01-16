package com.cptech.common.listenner;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.listeners.JobListenerSupport;
import org.springframework.core.annotation.Order;

import com.cptech.common.domain.TaskLogDO;
import com.cptech.common.service.TaskLogService;

@Order(value=2)
public class JobDetalListener extends JobListenerSupport {

	private TaskLogService taskLogService;
	
	private String logId="";

	public JobDetalListener(TaskLogService taskLogService) {
		this.taskLogService=taskLogService;
	}

	@Override
	public String getName() {
		return getClass().getName();
	}
	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		TaskLogDO taskLog = new TaskLogDO();
		JobDetail jobDetail = context.getJobDetail();
		JobKey key = jobDetail.getKey();
		String name = key.getName();
		String group = key.getGroup();
		taskLog.setJobGroup(group);
		taskLog.setJobMessage(context.toString());
		taskLog.setJobName(name);
		taskLog.setJobEvent(null);
		taskLog.setJobType("job");
		taskLog.setIsException("0");
		taskLog.setExceptionInfo(null);
		taskLog.preInsert();
		this.logId=taskLog.getId();
		taskLogService.save(taskLog);
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		TaskLogDO taskLogDO = taskLogService.get(logId);
		taskLogDO.setIsException("1");
		taskLogDO.setExceptionInfo("被否决执行");
		taskLogService.update(taskLogDO);
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,JobExecutionException jobException) {
		if(jobException!=null){
			TaskLogDO taskLogDO = taskLogService.get(logId);
			taskLogDO.setIsException("1");
			taskLogDO.setExceptionInfo(jobException.getMessage());
			taskLogService.update(taskLogDO);
		}
	}
}
