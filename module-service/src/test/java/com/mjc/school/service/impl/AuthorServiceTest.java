//package com.mjc.school.service.impl;
//
//import com.mjc.school.repository.impl.AuthorRepository;
//import com.mjc.school.repository.model.AuthorModel;
//import com.mjc.school.service.dto.AuthorRequestDto;
//import com.mjc.school.service.dto.AuthorResponseDto;
//import com.mjc.school.service.exception.NotFoundException;
//import com.mjc.school.service.mapping.AuthorMapper;
//import com.mjc.school.service.validation.annotation.Validate;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class AuthorServiceTest {
//
//    @Mock
//    private AuthorMapper mapper;
//
//    @Mock
//    private AuthorRepository authorRepository;
//
//    @InjectMocks
//    private AuthorService authorService;
//
//    private AuthorModel authorModel;
//    private AuthorResponseDto authorResponseDto;
//
//    LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
////
////
////    @DisplayName("JUnit test for create method")
////    @Test
////    void shouldCreateAuthorModelSuccessfully() throws NotFoundException {
////
////        AuthorRequestDto authorDto = new AuthorRequestDto(1L, "Author Name");
////
////        AuthorModel authorModel = new AuthorModel(1L, "Author Name", now, now);
////
////        when(mapper.mapAuthorRequestDtoToAuthor(authorDto)).thenReturn(authorModel);
////        when(authorRepository.create(any(AuthorModel.class))).thenReturn(authorModel);
////        when(mapper.mapAuthorToAuthorResponseDto(authorModel)).thenReturn(new AuthorResponseDto(1L, "Author Name", now, now));
////
////        AuthorResponseDto result = authorService.create(authorDto);
////
////        verify(mapper, times(1)).mapAuthorRequestDtoToAuthor(authorDto);
////        verify(authorRepository, times(1)).create(authorModel);
////        verify(mapper, times(1)).mapAuthorToAuthorResponseDto(authorModel);
////
////    }
//
////    @Validate(value = "checkAuthor")
////    @Override
////    public AuthorResponseDto create(AuthorRequestDto authorRequestDto) {
////        AuthorModel authorModel = mapper.mapAuthorRequestDtoToAuthor(authorRequestDto);
////        LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
////        authorModel.setCreatedDate(localDateTime);
////        authorModel.setUpdatedDate(localDateTime);
////        AuthorModel createdAuthorModel = authorRepository.create(authorModel);
////        return mapper.mapAuthorToAuthorResponseDto(createdAuthorModel);
////    }
//
////
////    @DisplayName("JUnit test for update method")
////    @Test
////    void shouldUpdateAuthorModelSuccessFully() throws NotFoundException {
////        Long id = 1L;
////
////        AuthorModel authorModel = new AuthorModel();
////        authorModel.setId(id);
////        authorModel.setName("Author Name");
////        authorModel.setCreateDate(now);
////        authorModel.setLastUpdatedDate(now);
////
////        AuthorModel updatedAuthorModel = new AuthorModel();
////        updatedAuthorModel.setId(id);
////        updatedAuthorModel.setName("Author Name");
////        updatedAuthorModel.setCreateDate(now);
////        updatedAuthorModel.setLastUpdatedDate(now);
////
////        AuthorDtoRequest authorDtoRequest = new AuthorDtoRequest(id, "Author Name");
////
////        AuthorDtoResponse authorDtoResponse = new AuthorDtoResponse(id, "Author Name", now, now);
////
////        when(authorRepository.existById(id)).thenReturn(true);
////        when(mapper.dtoToModel(authorDtoRequest)).thenReturn(authorModel);
////        when(authorRepository.update(any(AuthorModel.class))).thenReturn(authorModel);
////        when(mapper.modelToDto(any(AuthorModel.class))).thenReturn(authorDtoResponse);
////
////        AuthorDtoResponse result = authorService.update(authorDtoRequest);
////
////        assertEquals(authorDtoResponse, result);
////    }
////
////
////    @DisplayName("JUnit test for readAll method")
////    @Test
////    void testReadAll() {
////        List<AuthorModel> authorModels = new ArrayList<>();
////        authorModels.add(new AuthorModel(1L, "Author Name 1"));
////        authorModels.add(new AuthorModel(2L, "Author Name 2"));
////
////        List<AuthorDtoResponse> authorDtoResponses = new ArrayList<>();
////        authorDtoResponses.add(new AuthorDtoResponse(1L, "Author Name 1", now, now));
////        authorDtoResponses.add(new AuthorDtoResponse(2L, "Author Name 2", now, now));
////
////        when(authorRepository.readAll()).thenReturn(authorModels);
////        when(mapper.modelListToDtoList(authorModels)).thenReturn(authorDtoResponses);
////
////        List<AuthorDtoResponse> result = authorService.readAll();
////
////        assertEquals(authorDtoResponses, result);
////    }
////
////
////    @DisplayName("JUnit test for readById method")
////    @Test
////    void readByIdTest() {
////        Long id = 1L;
////
////        AuthorModel authorModel = new AuthorModel();
////        authorModel.setId(id);
////        authorModel.setName("Author Name");
////        authorModel.setCreateDate(now);
////        authorModel.setLastUpdatedDate(now);
////
////        AuthorDtoResponse authorDtoResponse = new AuthorDtoResponse(id, "Author Name", now, now);
////
////        when(authorRepository.existById(anyLong())).thenReturn(true);
////        when(authorRepository.readById(anyLong())).thenReturn(Optional.of(authorModel));
////        when(mapper.modelToDto(authorModel)).thenReturn(authorDtoResponse);
////
////        AuthorDtoResponse result = authorService.readById(1L);
////
////        assertEquals(authorDtoResponse, result);
////    }
////
////
////    @DisplayName("JUnit test for deleteById method")
////    @Test
////    void testDeleteById() {
////        Long id = 1L;
////        when(authorRepository.existById(id)).thenReturn(true);
////        when(authorRepository.deleteById(id)).thenReturn(true);
////
////
////        boolean deleted = authorService.deleteById(id);
////
////        assertTrue(deleted);
////        verify(authorRepository, times(1)).existById(id);
////        verify(authorRepository, times(1)).deleteById(id);
////    }
////
////    @DisplayName("JUnit test for deleteByIdNonExisting")
////    @Test
////    public void testDeleteByIdNonExisting() {
////        Long id = 1L;
////        when(authorRepository.existById(id)).thenReturn(false);
////
////        assertThrows(NotFoundException.class, () -> authorService.deleteById(id));
////        verify(authorRepository, times(1)).existById(id);
////        verify(authorRepository, never()).deleteById(id);
////    }
//}
//
