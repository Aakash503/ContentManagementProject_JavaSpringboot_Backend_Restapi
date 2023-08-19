package com.niit.contentmanagement.service;

import com.niit.contentmanagement.model.Content;

import java.util.List;

public interface ContentService
{
    public Content saveContent(Content content);
    public List<Content> getAllContent();

    public boolean deletecontent(int contentid);
}
