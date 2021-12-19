package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPage {
    private final WebDriverWait wait;

    @AndroidFindBy(id = "com.vkontakte.android:id/writebar_edit")
    public WebElement pasteMes;

    @AndroidFindBy(accessibility = "Send")
    public WebElement sendMessage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Max Zheltov. message for deleting. Red message\"]/android.widget.TextView")
    public WebElement pickMes;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Delete\"]/android.widget.ImageView")
    public WebElement delMes;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement confirmButton;

    @AndroidFindBy(accessibility = "Add attachment")
    public WebElement addAttach;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement pickPhoto;

    @AndroidFindBy(id = "com.vkontakte.android:id/acv_bottom_panel_counter")
    public WebElement attachPhoto;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement allowVK;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public WebElement allowAndroid;

    public ChatPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 20);
    }

    public void pasteMessage() {
        wait.until(ExpectedConditions.visibilityOf(pasteMes));
        pasteMes.sendKeys("message for deleting");
    }

    public void sendMessage() {
        sendMessage.click();
    }

    public void pickMessage() {
        wait.until(ExpectedConditions.visibilityOf(pickMes));
        pickMes.click();
    }

    public void deleteMessage() {
        wait.until(ExpectedConditions.visibilityOf(delMes));
        delMes.click();
    }

    public void confirmDeleting() {
        wait.until(ExpectedConditions.visibilityOf(confirmButton));
        confirmButton.click();
    }

    public void addAttachment() {
        addAttach.click();
    }

    public void pickPhoto() {
        wait.until(ExpectedConditions.visibilityOf(pickPhoto));
        pickPhoto.click();
    }

    public void attachPhoto() {
        wait.until(ExpectedConditions.visibilityOf(attachPhoto));
        attachPhoto.click();
    }

    public void sendPhoto() {
        sendMessage.click();
    }

    public void allowVk() {
        wait.until(ExpectedConditions.visibilityOf(allowVK));
        allowVK.click();
    }

    public void allowAndroid() {
        wait.until(ExpectedConditions.visibilityOf(allowAndroid));
        allowAndroid.click();
    }
}