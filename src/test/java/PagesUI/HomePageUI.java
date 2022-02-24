package PagesUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import SeleniumCore.BrowserInteractions;
import Utils.LocatorType;

public class HomePageUI {

	static final Logger logger = LogManager.getLogger(HomePageUI.class.getName());

	String DepatureCity = "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']";
	String ArrivalCity = "ctl00_mainContent_ddl_destinationStation1_CTXT";
	String ArrivalCity_MAA = "//li[contains(@class,'city_selected')]//a[@value='IXM']";
	String Search = "ctl00_mainContent_btn_FindFlights";
	String SearchResult = "//span[@class='bound-city uppercase']";
	String DateSelect ="//td[@class=' ui-datepicker-week-end ']//a[text()='29']";
	

	public void homePage() throws Exception {
		try {
			BrowserInteractions.navigateToURL(BrowserInteractions.propertyFileRead().getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void flightSearch() throws Exception {
		BrowserInteractions.clearAndEnterText(DepatureCity, LocatorType.XPATH, "MAA");
		BrowserInteractions.implicitwait();
		BrowserInteractions.clearAndEnterText(ArrivalCity, LocatorType.ID, "IXM");
		BrowserInteractions.click(ArrivalCity_MAA, LocatorType.XPATH);
		BrowserInteractions.click(DateSelect, LocatorType.XPATH);
		BrowserInteractions.click(Search, LocatorType.ID);
		BrowserInteractions.isElementPresent(SearchResult, LocatorType.XPATH);

	}

}
