/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelreview.testPackage;

import com.hotelreview.beforetestmethods.BeforeTestMethods;
import com.hotelreview.pagelevelmodule.TripadvisorPageModule;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Paul
 */
public class HotelReviewSuiteTestCases {

    static public WebDriver driver = null;
    TripadvisorPageModule taPageModule = null;

    @BeforeTest
    public void launchMethod() {
        try {
            driver = BeforeTestMethods.launchBrowser();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Test
    public void reviewHotel() {
        try {
            WebElement hoteslsLink, searchbox, searchicon, searchLink, reviewButton, overAllRating, reviewTitle, reviewText, hotelRatingsSectionHeader, hotelRatingService, hotelRatingCleanliness, hotelRatingValue, submiteReviewCheckbox;
            List<WebElement> hotelListTitles;
            driver.get("https://www.tripadvisor.in/");
            taPageModule = new TripadvisorPageModule();
            hoteslsLink = taPageModule.HomePage("HotelsIcon", driver);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(hoteslsLink));
            hoteslsLink.click();
            searchbox = taPageModule.HomePage("Searchbox", driver);
            wait.until(ExpectedConditions.visibilityOf(searchbox));
            searchbox.clear();
            searchbox.sendKeys("Club Mahindra");
            searchLink = taPageModule.HomePage("SearchLink", driver);
            wait.until(ExpectedConditions.visibilityOf(searchLink));
            searchLink.click();
            hotelListTitles = taPageModule.SearchResultPage("HotelList", driver);
            wait.until(ExpectedConditions.visibilityOf(hotelListTitles.get(0)));
            hotelListTitles.get(0).click();
            taPageModule.switchToNewTab(driver);
            reviewButton = taPageModule.HotelViewPage("WriteReviewButton", driver);
            wait.until(ExpectedConditions.visibilityOf(reviewButton));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", reviewButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reviewButton);
            taPageModule.switchToNewTab(driver);
            overAllRating = taPageModule.reviewPage("OverallRating", driver);
            wait.until(ExpectedConditions.visibilityOf(overAllRating));
            taPageModule.setRating("OverallRating", driver);
            reviewTitle = taPageModule.reviewPage("ReviewTitle", driver);
            reviewText = taPageModule.reviewPage("ReviewText", driver);
            reviewTitle.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
            reviewText.sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
            hotelRatingsSectionHeader = taPageModule.reviewPage("HotelRatingSectionHeader", driver);

            try {

                if (hotelRatingsSectionHeader.isDisplayed()) {

                    taPageModule.setRating("DetailsRating", driver);

                }
            } catch (Exception ex) {
                System.err.println("Hotel rating section is not available");
            }
            submiteReviewCheckbox = taPageModule.reviewPage("SubmitReviewCheckbox", driver);
            js.executeScript("arguments[0].scrollIntoView();", submiteReviewCheckbox);
            submiteReviewCheckbox.click();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
