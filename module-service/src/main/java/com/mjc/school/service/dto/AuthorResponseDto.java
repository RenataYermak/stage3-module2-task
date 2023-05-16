package com.mjc.school.service.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class AuthorResponseDto {

    Long id;
    String name;
    LocalDateTime createDate;
    LocalDateTime lastUpdateDate;
}