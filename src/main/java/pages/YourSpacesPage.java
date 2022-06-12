package pages;

import enums.SpaceTypes;
import org.openqa.selenium.By;

public class YourSpacesPage extends BasePage{
        String createNewSpaceButtons = "//ul[@class='space-list']/li/div/h3[text()='Create new space']//following-sibling::div/button[normalize-space()='%s']";


        public SpacePage createSpace(SpaceTypes spaceType){
                click(By.xpath(String.format(createNewSpaceButtons, spaceType)), "Create "+spaceType);
                return new SpacePage();
        }
}
