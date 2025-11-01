package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    private final WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        WebElement element = Waits.waitForClickable(driver, locator);
        element.click();
    }

    public void type(By locator, String text) {
        WebElement element = Waits.waitForVisible(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        WebElement element = Waits.waitForVisible(driver, locator);
        return element.getText();
    }

    public void forceClick(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            System.out.println("[ElementActions] Force-clicked element via JS: " + locator);
        } catch (Exception jsEx) {
            throw new RuntimeException("Failed to force-click element: " + locator, jsEx);
        }
    }
}


