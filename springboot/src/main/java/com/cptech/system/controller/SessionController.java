package com.cptech.system.controller;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cptech.common.utils.R;
import com.cptech.common.utils.ShiroUtils;
import com.cptech.system.domain.UserDO;
import com.cptech.system.domain.UserOnline;
import com.cptech.system.service.SessionService;

@RequestMapping("/sys/online")
@Controller
public class SessionController {
	@Autowired
	SessionService sessionService;
	@Autowired
    private SimpMessagingTemplate template;

	@GetMapping()
	public String online() {
		return "system/online/online";
	}

	@ResponseBody
	@RequestMapping("/list")
	public List<UserOnline> list() {
		return sessionService.list();
	}

	@ResponseBody
	@RequestMapping("/forceLogout/{sessionId}")
	public R forceLogout(@PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes) {
		try {
			UserDO userDO = sessionService.getBySessionId(sessionId);
			if(userDO.getUsername().equals(ShiroUtils.getUser().getUsername())) {
				return R.error("不能强制自己下线");
			}
			sessionService.forceLogout(sessionId);
			//用户被强制下线通知
			if(userDO!=null) {
		        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
		        executor.execute(new Runnable() {
		            @Override
		            public void run() {
		            	template.convertAndSendToUser(userDO.toString(), "/queue/forceLogout", "你已被强制下线，请重新登录！" );
		            }
		        });
		        executor.shutdown();
			}
			return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}

	}

	@ResponseBody
	@RequestMapping("/sessionList")
	public Collection<Session> sessionList() {
		return sessionService.sessionList();
	}


}
