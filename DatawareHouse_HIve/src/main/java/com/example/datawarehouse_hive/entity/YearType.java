package com.example.datawarehouse_hive.entity;

public class YearType {
    Integer year;
    String type;

    public YearType() {
    }

    public YearType(Integer year, String type) {
        this.year = year;
        this.type = type;
    }

    /**
     * 获取
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "YearType{year = " + year + ", type = " + type + "}";
    }
}
