package com.pierluigi.advertising_campaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
public class AdvertisingCampaignApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertisingCampaignApplication.class, args);
	}

}
