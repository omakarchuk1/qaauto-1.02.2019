package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.util.Iterator;
import java.util.List;

public class SearchTests extends BaseTest {

@Test
    public void basicSearchTest () {
    String userEmail = "sivak1115@outlook.com";
    String userPassword = "Temp1234%";
    String searchTerm = "HR";
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    int searchResultElementsSize =8;

    Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");
    HomePage homePage = landingPage.login(userEmail, userPassword);
    Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load after login.");

    SearchPage searchPage = homePage.search(searchTerm);
    Assert.assertTrue(searchPage.isPageLoaded(), "Search page did not load.");

    List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='search-result__wrapper']"));
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    Iterator<WebElement> itr = searchResultElements.iterator();
     Assert.assertEquals(searchResultElements.size(),searchResultElementsSize, "The search results is not equal to 8");
   //Assert.assertTrue(searchResultElements.size().contains(searchTerm), "Result does not contain HR.");






}
}
















//System.out.println("Search results count: "+searchResultElements.size());