# Selenium WebDriver Automation Testing
This project contains automated test cases written in Java using Selenium WebDriver.
It demonstrates basic how to search on Google and verify page content.

***Note***: Google implements CAPTCHA challenges to block automation tools like Selenium. Therefore, a CAPTCHA may appear after entering keywords and pressing Enter, which prevents full automation of the search flow. However, the verification steps after the search are still implemented as usual.

### Prerequisites
- Java JDK 21
- IntelliJ IDEA
- Selenium WebDriver
- TestNG
- Firefox or Chrome browser

### Test Cases
**TC_01_SearchBox
- Opens https://www.google.com
- Enters a keyword into the search box and presses Enter
- // Due to Google CAPTCHA, search results may not appear during real-time automated execution after pressing Enter
- Continues by clicking on one of the search result links and verifying the redirection

**TC_02_VerifyPageTitle
- Bypasses Google CAPTCHA by opening a direct Google Search URL with the keyword "Automation"
- Verifies the title of the result page
