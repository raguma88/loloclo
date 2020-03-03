import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageTest extends TestBase {

    @Test
    public void openBabiesPageTest() {
        BabiesPage babiesPage = homePage.clickBabiesButton();
        String heading = babiesPage.getHeadingText();
        Assert.assertEquals("ОДЕЖДА ДЛЯ НОВОРОЖДЕННЫХ", heading);
    }

    @Test
    public void signInTest() {
        homePage.registration("username22", "test22@mail.ru", "221882921", "221882921");
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String searchResultText = homePage.getSearchResultText();
        Assert.assertEquals("Все результаты", searchResultText);
    }

    @Test
    public void checkRememberMeCheckBoxTest() {
        Boolean checkbox = homePage.checkRememberMeCheckBox();
        Assert.assertTrue(checkbox);
    }
}

