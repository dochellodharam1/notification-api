package com.trickyjava.how.eventtracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "article")
public class Article {
    @Id
    private String id;
    private String hash;
    private String sourceName;
    private String title;
    private String author;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;
}
