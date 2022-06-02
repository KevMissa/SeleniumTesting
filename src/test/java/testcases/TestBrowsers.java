package testcases;

import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://shopdisney.com");
		String title = driver.getTitle();
		System.out.println(title.toUpperCase());
		Thread.sleep(2000);
		WebElement Clothing = driver.findElement(By.xpath("(//*[contains (text(),\"Clothing\" )])[5]"));
		WebElement ClothingContainer = driver.findElement(By.xpath("(//a[@id=\"clothing\"])[1]"));
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		
		String fontSize = Clothing.getCssValue("font-size");
		String color = Clothing.getCssValue("color");
		String fontWeight = Clothing.getCssValue("font-weight");
		Dimension size = Clothing.getSize();
		System.out.println("The color of the clothing button is: " + color);
		System.out.println("The font size of the clothing button is: " +fontSize);
		System.out.println("The font weight of the clothing button is: " +fontWeight);
		System.out.println("The size of the clothing button is: " +size);
		String paddingBottom = ClothingContainer.getCssValue("padding-bottom");
		String paddingLeft = ClothingContainer.getCssValue("padding-left");
		String paddingRight = ClothingContainer.getCssValue("padding-right");
		String paddingTop = ClothingContainer.getCssValue("padding-top");
		
		System.out.println("Bottom padding is: " + paddingBottom);
		System.out.println("Left padding is: " + paddingLeft);
		System.out.println("Right padding is: " + paddingRight);
		System.out.println("Top padding is: " + paddingTop);
		
		Thread.sleep(2000);
		actions.moveToElement(Clothing).perform();
		Thread.sleep(5000);
		String colorHover = Clothing.getCssValue("color");
		String fontSizeHover = Clothing.getCssValue("font-size");
		String fontWeightHover = Clothing.getCssValue("font-weight");
		Dimension sizeHover = Clothing.getSize();
		System.out.println("The font size when tab is hovered is: " +fontSize);
		System.out.println("The font weight when Clothing tab is hovered is: " + fontWeight);
		System.out.println("The color when Clothing tab is hovered is: " +colorHover);
		System.out.println("The size of the Clothing element is: " +sizeHover);
		
		SoftAssert softassert = new SoftAssert();
		
		
		String expectedPaddingBottom = "25px";
		softassert.assertEquals(paddingBottom, expectedPaddingBottom);
		softassert.assertAll();
		
		Thread.sleep(5000);
		driver.close(); //CURRENT BROWSER WINDOW
		driver.quit();	//CURRENT BROWSER WINDOW + ALL RELATED BROWSER IN EXECUTION
		
		
	}
}
