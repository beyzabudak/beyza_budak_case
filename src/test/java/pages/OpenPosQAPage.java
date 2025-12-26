package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static constants.TestConstants.*;
import static constants.TestConstants.JOB_LIST_ITEM;

import java.util.List;

public class OpenPosQAPage extends BasePage {

    public OpenPosQAPage(WebDriver driver) {
        super(driver);
    }

    public void filterJobs(String location, String department) {
        selectFilterItem(location, LOCATION_FILTER);
        selectFilterItem(department, DEPARTMENT_FILTER);
        waitForJobsUpdate();
    }

    private void selectFilterItem(String item, By locator) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locator));
        new Select(dropdown).selectByVisibleText(item);
    }

    public List<WebElement> getJobs() {
        return findAll(JOB_LIST_ITEM);
    }

    private String getJobField(WebElement job, By locator) {
        isVisible(locator);
        return job.findElement(locator).getText();
    }

    public String getJobTitle(WebElement job) {
        return getJobField(job, POSITION_TITLE);
    }

    public String getJobDepartment(WebElement job) {
        return getJobField(job, POSITION_DEPARTMENT);
    }

    public String getJobLocation(WebElement job) {
        return getJobField(job, POSITION_LOCATION);
    }

    public void openFirstJob() {
        getJobs().get(0).findElement(VIEW_ROLE).click();
    }

    public boolean isLeverPageOpened() {
        switchToNewTab();
        return driver.getCurrentUrl().contains("jobs.lever.co");
    }

    void waitForJobsUpdate() {
        List<WebElement> oldJobs = getJobs();
        if (!oldJobs.isEmpty()) {
            wait.until(ExpectedConditions.stalenessOf(oldJobs.get(0)));
        }
        waitJobsAppear();
    }

    public void waitJobsAppear() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(JOB_LIST_ITEM));
    }

}