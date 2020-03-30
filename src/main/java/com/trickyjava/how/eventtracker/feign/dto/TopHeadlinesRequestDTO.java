package com.trickyjava.how.eventtracker.feign.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopHeadlinesRequestDTO {
    private String key;
    private String country;
    private String category;
}
