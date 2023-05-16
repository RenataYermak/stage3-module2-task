package com.mjc.school.service.mapping;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    NewsModel mapNewsRequestDtoToNews(NewsRequestDto dto);

    @Mapping(target = "authorDto", expression =
                    "java(news.getAuthorId() != null ? authorService.readById(news.getAuthorId()) : null)")
    NewsResponseDto mapNewsToNewsResponseDto(NewsModel news);

    List<NewsResponseDto> mapNewsToNewsResponseDtoList(List<NewsModel> newsCollection);
}

