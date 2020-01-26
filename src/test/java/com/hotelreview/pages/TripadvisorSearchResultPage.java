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
public class TripadvisorSearchResultPage {

    //This contains the list of titles of all hotels after searching
    @FindBy(xpath = "//div[@class='result-title']")
    public List<WebElement> hotelList;

    public TripadvisorSearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
