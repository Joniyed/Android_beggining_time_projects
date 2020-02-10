package com.example.smartdeviceappdevelopementfall2019.models;

public class Adapter_data_models {
    private String name;
    private int number;
    private boolean status;

    public Adapter_data_models(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Adapter_data_models(String name, int number, boolean status) {
        this.name = name;
        this.number = number;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
