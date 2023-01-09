package rongda;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
            List<String> single = new ArrayList<>();
            single.add(cardNumTmp);
            single.add(bankName);
            cardMap.put(nameTmp, single);
        }
        return cardMap;
    }

    /**
     * 判断目录是否存在，不存在则创建
     * @param path
     */
    public static void createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
