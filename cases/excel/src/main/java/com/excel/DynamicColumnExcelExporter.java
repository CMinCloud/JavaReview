package com.excel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicColumnExcelExporter {
    public static byte[] export(List<String> headers, List<List<Object>> data) throws IOException {
        Workbook workbook = createWorkbook(headers, data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        return outputStream.toByteArray();
    }

    private static Workbook createWorkbook(List<String> headers, List<List<Object>> data) {
        Workbook workbook = new XSSFWorkbook();
        CellStyle headerStyle = createHeaderStyle(workbook);
        CellStyle dataStyle = createDataStyle(workbook);
        int rowCount = data.size() + 1;
        int columnCount = headers.size();
        for (int i = 0; i < rowCount; i++) {
            workbook.getSheetAt(0).createRow(i);
            for (int j = 0; j < columnCount; j++) {
                String value = i == 0 ? headers.get(j) : data.get(i - 1).get(j).toString();
                workbook.getSheetAt(0).getRow(i).createCell(j).setCellValue(value);
                CellStyle style = i == 0 ? headerStyle : dataStyle;
                workbook.getSheetAt(0).getRow(i).getCell(j).setCellStyle(style);
            }
        }
        return workbook;
    }

    private static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        XSSFCellStyle xssfStyle = (XSSFCellStyle) style;
        xssfStyle.setWrapText(true);
        return style;
    }

    private static CellStyle createDataStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.TOP);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        XSSFCellStyle xssfStyle = (XSSFCellStyle) style;
        xssfStyle.setWrapText(true);
        return style;
    }


    public static void main(String[] args) throws IOException {
        List<String> headers = new ArrayList<>();

        headers.add("Name");

        headers.add("Email");

        headers.add("Phone");

        headers.add("Join Date");

        List<List<Object>> data = new ArrayList<>();

        List<Object> row1Data = new ArrayList<>();

        row1Data.add("John Doe");

        row1Data.add("johndoe@gmail.com");

        row1Data.add("123-456-7890");

        row1Data.add(new Date());

        data.add(row1Data);

        byte[] excelBytes = DynamicColumnExcelExporter.export(headers, data);
    }
}