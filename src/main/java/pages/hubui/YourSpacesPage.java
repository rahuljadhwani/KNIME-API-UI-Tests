package pages.hubui;

import enums.SpaceTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reports.ExtentLogger;

import java.util.List;

/**
 * This class contains action methods for web elements present on Your Spaces Page
 *
 */
public class YourSpacesPage extends BasePage{
        String createNewSpaceButtons = "//ul[@class='space-list']/li/div/h3[text()='Create new space']//following-sibling::div/button[normalize-space()='%s']";
        By spaceCreatedMessage = By.xpath("//span[contains(text(),'Your new space was created successfully!')]");
        By spaceDeletedMessage = By.xpath("//span[contains(text(),'Space was deleted successfully!')]");


        By yourSpacesPageHeader = By.xpath("//h2[@class='title' and text()='Your spaces']");
        By yourSpacesList = By.xpath("//ul[@class='space-list']/li");
        By createSpaceTile = By.xpath("//ul[@class='space-list']/li/div/h3[text()='Create new space']");
        By lastEditedDates = By.xpath("//span[@class='date']");

        By sideMenuSettings = By.xpath("//div[@class='menus']/descendant::span[normalize-space()='Settings']");
        By sideMenuOverview = By.xpath("//div[@class='menus']/descendant::span[normalize-space()='Overview']");

        By footerKnimeMessage = By.xpath("//footer/descendant::div/h4[normalize-space()='KNIMEOpen for Innovation']");
        By footerAddress = By.xpath("//footer/descendant::address[normalize-space()='KNIME AG Hardturmstrasse 66 8005 Zurich, Switzerland']");

        public YourSpacesPage createSpace(SpaceTypes spaceType){
                click(By.xpath(String.format(createNewSpaceButtons, spaceType)), "Create "+spaceType);
                return this;
        }

        public SpacePage verifySpaceCreatedMessage(){
                Assert.assertTrue(checkIfDisplayed(spaceCreatedMessage));
                ExtentLogger.info("Space created successfully.");
                return new SpacePage();
        }

        public YourSpacesPage verifySpaceDeletedMessage(){
                Assert.assertTrue(checkIfDisplayed(spaceDeletedMessage));
                ExtentLogger.info("Space deleted successfully");
                return this;
        }

        public YourSpacesPage verifyYourSpacesHeader(){
                Assert.assertTrue(checkIfDisplayed(yourSpacesPageHeader));
                ExtentLogger.info("Your Spaces header presence verified");
                return this;
        }

        public YourSpacesPage verifySpaceList(){
                checkIfDisplayed(yourSpacesList);
                List<WebElement> spaceTiles = getDriver().findElements(yourSpacesList);
                Assert.assertTrue(spaceTiles.size()>=3);
                Assert.assertTrue(getDriver().findElements(lastEditedDates).size()==spaceTiles.size()-1);
                ExtentLogger.info("Space list and Last edited date verified");
                return this;
        }

        public YourSpacesPage verifyCreateNewSpaceOptions(){
                Assert.assertTrue(checkIfDisplayed(createSpaceTile));
                ExtentLogger.info("create new Space tile is present on Your Spaces page");
                Assert.assertTrue(checkIfDisplayed(By.xpath(String.format(createNewSpaceButtons, SpaceTypes.PRIVATE))));
                ExtentLogger.info("create private Space tile is present on Your Spaces page");
                Assert.assertTrue(checkIfDisplayed(By.xpath(String.format(createNewSpaceButtons, SpaceTypes.PUBLIC))));
                ExtentLogger.info("create public Space tile is present on Your Spaces page");
                return this;
        }

        public YourSpacesPage verifyFooterDetails(){
                Assert.assertTrue(checkIfDisplayed(footerKnimeMessage));
                ExtentLogger.info("KNIME Open for Innovation message is present in footer");
                Assert.assertTrue(checkIfDisplayed(footerAddress));
                ExtentLogger.info("correct KNIME address is present in footer");
                return this;
        }
}
