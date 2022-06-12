package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    By usernameInputField = By.xpath("//form[@class='user-login-form']//input[@id='edit-name']");
    By passwordInputField = By.xpath("//form[@class='user-login-form']//input[@id='edit-pass']");
    By submitButton = By.xpath("//form[@class='user-login-form']//button[@id='edit-submit']");

    public LoginPage enterUsername(){
        sendKeys(usernameInputField, "", "Username");
        return this;
    }

    public LoginPage enterPassword(){
        sendKeys(passwordInputField, "", "Password");
        return this;
    }

    public LoginPage clickSubmitButton(){
        click(submitButton, "Sign in button on login page");
        return this;
    }

}
