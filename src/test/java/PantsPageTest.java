import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PantsPageTest {

    public WebDriver driver;
    public PantsPage pantsPage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "/home/ralfidze/Documents/Gulnara/Intellij/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver" ,"/home/ralfidze/Documents/Gulnara/Intellij/drivers/chromedriver");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://loloclo.ru/products/shtanishki.html");
        pantsPage = new PantsPage(driver);
    }

    @Test
    public void addItemtoCartTest() {
        pantsPage.chooseColor("Бирюзовый");
        pantsPage.closeModalPopUpAboutCoockies();
        pantsPage.chooseSize(2);
        pantsPage.buyItem();
        String text = pantsPage.getaddedItemText();
        Assert.assertEquals("Товар добавлен в корзину!", text);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
