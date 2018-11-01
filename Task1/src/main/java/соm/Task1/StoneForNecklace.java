package соm.Task1;

import javax.sql.rowset.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StoneForNecklace {
    private ArrayList<Stone> stones;

    public ArrayList<Stone> getStones() {
        return stones;
    }

    public void addStone(Stone stone){
        stones.add(stone);
    }
    public void cleanStone(Stone stone){
        stones.clear();
    }


    public StoneForNecklace() {
        stones= new ArrayList<>();
    }

    public BigDecimal priceStones(){
        return stones.stream().map(Stone::getPrice).reduce((x,y)->x.add(y)).get();
    }
    public void sortByPrice(){
        Collections.sort(stones, Comparator.comparing(Stone::getPrice));
    }
    public ArrayList<Stone> filterByDiapheneity(Diaphaneity diaphaneity){
        ArrayList<Stone> filtered= new ArrayList<>(stones);
        filtered.removeIf(stone -> !stone.getDiaphaneity().equals(diaphaneity));
        return filtered;
    }
}
