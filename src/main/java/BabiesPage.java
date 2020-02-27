import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BabiesPage {

    WebDriver driver;
    public BabiesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headingText = By.xpath("//div/h1[text()='Одежда для новорожденных']");

    public String getHeadingText() {
        return driver.findElement(headingText).getText();
    }

}
