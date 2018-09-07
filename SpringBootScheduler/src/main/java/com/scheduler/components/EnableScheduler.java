package com.scheduler.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EnableScheduler {

	@Scheduled(fixedRate = 2000)
	public void schedule() {
		System.out.println("====scheduler task=========");
	}

}
