package com.pierluigi.advertising_campaign.Repository;

import com.pierluigi.advertising_campaign.Domain.Campaign;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampaignRepositoryImpl implements CampaignRepositoryCustom {
    private MongoTemplate mongoTemplate;
    public CampaignRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Campaign increment(String id, int increment, String category) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id).and("listCounter.category").is(category));
        Update update = new Update();
        update
                .inc("listCounter.$.listenNumber",increment);
        return mongoTemplate
                .findAndModify(query,update,Campaign.class,"campaign");
    }

    @Override
    public List<Campaign> readWithLimit(int limit, int page) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").exists(true)).skip((page*limit)-limit).limit(limit);
        return mongoTemplate.find(query, Campaign.class, "campaign");

    }
}
