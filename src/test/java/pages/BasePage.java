package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import static constants.TestConstants.*;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_WAIT);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        new Actions(driver).scrollToElement(element).perform();
    }

    protected boolean isVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement btn = new WebDriverWait(driver, DEFAULT_WAIT)
                    .until(ExpectedConditions.elementToBeClickable(CookieAcceptButton));
            btn.click();
        } catch (TimeoutException e) {
            System.out.println("Cookie accept button did not appear.");
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

    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void verifyTitle(String title) {
        Assert.assertTrue(
                driver.getTitle().contains(title),
                "Title is incorrect." + title
        );
    }
}