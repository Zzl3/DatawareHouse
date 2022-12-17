package com.example.datawarehouse_hive.entity;

public class YearMonth {
    Integer year;
    Integer Month;

    public YearMonth() {
    }

    public YearMonth(Integer year, Integer Month) {
        this.year = year;
        this.Month = Month;
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
     * @return Month
     */
    public Integer getMonth() {
        return Month;
    }

    /**
     * 设置
     * @param Month
     */
    public void setMonth(Integer Month) {
        this.Month = Month;
    }

    public String toString() {
        return "YearMonth{year = " + year + ", Month = " + Month + "}";
    }
}
