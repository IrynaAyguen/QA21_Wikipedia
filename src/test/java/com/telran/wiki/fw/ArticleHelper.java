package com.telran.wiki.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticleHelper extends HelperBase{

    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void search() {
       tap(By.id("search_container"));
       type(By.id("search_src_text"),"TCP/IP");
       tap(By.id("page_list_item_container"));
       String title =driver.findElement(By.id("view_page_title_text")).getText();
        System.out.println(title);

    }

    public void addToFavorites() {
        tap(By.xpath("//android.widget.ImageView[@content-desc=\"Add this article to a reading list\"]"));

    }

    public void createReadingList() {
        tap(By.id("org.wikipedia:id/onboarding_button"));  //Got it
        //type(By.id("org.wikipedia:id/text_input"),"Favorites"); //?


    }

    public void close() {
        tap(By.id("android:id/button1"));
    }

    public void goToFavorites() {
        tap(By.id("org.wikipedia:id/snackbar_action"));
    }



}
