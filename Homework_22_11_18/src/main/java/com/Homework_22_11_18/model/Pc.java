package com.Homework_22_11_18.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Pc {
    private int code;
    private String model;
    private short speed;
    private short ram;
    private double hd;
    private BigDecimal price;
    private String cd;

    public Pc() {
    }

    public Pc(int code, String model, short speed, short ram, double hd, BigDecimal price, String cd) {
        this.code = code;
        this.model = model;
        this.speed = speed;
        this.ram = ram;
        this.hd = hd;
        this.price = price;
        this.cd = cd;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public short getSpeed() {
        return speed;
    }

    public void setSpeed(short speed) {
        this.speed = speed;
    }

    public short getRam() {
        return ram;
    }

    public void setRam(short ram) {
        this.ram = ram;
    }

    public double getHd() {
        return hd;
    }

    public void setHd(double hd) {
        this.hd = hd;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pc{");
        sb.append("code=").append(code);
        sb.append(", model='").append(model).append('\'');
        sb.append(", speed=").append(speed);
        sb.append(", ram=").append(ram);
        sb.append(", hd=").append(hd);
        sb.append(", price=").append(price);
        sb.append(", cd='").append(cd).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pc pc = (Pc) o;
        return code == pc.code &&
                speed == pc.speed &&
                ram == pc.ram &&
                Double.compare(pc.hd, hd) == 0 &&
                Objects.equals(model, pc.model) &&
                Objects.equals(price, pc.price) &&
                Objects.equals(cd, pc.cd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, model, speed, ram, hd, price, cd);
    }
}
