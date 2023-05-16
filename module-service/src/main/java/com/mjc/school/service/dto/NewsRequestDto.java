package com.mjc.school.service.dto;

import lombok.Value;

@Value
public class NewsRequestDto {

    Long id;
    String title;
    String content;
    Long authorId;

}
