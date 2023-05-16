package com.mjc.school.service.dto;

import lombok.Setter;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Setter
public class NewsResponseDto {

    Long id;
    String title;
    String content;
    LocalDateTime createDate;
    LocalDateTime lastUpdateDate;
    AuthorResponseDto authorDto;
}