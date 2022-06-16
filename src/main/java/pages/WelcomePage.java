package pages;

import org.openqa.selenium.By;

/**
 * This class contains action methods for web elements present on Welcome Page
 *
 */
public class WelcomePage extends BasePage{

    By userProfileIcon = By.xpath("//div[contains(@class, 'avatar-profile')]/parent::button");
    By searchBox = By.xpath("//form[@id='search']//input[@name='q']");
    By searchButton = By.xpath("//form[@id='search']//button[@title='Search']");
    By clearSearchText = By.xpath("//form[@id='search']//button[@title='Clear']");
    String userSubMenu = "//div[contains(@class, 'avatar-profile')]/parent::button/following-sibling::div/ul/li/descendant::span[text()='%s']";

    public Object verifySuccessfulLogin(){
       /* if(Welcome text is present){
        return this;}
        else return false;*/
        return "";
    }

    public WelcomePage clickAvatarProfile(){
        click(userProfileIcon, "User profile avatar");
        return this;
    }

    public WelcomePage clickAvatarProfileWoLogging(){
        click(userProfileIcon);
        return this;
    }

    public UserProfile clickUserProfile(){
        click(By.xpath(String.format(userSubMenu, "Profile")), "User profile link");
        return new UserProfile();
    }

    public HomePage clickLogout(){
        click(By.xpath(String.format(userSubMenu, "Logout")), "Logout link");
        return new HomePage();
    }

    public HomePage clickLogoutWoLogging(){
        click(By.xpath(String.format(userSubMenu, "Logout")));
        return new HomePage();
    }

    public YourSpacesPage clickUserSpaces(){
        click(By.xpath(String.format(userSubMenu, "Spaces")), "User Spaces link");
        return new YourSpacesPage();
    }

    public WelcomePage enterSearchText(){
        click(searchBox, "Search box");
        sendKeys(searchBox, "", "Search box");
        return this;
    }

    public WelcomePage clickSearchButton(){
        click(searchButton, "Search button");
        return this;
    }

    public WelcomePage clickClearSearchText(){
        click(clearSearchText, "Clear search text button");
        return this;
    }
}
