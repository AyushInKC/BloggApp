package com.BlogApp.Blog.App.Controller;

import com.BlogApp.Blog.App.Model.BlogModel;
import com.BlogApp.Blog.App.Repository.BlogRepository;
import com.BlogApp.Blog.App.Serivce.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogService blogService;
    @PostMapping("/createBlog")
    public ResponseEntity<?> createBlog(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("image")MultipartFile image){
   try{
       BlogModel savedBlog=blogService.createBlog(title,description,image);
       return ResponseEntity.ok(savedBlog);
   }
   catch (Exception e){
       return  ResponseEntity.status(500).body("Error in saving the blog->"+e.getMessage());
   }
    }

   @GetMapping("/listAll")
    public ResponseEntity<?> listAll() {
       try {
           List<BlogModel> blogs = blogService.listAll();
           return ResponseEntity.ok(blogs);
       }
       catch (Exception e){
           return ResponseEntity.status(500).body("Error in fetching blogs->" + e.getMessage());
       }
   }

    @GetMapping("/findByTitle")
    public ResponseEntity<?> findByTitle(@RequestParam("title") String title) {
        try {
            Optional<BlogModel> blog = blogService.getBlogByTitle(title);
            if (blog.isPresent()) {
                return ResponseEntity.ok(blog.get());
            } else {
                return ResponseEntity.status(404).body("Blog not found with title: " + title);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching blog: " + e.getMessage());
        }
    }

}
