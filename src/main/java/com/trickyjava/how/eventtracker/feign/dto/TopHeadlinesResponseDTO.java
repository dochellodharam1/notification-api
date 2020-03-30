package com.trickyjava.how.eventtracker.feign.dto;

import com.trickyjava.how.eventtracker.model.Article;
import lombok.Data;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Data
public class TopHeadlinesResponseDTO implements Supplier<List<Article>> {
    private String status;
    private String totalResults;
    private List<ArticleDTO> articles;


    @Override
    public List<Article> get() {
        return articles
                .stream()
                .map(ArticleDTO::get)
                .collect(Collectors.toList());
    }
}
