package com.pierluigi.advertising_campaign.Repository;

import com.pierluigi.advertising_campaign.Domain.Campaign;
import com.pierluigi.advertising_campaign.Domain.Plafond;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends MongoRepository<Campaign,String>,CampaignRepositoryCustom {

}
