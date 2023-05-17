package com.mjc.school.service.mapping;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AuthorMapper {

    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    public abstract AuthorModel mapAuthorRequestDtoToAuthor(AuthorRequestDto authorDtoRequest);

    public abstract  AuthorResponseDto mapAuthorToAuthorResponseDto(AuthorModel authorModel);

    public abstract List<AuthorResponseDto> listAuthorsToAuthorResponseDto(List<AuthorModel> authorModelList);
}
