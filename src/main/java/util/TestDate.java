package util;

import java.time.LocalDate;

public class TestDate {

    public static void main(String[] args) {
        LocalDate startDate = LocalDateUtils.parseLocalDate("20230121", LocalDateUtils.UNSIGNED_DATE_PATTERN);
        String startDateFormat = LocalDateUtils.format(startDate, LocalDateUtils.UNSIGNED_DATE_PATTERN);
        int startDateInt = Integer.parseInt(startDateFormat);
        int i = 1;
        while (startDateInt <= 20230327) {
            int delta1 = deltaDays(startDateInt, 1);
            int delta30 = deltaDays(delta1, 29);
            int delta31 = deltaDays(delta30, 1);
            int delta60 = deltaDays(delta31, 29);
            // System.out.println(startDateInt + "== " + delta60 + "->" + delta31 + ", " + delta30 + "->" + delta1);
            System.out.println(startDateInt + ", " + delta60 + ", " + delta31 + ", " + delta30 + ", " + delta1+ ",");

            startDateInt = Integer.parseInt(LocalDateUtils.format(LocalDateUtils.parseLocalDate(startDateInt + "", LocalDateUtils.UNSIGNED_DATE_PATTERN).plusDays(1), LocalDateUtils.UNSIGNED_DATE_PATTERN));
        }
    }

    public static int deltaDays(int date, int deltaDays) {
        LocalDate startDate = LocalDateUtils.parseLocalDate(date + "", LocalDateUtils.UNSIGNED_DATE_PATTERN);
        while (deltaDays > 0) {
            startDate = startDate.minusDays(1);
            String startDateFormat = LocalDateUtils.format(startDate, LocalDateUtils.UNSIGNED_DATE_PATTERN);
            int startDateInt = Integer.parseInt(startDateFormat);
            if (startDateInt < 20230121 || startDateInt > 20230127) {
                deltaDays--;
            }
        }
        return Integer.parseInt(LocalDateUtils.format(startDate, LocalDateUtils.UNSIGNED_DATE_PATTERN));
    }
}
