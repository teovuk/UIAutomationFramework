package org.example.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.DriverManager;
import org.example.listener.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners({ TestListener.class })
public class WebBasePage {

    static Logger logger = LogManager.getLogger(WebBasePage.class);

    protected WebDriver webDriver = DriverManager.getWebDriver();
    public void initWebPage() throws Exception {
        logger.debug("initWebPage");
       PageFactory.initElements(webDriver, this);

    }

    public void navigateTo(String url) {
        logger.debug("navigateTo");
        try {
           webDriver.navigate().to(url);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }

    public void clickOnElement(WebElement element) {
        logger.debug("clickOnElement");
        try {
            element.click();
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

    }

    public void putText(WebElement element, String text) {
        logger.debug("putText");
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

    }
}
