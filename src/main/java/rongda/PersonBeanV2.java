package rongda;

import java.util.List;

public class PersonBeanV2 {
    String name;

    String totalCN;

    String total;

    List<WorkSpace> workSpaces;

    String cardNum;

    String bankDesc;

    public PersonBeanV2() {
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", totalCN='" + totalCN + '\'' +
                ", total='" + total + '\'' +
                ", workSpaces=" + workSpaces +
                ", cardNum='" + cardNum + '\'' +
                ", bankDesc='" + bankDesc + '\'' +
                '}';
    }

    public PersonBeanV2(String name, String totalCN, String total, List<WorkSpace> workSpaces, String cardNum, String bankDesc) {
        this.name = name;
        this.totalCN = totalCN;
        this.total = total;
        this.workSpaces = workSpaces;
        this.cardNum = cardNum;
        this.bankDesc = bankDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalCN() {
        return totalCN;
    }

    public void setTotalCN(String totalCN) {
        this.totalCN = totalCN;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<WorkSpace> getWorkSpaces() {
        return workSpaces;
    }

    public void setWorkSpaces(List<WorkSpace> workSpaces) {
        this.workSpaces = workSpaces;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getBankDesc() {
        return bankDesc;
    }

    public void setBankDesc(String bankDesc) {
        this.bankDesc = bankDesc;
    }
}
