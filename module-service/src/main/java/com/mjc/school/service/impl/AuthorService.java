package com.mjc.school.service.impl;

import com.mjc.school.repository.impl.AuthorRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.mapping.AuthorMapper;
import com.mjc.school.service.validation.annotation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AuthorService implements BaseService<AuthorRequestDto, AuthorResponseDto, Long> {

    private final AuthorRepository authorRepository;
    private final AuthorMapper mapper = AuthorMapper.INSTANCE;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Validate
    @Override
    public List<AuthorResponseDto> readAll() {
        return mapper.listAuthorsToAuthorResponseDto(authorRepository.readAll());
    }

    @Validate(value = "checkAuthorId")
    @Override
    public AuthorResponseDto readById(Long id) {
        if (authorRepository.existById(id)) {
            return mapper.mapAuthorToAuthorResponseDto(authorRepository.readById(id).get());
        } else {
            throw new NotFoundException(String.format("Author with ID %d not found.", id));
        }
    }

    @Validate(value = "checkAuthor")
    @Override
    public AuthorResponseDto create(AuthorRequestDto authorRequestDto) {
        AuthorModel authorModel = mapper.mapAuthorRequestDtoToAuthor(authorRequestDto);
        LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        authorModel.setCreateDate(localDateTime);
        authorModel.setLastUpdateDate(localDateTime);
        AuthorModel createdAuthorModel = authorRepository.create(authorModel);
        return mapper.mapAuthorToAuthorResponseDto(createdAuthorModel);
    }

    @Validate(value = "checkAuthor")
    @Override
    public AuthorResponseDto update(AuthorRequestDto authorRequestDto) {
        if (authorRepository.existById(authorRequestDto.getId())) {
            AuthorModel authorModel = mapper.mapAuthorRequestDtoToAuthor(authorRequestDto);
            LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            authorModel.setName(authorRequestDto.getName());
            authorModel.setLastUpdateDate(localDateTime);
            return mapper.mapAuthorToAuthorResponseDto(authorRepository.update(authorModel));
        } else {
            throw new NotFoundException(String.format("Author with ID %d not found.", authorRequestDto.getId()));
        }
    }

    @Validate(value = "checkAuthorId")
    @Override
    public boolean deleteById(Long id) {
        if (authorRepository.existById(id)) {
            return authorRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("Author with ID %d not found.", id));
        }
    }
}