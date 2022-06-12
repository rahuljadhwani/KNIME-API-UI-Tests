package pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage{

    By numberOfResults = By.xpath("//section[@class='heading']/descendant::p[@class='totalCount']/strong");
    By knimeHubLink = By.xpath("//nav[@class='breadcrumb']/descendant::a[normalize-space()='KNIME Hub']");


    public UserDashboardPage goBackToKnimeHubPage(){
        click(knimeHubLink, "KNIME hub breadcrumb link");
        return new UserDashboardPage();
    }

    public String getNumberOfResults(){
        return "";
    }

}
