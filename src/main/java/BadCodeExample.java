import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.google.com.ua/");
              // Find the text input element by its name
        //WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
      //element.sendKeys("Selenium");
       // Submit the form. WebDriver will find the form for us from the element
        //element.submit();
        //Quit
        //driver.quit();

        String searchTerm = "Selenium";
        WebElement searchField = driver.findElement(By.name("q"));
        //WebElement searchField1 = driver.findElement(By.xpath("//input[@name='q']"));
        //WebElement searchField1 = driver.findElement(By.xpath("//*[@name='q']"));
       searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        //div[@class='srg']/div
        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='srg']/div"));
        System.out.println("Search results count: "+searchResultElements.size());
        /*Loop through List of WebElements in searchResultElements list. Print text of each WebElement
        Iterator<WebElement> itr = searchResultElements.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next().getText());

            String myText = itr.next().getText();

            if(myText.contains("Selenium")){
            System.out.println("searchTerm found");
          }else{
              System.out.println("searchTerm not found");

*/

        //For each WebElement in searchResultsElements print text

        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText ();
            System.out.println(searchResultElementText);
            if (searchResultElementText.toLowerCase().contains(searchTerm)) {
                System.out.println("searchTerm found");
        } else {
            System.out.println("searchTerm not found");
          }

        }
    }
}
