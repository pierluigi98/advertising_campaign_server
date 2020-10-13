package com.pierluigi.advertising_campaign.Repository;

import com.pierluigi.advertising_campaign.Domain.Campaign;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepositoryCustom  {
    Campaign increment(String id, int increment, String category);
    List<Campaign> readWithLimit (int limit);
}
