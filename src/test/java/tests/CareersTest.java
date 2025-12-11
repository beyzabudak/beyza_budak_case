package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.BasePage;
import pages.HomePage;
import pages.QAJobsPage;

public class CareersTest {

    private WebDriver driver;
    private HomePage home;
    private QAJobsPage jobs;
    private BasePage base;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        home = new HomePage(driver);
        jobs = new QAJobsPage(driver);
        base = new BasePage(driver);
    }

    @Test
    public void testInsiderQaJobs() {

        // Step 1: Homepage validation
        home.open();
        base.verifyTitle("Insider");

        base.acceptCookiesIfPresent();
        home.validatePageBlocks();

        // Step 2: Navigate to QA jobs
        jobs.open();
        base.acceptCookiesIfPresent();
        jobs.clickSeeAllJobs();
        jobs.waitJobsAppear();

        jobs.applyFilters("Istanbul, Turkiye", "Quality Assurance");

        // Step 3: Validate jobs
        jobs.validateJobs(
                "Quality Assurance",
                "Quality Assurance",
                "Istanbul, Turkiye"
        );

        // Step 4: Open first job and verify Lever redirect
        jobs.openFirstJob();
        jobs.verifyLeverPageOpened();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}