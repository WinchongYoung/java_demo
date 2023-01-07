package rongda;

import org.apache.commons.collections.ArrayStack;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.redisson.mapreduce.Collector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ReadExcel {

    public static void main(String[] args) throws IOException {


        List<PersonBean> people = new ArrayList<>();

        List<List<Object>> list = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File("C:\\Users\\74582\\Desktop\\gaga.xlsx"));

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheetAt(1);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();

        // Traversing over each row of XLSX file
        FormulaEvaluator formulaEvaluator = new XSSFFormulaEvaluator(myWorkBook);

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            List<Object> tmp = new ArrayList<>();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        // System.out.print(cell.getStringCellValue() + "\t");
                        tmp.add(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        // System.out.print(cell.getNumericCellValue() + "\t");
                        tmp.add(cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        // System.out.print(cell.getBooleanCellValue() + "\t");
                        tmp.add(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        tmp.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                        break;
                    default:
                        tmp.add("");
                }
            }
            list.add(tmp);
        }

        System.out.println(list.get(0).get(0));

        // 分组
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> indexRecord = new ArrayList<>();
        Integer startIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() > 0 && list.get(i).get(0).toString().contains("北京荣达永发建设工程有限公司2022")) {
                startIndex = i;
            }
            if (list.get(i).size() > 0 && list.get(i).get(0).toString().contains("电话")) {
                indexRecord.add(Arrays.asList(startIndex, i));
            }
        }

        List<List<List<Object>>> result = new ArrayList<>();
        for (List<Integer> tmp : indexRecord) {
            List<List<Object>> lists = list.subList(tmp.get(0), tmp.get(1) + 1);
            result.add(lists);
        }

        for (List<List<Object>> tmp : result) {
            // 姓名处理
            String name = tmp.get(1).get(0).toString().replace("姓名", "").replace("：", "");
            // 工地处理
            Set<String> set = new HashSet<>();
            for (int z = 3; z < 8; z++) {
                if (!tmp.get(z).get(0).toString().trim().equals("")) {
                    set.add(tmp.get(z).get(0).toString().trim());
                }
            }
            // 大写金额处理
            String totalStr = tmp.get(20).get(4).toString();
            String totalCN = totalStr.replace("（", "").replace("）", "").replace("大写", "").replace("：", "").replace(" ", "");
            people.add(new PersonBean(name, totalCN,
                    new BigDecimal(tmp.get(20).get(2).toString()).setScale(0, BigDecimal.ROUND_HALF_UP).toString(), set, "", ""));
        }

        List<PersonBean> collect = people.stream().filter(x -> !x.name.trim().equals("")).collect(Collectors.toList());

        for (PersonBean per : collect) {
            System.out.println(per);
        }

    }
}
