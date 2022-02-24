package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	private static WebDriver driver;
	public static String currentDir = System.getProperty("user.dir");

	private BrowserFactory() {
	}

	public static WebDriver getCurrentBrowser() {
		return driver;
	}

	@SuppressWarnings("deprecation")
	public static void createBrowser(BrowserNames type) {
		System.out.println("Browser name:   " + type);
		if (type == BrowserNames.CHROME && (driver == null || !(driver instanceof ChromeDriver))) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (type == BrowserNames.FIREFOX && (driver == null || !(driver instanceof FirefoxDriver))) {
			/*
			 * ProfilesIni profile = new ProfilesIni(); FirefoxProfile myprofile =
			 * profile.getProfile("Selenium"); myprofile.setEnableNativeEvents(true);
			 * FirefoxProfile fprofile = new FirefoxProfile();
			 * fprofile.setPreference("browser.download.dir", System.getProperty("user.dir")
			 * + "\\TestDataFiles\\Proposal");
			 * fprofile.setPreference("browser.download.folderList", 2);
			 * fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
			 * "application/pdf;");
			 * fprofile.setPreference("browser.download.manager.showWhenStarting", false);
			 * fprofile.setEnableNativeEvents(true);
			 */
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (type == BrowserNames.IE) {
			if (driver == null || type != BrowserNames.IE) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "/src/test/resources/IEDriverServer.exe");
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability("ignoreZoomSetting", true);
				caps.setCapability("nativeEvents", false);
				driver = new InternetExplorerDriver(caps);

			}

		}
		driver.manage().window().maximize();

	}
}
