/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelreview.beforetestmethods;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Paul
 */
public class BeforeTestMethods {

    public static WebDriver driver = null;
    static String ChromedriverPath = System.getProperty("user.dir") + "//src/test/java/com/hotelreview/chromedriver/chromedriver.exe";

    //This launch the browser
    public static WebDriver launchBrowser() throws Exception {
        try {
            System.setProperty("webdriver.chrome.driver", ChromedriverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            return driver;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return driver;
    }
}
