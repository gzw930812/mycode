package com.cptech.common.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cptech.system.dao.UserDao;

@Component
public class Demo1 implements Job{
	@Autowired
	private UserDao userDao;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException{
    	//随时查询以保证连接不断开
    	userDao.get("");
    }

}