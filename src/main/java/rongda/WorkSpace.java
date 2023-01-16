package rongda;

import java.math.BigDecimal;

public class WorkSpace {

    private String name;

    private BigDecimal days;

    private Integer mon;

    private BigDecimal salaryPerDay;

    private BigDecimal salaryPerMon;

    private BigDecimal award;

    private BigDecimal salaryTotal;

    private String ps;

    public WorkSpace() {
    }

    public WorkSpace(String name, BigDecimal days, Integer mon, BigDecimal salaryPerDay, BigDecimal salaryPerMon, BigDecimal award, BigDecimal salaryTotal, String ps) {
        this.name = name;
        this.days = days;
        this.mon = mon;
        this.salaryPerDay = salaryPerDay;
        this.salaryPerMon = salaryPerMon;
        this.award = award;
        this.salaryTotal = salaryTotal;
        this.ps = ps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDays() {
        return days;
    }

    public void setDays(BigDecimal days) {
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

    public BigDecimal getAward() {
        return award;
    }

    public void setAward(BigDecimal award) {
        this.award = award;
    }

    public BigDecimal getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(BigDecimal salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return "WorkSpace{" +
                "name='" + name + '\'' +
                ", days=" + days +
                ", mon=" + mon +
                ", salaryPerDay=" + salaryPerDay +
                ", salaryPerMon=" + salaryPerMon +
                ", award=" + award +
                ", salaryTotal=" + salaryTotal +
                ", ps='" + ps + '\'' +
                '}';
    }
}
