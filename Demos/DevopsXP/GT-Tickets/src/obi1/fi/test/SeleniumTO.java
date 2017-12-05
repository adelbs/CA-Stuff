package obi1.fi.test;

import java.io.File;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SeleniumTO {

	private File excelFile;
	
	private XSSFWorkbook workbook;
	
	private String url;

	private ArrayList<SeleniumDataTO> dataList = new ArrayList<SeleniumDataTO>();
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<SeleniumDataTO> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<SeleniumDataTO> dataList) {
		this.dataList = dataList;
	}

	public XSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public File getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	
	
}
