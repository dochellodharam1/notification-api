package com.trickyjava.how.eventtracker.schedule;

import com.trickyjava.how.eventtracker.feign.NewsAPIOrgFeign;
import com.trickyjava.how.eventtracker.model.Article;
import com.trickyjava.how.eventtracker.repository.ArticleRepository;
import com.trickyjava.how.eventtracker.util.Utility;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class ArticleFetchScheduler {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private NewsAPIOrgFeign articleAPI;

    @Value("${news.api.key}")
    private String key;

    @Scheduled(fixedRate = 15 * 60 * 1000)
    public void fetchArticlesAndStore() {
        log.info("Fetching articles");
        List<Article> articles = articleAPI.fetchArticles(key, "in", "health").get();
        for (Article article : articles) {
            String hash = Utility.hash(article.getAuthor(), article.getTitle(), article.getPublishedAt().toString());
            Article savedArticle = articleRepository.findByHash(hash);
            if (null == savedArticle) {
                article.setHash(hash);
                articleRepository.save(article);
            }
        }
        log.info("Fetched total {} articles", articles.size());
    }
}
