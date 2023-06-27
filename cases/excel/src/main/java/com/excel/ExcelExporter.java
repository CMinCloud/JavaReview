package com.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelExporter {

    public static void export(String filePath, String sheetName) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Row row = workbook.createSheet(sheetName).createRow(0);
        for(int i=0; i<10; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue("Header " + i);
        }

        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Excel file has been exported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\test.xlsx";
        String sheetName = "Test Sheet";
        ExcelExporter.export(filePath, sheetName);
    }
}