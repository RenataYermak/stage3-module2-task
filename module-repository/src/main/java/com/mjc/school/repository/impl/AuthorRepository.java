package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.model.AuthorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {

    private final DataSource dataSource;

    @Autowired
    public AuthorRepository() throws IOException {
        dataSource = DataSource.getInstance();
    }

    @Override
    public List<AuthorModel> readAll() {
        return dataSource.getAuthorModelList();
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return Optional.of(dataSource.getAuthorModelList()
                .stream()
                .filter(authorModel -> authorModel.getId().equals(id))
                .findFirst()
                .get());
    }

    @Override
    public AuthorModel create(AuthorModel author) {
        List<AuthorModel> authorModelList = dataSource.getAuthorModelList();
        authorModelList.sort(Comparator.comparing(AuthorModel::getId));
        if (!authorModelList.isEmpty()) {
            author.setId(authorModelList.get(authorModelList.size() - 1).getId() + 1);
        } else {
            author.setId(1L);
        }
        authorModelList.add(author);
        return author;
    }

    @Override
    public AuthorModel update(AuthorModel author) {
        Optional<AuthorModel> authorModel = readById(author.getId());
        if (authorModel.isPresent()) {
            authorModel.get().setName(author.getName());
            authorModel.get().setLastUpdateDate(author.getLastUpdateDate());
            return authorModel.get();
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return dataSource.getAuthorModelList().remove(readById(id).get());
    }

    @Override
    public boolean existById(Long id) {
        return dataSource
                .getAuthorModelList()
                .stream()
                .anyMatch(authorModel -> authorModel.getId().equals(id));
    }
}
