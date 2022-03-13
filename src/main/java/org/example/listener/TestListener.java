package org.example.listener;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.*;


public class TestListener implements ITestListener{
    private static Logger logger = LogManager.getLogger(TestListener.class);

    WebDriver driver;

   @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("onTestStart");
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("onTestFailure");
      try {
            driver = DriverManager.getWebDriver();
            DriverManager.takeSnapShot("TEST", driver);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("Test Failed with message: " + e.getMessage());
        }
        logger.error("Test Failed with message: " + result.getThrowable().getMessage());

    }

    @Attachment
    public byte[] captureScreenshot(WebDriver driver) {
        Allure.addAttachment("testneki", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("onTestSkipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
