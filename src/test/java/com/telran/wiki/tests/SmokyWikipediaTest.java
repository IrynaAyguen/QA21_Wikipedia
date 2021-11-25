package com.telran.wiki.tests;

import org.testng.annotations.Test;

public class SmokyWikipediaTest extends TestBase{

    @Test
    public void addArticleAndRemoveTest() throws InterruptedException {
        System.out.println("app launch");

        app.getArticle().search();
        app.getArticle().addToFavorites();
        app.getArticle().createReadingList();
        app.getArticle().close();
        app.getArticle().goToFavorites();
        Thread.sleep(2000);
        app.getArticle().moveElementRightToLeft();
    }
}
