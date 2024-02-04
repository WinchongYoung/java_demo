package rongda;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static DecimalFormat df = new DecimalFormat("#");

    public static Object getCellValue(Cell cell) {
        Object value = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                value = String.valueOf(df.format(cell.getNumericCellValue()));
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

    /**
     * 获取银行卡号
     *
     * @param homeDir
     * @return
     * @throws IOException
     */
    public static Map<String, List<String>> getBankInfo(String homeDir) throws IOException {
        Map<String, List<String>> cardMap = new HashMap<>();
        FileInputStream mangerInfoFile = new FileInputStream(homeDir + "\\person_info\\person_info.xlsx");
        XSSFWorkbook managerINfoXss = new XSSFWorkbook(mangerInfoFile);
        XSSFSheet managerSheet = managerINfoXss.getSheetAt(0);
        for (Row row2 : managerSheet) {
            String nameTmp = "";
            if (row2.getCell(0) != null) {
                row2.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                nameTmp = row2.getCell(0).getStringCellValue().replace(" ", "");
            }
            String cardNumTmp = "";
            if (row2.getCell(1) != null) {
                cardNumTmp = Utils.getCellValue(row2.getCell(1)).toString();
            }
            String bankName = "";
            if (row2.getCell(2) != null) {
                row2.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                bankName = row2.getCell(2).getStringCellValue();
            }
            String phoneNum = "";
            if (row2.getCell(3) != null) {
                row2.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                phoneNum = row2.getCell(3).getStringCellValue();
            }
            List<String> single = new ArrayList<>();
            single.add(cardNumTmp);
            single.add(bankName);
            single.add(phoneNum);
            cardMap.put(nameTmp, single);
        }
        mangerInfoFile.close();
        return cardMap;
    }

    /**
     * 判断目录是否存在，不存在则创建
     *
     * @param path
     */
    public static void createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void saveResultAsExcel(List<PersonBeanV2> personBeanV2s, String filePath) {
        Map<String, WorkSpace> map = new HashMap<>();
        for (PersonBeanV2 personBeanV2 : personBeanV2s) {
            for (WorkSpace workSpace : personBeanV2.getWorkSpaces()) {
                if (!map.containsKey(workSpace.getName())) {
                    map.put(workSpace.getName(), workSpace);
                } else {
                    // String name, BigDecimal days, Integer mon, BigDecimal salaryPerDay, BigDecimal salaryPerMon, BigDecimal award, BigDecimal salaryTotal, String ps
                    WorkSpace originWorkSpace = map.get(workSpace.getName());
                    map.put(workSpace.getName(), new WorkSpace(
                            workSpace.getName(),
                            originWorkSpace.getDays().add(workSpace.getDays()),
                            0,
                            originWorkSpace.getSalaryPerDay().add(workSpace.getSalaryPerDay()),
                            BigDecimal.ZERO,
                            originWorkSpace.getAward().add(workSpace.getAward()),
                            originWorkSpace.getSalaryTotal().add(workSpace.getSalaryTotal()),
                            ""
                    ));
                }
            }
        }

        String[] title = {"工地", "总出勤天数", "总应结金额"};
        // 创建一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个工作表sheet
        XSSFSheet sheet = workbook.createSheet("sheet1");
        // 创建第一行
        XSSFRow row = sheet.createRow(0);
        // 创建一个单元格
        XSSFCell cell = null;
        // 创建表头
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        List<WorkSpace> values = new ArrayList<>(map.values());
        // 从第二行开始追加数据
        for (int i = 1; i <= values.size(); i++) {
            // 创建第i行
            XSSFRow nextRow = sheet.createRow(i);
            // 参数代表第几列
            XSSFCell cell2 = nextRow.createCell(0);
            cell2.setCellValue(values.get(i - 1).getName());
            cell2 = nextRow.createCell(1);
            cell2.setCellValue(values.get(i - 1).getDays().toString());
            cell2 = nextRow.createCell(2);
            cell2.setCellValue(values.get(i - 1).getSalaryTotal().toString());
        }
        // 创建一个文件
        File file = new File(filePath + "\\统计.xlsx");
        try {
            file.createNewFile();
            // 打开文件流
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
