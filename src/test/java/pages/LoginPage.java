package pages;

import helpers.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final AndroidDriver driver;
    @AndroidFindBy(id = "com.vkontakte.android:id/login_button")
    public WebElement logButton;
    @AndroidFindBy(id = "com.vkontakte.android:id/email_or_phone")
    public WebElement enterLogin;
    @AndroidFindBy(id = "com.vkontakte.android:id/vk_password")
    public WebElement enterPassword;
    @AndroidFindBy(id = "com.vkontakte.android:id/continue_btn")
    public WebElement enterButton;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void tapOnLoginButton() {
        logButton.click();
    }

    public void enterLogin() {
        enterLogin.sendKeys(ConfigReader.getProperty("login"));
    }

    public void enterPassword() {
        enterPassword.sendKeys(ConfigReader.getProperty("password"));
    }

    public NewsPage tapOnEnterButton() {
        enterButton.click();
        return new NewsPage(driver);
    }
}
