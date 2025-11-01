package core;

import config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private static WebDriverWait buildWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getDefaultTimeoutSeconds()));
    }

    public static WebElement waitForVisible(WebDriver driver, By locator) {
        return buildWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return buildWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }
}


