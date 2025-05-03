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
	public void mySetup() throws InterruptedException {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		Thread.sleep(1000); 	
		driver.findElement(By.cssSelector(".cta__button.cta__saudi")).click();
	
	}
	
	@Test(priority = 1, enabled = false)
	public void ChekTheDefultLanguages () {
	
		String ActualLanguage= driver.findElement(By.tagName("html")).getDomAttribute("lang");
        Assert.assertEquals(ActualLanguage, ExpectLanguage, "Language should be EN by default.");
        System .out.print(ActualLanguage);
	}
	
	@Test(priority = 2, enabled = false )
	public void  ChekTheCurrency() {
		
		WebElement Currency =driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG"));
        String ActualCurrency = Currency.getText();
        Assert.assertEquals(ActualCurrency, ExpectCurrency, "Currency should be SAR.");
        System .out.print(ActualCurrency);
	}
	
	@Test(priority = 3, enabled = false)
	public void  ChekTheContactNumber() {
		
		WebElement Body = driver.findElement(By.tagName("body"));
		WebElement ContactNumber =Body.findElement(By.linkText("+966554400000"));
		String ActualContactNumber = ContactNumber.getText();
		Assert.assertEquals(ActualContactNumber, ExpectContactNumber, "Saudi contact number (" + ExpectContactNumber + ") should be visible on the page.");
		System .out.print(ActualContactNumber);
	}
	
	@Test(priority = 4, enabled = false)
	public void checkQitafLogoIsDisplayed() throws InterruptedException {
		
	    WebElement Footer = driver.findElement(By.tagName("footer"));
	    WebElement QitafLogo = Footer.findElement(By.xpath(".//*[name()='svg']"));  
	    boolean ActualResultForThelogo = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualResultForThelogo, ExpectedResultsForTheLogo);	
		System.out.println("Qitaf Logo is displayed successfully.");
	}
	
	@Test(priority = 5, enabled = false)
	public void verifyHotelsTabIsNotSelected() {
		
	    WebElement HotelsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	    String ActualValue = HotelsTab.getDomAttribute("aria-selected");
	    Assert.assertEquals(ActualValue, ExpectedValue, "Hotels tab should NOT be selected by default.");
	    
	}
	
	@Test(priority = 6, enabled = false)
	public void verifyDefaultDepartureDate() {
	    WebElement DepartureDate = driver.findElement(By.xpath("//div[@data-testid='FlightSearchBox__FromDateButton']"));
	    String ActualDepartureDay = DepartureDate.getText().replaceAll("\\s+", " ").trim();
	    Assert.assertEquals(ActualDepartureDay, ExpectedDepartureDate, "Departure date should be Today +1 day.");
	}

	@Test(priority = 7, enabled = false)
	public void verifyDefaultReturnDate() {
	    WebElement ReturnDate = driver.findElement(By.xpath("//div[@data-testid='FlightSearchBox__ToDateButton']"));
	    String ActualReturnDay = ReturnDate.getText().replaceAll("\\s+", " ").trim();
	    Assert.assertEquals(ActualReturnDay, ExpectedReturnDate, "Return date should be Today +2 days.");
	}
	
	@Test(priority = 8, enabled = false)
	public void RandomlyChangeTheLanguage() {
		
		String[] URLs = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar", };
		int RandomIndex = rand.nextInt(URLs.length);
		driver.get(URLs[RandomIndex]);
	}

	@Test(priority = 9, enabled = false)
	public void clickCities() throws InterruptedException {
		
		 StaysButton();
	 
		WebElement locationInput = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
		String lang = driver.findElement(By.tagName("html")).getDomAttribute("lang");   

			  if (lang.contains("en")) {
				  locationInput.sendKeys(RandomEnglishCities);
		        } 
			  else {
		        	locationInput.sendKeys(RandomArabicCities);
		        }
		WebElement firstSuggestion = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
			  firstSuggestion.click();
	}
	
	@Test(priority = 10, enabled = false)
	public void selectRandomRoomOption() throws InterruptedException {
		
		//StaysButton();
		
		WebElement RoomSelectElement = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select MySelect = new Select(RoomSelectElement);
		List<WebElement> Option = MySelect.getOptions();
		int RandomDropdownIndex = rand.nextInt(Option.size());
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
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='srp_properties_found']")));
 
        String resultText = searchResult.getText();
        System.out.println(resultText);
 
        boolean actualResult = resultText.contains("found") || resultText.contains("مكان");
 
        Assert.assertEquals(actualResult, ExpectedFinshingSearchHotel);
    }
	
}
