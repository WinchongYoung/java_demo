package test.common;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Test15 {
    public static void main(String[] args) {
        // 系统日期
        LocalDate localDate = LocalDate.now();
        // 指定年月日
        LocalDate localDate2 = LocalDate.of(2022, 1,1);
        // parse方法-默认格式yyyy-MM-dd
        LocalDate localDate3 = LocalDate.parse("2022-01-01");
        // parse方法-指定格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy@MM@dd");
        LocalDate localDate4 = LocalDate.parse("2023@02@02", formatter);
        // 日期操作
        // 当月第一天
        LocalDate firstDayOfMonth = localDate4.with(TemporalAdjusters.firstDayOfMonth());
        //
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTime = localDate4.atTime(12, 0, 0).format(formatter2);

        LocalDate firstDayOfWeek = localDate4.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println(firstDayOfWeek);

    }
}
