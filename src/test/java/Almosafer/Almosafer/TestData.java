package Almosafer.Almosafer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
 String ExpectedValue = "false";
 

//for test 6+7
 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd EEEE"); // مثال: May 02 Friday
	LocalDate today = LocalDate.now();
	String ExpectedDepartureDate = today.plusDays(1).format(formatter);
	String ExpectedReturnDate = today.plusDays(2).format(formatter);
	
//for test 9
String[] EnglishCities = { "Dubai", "Jeddah", "Riyadh" };
int RandomIndex1 = rand.nextInt(EnglishCities.length);
String RandomEnglishCities =EnglishCities[RandomIndex1];

String[] ArabicCities = { "دبي", "جدة" };
int RandomIndex2 = rand.nextInt(ArabicCities.length);
String RandomArabicCities =ArabicCities[RandomIndex2];

//for test 9/10/11 if you want to run 10 or 11 alone you should remove the comment from it 
public void StaysButton() throws InterruptedException {
	Thread.sleep(1000);
	WebElement header = driver.findElement(By.tagName("header"));
	WebElement staysLink = header.findElement(By.xpath("//a[@data-testid='Header__HotelsNavigationTab']"));
	staysLink.click();
	}

//for test 12
boolean ExpectedFinshingSearchHotel = true;

}
