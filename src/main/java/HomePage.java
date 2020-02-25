import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {  //создаем класс

    public WebDriver driver;  //объявляем переменную driver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    } //создаем конструктор класса

    private By babiesButton = By.xpath("//div/ul/li[1]/a/span[1]"); //объявляем переменную типа By и присоавиваем ее значение локатора по XPath
    private By pantsButton = By.xpath("//div[@class='item-wrapper']//a[text()='Штанишки']");
    private By logInButton = By.xpath("//a[@class='f_auth']");
    private By logInButtonInForm = By.xpath("//div[@id='ui-id-1']//input[@name='Login']");
    private By signInButton = By.xpath("//a[text()='зарегистрироваться']");
    private By signInButtonInForm = By.xpath("//form[@id='regform2']//a[text()='Зарегистрироваться']");
    private By usernameField = By.xpath("//input[@placeholder='Имя']");
    private By emailField = By.xpath("//input[@id='reg_user_login']");
    private By emailFieldInForm = By.xpath("//div[@id='ui-id-1']//input[@placeholder='E-mail']");
    private By passwordField = By.xpath("//input[@placeholder='Пароль*']");
    private By passwordFieldForLogin = By.xpath("//input[@placeholder='Пароль']");
    private By confirmPasswordField = By.xpath("//input[@placeholder='Подтверждение пароля*']");
    private By searchButton = By.xpath("//div[3]/div[1]/a[@class='search_btn io']");
    private By searchField = By.xpath("//input[@class='multi-input']");
    private By searchResultText = By.xpath("//span[text()='Все результаты']");
    private By logOutButton = By.xpath("//div[@class='bottom-header']//a[text()='Выйти']");
    private By rememberMeCheckbox = By.xpath("//input[@id='USER_REMEMBER']");
    private By wantGetNewsCheckBox = By.xpath("//input[@id='USER_PERSONAL_NOTES']");

    public HomePage goToPantsPage () {
        driver.findElement(babiesButton).click();
        driver.findElement(pantsButton).click();
        return this;
    }

    public BabiesPage clickBabiesButton() {  //создаем метод типа BabiesPage
        driver.findElement(babiesButton).click(); //обращаемся к driver и вызываем методы библиотеки WebDriver, передаем в метод атрибут babiesButton
        return new BabiesPage(driver); //возвращаем объект BabiesPage и передаем в него driver
    }

    public HomePage registration(String username, String email, String password, String confirmPassword) {
        driver.findElement(logInButton).click();
        driver.findElement(signInButton).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        checkWantGetNewsCheckBox();
        driver.findElement(signInButtonInForm).click();
        return this;
    }

    public String checkLogOutButtonIsPresent() {
        Actions actions = new Actions(driver);
        WebElement link = driver.findElement(logInButton);
        actions.moveToElement(link).build().perform();
        return driver.findElement(logOutButton).getText();
    }

    public HomePage logIn(String email, String password) {
        driver.findElement(logInButton).click();
        driver.findElement(emailFieldInForm).sendKeys(email);
        driver.findElement(passwordFieldForLogin).sendKeys(password);
        driver.findElement(logInButtonInForm).click();
        return this;
    }

    public HomePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;  //возвращаем этот же класс (HomePage)
    }

    public HomePage searchItem(String itemName) { //создаем метод в который будем передавать параметр itemName
        WebElement searchInput = driver.findElement(searchField);
        searchInput.sendKeys(itemName);
        searchInput.sendKeys(Keys.ENTER);
        //driver.findElement(searchField).sendKeys(itemName);
        return this;
    }

    public String getSearchResultText() {
        return driver.findElement(searchResultText).getText();
    }

    public Boolean checkRememberMeCheckBox() {
        driver.findElement(logInButton).click();
        Boolean checkbox = driver.findElement(rememberMeCheckbox).isSelected();
        return checkbox;
    }

    public void checkWantGetNewsCheckBox() {
        if (driver.findElement(wantGetNewsCheckBox).isSelected())
        driver.findElement(By.xpath("//label[@class='user_remember user_remember_2']")).click();
    }
}
