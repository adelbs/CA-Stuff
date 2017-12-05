package obi1.fi.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public static void main(String[] args) throws Exception {
	  runAll();
  }

  public static void runAll() throws Exception {
	  TesteSelenium teste = new TesteSelenium();
	  teste.setUp();
	  teste.testESelenium();
	  teste.tearDown();
  }
  
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8082/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public void testESelenium() throws Exception {
    driver.get(baseUrl + "/RifaWeb/fi/Pessoa/newPessoa");
    driver.findElement(By.id("pessDsNome")).click();
    driver.findElement(By.id("pessDsNome")).clear();
    driver.findElement(By.id("pessDsNome")).sendKeys("teste");
    driver.findElement(By.id("pessDsTelefone")).clear();
    driver.findElement(By.id("pessDsTelefone")).sendKeys("123456789");
    driver.findElement(By.id("pessDsEmail")).clear();
    driver.findElement(By.id("pessDsEmail")).sendKeys("teste@teste.com");
    driver.findElement(By.id("pessDsEmpresa")).clear();
    driver.findElement(By.id("pessDsEmpresa")).sendKeys("reteste");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[@type='button']")).click();
    
    driver.get(baseUrl + "/RifaWeb/fi/Pessoa/list");
    driver.findElement(By.id("pessDsNome")).click();
    driver.findElement(By.id("pessDsNome")).clear();
    driver.findElement(By.id("pessDsNome")).sendKeys("teste");
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//tbody/tr/td)[1]")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    driver.findElement(By.linkText("Home")).click();
  }

  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
