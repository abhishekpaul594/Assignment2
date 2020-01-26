/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelreview.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Paul
 */
public class TripadvisorHotelReviewPageElement {

    //This contains page of HotelReviewPage
    @FindBy(xpath = "//span[@id='bubble_rating']")
    public WebElement overallRating;

    @FindBy(xpath = "//input[@id='ReviewTitle']")
    public WebElement reviewTitle;

    @FindBy(xpath = "//textarea[@id='ReviewText']")
    public WebElement reviewText;

    @FindBy(xpath = "//div[text()='Hotel Ratings']")
    public WebElement hotelRatingsSectionHeader;

    @FindBy(xpath = "//div[@class='detailsRatings']/span")
    public List<WebElement> detailsRating;

    @FindBy(xpath = "//input[@id='noFraud']")
    public WebElement submiteReviewCheckbox;

    public TripadvisorHotelReviewPageElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
