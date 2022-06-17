package pages.hubui;

import org.openqa.selenium.By;
import reports.ExtentLogger;

/**
 * This class contains action methods for web elements present on HomePage
 *
 */
public class HomePage extends BasePage{

    By signinButton = By.xpath("//div[@class='login']/button[normalize-space()='Sign in']");
    By acceptCookiesButton = By.xpath("    //*[text()='Cookie settings']/parent::div/following-sibling::div/button[normalize-space()='Accept and close']");


    public HomePage clickAcceptCookies() {
        try{
            click(acceptCookiesButton, "Accept cookies and close button");
        } catch (Exception e){
            ExtentLogger.info("Accept cookies dialog box didn't appear.");
        }
        return this;
    }

    public HomePage clickAcceptCookiesWithoutLogging() {
        try{
            click(acceptCookiesButton);
        } catch (Exception e){
            //add extent logging here later
        }
        return this;
    }

    public LoginPage clickOnSignInButton(){
        click(signinButton, "Sign in button on home page");
        return new LoginPage();
    }

    public LoginPage clickOnSignInButtonWithoutLogging(){
        click(signinButton);
        return new LoginPage();
    }

}
