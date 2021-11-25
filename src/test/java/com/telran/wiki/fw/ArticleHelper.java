package com.telran.wiki.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        tap(By.id("org.wikipedia:id/onboarding_button"));  //  Got it
        //type(By.id("org.wikipedia:id/text_input"),"My Favorites"); //  new name
    }

    public void close() {
        tap(By.id("android:id/button1"));
    }

    public void goToFavorites() {
        tap(By.id("org.wikipedia:id/snackbar_action"));
    }



    /*public void removeArticleFromFavorites() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int y = (int) (size.height/1.67);
        int startX = (int) (size.width*0.8);
        int stopX = (int) (size.width*0.2);

        action.longPress(PointOption.point(startX,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(stopX,y))
                .release()
                .perform();
    }
    */

        public void swipeToLeft(By locator) {
        TouchAction action = new TouchAction(driver);

        WebElement element = waitForElement(locator, 10);

        int leftX = (int) (element.getLocation().getX() * 0.3);
        int rightX = (int) (leftX + element.getSize().getWidth() * 0.8);
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        action.longPress(PointOption.point(rightX, middleY))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();
    }
}
