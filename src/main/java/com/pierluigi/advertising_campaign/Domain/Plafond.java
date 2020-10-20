package com.pierluigi.advertising_campaign.Domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Plafond {
    public static String COLLECTION_NAME="Plafond";
    @Id
    private ObjectId id;
    private int counter;

    public Plafond() {
    }

    public Plafond(int counter) {
        this.counter = counter;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Plafond{" +
                "id=" + id +
                ", counter=" + counter +
                '}';
    }
}
