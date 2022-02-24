package Utils;


public class BrowserUtils {


    public static void clearBrowserCache() throws InterruptedException {
        BrowserFactory.getCurrentBrowser().manage().deleteAllCookies();
    }

    public static void closeBrowser()

    {
        BrowserFactory.getCurrentBrowser().quit();
    }

}
