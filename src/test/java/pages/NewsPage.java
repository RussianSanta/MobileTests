package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {
    private static AndroidDriver driver;
    private static WebDriverWait wait;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Messenger\"]/android.widget.ImageView")
    public WebElement messengerButton;
    @AndroidFindBy(accessibility = "Open menu")
    public WebElement openMenu;
    @AndroidFindBy(accessibility = "Settings")
    public WebElement settings;

    public NewsPage(AppiumDriver<MobileElement> driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver,20);
    }

    public MessagePage switchToMessage() {
        wait.until(ExpectedConditions.visibilityOf(messengerButton));
        messengerButton.click();
        return new MessagePage(driver);
    }

    public void clickOnMenu() {
        openMenu.click();
    }

    public SettingsPage switchToSettings() {
        settings.click();
        return new SettingsPage(driver);
    }

    public boolean atPage() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/notifications_button")));
        return !(element == null);
    }
}
