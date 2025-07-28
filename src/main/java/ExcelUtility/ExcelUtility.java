package ExcelUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel( String Sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptAdv.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(Sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
}
		//Getting data from multiple row
		public int togetRowCount(String Sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new
		FileInputStream("./TestData/TestScriptAdv.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount= wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return rowcount;
		}

}
