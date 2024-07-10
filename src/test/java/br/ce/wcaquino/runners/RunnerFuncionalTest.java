package br.ce.wcaquino.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = "br.ce.wcaquino.steps",
    tags = "@funcionais",
    plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
    monochrome = true,
    snippets = SnippetType.CAMELCASE,
    dryRun = false
 
)
public class RunnerFuncionalTest {
	
	@BeforeClass
	public static void reset() {
	        WebDriver driver = new ChromeDriver();
	        
	        driver.get("https://seubarriga.wcaquino.me/"); // Substitua pela URL correta

	        // Faça o login
	        driver.findElement(By.id("email")).sendKeys("I@hotmail.com");
	        driver.findElement(By.id("senha")).sendKeys("1234");
	        driver.findElement(By.tagName("button")).click();
	        driver.findElement(By.linkText("reset")).click();

	        
		
		driver.quit();
	}

}


