package com.pierluigi.advertising_campaign.Repository;

import com.pierluigi.advertising_campaign.Domain.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends MongoRepository<Campaign,String>,CampaignRepositoryCustom {

}
