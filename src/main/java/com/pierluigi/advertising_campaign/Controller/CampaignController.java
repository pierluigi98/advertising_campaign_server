package com.pierluigi.advertising_campaign.Controller;

import com.pierluigi.advertising_campaign.Domain.Campaign;
import com.pierluigi.advertising_campaign.Domain.Counter;
import com.pierluigi.advertising_campaign.Service.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CampaignController {
    private CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PutMapping("/create")
    public Campaign f1(@RequestBody Campaign campaign){
        return campaignService.create(campaign);
    }

    @GetMapping("/readAll")
    public List<Campaign> f2(){
        return campaignService.readAll();
    }

    @PostMapping("/increment")
    public Campaign f4(@RequestParam("id") String id,@RequestParam("inc") int inc,@RequestParam("cat") String category)
    {
        return campaignService.increment(id,inc,category);
    }

    @GetMapping("/readWithLimit")
    public List<Campaign> f5(@RequestParam("limit") int limit,@RequestParam("page") int page){
        return campaignService.read(limit,page);
    }

    @GetMapping("/prova")
    public String f6()
    { return "prova"; }

    /*
    @PutMapping("/createAuto")
    public Campaign f3(){
        List<Counter> list = new ArrayList<>();
        list.add(new Counter(Counter.Categories.LISTEN_RADIO,400));
        list.add(new Counter(Counter.Categories.LISTEN_WEB,400));
        Campaign campaign = new Campaign("6","aa","bb",list);

        campaignService.create(campaign);

        return null;

    }*/
}
