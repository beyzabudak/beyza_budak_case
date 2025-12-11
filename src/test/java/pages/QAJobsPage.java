package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import static constants.TestConstants.*;

import java.util.List;

public class QAJobsPage extends BasePage {

    public QAJobsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL_CAREERS);
    }

    public void clickSeeAllJobs() {
        click(SEE_ALL_JOBS);
    }

    public void waitJobsAppear() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JOB_LIST_ITEM));
    }

    public void applyFilters(String locationItem, String departmentItem) {
        selectFilterItem(locationItem, LOCATION_FILTER);
        selectFilterItem(departmentItem, DEPARTMENT_FILTER);
        waitForJobsUpdate();
    }

    private void selectFilterItem(String item, By locator) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        new Select(dropdown).selectByVisibleText(item);
    }

    private void waitForJobsUpdate() {
        List<WebElement> oldJobs = getJobs();
        if (!oldJobs.isEmpty()) {
            //check the filter is fully updated
            wait.until(ExpectedConditions.stalenessOf(oldJobs.get(0)));
        }
        waitJobsAppear();
    }

    public void validateJobs(String title, String dept, String location) {
        for (WebElement job : getJobs()) {
            isVisible(POSITION_TITLE);
            String positionTitle = job.findElement(POSITION_TITLE).getText();
            String positionDepartment = job.findElement(POSITION_DEPARTMENT).getText();
            String positionLocation = job.findElement(POSITION_LOCATION).getText();

            Assert.assertTrue(positionTitle.contains(title), "Invalid title:" + positionTitle);
            Assert.assertTrue(positionDepartment.contains(dept), "Invalid department:" + positionDepartment);
            Assert.assertTrue(positionLocation.contains(location), "Invalid location:" + positionLocation);
        }
    }

    public void openFirstJob() {
        WebElement job = getJobs().get(0);
        job.findElement(VIEW_ROLE).click();
    }

    public void verifyLeverPageOpened() {
        switchToNewTab();
        wait.until(ExpectedConditions.urlContains("jobs.lever.co"));

        if (!driver.getCurrentUrl().contains("jobs.lever.co")) {
            throw new AssertionError("Lever page not opened.");
        }
    }

    private List<WebElement> getJobs() {
        waitJobsAppear();
        List<WebElement> jobs = getElements(JOB_LIST_ITEM);
        if (jobs.isEmpty()) {
            throw new AssertionError("No jobs found.");
        }
        return jobs;
    }
}