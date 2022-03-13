package org.example.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.constants.Constants;
import org.example.driver.DriverManager;
import org.example.listener.TestListener;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

@Listeners({ TestListener.class })
public class MobileBasePage {

    static Logger logger = LogManager.getLogger(MobileBasePage.class);

    protected AppiumDriver driver;


    public void putText(WebElement element, String text) {
        logger.debug("putText");
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

    }
    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }
}
