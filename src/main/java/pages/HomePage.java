package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    By signinButton = By.xpath("//div[@class='login']/button[normalize-space()='Sign in']");
    By acceptCookiesButton = By.xpath("    //*[text()='Cookie settings']/parent::div/following-sibling::div/button[normalize-space()='Accept and close']");


    public HomePage clickAcceptCookies() {
        click(acceptCookiesButton, "Accept cookies and close button");
        return this;
    }

    public LoginPage clickOnSignInButton(){
        click(signinButton, "Sign in button on home page");
        return new LoginPage();
    }

}
