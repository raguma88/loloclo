import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupWindowsManager {

    public WebDriver driver;
    private By jivoChat = By.xpath("//jdiv[text()='Вы можете мне помочь?']");
    private By closeJivoChatButton = By.xpath("//jdiv[@class='closeIcon_1U']");
    private By buttonInModalPopupAboutCoockies = By.xpath("//button[text()='Хорошо']");
    private By popupWindow = By.xpath("//div[@id='GZ_goback__wrapper']");
    private By closePopupWindowButton = By.xpath("//button[@class='button button--close']/span");

    public void closeJivoChat() {
        if(driver.findElements(jivoChat).size() > 0) {
            driver.findElement(closeJivoChatButton).click();
        }
    }

    public void closeModalPopUpAboutCoockies() {
        if(driver.findElements(By.xpath("//div[@class='modal_popup_sessid_box show']")).size() > 0) {
            driver.findElement(buttonInModalPopupAboutCoockies).click();
        }
    }

    public void closePopupWindow() {
        if(driver.findElements(popupWindow).size() > 0) {
            driver.findElement(closePopupWindowButton).click();
        }
    }
}
