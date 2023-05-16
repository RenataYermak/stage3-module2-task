package com.mjc.school.service.impl;

import com.mjc.school.repository.impl.NewsRepository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.mapping.NewsMapper;
import com.mjc.school.service.validation.annotation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService implements BaseService<NewsRequestDto, NewsResponseDto, Long> {

    private final NewsRepository newsRepository;
    private final NewsMapper mapper = NewsMapper.INSTANCE;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsResponseDto> readAll() {
        return mapper.mapNewsToNewsResponseDtoList(newsRepository.readAll());
    }

    @Validate(value = "checkNewsId")
    @Override
    public NewsResponseDto readById(Long id) {
        if (newsRepository.existById(id)) {
            Optional<NewsModel> optionalNewsModel = newsRepository.readById(id);
            return mapper.mapNewsToNewsResponseDto(optionalNewsModel.get());
        } else {
            throw new NotFoundException(String.format("News with ID %d not found.", id));
        }
    }

    @Validate(value = "checkNews")
    @Override
    public NewsResponseDto create(NewsRequestDto newsRequestDto) {
        NewsModel news = mapper.mapNewsRequestDtoToNews(newsRequestDto);
        LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        news.setCreateDate(localDateTime);
        news.setLastUpdateDate(localDateTime);
        NewsModel savedNews = newsRepository.create(news);
        return mapper.mapNewsToNewsResponseDto(savedNews);
    }

    @Validate(value = "checkNews")
    @Override
    public NewsResponseDto update(NewsRequestDto newsRequestDto) {
        if (newsRepository.existById(newsRequestDto.getId())) {
            NewsModel news = mapper.mapNewsRequestDtoToNews(newsRequestDto);
            LocalDateTime updatedDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            news.setLastUpdateDate(updatedDate);
            NewsModel savedNews = newsRepository.update(news);
            return mapper.mapNewsToNewsResponseDto(savedNews);
        } else {
            throw new NotFoundException(String.format("News with ID %d not found.", newsRequestDto.getId()));
        }
    }

    @Validate(value = "checkNewsId")
    public boolean deleteById(Long id) {
        if (newsRepository.existById(id)) {
            return newsRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("News with ID %d not found.", id));
        }
    }
}
