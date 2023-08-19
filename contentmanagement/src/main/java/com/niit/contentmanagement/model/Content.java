package com.niit.contentmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Content
{
    @Id
    private int contentid;
    private String title;
    private String contentdata;

    public Content() {
    }

    public Content(int contentid, String title, String contentdata) {
        this.contentid = contentid;
        this.title = title;
        this.contentdata = contentdata;
    }

    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentdata() {
        return contentdata;
    }

    public void setContentdata(String contentdata) {
        this.contentdata = contentdata;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentid=" + contentid +
                ", title='" + title + '\'' +
                ", contentdata='" + contentdata + '\'' +
                '}';
    }
}
