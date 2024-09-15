package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Blog {
    private List<Article> articles;
    private static final Logger logger = Logger.getLogger(Blog.class.getName());

    public Blog () {
        this.articles=new ArrayList<>();
    }
    public void addArticle(Article article){
        articles.add(article);
        logger.info("Added article: " + article.getTitle());
    }

    public List<Article> filterByAuthor (String author) {
        return articles.stream()
                .filter(article -> article.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Article> sortByDateAscending() {
        return articles.stream()
                .sorted(Comparator.comparing(Article::getPublishedDate))
                .collect(Collectors.toList());
    }

    public List<Article> sortByDateDescending() {
        return articles.stream()
                .sorted(Comparator.comparing(Article::getPublishedDate).reversed())
                .collect(Collectors.toList());
    }

    public List<Article> sortByLikes() {
        return articles.stream()
                .sorted(Comparator.comparingInt(Article::getLikes).reversed())
                .collect(Collectors.toList());
    }

    public Iterator<Article> getIterator() {
        return articles.iterator();
    }

    public boolean updateArticle(String title, Article updatedArticle) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTitle().equals(title)) {
                articles.set(i, updatedArticle);
                return true;
            }
        }
        return false;
    }

    public boolean removeArticle(String title) {
        boolean removed = articles.removeIf(article -> article.getTitle().equals(title));
        if (removed) {
            logger.info("Removed article: " + title);
        }
        return removed;
    }

}
