import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public PopupWindowsManager popup;
    public NavigationHelper navigate;
    public WebDriver driver;
    public HomePage homePage;
    public PantsPage pantsPage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "/home/ralfidze/Documents/Gulnara/Intellij/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver" ,"/home/ralfidze/Documents/Gulnara/Intellij/drivers/chromedriver");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://loloclo.ru");
        popup = new PopupWindowsManager(driver);
        navigate = new NavigationHelper(driver);
        homePage = new HomePage(driver);
        pantsPage = new PantsPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
