package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    By usernameInputField = By.xpath("//form[@class='user-login-form']//input[@id='edit-name']");
    By passwordInputField = By.xpath("//form[@class='user-login-form']//input[@id='edit-pass']");
    By submitButton = By.xpath("//form[@class='user-login-form']//button[@id='edit-submit']");

    public LoginPage enterUsername(String username){
        sendKeys(usernameInputField, username, "Username");
        return this;
    }

    public LoginPage enterUsernameWoLogging(String username){
        sendKeys(usernameInputField, username);
        return this;
    }

    public LoginPage enterPassword(String password){
        sendKeys(passwordInputField, password, "Password");
        return this;
    }

    public LoginPage enterPasswordWoLogging(String password){
        sendKeys(passwordInputField, password);
        return this;
    }

    public UserDashboardPage clickSubmitButton(){
        click(submitButton, "Sign in button on login page");
        return new UserDashboardPage();
    }

    public UserDashboardPage clickSubmitButtonWoLogging(){
        click(submitButton);
        return new UserDashboardPage();
    }

}
