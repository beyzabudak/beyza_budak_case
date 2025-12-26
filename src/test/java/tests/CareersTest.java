package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.*;

import static org.testng.Assert.assertTrue;

public class CareersTest {

    private WebDriver driver;
    private HomePage home;
    private CareersQAPage careersqa;
    private OpenPosQAPage openposqa;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        home = new HomePage(driver);
        careersqa = new CareersQAPage(driver);
        openposqa = new OpenPosQAPage(driver); 
    }

    @Test
    public void insiderQaJobsTest() {

        // 1. Home page
        home.open();
        assertTrue(
			home.checkTitle("Insider"), "Home page not opened"
		);
        home.acceptCookies();
		for (By block : home.getPageBlocks()) {
			assertTrue(home.checkBlockLoaded(block));
		}
		
        // 2. Careers Quality Assurance
        careersqa.open();
		careersqa.clickSeeAllJobs();
        openposqa.waitJobsAppear();
        openposqa.filterJobs("Istanbul, Turkiye", "Quality Assurance");

        // 3. Job validations
        Assert.assertFalse(openposqa.getJobs().isEmpty(), "No jobs found");
        openposqa.getJobs().forEach(job -> {
            assertTrue(openposqa.getJobTitle(job).contains("Quality Assurance"));
            assertTrue(openposqa.getJobDepartment(job).contains("Quality Assurance"));
            assertTrue(openposqa.getJobLocation(job).contains("Istanbul, Turkiye"));
        });



        // 4. Lever redirect
        openposqa.openFirstJob();
        assertTrue(openposqa.isLeverPageOpened(), "Lever page not opened");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}