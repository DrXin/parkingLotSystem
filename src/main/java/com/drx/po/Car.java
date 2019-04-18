package com.drx.po;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Alias("car")
public class Car implements Serializable {
    private int carId;
    private String color;
    private String licenseNum;
    private int driverId;
    private int formulaId;
    private String brand;

    public int getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(int formulaId) {
        this.formulaId = formulaId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", color='" + color + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                ", driverId=" + driverId +
                ", formulaId=" + formulaId +
                ", brand='" + brand + '\'' +
                '}';
    }
}
