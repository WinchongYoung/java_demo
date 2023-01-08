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

        File dir = new File("C:\\Users\\74582\\Desktop\\input_excel");

        File[] files = dir.listFiles();

        for (File tmpFile : files) {
            FileInputStream fis = new FileInputStream(tmpFile.getAbsolutePath());

            System.out.println(tmpFile.getAbsolutePath());
            // Finds the workbook instance for XLSX file
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

            int numberOfSheets = myWorkBook.getNumberOfSheets();
            for (int sheetIndex = 0; sheetIndex < numberOfSheets; sheetIndex++) {

                List<PersonBean> people = new ArrayList<>();

                List<List<Object>> list = new ArrayList<>();

                XSSFSheet mySheet = myWorkBook.getSheetAt(sheetIndex);
                System.out.println(mySheet.getSheetName());
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

                // System.out.println(list.get(0).get(0));

                // 分组
                List<List<Integer>> indexRecord = new ArrayList<>();
                Integer startIndex = 0;

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).size() > 0 && list.get(i).get(0).toString().contains("北京荣达永发建设工程有限公司2022")) {
                        startIndex = i;
                    }
                    if (list.get(i).size() > 0 && list.get(i).get(0).toString().contains("本人确认")) {
                        indexRecord.add(Arrays.asList(startIndex, i));
                    }
                }

                List<List<List<Object>>> result = new ArrayList<>();
                for (List<Integer> tmp : indexRecord) {
                    List<List<Object>> lists = list.subList(tmp.get(0), tmp.get(1) + 1);
                    result.add(lists);
                }

                /*indexRecord.forEach(System.out::println);
                System.exit(0);*/
                // 获取银行卡号表
                Map<String, List<String>> cardMap = new HashMap<>();
                FileInputStream mangerInfoFile = new FileInputStream(new File("C:\\Users\\74582\\Desktop\\person_info\\person_info.xlsx"));
                XSSFWorkbook managerINfoXss = new XSSFWorkbook(mangerInfoFile);
                XSSFSheet managerSheet = managerINfoXss.getSheetAt(0);
                Iterator<Row> rowIterator1 = managerSheet.iterator();
                while (rowIterator1.hasNext()) {
                    Row row2 = rowIterator1.next();
                    String nameTmp = "";
                    if (row2.getCell(0) != null) {
                        row2.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        nameTmp = row2.getCell(0).getStringCellValue().replace(" ", "");
                    }

                    String cardNumTmp = "";
                    if (row2.getCell(1) != null) {
                        cardNumTmp = getCellValue(row2.getCell(1)).toString();
                    }

                    String bankName = "";
                    if (row2.getCell(2) != null) {
                        row2.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        bankName = row2.getCell(2).getStringCellValue();
                    }
                    List<String> single = new ArrayList<>();
                    single.add(cardNumTmp);
                    single.add(bankName);
                    cardMap.put(nameTmp, single);
                }

                // cardMap.forEach((x, y) -> System.out.println(x + "->" + y));

                for (List<List<Object>> tmp : result) {
                    // 姓名处理
                    String name = tmp.get(1).get(0).toString().replace("姓名", "").replace("：", "").replace(" ", "");
                    /*if (name.equals("常红星")) {
                        System.exit(0);
                    }*/
                    // 工地处理
                    Set<String> set = new HashSet<>();
                    for (int z = 3; z < 8; z++) {
                        if (!tmp.get(z).get(0).toString().trim().equals("")) {
                            set.add(tmp.get(z).get(0).toString().trim());
                        }
                    }

                    // 数字金额
                    String moneyOri = tmp.get(20).get(2).toString().equals("") ? "0" : tmp.get(20).get(2).toString();
                    String money = new BigDecimal(moneyOri).setScale(0, BigDecimal.ROUND_HALF_UP).toString();

                    // 大写金额处理
                    String totalStr = tmp.get(20).get(4).toString();
                    String totalCN = totalStr.replace("（", "").replace("）", "").replace("大写", "").replace("：", "").replace(" ", "");
                    if (!money.equals("") && (totalCN.equals("元整") || totalCN.equals(""))) {
                        totalCN = ConvertUpMoney.toChinese(money) + "元整";
                    }

                    // 银行卡号
                    String cardNum = cardMap.containsKey(name) ? cardMap.get(name).get(0) : "";
                    // 开户行
                    String bankName = cardMap.containsKey(name) ? cardMap.get(name).get(1) : "";

                    people.add(new PersonBean(name, totalCN,
                            money + ".00",
                            set,
                            cardNum, bankName));
                }
                // people.forEach(System.out::println);
                // System.exit(0);
                List<PersonBean> collect = people.stream().filter(x -> !x.name.trim().equals("")).collect(Collectors.toList());

                for (PersonBean per : collect) {
                    Map<String, String> params = new HashMap<>();
                    params.put("fill_1", per.getWorkSpaces().stream().collect(Collectors.joining("、")));
                    params.put("fill_2", "2023");
                    params.put("fill_3", "1");
                    params.put("fill_4", "8");
                    params.put("fill_5", "支付" + per.getName() + "2022年余下全部工资");
                    params.put("fill_6", per.getTotalCN());
                    params.put("fill_7", per.getTotal());
                    params.put("fill_8", per.getCardNum() + "  " + per.getBankDesc());
                    Random random = new Random();
                    int randomNum = random.nextInt(10000);
                    CreatePdf.pdfGenerator("C:\\Users\\74582\\Desktop\\haha.pdf", "C:\\Users\\74582\\Desktop\\pdf_output\\" + per.name + ".pdf", params);
                    // System.out.println(per);
                }

                System.out.println("生成pdf成功，总计" + collect.size());

                // 生成pdf
            }


        }


    }

    public static Object getCellValue(Cell cell) {
        Object value = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                value = String.valueOf(df.format(cell.getNumericCellValue()));
                ;
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
