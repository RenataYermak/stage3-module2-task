package com.mjc.school.repository;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataSource {
    private static volatile DataSource INSTANCE;
    private final static String titleFile = "/news";
    private final static String authorFile = "/authors";
    private final static String contentFile = "/content";
    private final static int newsAmount = 20;
    private final static int authorsAmount = 20;
    private final List<NewsModel> newsModelList = new ArrayList<>();
    private final List<AuthorModel> authorModelList = new ArrayList<>();

    @Autowired
    public DataSource() throws IOException {
        FileUtils fileUtils = new FileUtils();
        List<String> authors = fileUtils.readFromFile(authorFile);
        List<String> titles = fileUtils.readFromFile(titleFile);
        List<String> contents = fileUtils.readFromFile(contentFile);

        fillNews(titles, contents);
        fillAuthors(authors);
    }

    public static DataSource getInstance() throws IOException {
        DataSource result = INSTANCE;
        if (result == null) {
            synchronized (DataSource.class) {
                result = INSTANCE;
                if (result == null)
                    INSTANCE = result = new DataSource();
            }
        }
        return result;
    }

    private void fillAuthors(List<String> authors) {
        for (int i = 0; i < authorsAmount; i++) {
            Random random = new Random();
            LocalDateTime now = LocalDateTime.now();

            LocalDateTime created = now.minusDays(30 + random.nextInt(30));
            LocalDateTime updated = now.minusDays(random.nextInt(30));
            AuthorModel author = new AuthorModel((long) i, authors.get(i), created, updated);
            authorModelList.add(author);

        }
    }

    private void fillNews(List<String> titles, List<String> contents) {
        for (int i = 0; i < newsAmount; i++) {
            Random random = new Random();
            LocalDateTime now = LocalDateTime.now();

            String title = titles.get(i);
            String content = contents.get(i);
            LocalDateTime created = now.minusDays(30 + random.nextInt(30));
            LocalDateTime updated = now.minusDays(random.nextInt(30));

            NewsModel news = new NewsModel((long) i, title, content, created, updated,(long) i);
            newsModelList.add(news);
        }
    }

    public List<NewsModel> getNewsModelList() {
        return this.newsModelList;
    }

    public List<AuthorModel> getAuthorModelList() {
        return this.authorModelList;
    }
}
