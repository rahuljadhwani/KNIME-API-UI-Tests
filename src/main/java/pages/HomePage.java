package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    By signinButton = By.xpath("//div[@class='login']/button[normalize-space()='Sign in']");


    public LoginPage clickOnSignInButton(){
        click(signinButton, "Sign in button on home page");
        return new LoginPage();
    }

}
