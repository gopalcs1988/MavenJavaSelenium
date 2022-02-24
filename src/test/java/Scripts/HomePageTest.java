package Scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTestSuite;
import PagesUI.HomePageUI;
import Utils.BrowserUtils;

public class HomePageTest extends BaseTestSuite {

	static final Logger logger = LogManager.getLogger(HomePageTest.class.getName());

	HomePageUI home = null;

	@BeforeClass
	public void createInstance() {
		home = new HomePageUI();
	}

	@Test
	public void flightSearchUI() throws Exception {
		// BrowserUtils.clearBrowserCache();
		logger.info("Home Page");
		home.homePage();
		logger.info("Flight Search");
		home.flightSearch();

	}

}
