package tungpzostar.springhibernatejsf.dao;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Repository;

import tungpzostar.springhibernatejsf.entity.Client;
import tungpzostar.springhibernatejsf.entity.Employee;

@Repository
public class FileDAOImpl implements FileDAO {

	private static String[] columns = { "EMPNO", "ENAME", "JOB", "MGR", "HIREDATE", "SAL", "COMM", "DEPTNO" };

	@Override
	public List<Client> processFile(UploadedFile f) {
		String line = null;
		List<Client> lstClient = new ArrayList<Client>();
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(f.getInputstream()));
			while ((line = bf.readLine()) != null) {
				String strArr[] = line.split(",");
				Client client = new Client(strArr[0], strArr[1]);
				lstClient.add(client);
				System.out.println(strArr[0] +" " + strArr[1]);
			}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstClient;
	}

	@Override
	public void writeExcelFile(List<Employee> lstEmp) throws Exception {
		Workbook workbook = new XSSFWorkbook();

		CreationHelper creationHelper = workbook.getCreationHelper();

		// Create a sheet
		Sheet sheet = workbook.createSheet("Employee");
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create Other rows and cells with employees data
		int rowNum = 1;
		
		for(Employee emp : lstEmp) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(emp.getEmpNo());
			row.createCell(1).setCellValue(emp.geteName());
			row.createCell(2).setCellValue(emp.getJob());
			row.createCell(3).setCellValue(emp.getMgr());
			
			Cell dateOfBirthCell = row.createCell(4);
			dateOfBirthCell.setCellValue(emp.getHireDate());
			dateOfBirthCell.setCellStyle(dateCellStyle);
//			row.createCell(4).setCellValue(emp.getHireDate());
			
			row.createCell(5).setCellValue(emp.getSal());
			if(emp.getComm() == null) {
				row.createCell(6).setCellValue("");
			}
			else row.createCell(6).setCellValue(emp.getComm());
			row.createCell(7).setCellValue(emp.getDept().getDeptNo());
		}
		for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
		//random string name:
		String genaratedString = RandomStringUtils.randomAlphabetic(6);
		
		// Write to file
		FileOutputStream fos = new FileOutputStream("employee-report"+genaratedString+".xls");
		workbook.write(fos);
		
		//closing stream
		fos.close();
		
		//closing workbook
		workbook.close();
	}

}
