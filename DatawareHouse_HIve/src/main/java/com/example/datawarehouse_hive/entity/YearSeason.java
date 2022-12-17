package com.example.datawarehouse_hive.entity;

public class YearSeason {
    Integer year;
    Integer season;

    public YearSeason() {
    }

    public YearSeason(Integer year, Integer season) {
        this.year = year;
        this.season = season;
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
     * @return season
     */
    public Integer getSeason() {
        return season;
    }

    /**
     * 设置
     * @param season
     */
    public void setSeason(Integer season) {
        this.season = season;
    }

    public String toString() {
        return "YearSeason{year = " + year + ", season = " + season + "}";
    }
}
