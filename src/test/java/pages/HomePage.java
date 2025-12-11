package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.TestConstants.*;


public class HomePage extends BasePage {

    private final By[] PAGE_BLOCKS = {
            HERO, SOCIAL, CORE, CAPABILITIES, AI, CHANNELS,
            CASE_STUDY, ANALYST, INTEGRATIONS, RESOURCES, CTA
    };

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL_HOMEPAGE);
    }

    public void validatePageBlocks() {
        for (By block : PAGE_BLOCKS) {
            scrollToElement(block);
            if (!isVisible(block)) {
                throw new AssertionError("Block not visible: " + block);
            }
            if (!waitForImagesToLoad(block)) {
                throw new AssertionError("Images not loaded in: " + block);
            }
        }
    }
}