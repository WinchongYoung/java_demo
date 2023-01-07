package rongda;

import java.util.Set;

public class PersonBean {
    String name;

    String totalCN;

    String total;

    Set<String> workSpaces;

    String cardNum;

    String bankDesc;

    public PersonBean(){}

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

    public PersonBean(String name, String totalCN, String total, Set<String> workSpaces, String cardNum, String bankDesc) {
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

    public Set<String> getWorkSpaces() {
        return workSpaces;
    }

    public void setWorkSpaces(Set<String> workSpaces) {
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
