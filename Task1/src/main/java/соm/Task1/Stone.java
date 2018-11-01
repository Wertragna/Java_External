package соm.Task1;


import соm.Task1.Enums.Color;

import java.math.BigDecimal;
import java.util.Objects;

public  abstract class Stone {
    private int caratWeight;
    private Color color;
    private BigDecimal price;
    private Diaphaneity diaphaneity;

    public Stone(int caratWeight, Color color, BigDecimal price, Diaphaneity diaphaneity) {
        this.caratWeight = caratWeight;
        this.color = color;
        this.price = price;
        this.diaphaneity = diaphaneity;
    }

    public int getCaratWeight() {
        return caratWeight;
    }

    public Color getColor() {
        return color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Diaphaneity getDiaphaneity() {
        return diaphaneity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stone stone = (Stone) o;
        return caratWeight == stone.caratWeight &&
                color == stone.color &&
                Objects.equals(price, stone.price) &&
                diaphaneity == stone.diaphaneity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(caratWeight, color, price, diaphaneity);
    }

    @Override
    public String toString() {
        return " Stone{" +
                "caratWeight=" + caratWeight +
                ", color=" + color +
                ", price=" + price +
                ", diaphaneity=" + diaphaneity +
                '}';
    }
}
