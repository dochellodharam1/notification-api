package com.trickyjava.how.eventtracker.feign.dto;

import com.trickyjava.how.eventtracker.model.Article;
import lombok.Data;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

@Data
public class ArticleDTO implements Supplier<Article> {
    private ArticleSourceDTO source;
    private String title;
    private String author;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;


    @Override
    public Article get() {
        Article article = new Article();
        article.setAuthor(author);
        article.setDescription(description);
        article.setPublishedAt(publishedAt);
        article.setSourceName(Optional.ofNullable(source)
                .map(ArticleSourceDTO::getName)
                .orElse(null));
        article.setTitle(title);
        article.setUrl(url);
        article.setUrlToImage(urlToImage);
        return article;
    }
}
