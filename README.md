# 🧪 Selenium UI Test Automation Framework

![Java](https://img.shields.io/badge/Java-11+-orange?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-Latest-red?style=for-the-badge&logo=testng)
![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?style=for-the-badge&logo=apache-maven)

A robust Selenium WebDriver-based UI test automation framework for the Company platform, implementing industry best practices and the Page Object Model (POM) design pattern.

---

## 📋 Table of Contents

- [About the Project](#-about-the-project)
- [Key Features](#-key-features)
- [Technologies](#-technologies)
- [Project Structure](#-project-structure)
- [Architecture](#-architecture)
- [Setup & Installation](#️-setup--installation)
- [Running Tests](#-running-tests)
- [Test Scenarios](#-test-scenarios)
- [Page Objects Overview](#-page-objects-overview)

---

## 🎯 About the Project

This project provides comprehensive UI test automation for the **Company** website, focusing on the Quality Assurance careers section. Built with scalability and maintainability in mind, it demonstrates professional automation engineering practices including:

- **Page Object Model (POM)** for clean separation of concerns
- **Reusable components** to minimize code duplication
- **Robust wait strategies** for reliable test execution
- **Modular test design** for easy maintenance and extension

---

## ✨ Key Features

- ✅ **Page Object Model Implementation** - Clean, maintainable test architecture
- ✅ **Smart Wait Mechanisms** - Dynamic waits with explicit conditions
- ✅ **Image Load Validation** - Ensures visual elements are fully rendered
- ✅ **Cross-Browser Ready** - Extensible for multiple browser support
- ✅ **Automatic Driver Management** - WebDriverManager handles browser drivers
- ✅ **Comprehensive Assertions** - TestNG-powered validations
- ✅ **Detailed Reporting** - Built-in TestNG reports

---

## 🛠 Technologies

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 11+ | Programming Language |
| **Selenium WebDriver** | 4.x | Browser Automation |
| **TestNG** | Latest | Test Framework & Assertions |
| **WebDriverManager** | Latest | Automatic Driver Management |
| **Maven** | 3.6+ | Dependency & Build Management |

---

## 📁 Project Structure

```
selenium-automation-framework/
│
├── src/
│   ├── main/java/
│   │   ├── constants/
│   │   │   └── TestConstants.java          # Centralized constants (URLs, locators, timeouts)
│   │   │
│   │   └── pages/
│   │       ├── BasePage.java               # Abstract base with common WebDriver methods
│   │       ├── HomePage.java               # Home page interactions
│   │       ├── CareersQAPage.java          # QA careers page navigation
│   │       └── OpenPosQAPage.java          # Job listings and filtering
│   │
│   └── test/java/
│       └── tests/
│           └── CareersTest.java            # End-to-end test scenarios
│
├── pom.xml                                  # Maven dependencies and configuration
└── README.md                                # Project documentation
```

---

## 🏗 Architecture

### **Design Pattern: Page Object Model (POM)**

```
┌─────────────────────────────────────────┐
│         TestConstants.java              │
│   (URLs, Locators, Configuration)       │
└────────────────┬────────────────────────┘
                 │
                 ▼
┌─────────────────────────────────────────┐
│           BasePage.java                 │
│  ┌───────────────────────────────────┐  │
│  │ • WebDriver initialization        │  │
│  │ • Common methods (click, find)    │  │
│  │ • Wait strategies                 │  │
│  │ • Scroll & navigation helpers     │  │
│  └───────────────────────────────────┘  │
└────────────────┬────────────────────────┘
                 │
        ┌────────┴────────┬──────────────┐
        ▼                 ▼              ▼
┌──────────────┐  ┌──────────────┐  ┌──────────────┐
│  HomePage    │  │ CareersQAPage│  │OpenPosQAPage │
│              │  │              │  │              │
│ • open()     │  │ • open()     │  │ • filterJobs │
│ • checkTitle │  │ • clickSee   │  │ • getJobs()  │
│ • checkBlock │  │   AllJobs()  │  │ • openFirst  │
└──────────────┘  └──────────────┘  └──────────────┘
        │                 │              │
        └────────┬────────┴──────────────┘
                 ▼
        ┌─────────────────┐
        │  CareersTest    │
        │  (Test Layer)   │
        └─────────────────┘
```

### **Key Components**

#### **1. TestConstants.java**
Centralized repository for all test data:
- URLs for different pages
- CSS/XPath locators for web elements
- Timeout configurations
- Reusable element selectors

#### **2. BasePage.java**
Abstract base class providing core functionality:
- **click(By locator)** - Waits for clickability and clicks
- **find(By locator)** - Returns visible element
- **findAll(By locator)** - Returns list of elements
- **isVisible(By locator)** - Checks element visibility
- **scrollTo(By locator)** - Scrolls element into view
- **waitForImagesToLoad(By locator)** - Validates image loading

#### **3. Page Objects**
- **HomePage** - Landing page interactions and section validations
- **CareersQAPage** - Navigation to QA job listings
- **OpenPosQAPage** - Job filtering and detail validation

---

## ⚙️ Setup & Installation

### **Prerequisites**

Ensure you have the following installed:

- ☑️ **JDK 11 or higher** ([Download](https://www.oracle.com/java/technologies/downloads/))
- ☑️ **Maven 3.6+** ([Download](https://maven.apache.org/download.cgi))
- ☑️ **Chrome Browser** (latest version)
- ☑️ **Git** ([Download](https://git-scm.com/downloads))

### **Installation Steps**

1. **Clone the repository**
   ```bash
   git clone https://github.com/beyzabudak/beyza_budak_case.git
   cd beyza_budak_case
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Verify setup**
   ```bash
   mvn clean compile
   ```

### **Maven Dependencies (pom.xml)**

Ensure your `pom.xml` includes:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version>
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.x.x</version>
        <scope>test</scope>
    </dependency>
    
    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.x.x</version>
    </dependency>
</dependencies>
```

---

## 🚀 Running Tests

### **Run All Tests**
```bash
mvn test
```

### **Run Specific Test Class**
```bash
mvn test -Dtest=CareersTest
```

### **Generate Reports**
After test execution, find reports at:
```
target/surefire-reports/index.html
```

---

## 🧪 Test Scenarios

### **Test Case: `QaJobsTest`**

This comprehensive test validates the complete job application workflow:

#### **Step 1: Home Page Validation**
- ✅ Navigate to Company homepage
- ✅ Verify page title contains "Company"
- ✅ Accept cookie consent banner
- ✅ Validate all homepage sections are loaded and visible:
    - Hero section
    - Social proof
    - Core differentiators
    - Capabilities
    - AI features
    - Channels
    - Case studies
    - Analyst reviews
    - Integrations
    - Resources
    - Call-to-action

#### **Step 2: Navigate to QA Careers**
- ✅ Open Quality Assurance careers page
- ✅ Click "See All Jobs" button
- ✅ Wait for job listings to load

#### **Step 3: Filter & Validate Jobs**
- ✅ Apply filters:
    - Location: "Istanbul, Turkiye"
    - Department: "Quality Assurance"
- ✅ Verify jobs are displayed
- ✅ Validate each job listing contains:
    - "Quality Assurance" in title
    - "Quality Assurance" in department
    - "Istanbul, Turkiye" in location

#### **Step 4: Job Application Redirect**
- ✅ Click "View Role" on first job
- ✅ Verify redirect to Lever application page
- ✅ Validate URL contains "jobs.lever.co"

---

## 📄 Page Objects Overview

### **HomePage.java**
```java
• open()                        // Navigate to homepage
• acceptCookies()               // Handle cookie banner
• checkTitle(String title)      // Validate page title
• checkBlockLoaded(By block)    // Verify section visibility
• getPageBlocks()               // Return list of page sections
```

### **CareersQAPage.java**
```java
• open()                        // Navigate to QA careers page
• clickSeeAllJobs()            // Click to view all QA positions
```

### **OpenPosQAPage.java**
```java
• filterJobs(location, dept)    // Apply job filters
• getJobs()                     // Return list of job elements
• getJobTitle(WebElement job)   // Extract job title
• getJobDepartment(job)         // Extract department
• getJobLocation(job)           // Extract location
• openFirstJob()                // Click first job listing
• isLeverPageOpened()          // Validate Lever redirect
• waitJobsAppear()             // Wait for jobs to load
```

---

## 📞 Contact

**Beyza Budak**  
GitHub: [@beyzabudak](https://github.com/beyzabudak)

---

## 📜 License

This project is created for educational and portfolio purposes.

---

<div align="center">
  <p>Made with ❤️ by Beyza Budak</p>
  <p>⭐ Star this repo if you find it helpful!</p>
</div>
