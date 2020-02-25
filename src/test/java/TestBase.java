import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected final PopupWindowsManager popup = new PopupWindowsManager();
    public HomePage homePage;
    public PantsPage pantsPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/home/ralfidze/Documents/Gulnara/Intellij/drivers/geckodriver");
        //System.setProperty("webdriver.chrome.driver" ,"/home/ralfidze/Documents/Gulnara/Intellij/drivers/chromedriver");
        popup.driver = new FirefoxDriver();
        //popup.driver = new ChromeDriver();
        popup.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        popup.driver.manage().window().maximize();
        popup.driver.get("https://loloclo.ru");
        homePage = new HomePage(popup.driver);
        pantsPage = new PantsPage(popup.driver);
    }

    @After
    public void tearDown() {
        popup.driver.quit();
    }
}
