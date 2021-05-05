package com.a.gritsyuk.evnedev;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage")); }
    /**
     * тестовый метод для осуществления аутентификации
     */
        @Test
        public void loginTest() {
        //значение login/password берутся из файла настроек по аналогии с chromedriver
//и loginpage
            loginPage.clickButton();
//вводим логин
            loginPage.inputLogin(ConfProperties.getProperty("login"));
            //нажимаем кнопку входа
            loginPage.clickLoginBtn1();
        //вводим пароль
            loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
            loginPage.clickLoginBtn2();

            String user = profilePage.getUserName();

            Assert.assertEquals(ConfProperties.getProperty("login"), user); }



}