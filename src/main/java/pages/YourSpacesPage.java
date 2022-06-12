package pages;

import enums.SpaceTypes;
import org.openqa.selenium.By;

public class YourSpacesPage extends BasePage{
        String createNewSpaceButtons = "//ul[@class='space-list']/li/div/h3[text()='Create new space']//following-sibling::div/button[normalize-space()='%s']";
        By spaceCreatedMessage = By.xpath("//span[contains(text(),'Your new space was created successfully!')]");
        By spaceDeletedMessage = By.xpath("//span[contains(text(),'Space was deleted successfully!')]");

        public YourSpacesPage createSpace(SpaceTypes spaceType){
                click(By.xpath(String.format(createNewSpaceButtons, spaceType)), "Create "+spaceType);
                return this;
        }

        public SpacePage verifySpaceCreatedMessage(){
                checkIfDisplayed(spaceCreatedMessage);
                return new SpacePage();
        }

        public YourSpacesPage verifySpaceDeletedMessage(){
                checkIfDisplayed(spaceDeletedMessage);
                return this;
        }
}
