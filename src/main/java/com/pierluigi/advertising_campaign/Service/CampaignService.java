package com.pierluigi.advertising_campaign.Service;

import com.pierluigi.advertising_campaign.Domain.Campaign;
import com.pierluigi.advertising_campaign.Repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    public CampaignService() {
    }

    public Campaign create(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public List<Campaign> readAll () {
        return campaignRepository.findAll();
    }

    public Campaign increment (String id,int increment,String category) {
        return campaignRepository.increment(id, increment, category);
    }
    public List<Campaign> read(int num, int page) {
        return campaignRepository.readWithLimit(num,page );
    }
}
