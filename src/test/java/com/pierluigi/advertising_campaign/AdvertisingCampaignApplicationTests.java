package com.pierluigi.advertising_campaign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootTest
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages="com.pierluigi.advertising_campaign.Repository.*")
class AdvertisingCampaignApplicationTests {

	@Autowired
	MongoTemplate mongoTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void testDBCincurrency(){

	}

}
