package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindBugsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private By lowerLimitLink= By.xpath("//*[@id=\"ec_product_page\"]/div[1]/span[1]/a[1]");
	private By upperLimitLink= By.xpath("//*[@id=\"ec_product_page\"]/div[1]/span[1]/a[3]");
	private By addToCartButton= By.xpath("//*[@id=\"ec_add_to_cart_5\"]");
	private By filterDropDown=By.xpath("//*[@id=\"sortfield\"]");
	private By viewCartButton= By.xpath("//a[@title='View Cart']");
	private By productDetails= By.xpath("//*[@id=\"ec_product_image_effect_4281370\"]/a");
	private By shoesProduct= By.xpath("//*[@id=\"ec_product_image_effect_4481370\"]/a");
	

	
	public FindBugsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	public String clickDefaultFilterLink() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Default Sorting");
		return driver.getCurrentUrl();
	}
	public String clickLowerLimitLink() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
	   	driver.findElement(lowerLimitLink).click();
	   	return driver.getCurrentUrl();
	}
	public String clickUpperLimitLink() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
	   	driver.findElement(upperLimitLink).click();
	   	return driver.getCurrentUrl();
	}
	public Select clickDropDown() {
	    return new Select(driver.findElement(filterDropDown));
	}
	public String clickPriceToLowFilter() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Price Low-High");
		return driver.getCurrentUrl();
	}
	public String clickPriceToHigh() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Price High-Low");
		return driver.getCurrentUrl();
	}
	public String clickTitleAZFilter() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Title A-Z");
		return driver.getCurrentUrl();	
	}
	public String clickTitleZAFilter() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Title Z-A");
		return driver.getCurrentUrl();
	}
	public String clickNewestFilter() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Newest");
		return driver.getCurrentUrl();
	}
	public String clickOldestFilter() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Oldest");
		return driver.getCurrentUrl();
	}
	public String clickBestRatingFilter() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Best Rating");
		return driver.getCurrentUrl();
	}
	public String clickMostViewedFilter() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		Select dropDown=clickDropDown();
		dropDown.selectByVisibleText("Most Viewed");
		return driver.getCurrentUrl();
	}
	public String clickAddToCart() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		driver.findElement(addToCartButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
		return driver.getPageSource();		
	}
	public String clickJeansPrduct() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		driver.findElement(productDetails).click();
		return driver.getCurrentUrl();
	}
	public String clickShoesPrduct() {
		driver.navigate().to("https://academybugs.com/find-bugs/");
		driver.findElement(shoesProduct).click();
		return driver.getCurrentUrl();
	}
	
}
