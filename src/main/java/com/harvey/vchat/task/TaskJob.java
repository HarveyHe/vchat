package com.harvey.vchat.task;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.harvey.vchat.bas.service.BasUsersService;
  
@Component 
public class TaskJob {  
	@Resource
	private BasUsersService basUsersService;
	
    @Scheduled(cron = "0/10 * * * * ?")  
    public void job1() {  
    	
    }  
} 