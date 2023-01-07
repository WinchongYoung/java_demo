package rongda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("all")
/**
 * java读取高版本的excel(xlsx后缀的excel)
 *
 * @author: qlq
 * @date : 2018年7月4日下午3:21:50
 */
public class POIRead07VersionExcel {

    public static void main(String[] args) throws IOException {
        List<PersonBean> personList = new ArrayList<>();
        try {
            // 获取一个工作簿
            // 第一种创建XSSFWorkbook的方法:
            /*
             * File file = new
             * File("C:/Users/liqiang/Desktop/考核/系统管理/导入excel模板/user.xlsx");
             * XSSFWorkbook workbook = new
             * XSSFWorkbook(FileUtils.openInputStream(file));
             */
            // 第二种创建XSSFWorkbook的方法
            Workbook workbook = new XSSFWorkbook("C:\\Users\\74582\\Desktop\\gaga.xlsx");

            // 获取一个工作表两种方式
            // HSSFSheet sheet = workbook.getSheet("sheet0");
            // 获取sheet数
            int sheetNumbers = workbook.getNumberOfSheets();
            // 获取工作表的第二种方式
            for (int k = 0; k < sheetNumbers; k++) {
                XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(k);
                int firstRow = 0;
                // 获取sheet的最后一行
                int lastRow = sheet.getLastRowNum();
                System.out.println(lastRow);
                System.exit(0);
                for (int i = firstRow; i <= lastRow; i++) {
                    XSSFRow row = sheet.getRow(i);
                    int lastCol = row.getLastCellNum();
                    for (int j = 0; j < lastCol; j++) {
                        XSSFCell cell = row.getCell(j);
                        // 强制将读取的数据作为String处理，否则读取数字会报错
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String value = cell.getStringCellValue();
                        System.out.print(value + "  ");
                    }
                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}