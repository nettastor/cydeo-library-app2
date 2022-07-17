package com.cydeo.library.pages;
import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BasePage{
    @FindBy(id = "inputEmail")
    public WebElement emailInput;
    @FindBy(id = "inputPassword")
    public WebElement passwordInput;
    @FindBy(xpath = "//button")
    public WebElement signinBtn;
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);}
public void login(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signinBtn.click();}}