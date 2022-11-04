package com.piggymetrics.accessservice.domain.Logger;

import java.util.UUID;

import javax.annotation.Nullable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "accessservice_requests", type = "text")
public class Request {
    @Id
    private String id = UUID.randomUUID().toString();

    @Nullable
    private String from;
    
    private String path;

    private int publicDateTime;

    public String getId() {
        return id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return this.from;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void setPublicDateTime(int d) {
        this.publicDateTime = d;
    }

    public int getPublicDateTime() {
        return this.publicDateTime;
    }
    
}
