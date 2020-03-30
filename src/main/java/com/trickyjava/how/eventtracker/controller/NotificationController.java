package com.trickyjava.how.eventtracker.controller;

import com.trickyjava.how.eventtracker.model.Article;
import com.trickyjava.how.eventtracker.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private ArticleRepository articleRepository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Page<Article>> list(@PageableDefault(page = 0, size = 20)
                                              @SortDefault.SortDefaults({
                                                      @SortDefault(sort = "id", direction = Sort.Direction.ASC)
                                              }) Pageable pageable) {
        return ResponseEntity.ok(articleRepository.findAll(pageable));
    }
}
