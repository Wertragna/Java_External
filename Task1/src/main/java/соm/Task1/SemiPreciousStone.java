package соm.Task1;

import соm.Task1.Enums.Color;
import соm.Task1.Enums.SemiPreciousStoneName;

import java.math.BigDecimal;
import java.util.Objects;

public class SemiPreciousStone extends Stone {
    SemiPreciousStoneName name;
    public static class SemiPreciousStoneBuilder{
        SemiPreciousStoneName name;
        private int caratWeight;
        private Color color=Color.White;
        private BigDecimal price=BigDecimal.ZERO;
        private Diaphaneity diaphaneity=Diaphaneity.Transparent;
        public SemiPreciousStoneBuilder(SemiPreciousStoneName name){
            this.name= name;
        }
        public SemiPreciousStoneBuilder color(Color color){
            this.color= color;
            return this;
        }
        public SemiPreciousStoneBuilder price(BigDecimal price){
            this.price= price;
            return this;
        }
        public SemiPreciousStoneBuilder diaphaneity(Diaphaneity diaphaneity){
            this.diaphaneity= diaphaneity;
            return this;
        }
        public SemiPreciousStoneBuilder carat(int carat){
            this.caratWeight= carat;
            return this;
        }
        public SemiPreciousStone build(){
            return new SemiPreciousStone(this);
        }
    }
    private SemiPreciousStone(SemiPreciousStoneBuilder builder) {
        super(builder.caratWeight, builder.color, builder.price, builder.diaphaneity);
        this.name=builder.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SemiPreciousStone that = (SemiPreciousStone) o;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "SemiPreciousStone{" +
                "name=" + name + super.toString() +
                "}";
    }
}
