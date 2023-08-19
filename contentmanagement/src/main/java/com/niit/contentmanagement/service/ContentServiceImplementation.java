package com.niit.contentmanagement.service;

import com.niit.contentmanagement.model.Content;
import com.niit.contentmanagement.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImplementation implements ContentService{

    private ContentRepository contentRepository;

    @Autowired
    public ContentServiceImplementation(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public boolean deletecontent(int contentid) {
        contentRepository.deleteById(contentid);
        return true;
    }


}
