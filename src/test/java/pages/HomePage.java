package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static constants.TestConstants.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL_HOMEPAGE);
    }

    public void acceptCookies() {
        click(CookieAcceptButton);
    }
	public boolean checkTitle(String title)
	{
		return driver.getTitle().contains(title);
	}
 
	public boolean checkBlockLoaded(By block) {
		scrollTo(block);
        return isVisible(block) && waitForImagesToLoad(block);
    }
	
	public List<By> getPageBlocks() {
		return List.of(
			HERO, SOCIAL, CORE, CAPABILITIES, AI,
			CHANNELS, CASE_STUDY, ANALYST, INTEGRATIONS, RESOURCES, CTA
		);
	}

}