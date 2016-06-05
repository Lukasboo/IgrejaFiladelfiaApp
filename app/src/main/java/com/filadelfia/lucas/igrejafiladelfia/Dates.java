package com.filadelfia.lucas.igrejafiladelfia;

/**
 * Created by lucas on 05/06/16.
 */
public class Dates {

    int id;
    String year_month, months;

    public Dates(String year_month, String months) {

        this.year_month = year_month;
        this.months = months;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear_month() {
        return year_month;
    }

    public void setYear_month(String year_month) {
        this.year_month = year_month;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }



}
