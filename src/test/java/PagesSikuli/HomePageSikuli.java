package PagesSikuli;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sikuli.script.FindFailed;

import PagesUI.HomePageUI;
import SeleniumCore.BrowserInteractions;
import Utils.LocatorType;

public class HomePageSikuli {

	static final Logger logger = LogManager.getLogger(HomePageUI.class.getName());
	
	String Logo = "SpiceJetLogo.png";
	String ArrivalCity = "ArrivalCity.png";
	String DepatureCity = "DepatureCity.png";
	String Date_29 = "Date_29.png";
	String Search = "SearchButton.png";
	String SearchResult = "Flight_Selection.png";

	public void homePageGUI() throws Exception {
		try {
			BrowserInteractions.navigateToURL(BrowserInteractions.propertyFileRead().getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void flightSearchGUI() throws Exception {
		BrowserInteractions.existGUI(DepatureCity, 5);
		BrowserInteractions.clickGUI(DepatureCity);
		BrowserInteractions.typeGUI("IXM");
		BrowserInteractions.clickGUI(ArrivalCity);		
		BrowserInteractions.typeGUI("MAA");
		BrowserInteractions.existGUI(Date_29, 5);
		BrowserInteractions.clickGUI(Date_29);
		BrowserInteractions.clickGUI(Search);
		BrowserInteractions.existGUI(SearchResult, 5);
	}

}