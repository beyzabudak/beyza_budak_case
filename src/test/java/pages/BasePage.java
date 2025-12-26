package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import static constants.TestConstants.DEFAULT_WAIT;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_WAIT);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findAll(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected boolean isVisible(By locator) {
        try {
            find(locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void scrollTo(By locator) {
        new Actions(driver)
                .scrollToElement(find(locator))
                .perform();
    }

    protected void switchToNewTab() {
        String current = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(current)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
	
	public boolean waitForImagesToLoad(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            new WebDriverWait(driver, DEFAULT_WAIT).until(d ->
                    (Boolean) ((JavascriptExecutor) d).executeScript(
                            "const imgs = arguments[0].querySelectorAll('img');" +
                                    "return Array.from(imgs).every(img => img.complete && img.naturalHeight > 0);",
                            element
                    )
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
}