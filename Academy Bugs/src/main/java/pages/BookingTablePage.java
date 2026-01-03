package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingTablePage {
	 private WebDriver driver;
	 private WebDriverWait wait;
	 private By bookingTableTab=By.xpath("//*[@id=\"sq-content\"]/div/section/div/a[6]/div/div"); 
	 private By dateField=By.xpath("//*[@id=\"rtb-date_table\"]/tbody/tr[5]/td[3]/div");
//	 private By timeField = By.xpath("//*[@id='rtb-time_root']//div[contains(@class,'rtb-time') or contains(@class,'rtb-time-input')]");
	 private By timeField = By.xpath("//div[@role='combobox' and contains(@aria-owns,'rtb-time')]");



	 private By timeOptionField=By.xpath("//*[@id=\"rtb-time_root\"]/div/div/div/div/ul");
	 private By timeValue=By.xpath("//*[@id=\"rtb-time_root\"]/div/div/div/div/ul/li[6]");
	 private By partyField=By.xpath("//*[@id=\"rtb-party\"]");
	 private By nameField=By.xpath("//*[@id=\"rtb-name\"]");
	 private By emailField=By.xpath("//*[@id=\"rtb-email\"]");
	 private By phoneField=By.xpath("//*[@id=\"rtb-phone\"]");
	 private By addMessageLink=By.xpath("//*[@id=\"post-4251\"]/div/div/form/fieldset[2]/div[4]/a");
	 private By bookingButtonField=By.xpath("//*[@id=\"academy-booking-submit\"]");
	 private By messageField=By.xpath("//*[@id=\"rtb-message\"]");
	 
     public BookingTablePage(WebDriver driver) {
		  this.driver = driver;
		  this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  }
     public String clickBookingTableTab() {
    	
    	 driver.findElement(bookingTableTab).click();
    	 return driver.getCurrentUrl();
     }
	 public int clickDateField() {
		 driver.navigate().to("https://academybugs.com/my-bookings/");
		 List<WebElement> elements = driver.findElements(dateField);
	     return elements.size();
		 
	 }
	 private By timeOption(String time) {
		    return By.xpath("//div[text()='" + time + "']");
	}
	 public void clickTimeField() {
		 driver.navigate().to("https://academybugs.com/my-bookings/");

		    // Wait for Time label (page ready signal)
		    wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//label[text()='Time']")
		    ));

		    // Click the visible Time input (JS click is REQUIRED)
		    WebElement timeInput = wait.until(
		            ExpectedConditions.presenceOfElementLocated(timeField)
		    );

		    ((JavascriptExecutor) driver)
		            .executeScript("arguments[0].scrollIntoView({block:'center'});", timeInput);
		    ((JavascriptExecutor) driver)
		            .executeScript("arguments[0].click();", timeInput);

		    // Wait for dropdown options
		    By timeValue = timeOption("10:00 AM");
		    wait.until(ExpectedConditions.elementToBeClickable(timeValue)).click();
	 }
	 public void clickPartyField() {
		 driver.navigate().to("https://academybugs.com/my-bookings/");
		 Select party = new Select(driver.findElement(partyField));
		 party.selectByValue("3");
		 
	 }
	 public void clickAddMessageField() {
		 driver.navigate().to("https://academybugs.com/my-bookings/");
		 driver.findElement(addMessageLink).click();
	 }
	 public String fillBookingTableForm(String name,String email,String phone,String message) {
		 driver.navigate().to("https://academybugs.com/my-bookings/");

	     wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
	     driver.findElement(emailField).sendKeys(email);
	     driver.findElement(phoneField).sendKeys(phone);

	     // CLICK ADD MESSAGE FIRST
	     driver.findElement(addMessageLink).click();

	     WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(messageField));
	     msg.clear();
	     msg.sendKeys(message);

	    return driver.getCurrentUrl();
		}
	 public void clickSend() {
	        driver.findElement(bookingButtonField).click();
	 }
}
