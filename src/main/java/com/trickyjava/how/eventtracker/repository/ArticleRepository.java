package com.trickyjava.how.eventtracker.repository;

import com.trickyjava.how.eventtracker.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ArticleRepository extends MongoRepository<Article, String>, QueryByExampleExecutor<Article> {
    Article findByHash(String hash);
}
