package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
static FileInputStream fis=null;
public FileInputStream getFileInputStream()
{
	String filepath=System.getProperty("user.dir")+"/src/test/java/data/Book1.xlsx";
	File scrcfile=new File(filepath);
	try {
		fis=new FileInputStream(scrcfile);
	} catch (FileNotFoundException e) {
		System.out.println("error occured :"+e.getMessage());
		System.exit(0);
		
	}
	return fis;
}
public Object[][] getexceldata() throws IOException
{
	fis=getFileInputStream();
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheetAt(0);
	int TotalNumberofRows=(sheet.getLastRowNum()+1);
	int TotalNumberofcols=4;
	String [][] arrayExcelData=new String[TotalNumberofRows][TotalNumberofcols];
	for (int i = 0; i < TotalNumberofRows; i++) {
		for (int j = 0; j < TotalNumberofcols; j++) {
			XSSFRow row=sheet.getRow(i);
			arrayExcelData[i][j]=row.getCell(j).toString();
		}
		
	}
	wb.close();
	return arrayExcelData;
}
}
