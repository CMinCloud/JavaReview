package com;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 复杂Excel导出，表头合并
 */
public class complexExcel {

    /**
     * 创建标题样式
     *
     * @param wb
     * @return
     */
    private static HSSFCellStyle createTitleCellStyle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //背景颜色
        cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        // 创建字体样式
        HSSFFont headerFont1 = (HSSFFont) wb.createFont();
        //字体加粗
        headerFont1.setBold(true);
        // 设置字体类型
        headerFont1.setFontName("黑体");
        // 设置字体大小
        headerFont1.setFontHeightInPoints((short) 15);
        // 为标题样式设置字体样式
        cellStyle.setFont(headerFont1);

        return cellStyle;
    }


    /**
     * 创建表头样式
     *
     * @param wb
     * @return
     */
    private static HSSFCellStyle createHeadCellStyle(HSSFWorkbook wb) {
        HSSFCellStyle cellStyle = wb.createCellStyle();
        // 设置自动换行
        cellStyle.setWrapText(true);
        //背景颜色
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        //下边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        //左边框
        cellStyle.setBorderLeft(BorderStyle.THIN);
        //右边框
        cellStyle.setBorderRight(BorderStyle.THIN);
        //上边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        // 创建字体样式
        HSSFFont headerFont = (HSSFFont) wb.createFont();
        //字体加粗
        headerFont.setBold(true);
        // 设置字体类型
        headerFont.setFontName("黑体");
        // 设置字体大小
        headerFont.setFontHeightInPoints((short) 12);
        // 为标题样式设置字体样式
        cellStyle.setFont(headerFont);

        return cellStyle;
    }


    //    生成八行十列的数据
    private static List<List<String>> generateData() {
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                rowData.add("Row " + (i + 1) + ", Col " + (j + 1));
            }
            data.add(rowData);
        }
        return data;
    }


    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet-001");

        /** 第三步，设置样式以及字体样式*/
        HSSFCellStyle titleStyle = createTitleCellStyle(workbook);
        HSSFCellStyle headerStyle = createHeadCellStyle(workbook);


        /***************************************************************
         /** 第四步，创建标题，合并标题单元格*/
        int rowNUm = 0;  //创建行号
//        创建第一页的第一行，从索引0开始
        HSSFRow row0 = sheet.createRow(rowNUm++);
        row0.setHeight((short) 800);    //设置行高

        String title = "第一行标题名";
        HSSFCell cell00 = row0.createCell(0);//创建单元格，也就是所在行的列
        cell00.setCellValue(title);         //设置单元格的值
        cell00.setCellStyle(titleStyle);

        // 合并单元格，参数依次为起始行，结束行，起始列，结束列 （索引0开始）
        //标题合并单元格操作，7为总列数
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));


//        第二行
        HSSFRow row1 = sheet.createRow(rowNUm++);
        row1.setHeight((short) 500);
//todo 放到创建sheet后试试看        设置sheet中未合并的列的宽度
        sheet.setColumnWidth(0, 5000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 5000);
        sheet.setColumnWidth(6, 5000);
        sheet.setColumnWidth(7, 5000);
//        第二行表头的名称
        String[] row_first = {"", "", "", "", "", "", "", ""};
        for (int i = 0; i < row_first.length; i++) {
            HSSFCell row1Cell = row1.createCell(i);
//            row1Cell.setCellStyle(titleStyle);
            row1Cell.setCellValue(row_first[i]);
        }

//        查询出来的数据，直接调用接口查询
        /**
         * 略
         */
        List<List<String>> rowList = generateData();


//        填充数据
        for (List<String> columeList : rowList) {
            HSSFRow sheetRow = sheet.createRow(rowNUm++);
            for (int i = 0; i < columeList.size(); i++) {
                HSSFCell cell = sheetRow.createCell(i);
//                cell.setCellStyle(titleStyle);
                cell.setCellValue(columeList.get(i));
            }
        }

//        根据需求合并单元格
        sheet.addMergedRegion(new CellRangeAddress(3, 5, 1, 1));
        sheet.addMergedRegion(new CellRangeAddress(3, 5, 2, 4));
        sheet.addMergedRegion(new CellRangeAddress(7, 9, 6, 7));


//        将数据写入xls
//        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        try {
            FileOutputStream outputStream = new FileOutputStream("D://output.xlsx");
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
