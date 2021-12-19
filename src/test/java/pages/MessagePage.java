package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    public WebElement toChat;

    public MessagePage(AppiumDriver<MobileElement> driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 10);
    }

    public void swipeDown () {
        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(539, 1610))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(new PointOption().withCoordinates(555, 628))
                .release()
                .perform();
    }

    public ChatPage switchToChat() {
        wait.until(ExpectedConditions.visibilityOf(toChat));
        toChat.click();
        return new ChatPage(driver);
    }

    public boolean atPage() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/im_dialogs_list_container")));
        return !(element == null);
    }
}
