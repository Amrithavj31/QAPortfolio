package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    private By articlesField=By.xpath("//p[text()='The articles should show appropriate content, but in this example clicking an article shows an error page.']");
    private By sendButtonLinkField=By.xpath("//h5[text()='Send button returns an error page']");
    private By videoLinkField = By.xpath("//h5[text()='Video player doesn’t work']");
    private By articlesErrorField = By.xpath("//h5[text()='Articles show an error page']");
    private By searchField= By.xpath("//h5[text()='Search button leads to an error']");
    private By bookTableField = By.xpath("//*[@id=\"sq-content\"]/div/section/div/a[6]/div/div/h5");
    private By helpLinkField =  By.xpath("//li[@id='menu-item-2363']//a[@href='#']");
    private By exampleOfBugField=By.xpath("//*[@id=\"menu-item-5906\"]/a");
    private By typesOfBugField=By.xpath("//*[@id=\"menu-item-1024\"]/a");
    private By findBugField =By.xpath("//*[@id=\"menu-item-561\"]/a");
    private By reportBugField = By.xpath("//*[@id=\"menu-item-5687\"]/a");
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
  
    public int exampleOfBugLink() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(exampleOfBugField));
   	 	List<WebElement> elements = driver.findElements(exampleOfBugField);
        return elements.size();
    }
    public int typeOfBugLink() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(typesOfBugField));
      	 List<WebElement> elements = driver.findElements(typesOfBugField);
         return elements.size();
    }
    public int findBugLink() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(findBugField));
     	 List<WebElement> elements = driver.findElements(findBugField);
        return elements.size();
   }
    public int reportBugLink() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(reportBugField));
    	 List<WebElement> elements = driver.findElements(reportBugField);
       return elements.size();
  }
    public int socialShare() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(articlesField));
    	 List<WebElement> elements = driver.findElements(articlesField);
         return elements.size();
    }
    public int sendButtonBug() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(sendButtonLinkField));
   	 	List<WebElement> elements = driver.findElements(sendButtonLinkField);
        return elements.size();
   }
    public int videoLinkBug() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(videoLinkField));
      	 List<WebElement> elements = driver.findElements(videoLinkField);
      	 return elements.size();
     }
    public int articlesBug() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(articlesField));
     	 List<WebElement> elements = driver.findElements(articlesErrorField);
     	 return elements.size();
    }
    public int searchBug() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
    	 List<WebElement> elements = driver.findElements(searchField);
         return elements.size();
   }
   public int bookingBug() {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(bookTableField));
   	 	List<WebElement> elements = driver.findElements(bookTableField);
        return elements.size();
  }
   public int helpLink() {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(helpLinkField));
	   	 List<WebElement> elements = driver.findElements(helpLinkField);
	     return elements.size();
	  }
}
