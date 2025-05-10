package Almosafer.Almosafer;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {
	
	WebDriver driver = new ChromeDriver();
	String URL ="https://global.almosafer.com/en";
	Random rand = new Random();
	
	
//for test 1
 String ExpectLanguage = "en" ;
 
//for test 2
  String ExpectCurrency ="SAR";

//for test 3
  String ExpectContactNumber ="+966554400000" ;

//for test 4
  boolean ExpectedResultsForTheLogo = true;
 
//for test 5
  String ExpectedValueForHotelTab = "false";
 

//for test 6+7
  LocalDate Today = LocalDate.now();
 
	int Tomorrow = Today.plusDays(1).getDayOfMonth();
	String ExpectedDepatureDate = String.format("%02d", Tomorrow);
	
	int TheDayAfterTomorrow = Today.plusDays(2).getDayOfMonth();
	String ExpectedReturnDate = String.format("%02d", TheDayAfterTomorrow);
	
//for test 8
  String[] URLs = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar", };
  int RandomIndex = rand.nextInt(URLs.length);
  String ExpectedLanaguageEn = "en";
  String ExpectedLanaguageAr = "ar";
	
//for test 9
  String[] EnglishCities = { "Dubai", "Jeddah", "Riyadh" };
  int RandomIndex1 = rand.nextInt(EnglishCities.length);
  String RandomEnglishCities =EnglishCities[RandomIndex1];

  String[] ArabicCities = { "دبي", "جدة" };
  int RandomIndex2 = rand.nextInt(ArabicCities.length);
  String RandomArabicCities =ArabicCities[RandomIndex2];

//for test 9/10/11 if you want to run 10 or 11 alone you should remove the comment from it 
  public void StaysButton() throws InterruptedException {
	WebElement hotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	hotelTab.click();
	}

//for test 12
  boolean ExpectedFinshingSearchHotel = true;

//for BeforeTest 
  public void Setup() {
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 	
	driver.findElement(By.cssSelector(".cta__button.cta__saudi")).click();
	}

}
