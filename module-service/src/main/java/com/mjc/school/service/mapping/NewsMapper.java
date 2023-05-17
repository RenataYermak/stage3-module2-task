package com.mjc.school.service.mapping;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class NewsMapper {

    @Autowired
    protected BaseService<AuthorRequestDto, AuthorResponseDto, Long> authorService;


    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    public abstract NewsModel mapNewsRequestDtoToNews(NewsRequestDto dto);

    @Mapping(target = "authorDto", expression =
            "java(news.getAuthorId() != null ? authorService.readById(news.getAuthorId()) : null)")
    public abstract NewsResponseDto mapNewsToNewsResponseDto(NewsModel news);

    public abstract List<NewsResponseDto> mapNewsToNewsResponseDtoList(List<NewsModel> newsCollection);
}

