package pages.hubui;

import org.openqa.selenium.By;

/**
 * This class contains action methods for web elements present on Search Results Page
 *
 */
public class SearchResultsPage extends BasePage{

    By numberOfResults = By.xpath("//section[@class='heading']/descendant::p[@class='totalCount']/strong");
    By knimeHubLink = By.xpath("//nav[@class='breadcrumb']/descendant::a[normalize-space()='KNIME Hub']");


    public WelcomePage goBackToKnimeHubPage(){
        click(knimeHubLink, "KNIME hub breadcrumb link");
        return new WelcomePage();
    }

    public String getNumberOfResults(){
        return "";
    }

}
