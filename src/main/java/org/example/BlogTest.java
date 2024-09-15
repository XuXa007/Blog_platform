package org.example;

import org.junit.jupiter.api.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Date;

class BlogTest {
    @Test
    void testAddAndRemoveArticle() {
        Blog blog = new Blog();
        Article article = new Article("Test Article", "John Doe", new Date(), 5);
        blog.addArticle(article);

        assertEquals(1, blog.getArticles().size());
        assertTrue(blog.removeArticle("Test Article"));
        assertEquals(0, blog.getArticles().size());


    }

}
