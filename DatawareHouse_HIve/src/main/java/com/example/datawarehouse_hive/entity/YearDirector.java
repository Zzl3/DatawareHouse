package com.example.datawarehouse_hive.entity;

public class YearDirector {
    Integer year;
    String director;

    public YearDirector() {
    }

    public YearDirector(Integer year, String director) {
        this.year = year;
        this.director = director;
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
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * 设置
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    public String toString() {
        return "YearDirector{year = " + year + ", director = " + director + "}";
    }
}
