package com.trickyjava.how.eventtracker.feign;


import com.trickyjava.how.eventtracker.feign.dto.TopHeadlinesResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "NewsAPIOrgFeign", url = "http://newsapi.org/v2")
public interface NewsAPIOrgFeign {

    @RequestMapping(path = "/top-headlines?apiKey={apiKey}&country={country}&category={category}")
    TopHeadlinesResponseDTO fetchArticles(@PathVariable("apiKey") String key,
                                          @PathVariable("country") String country,
                                          @PathVariable("category") String category);
}
