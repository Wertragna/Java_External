package com.Homework_15_11_18.ProductModel;

import java.util.Objects;

public class Product {
    private String model;
    private String maker;
    private String type;

    public Product(String model, String maker, String type) {
        this.model = model;
        this.maker = maker;
        this.type = type;
    }

    public Product() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("model='").append(model).append('\'');
        sb.append(", maker='").append(maker).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(model, product.model) &&
                Objects.equals(maker, product.maker) &&
                Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maker, type);
    }
}
