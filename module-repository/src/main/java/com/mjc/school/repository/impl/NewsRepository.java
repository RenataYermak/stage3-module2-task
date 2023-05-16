package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.model.NewsModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<NewsModel, Long> {

    private final DataSource dataSource;

    public NewsRepository() throws IOException {
        dataSource = DataSource.getInstance();
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getNewsModelList();
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        return Optional.of(dataSource.getNewsModelList().stream()
                .filter(news -> Objects.equals(news.getId(), id))
                .findFirst()
                .get());
    }

    @Override
    public NewsModel create(NewsModel news) {
        List<NewsModel> newsModelList = dataSource.getNewsModelList();
        newsModelList.sort(Comparator.comparing(NewsModel::getId));
        if (!newsModelList.isEmpty()) {
            news.setId(newsModelList.get(newsModelList.size() - 1).getId() + 1);
        } else {
            news.setId(1L);
        }
        newsModelList.add(news);
        return news;
    }

    @Override
    public NewsModel update(NewsModel entity) {
        Optional<NewsModel> news = readById(entity.getId());
        if (news.isPresent()) {
            news.get().setTitle(entity.getTitle());
            news.get().setContent(entity.getContent());
            news.get().setAuthorId(entity.getAuthorId());
            news.get().setLastUpdateDate(LocalDateTime.now());
            return news.get();
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return dataSource.getNewsModelList().remove(readById(id).get());
    }

    @Override
    public boolean existById(Long id) {
        return dataSource
                .getNewsModelList()
                .stream()
                .anyMatch(newsModel -> Objects.equals(newsModel.getId(), id));
    }
}
