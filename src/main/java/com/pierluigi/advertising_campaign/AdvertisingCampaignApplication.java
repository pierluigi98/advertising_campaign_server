package com.pierluigi.advertising_campaign;

import com.pierluigi.advertising_campaign.Domain.Plafond;
import com.pierluigi.advertising_campaign.Runnable.RunnableFindModify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class AdvertisingCampaignApplication implements CommandLineRunner {
	@Autowired
	MongoTemplate mongoTemplate;
	public static void main(String[] args) {
		SpringApplication.run(AdvertisingCampaignApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int i=0;
		CountDownLatch countDownLatch = new CountDownLatch(400);
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(400);
		RunnableFindModify runnableFindModify = new RunnableFindModify(mongoTemplate, countDownLatch);
		while (i<400) {
			scheduledExecutorService.schedule(runnableFindModify, 0, TimeUnit.SECONDS);
			i++;
		}
		}
}
