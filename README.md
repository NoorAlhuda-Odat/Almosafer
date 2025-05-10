# Almosafer UI Test Automation

This repository contains an automated test suite for the **Almosafer** travel booking website. The tests are written in Java using Selenium WebDriver and TestNG for validating various UI elements and functionalities.

## 📁 Project Structure
The project is structured as follows:

- `AlmosaferUITest.java`: Contains the test scenarios.
- `pom.xml`: Maven configuration for managing dependencies.

## 🛠️ Prerequisites
To run the tests, make sure you have the following tools installed:

- Java 17+
- Selenium WebDriver
- TestNG
- ChromeDriver

## ✅ Test Scenarios

1. **ChekTheDefultLanguages**  
   Verifies that the default site language is English (lang="en").

2. **ChekTheCurrency**  
   Verifies that the default currency is SAR.

3. **ChekTheContactNumber**  
   Confirms that the contact number +966554400000 is displayed on the site.

4. **checkQitafLogoIsDisplayed**  
   Validates that the Qitaf logo (SVG) is visible in the footer.

5. **verifyHotelsTabIsNotSelected**  
   Ensures the Hotels tab is not selected by default.

6. **verifyDefaultDepartureDate**  
   Checks if the departure date is set to Today + 1 day.

7. **verifyDefaultReturnDate**  
   Checks if the return date is set to Today + 2 days.

8. **RandomlyChangeTheLanguage**  
   Randomly changes the site’s language between English and Arabic.

9. **clickCities**  
   Enters a city name randomly based on the selected language (English or Arabic).

10. **selectRandomRoomOption**  
    Randomly selects a room option from the available dropdown options.

11. **clickSearchHotelsButton**  
    Clicks the search button to initiate the search for hotels.

12. **NewPage**  
    Waits for the search results to load and verifies if hotels were found.

## 🚀 How to Run the Tests

### Steps to run:

1. Clone this repository to your local machine.
2. Set up ChromeDriver:
   - Ensure that ChromeDriver is in your system path or configure it in the code.
3. Run the tests:
   - From your IDE, run the `AlmosaferUITest` class.
   - Alternatively, you can run the tests via terminal using Maven:
     ```
     mvn test
     ```

## 🧠 Notes
- **Test Data**: The test data (language, city names, and expected dates) is dynamically generated in the test file.
- **Hotel Search**: Use the helper method `StaysButton()` to navigate to the hotel search page before running the relevant tests.
- **Assumptions**: This project assumes the site is accessible and an active internet connection is available.

## 📌 Future Enhancements
- Enable all test cases and organize them with TestNG groups.
- Implement logging and screenshots on failure.
- Integrate the tests into a CI/CD pipeline (e.g., Jenkins, GitHub Actions).
