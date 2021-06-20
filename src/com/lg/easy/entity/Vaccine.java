package com.lg.easy.entity;

public class Vaccine {
    private Integer id;
    private String vaccine;
    private String staff_name;
    private String stock_number;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStock_number() {
        return stock_number;
    }

    public void setStock_number(String stock_number) {
        this.stock_number = stock_number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Feed{" +
                "id=" + id+
                ", vaccine='" + vaccine+ '\'' +
                ", staff_name='" + staff_name+ '\'' +
                ", stock_number='" + stock_number+ '\'' +
                ", time='" +time+ '\'' +
                '}';
    }
}
