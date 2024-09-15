package org.example;

import java.util.Date;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Blog blog = new Blog();

        blog.addArticle(new Article("Java Collections", "John Doe", new Date(123456789), 15));
        blog.addArticle(new Article("Spring Boot Basics", "Jane Smith", new Date(223456789), 25));
        blog.addArticle(new Article("Concurrency in Java", "John Doe", new Date(323456789), 10));


        System.out.println("Articles by John Doe:");
        blog.filterByAuthor("John Doe").forEach(System.out::println);

        System.out.println("\nArticles sorted by date (ascending):");
        blog.sortByDateAscending().forEach(System.out::println);

        System.out.println("\nArticles sorted by likes:");
        blog.sortByLikes().forEach(System.out::println);


        System.out.println("\nIterating through articles:");
        Iterator<Article> iterator = blog.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Article updatedArticle = new Article("Concurrency in Java", "John Doe", new Date(), 20);
        boolean isUpdated = blog.updateArticle("Concurrency in Java", updatedArticle);
        System.out.println("Article updated: " + isUpdated);

        boolean isRemoved = blog.removeArticle("Java Collections");
        System.out.println("Article removed: " + isRemoved);


    }
}