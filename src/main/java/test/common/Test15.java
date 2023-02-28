package test.common;

import java.sql.Timestamp;
import java.time.*;
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

        // 月初开始时间
        LocalDateTime monthStartTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        // 月末时间
        LocalDateTime endDateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);

        // LocalDateTime转时间戳
        long timeStamp = Timestamp.valueOf(monthStartTime).getTime() / 1000;
        // 当前时间戳
        long epochSecond = Instant.now().getEpochSecond();

    }
}
