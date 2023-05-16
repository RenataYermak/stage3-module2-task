//package com.mjc.school.service.impl;
//
//import com.mjc.school.service.dto.NewsRequestDto;
//import com.mjc.school.service.dto.NewsResponseDto;
//import com.mjc.school.service.exception.NotFoundException;
//import com.mjc.school.service.exception.ValidationException;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringJUnitConfig
//class NewsServiceTest {
//
//    @Autowired
//    private NewsService newsService;
//
//    @Test
//    void create() {
//        NewsRequestDto newsResponseDto = new NewsRequestDto(1L, "Test news.txt", "This is a test news.txt", 1L);
//
//        NewsResponseDto createdNews = newsService.create(newsResponseDto);
//
//        assertNotEquals(createdNews.getId(), 0L);
//        assertEquals(newsResponseDto.getTitle(), createdNews.getTitle());
//        assertEquals(newsResponseDto.getContent(), createdNews.getContent());
//        assertEquals(newsResponseDto.getAuthorId(), createdNews.getAuthorId());
//    }
//
//    @Test
//    void getAll() {
//        List<NewsResponseDto> freshNewsList = newsService.readAll();
//        assertNotEquals(freshNewsList.size(), 0);
//
//        NewsRequestDto newsResponseDto1 = new NewsRequestDto(1L, "Some title news1.txt", "Some description news1.txt", 1L);
//        NewsRequestDto newsResponseDto2 = new NewsRequestDto(1L, "Some title news2.txt", "Some description news1.txt", 2L);
//        NewsResponseDto created1 = newsService.create(newsResponseDto1);
//        NewsResponseDto created2 = newsService.create(newsResponseDto2);
//        List<NewsResponseDto> newsList = newsService.readAll();
//
//        assertTrue(newsList.containsAll(List.of(created1, created2)));
//    }
//
//    @Test
//    void getById() {
//        NewsRequestDto newsResponseDto = new NewsRequestDto(1L, "Some title news.txt", "Some title news.txt", 1L);
//        NewsResponseDto createdNews = newsService.create(newsResponseDto);
//
//        NewsResponseDto retrievedNews = newsService.readById(createdNews.getId());
//
//        assertEquals(createdNews, retrievedNews);
//    }
//
//    @Test
//    void update() {
//        NewsRequestDto updatedNewsRequestDto = new NewsRequestDto(1L, "Updated test news.txt", "Updated test news.txt", 2L);
//
//        NewsResponseDto updatedNews = newsService.update(updatedNewsRequestDto);
//
//        assertEquals(updatedNewsRequestDto.getTitle(), updatedNews.getTitle());
//        assertEquals(updatedNewsRequestDto.getContent(), updatedNews.getContent());
//        assertEquals(updatedNewsRequestDto.getAuthorId(), updatedNews.getAuthorId());
//    }
//
//    @Test
//    void delete() {
//        NewsRequestDto newsResponseDto = new NewsRequestDto(1L, "Some title news.txt", "Some title news.txt", 1L);
//        NewsResponseDto createdNews = newsService.create(newsResponseDto);
//
//        newsService.deleteById(createdNews.getId());
//        List<NewsResponseDto> newsList = newsService.readAll();
//
//        assertFalse(newsList.contains(createdNews));
//        assertThrows(NotFoundException.class, () -> newsService.readById(createdNews.getId()));
//    }
//
//    @Test
//    public void testCreateNewsWithInvalidData() {
//        NewsRequestDto newsResponseDto = new NewsRequestDto(1L, "INL", "INL", 1L);
//
//        assertThrows(ValidationException.class, () -> newsService.create(newsResponseDto));
//    }
//
//    @Test
//    public void testUpdateNonExistingNews() {
//        NewsRequestDto newsResponseDto = new NewsRequestDto(100000000L, "Some title news.txt", "Some title news.txt", 100000000L);
//
//        assertThrows(NotFoundException.class, () -> newsService.update(newsResponseDto));
//    }
//}
