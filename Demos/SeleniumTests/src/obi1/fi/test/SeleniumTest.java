package obi1.fi.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private SeleniumTO seleniumTO = new SeleniumTO();
	
	private boolean allTestOK = true;
	
	public static void main(String[] args) {
		new SeleniumTest().runTest();
	}

	public void runTest() {
		try {
			setUp();
			testSelenium();
		}
		catch (Exception x) {
			allTestOK = false;
			x.printStackTrace();
		}
		finally {
			try {
				tearDown();
			}
			catch (Exception x) {
				x.printStackTrace();
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		
    	//Lendo o excel
    	seleniumTO.setExcelFile(new File("C:\\\\SELENIUM\\\\massaSelenium.xlsx"));
		FileInputStream file = new FileInputStream(seleniumTO.getExcelFile());
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet;
		Row row;
		Iterator<Row> rowIterator;

		//Lendo as configuracoes
		sheet = workbook.getSheet("conf");
		seleniumTO.setWorkbook(workbook);
		seleniumTO.setUrl(sheet.getRow(0).getCell(1).getStringCellValue());
		
		//Lendo os dados para o teste
		SeleniumDataTO dataTO;
		sheet = workbook.getSheet("data");
		rowIterator = sheet.iterator();
		int rowNum = 0;
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			
			if (rowNum > 0) {
				dataTO = new SeleniumDataTO();
				dataTO.setRowNum(rowNum);
				dataTO.setTipoCliente(row.getCell(0).getStringCellValue());
				dataTO.setTipoCartao(row.getCell(1).getStringCellValue());
				dataTO.setLogin(row.getCell(2).getStringCellValue());
				dataTO.setSenha(row.getCell(3).getStringCellValue());
				
				seleniumTO.getDataList().add(dataTO);
			}
			
			rowNum++;
		}
		
		System.setProperty("webdriver.gecko.driver", "C:\\Java\\LIB\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void testSelenium() throws Exception {

		for (SeleniumDataTO dataTO : seleniumTO.getDataList()) {
			try {
				driver.get(seleniumTO.getUrl());
				
				try {
					//Desloga para logar com o proximo usuario, 
					//faz isso em primeiro lugar caso o usuario do teste anterior tenha ficado logado por conta de algum erro
					if (driver.findElement(By.xpath("//a[contains(text(),'[Sair]')]")).isDisplayed())
						driver.findElement(By.xpath("//a[contains(text(),'[Sair]')]")).click();
				}
				catch (Exception x) {}
				
				driver.findElement(By.id("menuLogin")).click();
				driver.findElement(By.id("clieDsLogin")).clear();
				driver.findElement(By.id("clieDsLogin")).sendKeys(dataTO.getLogin());
				driver.findElement(By.id("clieDsPwd")).clear();
				driver.findElement(By.id("clieDsPwd")).sendKeys(dataTO.getSenha());
				driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
				//Compra um ingresso de cada tipo
				Thread.sleep(500);
				checkEvento("1", "Futebol", dataTO);
				checkEvento("2", "Shows", dataTO);
				checkEvento("3", "Teatro", dataTO);
				checkEvento("4", "Cinema", dataTO);
				checkEvento("5", "Lutas", dataTO);
	
				//Desloga para logar com o proximo usuario
				driver.findElement(By.xpath("//a[contains(text(),'[Sair]')]")).click();
				dataTO.setPassou("OK");
			}
			catch (Exception x) {
				allTestOK = false;
				dataTO.setPassou(x.getMessage());
			}
		}
    
	}

	public void checkEvento(String idMenu, String evento, SeleniumDataTO dataTO) throws Exception {
		driver.findElement(By.xpath("//div[@onclick=\"openMenu('../Ticket/load?evenCdTipo="+ idMenu +"');\"]")).click();
		if (!isElementPresent(By.cssSelector("div.ticket"))) {
			verificationErrors.append("Erro ao tentar abrir o evento '"+ evento +"'.");
			throw new Exception("Nenhum ticket de '"+ evento +"' encontrado.");
		}

		//Fazendo a compra
		driver.findElement(By.xpath("//form/div[2]//button")).click();
		driver.findElement(By.xpath("//div[@id='dialogTemplate']//button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='dialogTemplate']/div[3]/button[3]")).click();
	}
  
	@After
	public void tearDown() throws Exception {

		FileOutputStream fileOut = new FileOutputStream(seleniumTO.getExcelFile());
		try {
			//Gravando o resultado dos testes no excel
			XSSFSheet sheet = seleniumTO.getWorkbook().getSheet("data");
			Row row;
			for (SeleniumDataTO dataTO : seleniumTO.getDataList()) {
				row = sheet.getRow(dataTO.getRowNum());
				row.createCell(4).setCellValue(dataTO.getPassou());
			}
			seleniumTO.getWorkbook().write(fileOut);
		}
		catch (Exception x) {
			x.printStackTrace();
		}
		finally {
			fileOut.close();
		}
		
		if (allTestOK) {
			System.out.println("Todos os testes passaram!");
		}
		else {
			System.out.println("Alguns testes falharam!");
			System.out.println("Verificar em "+ seleniumTO.getExcelFile().getAbsolutePath());
		}
		
		//Encerrando o browser
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} 
		catch (NoSuchElementException e) {
			return false;
		}
	}
}
