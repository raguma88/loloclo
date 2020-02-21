import org.junit.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class HomePageTest {

    public WebDriver driver;
    public HomePage homePage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "/home/ralfidze/Documents/Gulnara/Intellij/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver" ,"/home/ralfidze/Documents/Gulnara/Intellij/drivers/chromedriver");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://loloclo.ru");
        homePage = new HomePage(driver);
    }

    @Test
    public void openBabiesPageTest() {
        BabiesPage babiesPage = homePage.clickBabiesButton();
        String heading = babiesPage.getHeadingText();
        Assert.assertEquals("ОДЕЖДА ДЛЯ НОВОРОЖДЕННЫХ", heading);
    }

    @Test
    public void signInTest() {
        homePage.registration("username18", "test18@mail.ru", "181882921", "181882921");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String logOutButtonText = homePage.checkLogOutButtonIsPresent();
        Assert.assertEquals("ВЫЙТИ", logOutButtonText);
    }

    @Test
    public void logInTest() {
        homePage.logIn("test12@mail.ru", "121882921");
        String logOutButtonText = homePage.checkLogOutButtonIsPresent();
        Assert.assertEquals("ВЫЙТИ", logOutButtonText);
    }

    @Test
       public void searchItemTest(){
        homePage.clickSearchButton();
        homePage.searchItem("боди");
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        String searchResultText = homePage.getSearchResultText();
        Assert.assertEquals("Все результаты", searchResultText);
    }

    @Test
    public void checkRememberMeCheckBoxTest() {
        Boolean checkbox = homePage.checkRememberMeCheckBox();
        Assert.assertTrue(checkbox);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

