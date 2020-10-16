package com.pierluigi.advertising_campaign.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Campaign {
    @Id
    private String idCampaign;
    private String title;
    private String description;
    private List<Counter> listCounter;

    public Campaign(String idCampaign, String title, String description, List<Counter> listCounter) {
        this.idCampaign = idCampaign;
        this.title = title;
        this.description = description;
        this.listCounter = listCounter;
    }

    public Campaign(){}

    public String getIdCampaign() {
        return idCampaign;
    }

    public void setIdCampaign(String idCampaign) {
        this.idCampaign = idCampaign;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Counter> getListCounter() {
        return listCounter;
    }

    public void setListCounter(List<Counter> listCounter) {
        this.listCounter = listCounter;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "idCampaign='" + idCampaign + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", listCounter=" + listCounter +
                '}';
    }
}
