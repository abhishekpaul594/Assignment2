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
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Paul
 */
public class TripadvisorPageElement {

    //This contains home page elements
    @FindBy(xpath = "//a[@href='/Hotels']")
    public WebElement hotelsIcon;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    public WebElement searchbox;

    @FindBy(xpath = "//span[contains(text(),'Club Mahindra')]")
    public WebElement searchLink;

    public TripadvisorPageElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
