package соm.Task1;

import соm.Task1.Enums.Color;
import соm.Task1.Enums.PreciousStoneName;

import java.math.BigDecimal;
import java.util.Objects;

public class PreciousStone extends Stone {
    PreciousStoneName name;
    public static class PreciousStoneBuilder{
        private PreciousStoneName name;
        private int caratWeight;
        private Color color=Color.White;
        private BigDecimal price=BigDecimal.ZERO;
        private Diaphaneity diaphaneity=Diaphaneity.Transparent;
        public PreciousStoneBuilder(PreciousStoneName name){
            this.name= name;

        }
        public PreciousStoneBuilder color(Color color){
            this.color= color;
            return this;
        }
        public PreciousStoneBuilder price(BigDecimal price){
            this.price= price;
            return this;
        }
        public PreciousStoneBuilder diaphaneity(Diaphaneity diaphaneity){
            this.diaphaneity= diaphaneity;
            return this;
        }
        public PreciousStoneBuilder carat(int carat){
            this.caratWeight= carat;
            return this;
        }
        public PreciousStone build(){
            return new PreciousStone(this);
        }
    }
    private PreciousStone(PreciousStoneBuilder builder) {
        super(builder.caratWeight, builder.color, builder.price, builder.diaphaneity);
        this.name = builder.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PreciousStone that = (PreciousStone) o;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "PreciousStone{" +
                "name=" + name + super.toString() +
                "}";
    }

}
