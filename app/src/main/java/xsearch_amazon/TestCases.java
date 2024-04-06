package xsearch_amazon;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
    WebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testcase01() {
		System.out.println("Start Test case: testCase01");
		driver.get("https://www.amazon.in/");
		String Url = driver.getCurrentUrl();

		if (Url.toLowerCase().contains("amazon")) {
			System.out.println("testcase01: Pass");
		} else {
			System.out.println("testcase01: Failed");
		}
		System.out.println("The current Url is: " + Url);

		System.out.println("end Test case: testCase01");
	}

	public void testcase02() throws InterruptedException {
		System.out.println("Start Test case: testCase02");
		driver.get("https://www.amazon.in/");

        Thread.sleep(2000);

		WebElement textbox = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(1000);
		textbox.sendKeys("laptop");
        Thread.sleep(1000);
		textbox.submit();
		
		Thread.sleep(2000);

		// if(driver.getPageSource().toLowerCase().contains("laptop"))
		// or
		boolean ispresent = false;
		List<WebElement> searchTerm = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		for (WebElement checkTerms : searchTerm) {
			String Text = checkTerms.getText();
			if (Text.toLowerCase().contains("laptop")) {
				ispresent = true;
				System.out.println("Testcase02: Pass");
				break;

			}
		}

		System.out.println("end Test case: testCase02");
	}

	public void testcase03() throws InterruptedException {
		System.out.println("Start Test case: testCase03");
		driver.get("https://www.amazon.in/");
		WebElement checkText = driver.findElement(By.xpath("//a[text()=' Electronics ']"));
		checkText.click();
		Thread.sleep(2000);
		String Cureenturl = driver.getCurrentUrl();
		if (Cureenturl.toLowerCase().contains("electronics")) {
			System.out.println("Testcase03: Pass");
		}
		System.out.println("end Test case: testCase03");
	}


    public void testCase02() throws InterruptedException {
		System.out.println("Start Test case: testCase02");
		driver.get("https://www.amazon.in/");

		WebElement textbox = driver.findElement(By.id("twotabsearchtextbox"));
		textbox.sendKeys("laptop");
		textbox.submit();
		
		Thread.sleep(2000);

		// if(driver.getPageSource().toLowerCase().contains("laptop"))
		
		boolean ispresent = false;
		List<WebElement> searchTerm = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		for (WebElement checkTerms : searchTerm) {
			String Text = checkTerms.getText();
			if (Text.toLowerCase().contains("laptop")) {
				ispresent = true;
				System.out.println("Testcase02: Pass");
				break;

			}
		}

		System.out.println("end Test case: testCase02");
	}

	public void testCase03() throws InterruptedException {
		System.out.println("Start Test case: testCase03");
		driver.get("https://www.amazon.in/");
		WebElement checkText = driver.findElement(By.xpath("//a[text()=' Electronics ']"));
		checkText.click();
		Thread.sleep(2000);
		String Cureenturl = driver.getCurrentUrl();
		if (Cureenturl.toLowerCase().contains("electronics")) {
			System.out.println("Testcase03: Pass");
		}
		System.out.println("end Test case: testCase03");
	}
    
}
