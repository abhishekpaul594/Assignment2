/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelreview.pagelevelmodule;

import com.google.common.collect.Iterators;
import com.hotelreview.pages.TripadvisorHotelReviewPageElement;
import com.hotelreview.pages.TripadvisorHotelViewPageElement;
import com.hotelreview.pages.TripadvisorPageElement;
import com.hotelreview.pages.TripadvisorSearchResultPage;
import static com.hotelreview.testPackage.HotelReviewSuiteTestCases.driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Paul
 */
public class TripadvisorPageModule {

    static WebDriver driver;
    TripadvisorPageElement taPageElement;
    TripadvisorHotelReviewPageElement taHotelReviewElement;
    TripadvisorSearchResultPage taHotelSearchResultElement;
    TripadvisorHotelViewPageElement taHotelView;

    //This fetch the homepage elements of Tripadvisor
    public WebElement HomePage(String homepageElementName, WebDriver driver) {
        taPageElement = new TripadvisorPageElement(driver);
        WebElement homepageElement = null;
        try {
            if (homepageElementName.equals("HotelsIcon")) {
                homepageElement = taPageElement.hotelsIcon;
            } else if (homepageElementName.equals("Searchbox")) {
                homepageElement = taPageElement.searchbox;
            } else if (homepageElementName.equals("SearchLink")) {
                homepageElement = taPageElement.searchLink;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return homepageElement;
    }

    //This return an element list of all hoteltitles in searchresult page after searching a hotel
    public List<WebElement> SearchResultPage(String searchResultPageElementName, WebDriver driver) {
        List<WebElement> searchResultPageElement = null;
        taHotelSearchResultElement = new TripadvisorSearchResultPage(driver);
        try {
            if (searchResultPageElementName.equals("HotelList")) {
                searchResultPageElement = taHotelSearchResultElement.hotelList;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return searchResultPageElement;
    }

    //This fetch elements of hotelview page
    public WebElement HotelViewPage(String hotelViewPageElementName, WebDriver driver) {
        taHotelView = new TripadvisorHotelViewPageElement(driver);
        WebElement hotelViewPageElement = null;
        try {
            if (hotelViewPageElementName.equals("WriteReviewButton")) {
                hotelViewPageElement = taHotelView.writeReviewButton;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return hotelViewPageElement;
    }

    //This fetch elements of hotel review page
    public WebElement reviewPage(String reviewPageElementName, WebDriver driver) {
        taHotelReviewElement = new TripadvisorHotelReviewPageElement(driver);
        WebElement reviewPageElement = null;
        try {
            if (reviewPageElementName.equals("OverallRating")) {
                reviewPageElement = taHotelReviewElement.overallRating;
            } else if (reviewPageElementName.equals("ReviewTitle")) {
                reviewPageElement = taHotelReviewElement.reviewTitle;
            } else if (reviewPageElementName.equals("ReviewText")) {
                reviewPageElement = taHotelReviewElement.reviewText;
            } else if (reviewPageElementName.equals("HotelRatingSectionHeader")) {
                reviewPageElement = taHotelReviewElement.hotelRatingsSectionHeader;
            } else if (reviewPageElementName.equals("SubmitReviewCheckbox")) {
                reviewPageElement = taHotelReviewElement.submiteReviewCheckbox;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return reviewPageElement;
    }

    //This set the ratings of hotel in review page
    public void setRating(String ratingTitle, WebDriver driver) throws InterruptedException {
        List<WebElement> ratingElement = new ArrayList<WebElement>();
        int count = 0;
        //This set the overall rating and check if the stars are lighted up properly
        if (ratingTitle.equals("OverallRating")) {
            ratingElement.add(reviewPage("OverallRating", driver));
            for (int i = 0; i < ratingElement.size(); i++) {
                Actions actions = new Actions(driver);
                actions.moveToElement(ratingElement.get(i), 5, 5).build().perform(); //hover on first star
                if (ratingElement.get(i).getAttribute("class").endsWith("10")) {
                    count++;
                }
                Thread.sleep(500);
                actions.moveToElement(ratingElement.get(i), 50, 5).build().perform(); //hover on the second star
                if (ratingElement.get(i).getAttribute("class").endsWith("20")) {
                    count++;
                }
                Thread.sleep(500);
                actions.moveToElement(ratingElement.get(i), 75, 5).build().perform();//hover on the third star
                if (ratingElement.get(i).getAttribute("class").endsWith("30")) {
                    count++;
                }
                Thread.sleep(500);
                actions.moveToElement(ratingElement.get(i), 100, 5).build().perform();//hover on the fourth star
                if (ratingElement.get(i).getAttribute("class").endsWith("40")) {
                    count++;
                }
                Thread.sleep(500);
                actions.moveToElement(ratingElement.get(i), 150, 5).click().build().perform();//hover on the fifth star
                if (ratingElement.get(i).getAttribute("class").endsWith("50")) {
                    count++;
                }
                Thread.sleep(500);
                if (count == 5) {
                    System.out.println("All stars lighted up");
                } else {
                    System.out.println("All stars are not lighted up");
                }
                count = 0;
            }
        } //This set the details rating and check if the stars are lighted up properly
        else if (ratingTitle.equals("DetailsRating")) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", reviewPage("HotelRatingSectionHeader", driver));
            for (int i = 0; i < taHotelReviewElement.detailsRating.size(); i++) {
                Actions actions = new Actions(driver);
                actions.moveToElement(taHotelReviewElement.detailsRating.get(i), 5, 5).build().perform(); //Hover on first star
                if (taHotelReviewElement.detailsRating.get(i).getAttribute("class").endsWith("10")) {
                    count++;
                }
                Thread.sleep(500);
                actions.moveToElement(taHotelReviewElement.detailsRating.get(i), 25, 5).build().perform();//Hover on second star
                if (taHotelReviewElement.detailsRating.get(i).getAttribute("class").endsWith("20")) {
                    count++;
                }
                Thread.sleep(500);
                actions.moveToElement(taHotelReviewElement.detailsRating.get(i), 50, 5).build().perform();//Hover on third star
                if (taHotelReviewElement.detailsRating.get(i).getAttribute("class").endsWith("30")) {
                    count++;
                }
                Thread.sleep(500);
                actions.moveToElement(taHotelReviewElement.detailsRating.get(i), 75, 5).build().perform();//Hover on fourth star
                if (taHotelReviewElement.detailsRating.get(i).getAttribute("class").endsWith("40")) {
                    count++;
                }
                Thread.sleep(500);
                actions.moveToElement(taHotelReviewElement.detailsRating.get(i), 100, 5).click().build().perform();//Hover on fifth star
                if (taHotelReviewElement.detailsRating.get(i).getAttribute("class").endsWith("50")) {
                    count++;
                }
                Thread.sleep(500);
                if (count == 5) {
                    System.out.println("All stars lighted up");
                } else {
                    System.out.println("All stars are not lighted up");
                }
                count = 0;
            }
        }

    }

    //This method switches to newly opened tab in browser
    public void switchToNewTab(WebDriver driver) {
        String homeWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        Iterator<String> windowIterator = allWindows.iterator();

        while (windowIterator.hasNext()) {

            String childWindow = windowIterator.next();

            driver.switchTo().window(childWindow);

        }
    }

}
