import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    private WebDriver driver;
    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }
    public PopupWindowsManager popup;

    private By babiesButton = By.xpath("//div/ul/li[1]/a/span[1]");
    private By pantsButton = By.xpath("//div[@class='item-wrapper']//a[text()='Штанишки']");

    public void goToPantsPage () {
        driver.findElement(babiesButton).click();
        //popup.closePopupWindow();
        driver.findElement(pantsButton).click();
    }
}
