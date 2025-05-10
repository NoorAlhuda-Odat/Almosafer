package Almosafer.Almosafer;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AppTest extends TestData {

	@BeforeTest
	public void mySetup(){
		
		Setup();
	}
	
	@Test(priority = 1, enabled = false)
	public void ChekTheDefultLanguages () {
		
		String ActualLanguage= driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectLanguage, "Language should be EN by default.");
	}
	
	@Test(priority = 2, enabled = false)
	public void  ChekTheCurrency() {
		
		String ActualCurrency =driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG")).getText();
		Assert.assertEquals(ActualCurrency, ExpectCurrency, "Currency should be SAR.");
	}
	
	@Test(priority = 3, enabled = false)
	public void  ChekTheContactNumber() {
		
		String ActualContactNumber =driver.findElement(By.linkText("+966554400000")).getText();
		Assert.assertEquals(ActualContactNumber, ExpectContactNumber, "Saudi contact number (" + ExpectContactNumber + ") should be visible on the page.");
	}
	
	@Test(priority = 4, enabled = false)
	public void checkQitafLogoIsDisplayed() throws InterruptedException {
		
		WebElement Footer = driver.findElement(By.tagName("footer"));
		WebElement QitafLogo = Footer.findElement(By.cssSelector(".sc-ekulBa.iOOTo")).findElement(By.tagName("svg"));
		boolean ActualResultForThelogo = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualResultForThelogo, ExpectedResultsForTheLogo,"Qitaf Logo is displayed successfully.");	
	}
	
	@Test(priority = 5, enabled = false)
	public void verifyHotelsTabIsNotSelected() {
		
		WebElement HotelsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValueForHotelTab = HotelsTab.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualValueForHotelTab, ExpectedValueForHotelTab, "Hotels tab should NOT be selected by default.");    
	}
	
	@Test(priority = 6, enabled = false)
	public void verifyDefaultDepartureDate() {
		
		List<WebElement> Dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualDepatureDate = Dates.get(0).getText();
		Assert.assertEquals(ActualDepatureDate, ExpectedDepatureDate);	
	}

	@Test(priority = 7, enabled = false)
	public void verifyDefaultReturnDate() {
		
		List<WebElement> Dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualReturnDate = Dates.get(1).getText();
		Assert.assertEquals(ActualReturnDate, ExpectedReturnDate);	
	}
	
	@Test(priority = 8, enabled = false)
	public void RandomlyChangeTheLanguage() {
		
		driver.get(URLs[RandomIndex]);
	      if (driver.getCurrentUrl().contains("en")) {
	    	  String ActualLanaguge = driver.findElement(By.tagName("html")).getDomAttribute("lang");
	    	  Assert.assertEquals(ActualLanaguge, ExpectedLanaguageEn); 
	      }
	      else {
	    	  String ActualLanaguge = driver.findElement(By.tagName("html")).getDomAttribute("lang");
	    	  Assert.assertEquals(ActualLanaguge, ExpectedLanaguageAr);
	      } 
	}

	@Test(priority = 9, enabled = false)
	public void clickCities() throws InterruptedException {
		
		StaysButton();
		WebElement locationInput = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
	      if (driver.getCurrentUrl().contains("en")) {
	    	  locationInput.sendKeys(RandomEnglishCities);
	      } 
	      else {
	    	  locationInput.sendKeys(RandomArabicCities);
	      }
	      // firstSuggestion
	      WebElement UnorderedList = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
	      UnorderedList.findElements(By.tagName("li")).get(1).click();	  
	}
	
	@Test(priority = 10, enabled = false)
	public void selectRandomRoomOption() throws InterruptedException {
		
		//StaysButton();
		WebElement RoomSelectElement = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select MySelect = new Select(RoomSelectElement);
		int RandomDropdownIndex = rand.nextInt(2);
		MySelect.selectByIndex(RandomDropdownIndex);
	}
	
	@Test(priority = 11, enabled = false)
	public void clickSearchHotelsButton() throws InterruptedException {
		
		//StaysButton();
		WebElement searchButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		searchButton.click();
	}
	
	@Test(priority = 12, enabled = false)
	public void NewPage() throws InterruptedException {
		
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement SearchResult = Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='srp_properties_found']")));
		String ResultText = SearchResult.getText();
		System.out.println(ResultText);
		boolean ActualResult = ResultText.contains("found") || ResultText.contains("مكان");
		Assert.assertEquals(ActualResult, ExpectedFinshingSearchHotel);
		
		/* or
		 * Get and print the readyState
		 * String pageState = (String) js.executeScript("return document.readyState");
		 * System.out.println(pageState);
		 * assertEquals(pageState, "complete");
		*/
	}
}
