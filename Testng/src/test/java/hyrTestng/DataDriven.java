package hyrTestng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataDriven {

    @DataProvider(name = "excelData")
    public String[][] excelData() throws IOException {
        File excelFile = new File("C:\\Users\\vigu2\\git\\SeleniumTestNG\\Testng\\src\\test\\resources\\data.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalColumns = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[totalRows - 1][totalColumns];
        for (int i = 0; i < totalRows - 1; i++) {
            for (int j = 0; j < totalColumns; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }

        workbook.close();
        fis.close();
        return data;
    }
}



