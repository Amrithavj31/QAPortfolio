package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	  private WebDriver driver;
	  private WebDriverWait wait;
	  private By contactTabLink = By.xpath("//*[@id=\"sq-content\"]/div/section/div/a[2]/div/div/p[2]");
	  private By contactFormLink=By.xpath("//b[normalize-space()='Contact Us Form']");
	  private By firstNameField=By.id("first_name");
	  private By lastNameField=By.xpath("//*[@id=\"contact-form\"]/div[1]/div/div[2]/input");
	  private By emailField=By.xpath("//*[@id=\"contact-form\"]/div[2]/input");
	  private By subjectField=By.xpath("//*[@id=\"contact-form\"]/div[3]/input");
	  private By messageField=By.xpath("//*[@id=\"input-message\"]");
	  private By sendButton=By.xpath("//*[@id=\"submit-contact-form\"]");
	 
	  
	  public ContactUsPage(WebDriver driver) {
		  this.driver = driver;
		  this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  }
	  
	  public int clickContactTabLink() {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(contactTabLink));
	   	 	List<WebElement> elements = driver.findElements(contactTabLink);
	        return elements.size();
	  }
	  public int clickContactFormLink() {
	   	 	List<WebElement> elements = driver.findElements(contactFormLink);
	   	 	System.out.println("size "+elements.size()                                                                                                                                                                                                                                                                              );
	        return elements.size();
	  }
	  public void clickFirstNameLink(String firstName) {
		  driver.navigate().to("https://academybugs.com/contact-us-form/");
		  WebElement element = driver.findElement(firstNameField);
		  element.clear();
		  element.sendKeys(firstName);	
	  }
	  public void clickLastNameLink(String lastName) {
		  driver.findElement(lastNameField).sendKeys(lastName);
	  }
	  public void clickEmailLink(String email) {
		  driver.findElement(emailField).sendKeys(email);
	  }
	  public void clickSubjectLink(String subject) {
		  driver.findElement(subjectField).sendKeys(subject);
	  }
	  public void clickMessageLink(String message) {
		  driver.findElement(messageField).sendKeys(message);
	  }
	  public void clickSendButtonLink() {
		  driver.findElement(sendButton).click();
	  }
	    public void fillContactForm(String firstName,String lastName,String email,String subject,String message) {
	    	 driver.navigate().to("https://academybugs.com/contact-us-form/");

	    	wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));

	        driver.findElement(firstNameField).clear();
	        driver.findElement(firstNameField).sendKeys(firstName);

	        driver.findElement(lastNameField).clear();
	        driver.findElement(lastNameField).sendKeys(lastName);

	        driver.findElement(emailField).clear();
	        driver.findElement(emailField).sendKeys(email);

	        driver.findElement(subjectField).clear();
	        driver.findElement(subjectField).sendKeys(subject);

	        driver.findElement(messageField).clear();
	        driver.findElement(messageField).sendKeys(message);
	    }
	    // Click Send button
	    public void clickSend() {
	        wait.until(ExpectedConditions.elementToBeClickable(sendButton));
	        driver.findElement(sendButton).click();
	    }

	    // Used for assertion in test
	    public boolean isOnContactForm() {
	        return driver.getCurrentUrl().contains("contact-us-form");
	    }
}
