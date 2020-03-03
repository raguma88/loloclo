import org.junit.Assert;
import org.junit.Test;

public class PantsPageTest extends TestBase {

    @Test
    public void addItemtoCartTest() {
        navigate.goToPantsPage();
        pantsPage.chooseColor("Розовый");
        popup.closeModalPopUpAboutCoockies();
        popup.closeJivoChat();
        popup.closePopupWindow();
        pantsPage.chooseSize(3);
        pantsPage.buyItem();
        String text = pantsPage.getaddedItemText();
        Assert.assertEquals("Товар добавлен в корзину!", text);
    }
}
