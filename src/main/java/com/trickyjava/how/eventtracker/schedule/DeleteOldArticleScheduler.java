package com.trickyjava.how.eventtracker.schedule;

import com.trickyjava.how.eventtracker.model.Article;
import com.trickyjava.how.eventtracker.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeleteOldArticleScheduler {

    @Autowired
    private ArticleRepository articleRepository;

    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void deleteOldArticles() {
        keepOnly(100);
    }

    private boolean keepOnly(int count) {
        PageRequest pageRequest = PageRequest.of(1, count, Sort.by(Sort.Order.desc("publishedAt")));
        Page<Article> articles = articleRepository.findAll(pageRequest);
        articleRepository.deleteAll(articles);
        if (!articles.isLast()) {
            return keepOnly(count);
        }
        return true;
    }

}
