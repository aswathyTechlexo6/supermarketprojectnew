package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	public static String getStringdata(int a,int b,String sheet) throws IOException
	{
		String filepath=Constant.FILE_PATH;
		f=new FileInputStream(filepath);//obtaining bytes from the file
		w=new XSSFWorkbook(f);//creating workbook instance that refers to xlsx file
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static String getIntegerdata(int a,int b,String sheet) throws IOException
	{
		String filepath=Constant.FILE_PATH;
		f=new FileInputStream(filepath);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow r=s.getRow(a);
		XSSFCell c=r.getCell(b);
		int y=(int) c.getNumericCellValue();//typecasting
		return String.valueOf(y);
		
	}

}
