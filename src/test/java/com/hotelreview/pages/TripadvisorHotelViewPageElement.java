/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelreview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Paul
 */
public class TripadvisorHotelViewPageElement {

    //This contains elements of hotelview page
    @FindBy(xpath = "//a[text()='Write a review']")
    public WebElement writeReviewButton;

    public TripadvisorHotelViewPageElement(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
}
