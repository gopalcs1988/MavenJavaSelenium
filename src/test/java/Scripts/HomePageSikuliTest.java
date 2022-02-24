package Scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTestSuite;
import PagesSikuli.HomePageSikuli;
import PagesUI.HomePageUI;
import Utils.BrowserUtils;

public class HomePageSikuliTest extends BaseTestSuite {

	static final Logger logger = LogManager.getLogger(HomePageSikuliTest.class.getName());

	HomePageSikuli home = null;

	@BeforeClass
	public void createInstance() {
		home = new HomePageSikuli();
	}

	@Test
	public void flightSearchGUI() throws Exception {
		// BrowserUtils.clearBrowserCache();
		logger.info("Home Page");
		home.homePageGUI();
		logger.info("Flight Search");
		home.flightSearchGUI();

	}
}
