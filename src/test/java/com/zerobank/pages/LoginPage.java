package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(name = "user_login")
    public WebElement userLoginName;

    @FindBy(id = "user_password")
    public WebElement userPassword;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(css = "div[class='alert alert-error']")
    public WebElement alertMessage;

    public void login(String username, String password){
        userLoginName.sendKeys(username);
        userPassword.sendKeys(password);
        submit.click();
    }


}
