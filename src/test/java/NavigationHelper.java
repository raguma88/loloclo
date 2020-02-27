import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    private WebDriver driver;
    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    private By babiesButton = By.xpath("//div/ul/li[1]/a/span[1]");
    private By pantsButton = By.xpath("//div[@class='item-wrapper']//a[text()='Штанишки']");

    public NavigationHelper goToPantsPage () {
        driver.findElement(babiesButton).click();
        driver.findElement(pantsButton).click();
        return this;
    }
}
