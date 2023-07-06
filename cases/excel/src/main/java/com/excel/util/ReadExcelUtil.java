package com.excel.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadExcelUtil {
    /**
     * 读取excel文件数据，所有的sheet数据
     * 返回数据格式 [{sheetName=用户信息, data=[{姓名=王海, 年龄=1}, {姓名=李四, 年龄=2}]}, {sheetName=操作记录, data=[{操作记录=方法, 操作人=25}, {操作记录=发发发, 操作人=25}]}, {sheetName=Sheet3, data=[]}]
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static List<Map<String, Object>> readExcel(File file) throws IOException {
        List<Map<String, Object>> allList = new ArrayList<>();
        // 获取excel工作簿对象
        String fileName = file.getName();
        String substring = fileName.substring(fileName.lastIndexOf("."));
        HSSFWorkbook workbook = null;
        XSSFWorkbook workbookXss = null;
        if (".xls".equals(substring)) {
            workbook = new HSSFWorkbook(new FileInputStream(file));
            allList = readSheet(workbook, null);
        } else if (".xlsx".equals(substring)) {
            workbookXss = new XSSFWorkbook(new FileInputStream(file));
            allList = readSheet(null, workbookXss);
        }


        for (Map<String, Object> map : allList) {
            Set<String> set = map.keySet();
            for (String s : set) {
                System.out.println(s+":"+map.get(s));
            }
        }
        return null;
    }

    /**
     * 读取所有sheet数据
     *
     * @param workbooks
     * @param workbookXss
     * @return
     */
    public static List<Map<String, Object>> readSheet(HSSFWorkbook workbooks, XSSFWorkbook workbookXss) {
        List<Map<String, Object>> allList = new ArrayList<>();
        for (Sheet sheet : workbooks != null ? workbooks : workbookXss) {
            List<String> headerList = new ArrayList<>();
            List<Map<String, Object>> dataList = new ArrayList<>();
            System.out.println(sheet.getSheetName());
            int i = 0;
            for (Row row : sheet) {
                if (i == 0) {
                    if (i == 0) {
                        for (Cell cell : row) {
                            headerList.add(cell.getStringCellValue());
                        }
                    }
                } else {
                    Map<String, Object> map = new HashMap<>();
                    int j = 0;
                    for (Cell cell : row) {
                        //设置单元格类型
                        cell.setCellType(CellType.STRING);
                        map.put(headerList.get(j), cell.getStringCellValue());
                        j++;
                    }
                    dataList.add(map);
                }
                i++;
            }
            Map<String, Object> map = new HashMap<>();
            map.put("sheetName", sheet.getSheetName());
            map.put("data", dataList);
            allList.add(map);
        }
        return allList;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("E:\\work\\监测站\\demo1.xlsx");
        readExcel(file);
//        File file1 = new File("D:测试excel.xls");
//        readExcel(file1);
    }
}
