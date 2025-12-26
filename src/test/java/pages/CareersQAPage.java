package pages;

import org.openqa.selenium.WebDriver;
import static constants.TestConstants.*;

public class CareersQAPage extends BasePage {

    public CareersQAPage(WebDriver driver) {
        super(driver);
    }
	
	public void open() {
        driver.get(URL_CAREERS_QA);
    }
	
	public void clickSeeAllJobs() {
        click(SEE_ALL_JOBS);
    }
}
