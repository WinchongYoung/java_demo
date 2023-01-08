package rongda;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ReadExcel {
    public static DecimalFormat df = new DecimalFormat("#");

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
                        tmp.add(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        tmp.add(cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
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

        // 获取银行卡号表
        Map<String, List<String>> cardMap = new HashMap<>();
        FileInputStream mangerInfoFile = new FileInputStream(new File("C:\\Users\\74582\\Desktop\\管理人员银行卡号.xlsx"));
        XSSFWorkbook managerINfoXss = new XSSFWorkbook(mangerInfoFile);
        XSSFSheet managerSheet = managerINfoXss.getSheetAt(0);
        Iterator<Row> rowIterator1 = managerSheet.iterator();
        while (rowIterator1.hasNext()) {
            Row row2 = rowIterator1.next();
            String nameTmp = "";
            if (row2.getCell(1) != null) {
                row2.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                nameTmp = row2.getCell(1).getStringCellValue();
            }

            String cardNumTmp = "";
            if (row2.getCell(6) != null) {
                cardNumTmp = getCellValue(row2.getCell(6)).toString();
            }

            String bankName = "";
            if (row2.getCell(7) != null) {
                row2.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                bankName = row2.getCell(7).getStringCellValue();
            }
            List<String> single = new ArrayList<>();
            single.add(cardNumTmp);
            single.add(bankName);
            cardMap.put(nameTmp, single);
        }
        // cardMap.forEach((x, y) -> System.out.println(x + "->" + y));
        // System.out.println(cardMap.size());
        // System.exit(0);

        for (List<List<Object>> tmp : result) {
            // 姓名处理
            String name = tmp.get(1).get(0).toString().replace("姓名", "").replace("：", "").replace(" ", "");
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

            // 银行卡号
            String cardNum = cardMap.containsKey(name) ? cardMap.get(name).get(0) : "";
            // 开户行
            String bankName = cardMap.containsKey(name) ? cardMap.get(name).get(1) : "";

            people.add(new PersonBean(name, totalCN,
                    new BigDecimal(tmp.get(20).get(2).toString()).setScale(0, BigDecimal.ROUND_HALF_UP).toString() + ".00",
                    set,
                    cardNum, bankName));
        }

        List<PersonBean> collect = people.stream().filter(x -> !x.name.trim().equals("")).collect(Collectors.toList());

        for (PersonBean per : collect) {
            Map<String, String> params = new HashMap<>();
            params.put("fill_1", per.getWorkSpaces().stream().collect(Collectors.joining(" ")));
            params.put("fill_2", "2023");
            params.put("fill_3", "1");
            params.put("fill_4", "8");
            params.put("fill_5", "支付" + per.getName() + "2022年余下全部工资");
            params.put("fill_6", per.getTotalCN());
            params.put("fill_7", per.getTotal());
            params.put("fill_8", per.getCardNum() + "  " + per.getBankDesc());
            CreatePdf.pdfGenerator("C:\\Users\\74582\\Desktop\\haha.pdf", "C:\\Users\\74582\\Desktop\\pdf_output\\" + per.name + ".pdf", params);
            System.out.println(per);
        }

        // 生成pdf


    }

    public static Object getCellValue(Cell cell) {
        Object value = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                value = String.valueOf(df.format(cell.getNumericCellValue()));;
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:
                value = NumberToTextConverter.toText(cell.getNumericCellValue());
                break;
            default:

        }
        return value;
    }

}
