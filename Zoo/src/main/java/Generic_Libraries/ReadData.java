package Generic_Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/***
 * 
 * @author Manjunath
 *
 */

public class ReadData {
	/**
	 * This method helps us to read data from property file
	 * 
	 * @param the associated key name in property file
	 * @return
	 */

	//reading from property file
	public static String fromPropertyFile(String key) {
		FileInputStream fis = null;
		Properties properties = null;
		try {
			fis = new FileInputStream(new File("./src/test/resources/testData/Configration.properties"));
			properties = new Properties();
			properties.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);

	}


	//extracting only single cell value from excel
	public static String fromExcel(String sheetName, int rowNo, int cellNo) {
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream(new File("./src/test/resources/testData/testData.xlsx"));
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();

	}


	//reading date from excel
	public static LocalDateTime fromExcelWithDateTime(String sheetName, int rowNo, int cellNo) {
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream(new File("./src/test/resources/testData/testData.xlsx"));
			workbook = WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue();

	}

	//getting only day from computer based on input
	public static int dayFromSystem(int num) {
		LocalDateTime systemdate = LocalDateTime.now().plusDays(num);

		int day =systemdate.getDayOfMonth();
		return day;
	}

	//getting only year from computer based on input
	public static int yearFromSystem(int num) {
		LocalDateTime systemdate = LocalDateTime.now().plusYears(num);

		int year = systemdate.getYear();
		return year;
	}

	//getting only month from computer based on input
	public static String monthFromSystem(int num) {
		LocalDateTime systemdate = LocalDateTime.now().plusMonths(num);
		String monthName = systemdate.getMonth().name();	
		String month = "" + monthName.charAt(0) + monthName.substring(1, 3).toLowerCase();
		return month;	
	}

	//reading multiple data from the excel(rows and columns)
	@DataProvider
	public static String[][] multipleDataFromExcel() {
		FileInputStream fis=null;
		Workbook workBook=null;
		try {
			fis = new FileInputStream("./src/test/resources/testData/testData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workBook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheetInfo = workBook.getSheet("Shashank");
		int rowCount = sheetInfo.getPhysicalNumberOfRows()-1;
		int columnCount = sheetInfo.getRow(1).getPhysicalNumberOfCells()-1;
		String data[][]=new String[rowCount][columnCount];

		for(int i=1,k=0;i<=rowCount;i++,k++) {
			for(int j=1,l=0;j<=columnCount;j++,l++) {
				data[k][l]=sheetInfo.getRow(i).getCell(j).toString();
			}
		}
		return data;

	}


	//reading a single row data
	public static String[][] DataFromExcel(String sheetName,int rowNo) {
		FileInputStream fis=null;
		Workbook workBook=null;
		try {
			fis = new FileInputStream("./src/test/resources/testData/testData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workBook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheetInfo = workBook.getSheet(sheetName);
		int columnCount = sheetInfo.getRow(rowNo).getPhysicalNumberOfCells()-1;
		String data[][]=new String[1][columnCount];


		for(int j=0;j<columnCount;j++) {
			data[0][j]=sheetInfo.getRow(rowNo).getCell(j+1).toString();
		}

		return data;

	}


	//reading month from excel
	public static String readMonthFromExcel(String sheetName,int row,int col){
		String dat = ReadData.fromExcel(sheetName,row,col);

		String month = null;
		String date[]= dat.split("/");

		String m = date[1];
		int months = Integer.parseInt(m);

		switch(months) {
		case 1:month ="Jan";
		break;
		case 2:month="Feb";
		break;
		case 3:month ="Mar";
		break;
		case 4:month="Apr";
		break;
		case 5:month ="May";
		break;
		case 6:month="Jun";
		break;
		case 7:month ="Jul";
		break;
		case 8:month="Aug";
		break;
		case 9:month ="Sep";
		break;
		case 10:month="Oct";
		break;
		case 11:month ="Nov";
		break;
		case 12:month="Dec";
		break;
		}
		return month;
	}

	//reading day from excel
	public static int readDayFromExcel(String sheetName,int row,int col) {
		String dat = ReadData.fromExcel(sheetName, row, col);
		String date[]= dat.split("/");
		String d = date[0];
		int day = Integer.parseInt(d);
		return day;	
	}

	//reading year from excel
	public static int readyearFromExcel(String sheetName,int row,int col) {
		String dat = ReadData.fromExcel(sheetName,row,col);
		String date[]= dat.split("/");
		String y = date[2];
		int year = Integer.parseInt(y);
		return year;
	}
}


