package com.pierluigi.advertising_campaign.Runnable;
import com.mongodb.client.model.UpdateOptions;
import com.pierluigi.advertising_campaign.AdvertisingCampaignApplication;
import com.pierluigi.advertising_campaign.Domain.Plafond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnableFindModify implements Runnable{

    private MongoTemplate mongoTemplate;
    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatchMain;
    public static long time;

    public RunnableFindModify(MongoTemplate mongoTemplate, CountDownLatch countDownLatch, CountDownLatch countDownLatchMain) {
        this.mongoTemplate = mongoTemplate;
        this.countDownLatch = countDownLatch;
        this.countDownLatchMain = countDownLatchMain;
    }

    @Override
    public void run() {
        Logger logger = LoggerFactory.getLogger(RunnableFindModify.class);
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").exists(true).and("counter").gt(0));
        Update update = new Update();
        update.inc("counter",-1);

        countDownLatch.countDown();
        try {
            countDownLatch.await();
            time = System.currentTimeMillis();
            Plafond p = mongoTemplate.findAndModify(query,update, FindAndModifyOptions
                    .options().returnNew(true),Plafond.class,"plafond");
            countDownLatchMain.countDown();
            if (p == null) {
                logger.info("null");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
}
