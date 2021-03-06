package Base;

import SeleniumCore.BrowserInteractions;
import Utils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class BaseTestSuite {

	public static String propertyFileName = "";
	// public static String browserName ="";
	public static Logger logger = LogManager.getLogger(BaseTestSuite.class.getName());

	private WebDriver driver = BrowserFactory.getCurrentBrowser();
	public static String testcasename;

	@BeforeSuite(alwaysRun = true)
	@Parameters("propertyFile")
	public void testFolderCleanup(String propertyFile) throws Exception {
		propertyFileName = propertyFile;
		TestCleanUp.clearTempFolder();

		//String browserName = BrowserInteractions.propertyFileRead().getProperty("browser");
		//Property name of browser will be passed from the jenkins choice parameter
		String browserName = System.getProperty("browser");
		System.out.println("Browser Name: " + browserName);
		if (browserName != null) {
			switch (browserName) {
			case "FIREFOX":
				BrowserFactory.createBrowser(BrowserNames.FIREFOX);
				break;
			case "CHROME":
				BrowserFactory.createBrowser(BrowserNames.CHROME);
				break;
			case "SAFARI":
				BrowserFactory.createBrowser(BrowserNames.SAFARI);
				break;
			case "IE":
				BrowserFactory.createBrowser(BrowserNames.IE);
				break;

			default:
				logger.info("Browser is not defined in the property file");
				break;
			}
		} else {
			logger.info("Browser is not defined in the property file");
		}

	}

	@BeforeClass(alwaysRun = true)
	public void logBeforeSuite() {
		logger.info("Started running suite :  " + getClass().getSimpleName());
	}

	@BeforeMethod
	public void logBeforeMethod(Method method)

	{
		logger.info("Started Running Method" + method.getName());
		testcasename = method.getName();
		System.out.println("Testcase Name: " + testcasename);

	}

	@AfterMethod
	public void logAfterMethod(ITestResult result) {
		logger.info("Finished Running Test: " + result.getMethod().getMethodName());
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info("Status : Pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.info("Status : Fail");
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.info("Status : Skipped");
		}
	}

	@AfterClass(alwaysRun = true)
	public void logAfterSuite() {
		logger.info("Finished running suite : " + getClass().getSimpleName());

		if (driver instanceof FirefoxDriver) {
			logger.info("Browser : Firefox");
			logger.info("Version:" + ((FirefoxDriver) driver).getCapabilities().getVersion());
		} /*
			 * else if (driver instanceof ChromeDriver) { logger.info("Browser : Chrome");
			 * logger.info("Version:" + ((ChromeDriver)
			 * driver).getCapabilities().getVersion()); }
			 */ 
		else if (driver instanceof InternetExplorerDriver) {
			logger.info("Browser : IE");
			logger.info("Version:" + ((InternetExplorerDriver) driver).getCapabilities().getVersion());
		} else if (driver instanceof SafariDriver) {
			logger.info("Browser : Safari");
			logger.info("Version:" + ((SafariDriver) driver).getCapabilities().getVersion());
		} else if (driver instanceof RemoteWebDriver) {
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			logger.info("Browser:Remote " + caps.getBrowserName() + " Driver");
			logger.info("Browser Version:" + caps.getVersion());
			logger.info("Platform:" + caps.getPlatform());
		}

	}

	@AfterSuite(alwaysRun = true)
	public void AfterSuite() {
		BrowserUtils.closeBrowser();
	}

}
