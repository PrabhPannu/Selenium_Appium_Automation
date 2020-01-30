package com.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupWebDriver {

    WebDriver driver;
    public void SetupWebDriver(){
        if(driver==null) {
            System.setProperty("webdriver.chrome.driver", "/Users/h/Downloads/chromedriver");
            driver = new ChromeDriver();
        }

    }
}
