import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

println new File("Data Files/IHS_IP_permissions/attachments/").absolutePath
//String source_fileName="/Users/jcfu/Desktop/test_result.xlsx"
//String dest_fileName="/Users/jcfu/Desktop/test_result_"+GlobalVariable.recordName1+".xlsx"

//new File(dest_fileName) << new File(source_fileName).bytes
//CustomKeywords.'ip_permissions.utils.addGlobalVariable'('localURL', 'katalon.com')

//println GlobalVariable.localURL
return

/*
GlobalVariable.G_wait_s=1
 result = 'test1'
 results= 'col2'
write_failed_result(result,results)

 result = 'test2'
write_failed_result(result,results)
result = 'test3'
write_failed_result(result,results)


def write_failed_result( def col1=null, def col2=null) {
	String col0='ISSUE # '+(GlobalVariable.G_wait_s++)
	//String source_fileName="/Users/jcfu/Desktop/test_result.xlsx"
	String source_fileName="Data Files/IHS_IP_permissions/test_result.xlsx"
	String fileName="/Users/jcfu/Desktop/test_result_"+GlobalVariable.recordName1+".xlsx"
	def inputFile = new File(fileName)
	// Check if a file with same name exisits in the folder.
	if(!inputFile.exists()){
		//inputFile.createNewFile()
		new File(fileName) << new File(source_fileName).bytes
		
	}
    FileInputStream fis = new FileInputStream(inputFile);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
     
    //XSSFSheet sheet = workbook.getSheet("Sheet1");
	XSSFSheet sheet = workbook.getSheetAt(0);
	
    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
    Row row = sheet.createRow(rowCount+1);
    Cell cell = row.createCell(0);
    cell.setCellType(cell.CELL_TYPE_STRING);
    cell.setCellValue(col0);
	if (!col1.equals(null)){
		cell = row.createCell(1);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(col1);
	}
	if (!col2.equals(null)){
		cell = row.createCell(2);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(col2);
	}
    FileOutputStream fos = new FileOutputStream(fileName);
    workbook.write(fos);
    fos.close();
	KeywordUtil.markFailed(col0+'\n'+col1)
}
*/