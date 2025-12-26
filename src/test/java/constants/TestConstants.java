package constants;

import org.openqa.selenium.By;

import java.time.Duration;

public class TestConstants {

    //URL's
    public static final String URL_HOMEPAGE = "https://insiderone.com/";
    public static final String URL_CAREERS_QA = "https://insiderone.com/careers/quality-assurance/";

    //Timeout
    public static final Duration DEFAULT_WAIT = Duration.ofSeconds(15);

    //HomePage
    public static final By HERO = By.cssSelector("section.homepage-hero");
    public static final By SOCIAL = By.cssSelector("section.homepage-social-proof");
    public static final By CORE = By.cssSelector("section.homepage-core-differentiators");
    public static final By CAPABILITIES = By.cssSelector("section.homepage-capabilities");
    public static final By AI = By.cssSelector("section.homepage-insider-one-ai");
    public static final By CHANNELS = By.cssSelector("section.homepage-channels");
    public static final By CASE_STUDY = By.cssSelector("section.homepage-case-study");
    public static final By ANALYST = By.cssSelector("section.homepage-analyst");
    public static final By INTEGRATIONS = By.cssSelector("section.homepage-integrations");
    public static final By RESOURCES = By.cssSelector("section.homepage-resources");
    public static final By CTA = By.cssSelector("section.homepage-call-to-action");
    public static final By CookieAcceptButton = By.id("wt-cli-accept-all-btn");

    //QAJobsPage
    public static final By JOB_LIST_ITEM = By.cssSelector(".position-list-item");
    public static final By SEE_ALL_JOBS = By.cssSelector("a[href*='department=qualityassurance']");
    public static final By DEPARTMENT_FILTER = By.id("filter-by-department");
    public static final By LOCATION_FILTER = By.id("filter-by-location");
    public static final By VIEW_ROLE = By.cssSelector("a.btn-navy");
    public static final By POSITION_TITLE = By.cssSelector(".position-title");
    public static final By POSITION_DEPARTMENT = By.cssSelector(".position-department");
    public static final By POSITION_LOCATION = By.cssSelector(".position-location");

}