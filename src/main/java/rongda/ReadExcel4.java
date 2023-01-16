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
import java.util.*;
import java.util.stream.Collectors;

public class ReadExcel4 {

    public static void main(String[] args) throws IOException {

        String homeDir = args[0];
        String year = args[1], mon = args[2], day = args[3];
        Integer yearDelta = Integer.parseInt(year) - 1;

        File dir = new File(homeDir + "\\input_excel");

        File[] files = dir.listFiles();

        List<PersonBeanV2> allPeople = new ArrayList<>();

        // 获取银行卡号表
        Map<String, List<String>> cardMap = Utils.getBankInfo(homeDir);

        for (File tmpFile : files) {
            FileInputStream fis = new FileInputStream(tmpFile.getAbsolutePath());

            System.out.println(tmpFile.getAbsolutePath());
            // Finds the workbook instance for XLSX file
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

            int numberOfSheets = myWorkBook.getNumberOfSheets();

            // 生成前创建目录
            String savePath = homeDir + "\\out_put\\" + tmpFile.getName().replace(".xlsx", "");
            for (int sheetIndex = 0; sheetIndex < numberOfSheets; sheetIndex++) {

                List<PersonBeanV2> people = new ArrayList<>();

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

                // 分组
                List<List<Integer>> indexRecord = new ArrayList<>();
                Integer startIndex = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).size() > 0 && list.get(i).get(0).toString().contains("北京荣达永发建设工程有限公司20")) {
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

                for (List<List<Object>> tmp : result) {
                    // 姓名处理
                    String name = tmp.get(1).get(0).toString().replace("姓名", "").replace("：", "").replace(" ", "");
                    // 工地处理
                    List<WorkSpace> workSpaces = new ArrayList<>();
                    for (int z = 3; z < 8; z++) {
                        if (!tmp.get(z).get(0).toString().trim().equals("")) {
                            BigDecimal days = !tmp.get(z).get(2).toString().trim().equals("") ? new BigDecimal(tmp.get(z).get(2).toString()) : BigDecimal.ZERO;
                            days = days.setScale(2, BigDecimal.ROUND_HALF_UP);

                            BigDecimal salaryTotal = !tmp.get(z).get(6).toString().trim().equals("") ? new BigDecimal(tmp.get(z).get(6).toString()) : BigDecimal.ZERO;
                            salaryTotal = salaryTotal.setScale(0, BigDecimal.ROUND_HALF_UP);

                            workSpaces.add(
                                    new WorkSpace(tmp.get(z).get(0).toString().trim(),
                                            days,
                                            0,
                                            BigDecimal.ZERO,
                                            !tmp.get(z).get(3).toString().trim().equals("") ? new BigDecimal(tmp.get(z).get(3).toString()) : BigDecimal.ZERO,
                                            !tmp.get(z).get(5).toString().trim().equals("") ? new BigDecimal(tmp.get(z).get(5).toString()) : BigDecimal.ZERO,
                                            salaryTotal,
                                            tmp.get(z).get(7).toString())
                            );
                        }
                    }

                    // 数字金额
                    String moneyOri = tmp.get(20).get(2).toString().equals("") ? "0" : tmp.get(20).get(2).toString();
                    String money = new BigDecimal(moneyOri).setScale(0, BigDecimal.ROUND_HALF_UP).toString();

                    // 大写金额处理
                    String totalStr = tmp.get(20).get(4).toString();
                    String totalCN = totalStr.replace("（", "").replace("）", "").replace("大写", "").replace("：", "").replace(" ", "");
                    if (!money.equals("") && (totalCN.equals("元整") || totalCN.equals(""))) {
                        totalCN = ConvertUpMoney.toChinese(money) + "整";
                    }

                    // 银行卡号
                    String cardNum = cardMap.containsKey(name) ? cardMap.get(name).get(0) : "";
                    // 开户行
                    String bankName = cardMap.containsKey(name) ? cardMap.get(name).get(1) : "";


                    PersonBeanV2 personBeanV2 = new PersonBeanV2(name, totalCN,
                            money + ".00",
                            workSpaces,
                            cardNum, bankName);
                    people.add(personBeanV2);
                    allPeople.add(personBeanV2);
                }
                // 过滤没有姓名的数据
                List<PersonBeanV2> collect = people.stream().filter(x -> !x.getName().trim().equals("")).collect(Collectors.toList());

                // 生成pdf
                Utils.createDir(savePath);
                for (PersonBeanV2 per : collect) {
                    Map<String, String> params = new HashMap<>();
                    params.put("fill_1", per.getWorkSpaces().stream().map(WorkSpace::getName).collect(Collectors.toSet()).stream().collect(Collectors.joining("、")));
                    params.put("fill_2", year);
                    params.put("fill_3", mon);
                    params.put("fill_4", day);
                    params.put("fill_5", "支付" + per.getName() + yearDelta + "年余下全部工资");
                    params.put("fill_6", per.getTotalCN());
                    params.put("fill_7", per.getTotal());
                    params.put("fill_8", per.getCardNum() + "  " + per.getBankDesc());
                    Random random = new Random();
                    CreatePdf.pdfGenerator(homeDir + "\\source_pdf\\source_pdf.pdf", savePath + "\\" + per.name + ".pdf", params);
                }
                System.out.println("生成pdf成功，总计" + collect.size());
            }

            // 合并pdf
            File excelDir = new File(savePath);
            List<String> pdfs = new ArrayList<>();
            File[] sheetDirs = excelDir.listFiles();
            for (File pdf : sheetDirs) {
                if (pdf.getName().endsWith("pdf")) {
                    pdfs.add(pdf.getAbsolutePath());
                }
            }
            Utils.createDir(".\\out_put_batch");
            PdfUtils.mergePdfFile(pdfs, homeDir + "\\out_put_batch\\" + tmpFile.getName().replace(".xlsx", "") + ".pdf");

            fis.close();
        }
        // allPeople.forEach(System.out::println);
        Utils.saveResultAsExcel(allPeople, homeDir);
    }

}
