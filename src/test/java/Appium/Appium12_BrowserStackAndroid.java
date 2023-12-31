package Appium;


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Appium12_BrowserStackAndroid  {

    @Test
    public void browserstackAndroid() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "hakankara_If5348");
        caps.setCapability("browserstack.key", "qsn7wbGdRMkxtxBDhzqw");

        // Set URL of the application under test
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        caps.setCapability("platformName", "Android");
        // Specify device and os_version for testing
        caps.setCapability("deviceName", "Samsung Galaxy A10");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Appium Project");
        caps.setCapability("build", "browserstack-1");
        caps.setCapability("name", "sample_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);
// Test case for the BrowserStack sample Android app.
// If you have uploaded your app, update the test case here.
        WebElement searchElement = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        WebElement insertTextElement = new WebDriverWait(driver, 10).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElements(By.className(
                "android.widget.TextView"));
        assert(allProductsName.size() > 0);

// Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}