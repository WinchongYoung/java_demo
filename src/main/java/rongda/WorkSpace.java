package rongda;

import java.math.BigDecimal;

public class WorkSpace {
    private String name;

    private Integer days;

    private Integer mon;

    private BigDecimal salaryPerDay;

    private BigDecimal salaryPerMon;

    private String ps;

    public WorkSpace() {
    }

    public WorkSpace(String name, Integer days, Integer mon, BigDecimal salaryPerDay, BigDecimal salaryPerMon, String ps) {
        this.name = name;
        this.days = days;
        this.mon = mon;
        this.salaryPerDay = salaryPerDay;
        this.salaryPerMon = salaryPerMon;
        this.ps = ps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getMon() {
        return mon;
    }

    public void setMon(Integer mon) {
        this.mon = mon;
    }

    public BigDecimal getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(BigDecimal salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    public BigDecimal getSalaryPerMon() {
        return salaryPerMon;
    }

    public void setSalaryPerMon(BigDecimal salaryPerMon) {
        this.salaryPerMon = salaryPerMon;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}
