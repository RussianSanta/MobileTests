package tests;

import helpers.ConfigReader;
import helpers.SetCapability;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.net.URL;

public class VkTests {
    private AppiumDriver<MobileElement> driver;
    private static NewsPage newsPage;
    private static MessagePage messagePage;
    private static SettingsPage settingsPage;
    private static ChatPage chatPage;
    private DesiredCapabilities capabilities;

    @Before
    public void setUp() {
        setAndroidCapabilities(ConfigReader.getProperty("pathBrowserStack"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.tapOnLoginButton();
        loginPage.enterLogin();
        loginPage.enterPassword();
        newsPage = loginPage.tapOnEnterButton();
        Assert.assertTrue("Не выполнен вход", newsPage.atPage());
    }

    private void setAndroidCapabilities(String path) throws JSONException {
        this.capabilities = new DesiredCapabilities();
        JSONObject appiumJson = SetCapability.readJsonFromFile(this.getClass().getClassLoader().getResource(path).getPath());
        JSONObject caps = SetCapability.getCapabilities(appiumJson);
        caps.keySet().forEach(keyStr -> this.capabilities.setCapability(keyStr, caps.get(keyStr)));
        try {
            this.driver = new AndroidDriver(new URL(SetCapability.getUrl(appiumJson)), this.capabilities);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void sendAndDeleteMessage() {
        messagePage = newsPage.switchToMessage();
        Assert.assertTrue("Не открыта страница сообщений", messagePage.atPage());
        chatPage = messagePage.switchToChat();
        chatPage.pasteMessage();
        chatPage.sendMessage();
        chatPage.pickMessage();
        chatPage.deleteMessage();
        chatPage.confirmDeleting();
    }

    @Test
    public void doNoDisturb() {
        newsPage.clickOnMenu();
        settingsPage = newsPage.switchToSettings();
        Assert.assertTrue("Не открыта страница настроек", settingsPage.atPage());
        settingsPage.doNotDisturb();
        settingsPage.pickForHour();
    }

    @Test
    public void sendPhoto() {
        messagePage = newsPage.switchToMessage();
        Assert.assertTrue("Не открыта страница сообщений", messagePage.atPage());
        chatPage = messagePage.switchToChat();
        chatPage.addAttachment();
        chatPage.allowVk();
        chatPage.allowAndroid();
        chatPage.pickPhoto();
        chatPage.attachPhoto();
        chatPage.sendPhoto();
    }

    @Test
    public void swipeChat() {
        messagePage = newsPage.switchToMessage();
        Assert.assertTrue("Не открыта страница сообщений", messagePage.atPage());
        messagePage.swipeDown();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}