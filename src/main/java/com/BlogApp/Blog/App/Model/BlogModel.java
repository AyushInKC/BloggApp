package com.BlogApp.Blog.App.Model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "Data")
public class BlogModel {
    @Id
    private String id;
    private String title;
    private String description;
    private byte[] image;
}
