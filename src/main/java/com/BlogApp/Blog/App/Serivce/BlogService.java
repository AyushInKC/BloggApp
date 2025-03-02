package com.BlogApp.Blog.App.Serivce;

import com.BlogApp.Blog.App.Model.BlogModel;
import com.BlogApp.Blog.App.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public BlogModel createBlog(String title, String description, MultipartFile image) throws IOException {
        byte[] imgBytes=image.getBytes();
        BlogModel savedBlog=new BlogModel();
        savedBlog.setTitle(title);
        savedBlog.setDescription(description);
        savedBlog.setImage(imgBytes);
      return   blogRepository.save(savedBlog);
    }

    public List<BlogModel> listAll() {
        return blogRepository.findAll();
    }

    public Optional<BlogModel> getBlogByTitle(String title) {
        return blogRepository.findByTitle(title);
    }
}
