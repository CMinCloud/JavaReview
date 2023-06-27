package com.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyExportDemo
 * @Description TODO
 * @date 2023/6/27 23:54
 * @Version 1.0
 */
public class MyExportDemo {

    Workbook workbook = new XSSFWorkbook();  // 创建一个新的工作簿
    Sheet sheet = workbook.createSheet("Sheet1");  // 创建一个名为 "Sheet1"


    public static void exportToExcel(List<Object[]> dataList) throws FileNotFoundException {
        Workbook workbook = new XSSFWorkbook();  // 创建一个新的工作簿
        Sheet sheet = workbook.createSheet("Sheet1");  // 创建一个名为 "Sheet1" 的工作表

        for (int i = 0; i < dataList.size(); i++) {
//            创建新行
            Row row = sheet.createRow(i);
//            获取当前行的数据
            Object[] rowData = dataList.get(i);
//            创建单元格并将数据封装到单元格中
            for (int j = 0; j < rowData.length; j++) {
                Cell cell = row.createCell(j);      //新单元格
                cell.setCellValue(String.valueOf(rowData[j]));                //填充单元格
            }
        }

        try {
            //        将工作溥写入到输入流
            FileOutputStream outputStream = new FileOutputStream("D://output.xlsx");
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        // 创建数据集合 dataList
        List<Object[]> dataList = new ArrayList<>();
        // 生成测试数据并添加到 dataList
        addData(dataList, "姓名", "年龄", "国家");
        addData(dataList, "John", 25, "USA");
        addData(dataList, "Emily", 30, "Canada");
        addData(dataList, "Tom", 28, "UK");

        exportToExcel(dataList);
        System.out.println("数据已导出到 Excel 文件中。");
    }

    private static void addData(List<Object[]> dataList, Object data1, Object data2, Object data3) {
        Object[] rowData = new Object[3];
        rowData[0] = data1;
        rowData[1] = data2;
        rowData[2] = data3;
        dataList.add(rowData);
    }


}
