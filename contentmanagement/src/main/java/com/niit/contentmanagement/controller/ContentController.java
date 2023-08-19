package com.niit.contentmanagement.controller;

import com.niit.contentmanagement.model.Content;
import com.niit.contentmanagement.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ContentController
{
    private ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/savecontent")
    public ResponseEntity<?> saveFunction1(@RequestBody Content content){
        return new ResponseEntity<>(contentService.saveContent(content), HttpStatus.OK);
    }

    @GetMapping("/fetchall")
    public ResponseEntity<?> fetchFunction1(){
        return new ResponseEntity<>(contentService.getAllContent(), HttpStatus.OK);
    }

    @DeleteMapping("/deletecontent/{contentid}")
    public ResponseEntity<?> deleteFunction1(@PathVariable("contentid") int contentid){
        return new ResponseEntity<>(contentService.deletecontent(contentid), HttpStatus.OK);
    }


}
