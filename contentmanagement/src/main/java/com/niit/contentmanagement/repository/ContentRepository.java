package com.niit.contentmanagement.repository;

import com.niit.contentmanagement.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends MongoRepository<Content,Integer> {
}
