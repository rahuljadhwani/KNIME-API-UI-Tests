package pages;

import org.openqa.selenium.By;

/**
 * This class contains action methods for web elements present on Space Page
 *
 */

public class SpacePage extends BasePage{

    By editSpaceName = By.xpath("//div[@class='editable-heading']/descendant::textarea");
    By saveSpaceNameButton = By.xpath("//button[@title='Save']");
    By cancelEditSpaceName = By.xpath("//button[@title='Cancel']");

    By moreSpaceOptions = By.xpath("//button[contains(@class,'toggle function-button')]");
    By closeSpaceOptions = By.xpath("//button[contains(@class,'closer function-button')]");

    By deleteSpaceButton = By.xpath("//button[normalize-space()='Delete space']");
    By changeSpaceVisibilityButton = By.xpath("//h6[normalize-space()='Visibility']//following-sibling::div/button");

    By deleteSpaceConfirmationHeader = By.xpath("//div[@class='header']/*[text()='Delete this space']");
    By enterSpaceNameToConfirmAction = By.xpath("//div[@class='confirmation']/descendant::input[@placeholder='space name']");
    By deleteSpaceConfirmationButton = By.xpath("//button[contains(text(),'delete space permanently')]");

    By changeVisibilityConfirmationHeader = By.xpath("//div[@class='header']/*[text()='Make this space private']");
    By changeVisibilityConfirmButton = By.xpath("//button[contains(text(),'make this space private')]");

    By currentSpaceName = By.xpath("//div[@class='confirmation']/descendant::strong");



    public Object verifySpaceCreated(){
        /*if(true) return this;
        else return false;*/
        return false;
    }

    public SpacePage editSpaceName(String customSpaceName){
        sendKeys(editSpaceName, customSpaceName, "Edit Space name");
        return this;
    }

    public SpacePage saveSpaceName(){
        click(saveSpaceNameButton, "Save Space name button");
        return this;
    }

    public SpacePage cancelEditSpaceName(){
        click(cancelEditSpaceName, "Cancel edit Space name");
        return this;
    }

    public SpacePage clickMoreOptions(){
        click(moreSpaceOptions, "More Space options");
        return this;
    }

    public SpacePage closeMoreOptions(){
        click(closeSpaceOptions, "Close more options");
        return this;
    }

    public SpacePage deleteSpace(){
        click(deleteSpaceButton, "Delete Space button");
        return this;
    }

    public SpacePage enterSpaceNameToDeleteSpace(String spaceName){
        sendKeys(enterSpaceNameToConfirmAction, spaceName, "Space name in Deletion textarea");
        return this;
    }

    public SpacePage enterSpaceNameToDeleteSpace(){
        sendKeys(enterSpaceNameToConfirmAction, getText(currentSpaceName), "Space name in Deletion textarea");
        return this;
    }


    public YourSpacesPage deleteSpaceConfirm(){
        click(deleteSpaceConfirmationButton, "Delete Space permanently button");
        return new YourSpacesPage();
    }


    public SpacePage changeSpaceVisibility(String spaceName){
        click(changeSpaceVisibilityButton, "Change Space visibility button");
        //wait for header to appear
        sendKeys(enterSpaceNameToConfirmAction, spaceName, "Space name in change visibility textarea");
        click(changeVisibilityConfirmButton, "Change visibility confirmation button");
        //assert change visibility message
        return this;
    }


}
