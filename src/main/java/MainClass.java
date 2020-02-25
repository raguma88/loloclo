import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver" ,"/home/ralfidze/Documents/Gulnara/Intellij/drivers/geckodriver");
        //System.setProperty("webdriver.chrome.driver" ,"/home/ralfidze/Documents/Гульнарочки/Intellij/drivers/chromedriver");

        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://loloclo.ru/products/shtanishki.html");

        HomePage homePage = new HomePage(driver);
        BabiesPage babiesPage = new BabiesPage(driver);
        PantsPage pantsPage = new PantsPage(driver);

        driver.close();




    }
}
