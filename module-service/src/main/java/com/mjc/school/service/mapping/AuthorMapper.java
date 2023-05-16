package com.mjc.school.service.mapping;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    AuthorModel mapAuthorRequestDtoToAuthor(AuthorRequestDto authorDtoRequest);

    AuthorModel mapAuthorResponseDtoToAuthor(AuthorResponseDto authorDtoResponse);

    AuthorResponseDto mapAuthorToAuthorResponseDto(AuthorModel authorModel);

    AuthorRequestDto mapAuthorToAuthorRequestDto(AuthorModel authorModel);

    List<AuthorResponseDto> listAuthorsToAuthorResponseDto(List<AuthorModel> authorModelList);
}
