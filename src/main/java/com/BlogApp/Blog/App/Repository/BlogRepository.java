package com.BlogApp.Blog.App.Repository;

import com.BlogApp.Blog.App.Model.BlogModel;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.util.Optional;

public interface BlogRepository extends MongoRepository<BlogModel, String> {
    Optional<BlogModel> findByTitle(String title);
}
