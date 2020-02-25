import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PantsPage {

    WebDriver driver;
    public PantsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headingText = By.xpath("//div/h1[text()='Штанишки']");
    private By buyButton = By.xpath("//a[@title='Купить']");
    private By addedItemText = By.xpath("//span[text()='Товар добавлен в корзину!']");
    private By colorList = By.xpath("//a[@title='%$']");
    private By sizeList = By.xpath("//a[@data-size='%$']");

    public String getHeadingText() {
        return driver.findElement(headingText).getText();
    }

    public String getaddedItemText() {
        return driver.findElement(addedItemText).getText();
    }

    public PantsPage chooseColor(String name) {
        //List<WebElement> colors = driver.findElements(By.xpath("//div[@class='color_list']/a"));
        //colors.get(i).click();
        String color = "//div[@class='color_list']/a[@title='%s']";
        driver.findElement(By.xpath(String.format(color, name))).click();
        return this;
    }

    public PantsPage chooseSize(int i) {
        List<WebElement> sizes = driver.findElements(By.xpath("//div[@class='size_list']/a"));
        sizes.get(i).click();
        //String size = "//div[@class='size_list']/a[@data-size='%s']";
        //driver.findElement(By.xpath(String.format(size, name))).click();
        return this;
    }

    public PantsPage buyItem() {
        driver.findElement(buyButton).click();
        return this;
    }
}
