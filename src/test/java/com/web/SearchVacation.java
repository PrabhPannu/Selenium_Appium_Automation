package com.web;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static com.web.Utility.capture;

public class SearchVacation extends SetupWebDriver {
    ExtentReports extentReports;
    ExtentTest test;
   @BeforeTest
   public void setup() throws InterruptedException {
       SetupWebDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://www.travelocity.ca/");
       Thread.sleep(2000);
   }
    @Test
    public void SearchVacation() throws InterruptedException, IOException {
        extentReports = new ExtentReports (System.getProperty("user.dir") +"/TravelocityReport.html", true);
        test = extentReports.startTest("Test 1");
        WebElement Vacations =  driver.findElement(By.xpath("//*[@id=\"tab-threePP-tab-hp\"]"));
        Vacations.click();
        test.log(LogStatus.INFO,"vacations"  );
        Thread.sleep(3000);
        Select LeavingDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"threePP-origin-hp-threepp\"]")));
        LeavingDropDown.selectByValue("YYZ");
        Thread.sleep(3000);
        WebElement GoingTo=  driver.findElement(By.xpath("//*[@id=\"tab-threePP-tab-hp\"]"));
        GoingTo.click();
        driver.findElement(By.xpath("//option[contains(text(),'Cancun')]")).click();
        test.log(LogStatus.INFO,"going to"  );
        WebElement DepartingDate = driver.findElement(By.xpath("//*[@id=\"threePP-departing-date-hp-threepp\"]"));
        DepartingDate.clear();
        test.log(LogStatus.INFO,"departingdate"  );
        DepartingDate.sendKeys("31/01/2020");
        WebElement Duration =  driver.findElement(By.xpath("//select[@name='duration']//following::option[text()='3 days']"));
        Duration.click();
        test.log(LogStatus.INFO,"duration"  );
        WebElement AdultCount = driver.findElement(By.xpath("//select[@name='adultCount']//following-sibling::option[@value='3']"));
        AdultCount.click();
        test.log(LogStatus.INFO,"adultcount"  );
        WebElement Search = driver.findElement(By.xpath("//*[@id=\"gcw-threePP-form-hp-threepp\"]/div[6]/label/button"));
        Search.click();
        test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "com.web.Vacation Searched");
        test.log(LogStatus.INFO,"search"  );

   }
   @AfterTest
    public  void tearDown()
   {
       extentReports.endTest(test);
       extentReports.flush();
       driver.quit();
   }

}


