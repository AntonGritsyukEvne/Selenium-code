package com.a.gritsyuk.evnedev;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"gb\"]/div/div[2]/a")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@id, 'identifierId']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='identifierNext]/div/button")
    private WebElement nextBtn;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwdField;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button")
    private WebElement nextBtn2;

    public void inputLogin(String login) {
        loginField.sendKeys(login); }


    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLoginBtn() {
        nextBtn.click(); }

    public void clickLoginBtn() {
        nextBtn2.click(); } }

