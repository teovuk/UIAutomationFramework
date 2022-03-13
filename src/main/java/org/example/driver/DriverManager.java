package org.example.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    static Logger log = LogManager.getLogger(DriverManager.class);

   public static  WebDriver webDriver;

    public static WebDriver getWebDriver() {
        log.info("getWebDriver");
        if (webDriver==null){
            webDriver = getChromeDriver();
            webDriver.navigate().to("https://nl-be.napoleongames.be/");
        }

        return webDriver;
    }

    public static AppiumDriver getDriverAndroid() throws MalformedURLException {
        log.info("getDriverAndroid");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        String appUrl = System.getProperty("user.dir")+ File.separator +"src" + File.separator +"main"+ File.separator +"resources"+ File.separator +"ApiDemos-debug.apk";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone64_arm64");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, appUrl);


       AppiumDriver driver = new AndroidDriver(url,caps);
       driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

       return driver;
    }

    public static AppiumDriver getDriverIOS() throws MalformedURLException {
        log.info("getDriverIOS");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        String appUrl = System.getProperty("user.dir")+ File.separator +"src" + File.separator +"main"+ File.separator +"resources"+ File.separator +"TestApp-iphonesimulator.app";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.UDID, "1936DA1F-4760-410D-A8CA-A502248F8075");
        caps.setCapability(MobileCapabilityType.APP, appUrl);

        AppiumDriver driver = new AppiumDriver(url,caps);


        return driver;
    }


    public static WebDriver getChromeDriver() {
        log.info("getChromeDriver");


        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        // options.addArguments("--headless");
        options.addArguments("start-maximized");
        // options.addArguments("--window-size=1920,1080");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        //options.addArguments("--disable-gpu");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-dev-shm-usage");

        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        des.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(des);
    }


    public static void takeSnapShot(String fileWithPath, WebDriver driver) throws Exception {
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot;
try {
    scrShot = ((TakesScreenshot) driver);

    // Call getScreenshotAs method to create image file
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    // Move image file to new destination
    File DestFile = new File(System.getProperty("user.dir") + File.separator + "screenshot"+File.separator +"image.png");
    // Copy file at destination
    FileUtils.copyFile(SrcFile, DestFile);

}catch(Exception e){

   e.printStackTrace();
}
    }

    public void quitWebDriver() {
        log.info("Quiting driver...");
        webDriver.quit();

    }

    public void navigate(String url) {
        log.info("Navigate to: " + url);
        webDriver.get(url);
    }

    public void refresh() {
        log.info("Refresh Page ");
        webDriver.navigate().refresh();
    }




}
